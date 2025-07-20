package com.workouttracker.ui.workout

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.workouttracker.R
import com.workouttracker.data.model.Workout
import com.workouttracker.databinding.ActivityCreateWorkoutBinding
import java.text.SimpleDateFormat
import java.util.*

class CreateWorkoutActivity : AppCompatActivity() {
    
    companion object {
        const val EXTRA_WORKOUT = "extra_workout"
    }
    
    private lateinit var binding: ActivityCreateWorkoutBinding
    private val viewModel: CreateWorkoutViewModel by viewModels()
    
    private var isEditMode = false
    private var workoutToEdit: Workout? = null
    private var selectedDate = Calendar.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Check if we're in edit mode
        workoutToEdit = intent.getParcelableExtra(EXTRA_WORKOUT)
        isEditMode = workoutToEdit != null
        
        setupToolbar()
        setupUI()
        setupValidation()
        observeViewModel()
        
        // If editing, populate fields
        workoutToEdit?.let { populateFields(it) }
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = if (isEditMode) getString(R.string.edit_workout) else getString(R.string.create_workout)
        }
    }
    
    private fun setupUI() {
        binding.apply {
            // Set initial date
            updateDateDisplay()
            
            // Date picker
            textWorkoutDate.setOnClickListener {
                showDatePicker()
            }
            
            // Save button
            buttonSave.setOnClickListener {
                saveWorkout()
            }
            
            // Cancel button
            buttonCancel.setOnClickListener {
                showCancelConfirmation()
            }
            
            // Duration picker
            textWorkoutDuration.setOnClickListener {
                showDurationPicker()
            }
        }
    }
    
    private fun setupValidation() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateForm()
            }
        }
        
        binding.editTextWorkoutName.addTextChangedListener(textWatcher)
    }
    
    private fun observeViewModel() {
        viewModel.createState.observe(this) { state ->
            when (state) {
                is CreateWorkoutState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.buttonSave.isEnabled = false
                }
                is CreateWorkoutState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    showSuccess(state.message)
                    finish()
                }
                is CreateWorkoutState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.buttonSave.isEnabled = true
                    showError(state.message)
                }
                is CreateWorkoutState.Idle -> {
                    binding.progressBar.visibility = View.GONE
                    validateForm()
                }
            }
        }
    }
    
    private fun populateFields(workout: Workout) {
        binding.apply {
            editTextWorkoutName.setText(workout.name)
            editTextWorkoutNotes.setText(workout.notes)
            
            // Parse and set date
            try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                val date = inputFormat.parse(workout.date)
                date?.let {
                    selectedDate.time = it
                    updateDateDisplay()
                }
            } catch (e: Exception) {
                // Try alternative format
                try {
                    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    val date = inputFormat.parse(workout.date)
                    date?.let {
                        selectedDate.time = it
                        updateDateDisplay()
                    }
                } catch (e2: Exception) {
                    // Keep current date if parsing fails
                }
            }
            
            // Set duration
            if (workout.duration > 0) {
                textWorkoutDuration.text = "${workout.duration} minutes"
                textWorkoutDuration.tag = workout.duration
            }
        }
    }
    
    private fun showDatePicker() {
        DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateDisplay()
            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
    
    private fun showDurationPicker() {
        val currentDuration = (binding.textWorkoutDuration.tag as? Int) ?: 0
        val currentHours = currentDuration / 60
        val currentMinutes = currentDuration % 60
        
        TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val totalMinutes = (hourOfDay * 60) + minute
                binding.textWorkoutDuration.text = when {
                    totalMinutes == 0 -> "Tap to set duration"
                    hourOfDay == 0 -> "$minute minutes"
                    minute == 0 -> "$hourOfDay hour${if (hourOfDay > 1) "s" else ""}"
                    else -> "$hourOfDay hour${if (hourOfDay > 1) "s" else ""} $minute minutes"
                }
                binding.textWorkoutDuration.tag = totalMinutes
            },
            currentHours,
            currentMinutes,
            true
        ).show()
    }
    
    private fun updateDateDisplay() {
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        binding.textWorkoutDate.text = dateFormat.format(selectedDate.time)
    }
    
    private fun validateForm() {
        val name = binding.editTextWorkoutName.text.toString().trim()
        val isValid = name.isNotEmpty()
        
        binding.buttonSave.isEnabled = isValid
        
        if (name.isEmpty() && binding.editTextWorkoutName.hasFocus()) {
            binding.textInputLayoutWorkoutName.error = getString(R.string.error_required_field)
        } else {
            binding.textInputLayoutWorkoutName.error = null
        }
    }
    
    private fun saveWorkout() {
        val name = binding.editTextWorkoutName.text.toString().trim()
        val notes = binding.editTextWorkoutNotes.text.toString().trim()
        val duration = (binding.textWorkoutDuration.tag as? Int) ?: 0
        
        // Format date for API
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val dateString = dateFormat.format(selectedDate.time)
        
        if (isEditMode && workoutToEdit != null) {
            val updatedWorkout = workoutToEdit!!.copy(
                name = name,
                notes = notes,
                duration = duration,
                date = dateString
            )
            viewModel.updateWorkout(workoutToEdit!!.id, updatedWorkout)
        } else {
            viewModel.createWorkout(name, dateString, duration, notes)
        }
    }
    
    private fun showCancelConfirmation(onConfirm: () -> Unit = { finish() }) {
        val name = binding.editTextWorkoutName.text.toString().trim()
        val notes = binding.editTextWorkoutNotes.text.toString().trim()
        val hasChanges = name.isNotEmpty() || notes.isNotEmpty()
        
        if (hasChanges) {
            MaterialAlertDialogBuilder(this)
                .setTitle("Discard changes?")
                .setMessage("You have unsaved changes. Are you sure you want to discard them?")
                .setPositiveButton("Discard") { _, _ ->
                    onConfirm()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        } else {
            onConfirm()
        }
    }
    
    private fun showSuccess(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Success")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    private fun showError(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                showCancelConfirmation()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    override fun onBackPressed() {
        showCancelConfirmation { super.onBackPressed() }
    }
}

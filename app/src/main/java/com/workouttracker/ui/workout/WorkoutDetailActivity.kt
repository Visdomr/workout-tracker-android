package com.workouttracker.ui.workout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.workouttracker.R
import com.workouttracker.data.model.ExerciseCategory
import com.workouttracker.data.model.Workout
import com.workouttracker.databinding.ActivityWorkoutDetailBinding
import java.text.SimpleDateFormat
import java.util.*

class WorkoutDetailActivity : AppCompatActivity() {
    
    companion object {
        const val EXTRA_WORKOUT = "extra_workout"
    }
    
    private lateinit var binding: ActivityWorkoutDetailBinding
    private val viewModel: WorkoutDetailViewModel by viewModels()
    private lateinit var exerciseAdapter: ExerciseAdapter
    
    private var workout: Workout? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        workout = intent.getParcelableExtra(EXTRA_WORKOUT)
        if (workout == null) {
            finish()
            return
        }
        
        setupToolbar()
        setupRecyclerView()
        setupFab()
        observeViewModel()
        
        // Display workout details
        displayWorkoutDetails(workout!!)
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = workout?.name ?: "Workout Details"
        }
    }
    
    private fun setupRecyclerView() {
        exerciseAdapter = ExerciseAdapter(
            onExerciseClick = { exercise ->
                // TODO: Navigate to exercise detail
            },
            onEditExerciseClick = { exercise ->
                // TODO: Navigate to edit exercise
            },
            onDeleteExerciseClick = { exercise ->
                showDeleteExerciseConfirmation(exercise.id)
            }
        )
        
        binding.recyclerViewExercises.apply {
            layoutManager = LinearLayoutManager(this@WorkoutDetailActivity)
            adapter = exerciseAdapter
        }
    }
    
    private fun setupFab() {
        binding.fabAddExercise.setOnClickListener {
            // TODO: Navigate to add exercise
            // For now, show a placeholder message
            MaterialAlertDialogBuilder(this)
                .setTitle("Add Exercise")
                .setMessage("Exercise management will be implemented in the next phase.")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
    
    private fun observeViewModel() {
        viewModel.workout.observe(this) { updatedWorkout ->
            updatedWorkout?.let {
                workout = it
                displayWorkoutDetails(it)
            }
        }
        
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        
        viewModel.error.observe(this) { error ->
            error?.let {
                showError(it)
                viewModel.clearError()
            }
        }
    }
    
    private fun displayWorkoutDetails(workout: Workout) {
        binding.apply {
            // Workout basic info
            textWorkoutName.text = workout.name
            textWorkoutDate.text = formatDate(workout.date)
            
            // Duration
            textWorkoutDuration.text = if (workout.duration > 0) {
                "${workout.duration} minutes"
            } else {
                "Duration not recorded"
            }
            
            // Notes
            if (workout.notes.isNotBlank()) {
                textWorkoutNotes.text = workout.notes
                textWorkoutNotes.visibility = View.VISIBLE
                labelNotes.visibility = View.VISIBLE
            } else {
                textWorkoutNotes.visibility = View.GONE
                labelNotes.visibility = View.GONE
            }
            
            // Exercise count and categories
            val exerciseCount = workout.exercises.size
            textExerciseCount.text = "$exerciseCount ${if (exerciseCount == 1) "exercise" else "exercises"}"
            
            // Update exercise list
            updateExerciseList(workout)
            
            // Update category summary
            updateCategorySummary(workout)
        }
    }
    
    private fun updateExerciseList(workout: Workout) {
        if (workout.exercises.isNotEmpty()) {
            binding.recyclerViewExercises.visibility = View.VISIBLE
            binding.layoutEmptyExercises.visibility = View.GONE
            exerciseAdapter.submitList(workout.exercises)
        } else {
            binding.recyclerViewExercises.visibility = View.GONE
            binding.layoutEmptyExercises.visibility = View.VISIBLE
        }
    }
    
    private fun updateCategorySummary(workout: Workout) {
        val categories = workout.exercises
            .map { ExerciseCategory.fromString(it.category) }
            .distinct()
        
        binding.chipGroupCategories.removeAllViews()
        
        categories.forEach { category ->
            val chip = com.google.android.material.chip.Chip(this)
            chip.text = category.displayName
            chip.isCheckable = false
            chip.chipBackgroundColor = getColorStateList(getCategoryColor(category))
            chip.setTextColor(getColor(R.color.white))
            binding.chipGroupCategories.addView(chip)
        }
        
        binding.chipGroupCategories.visibility = if (categories.isNotEmpty()) View.VISIBLE else View.GONE
    }
    
    private fun getCategoryColor(category: ExerciseCategory): Int {
        return when (category) {
            ExerciseCategory.CHEST -> R.color.category_chest
            ExerciseCategory.BACK -> R.color.category_back
            ExerciseCategory.SHOULDERS -> R.color.category_shoulders
            ExerciseCategory.ARMS -> R.color.category_arms
            ExerciseCategory.LEGS -> R.color.category_legs
            ExerciseCategory.CORE -> R.color.category_core
            ExerciseCategory.CARDIO -> R.color.category_cardio
            ExerciseCategory.OTHER -> R.color.category_other
        }
    }
    
    private fun formatDate(dateString: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            date?.let { outputFormat.format(it) } ?: dateString
        } catch (e: Exception) {
            try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val outputFormat = SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault())
                val date = inputFormat.parse(dateString)
                date?.let { outputFormat.format(it) } ?: dateString
            } catch (e2: Exception) {
                dateString
            }
        }
    }
    
    private fun showDeleteExerciseConfirmation(exerciseId: Long) {
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.delete_exercise))
            .setMessage(getString(R.string.confirm_delete_exercise))
            .setPositiveButton(getString(R.string.delete)) { _, _ ->
                viewModel.deleteExercise(exerciseId)
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
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
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.workout_detail_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_edit -> {
                workout?.let { workout ->
                    val intent = Intent(this, CreateWorkoutActivity::class.java).apply {
                        putExtra(CreateWorkoutActivity.EXTRA_WORKOUT, workout)
                    }
                    startActivity(intent)
                }
                true
            }
            R.id.action_delete -> {
                showDeleteWorkoutConfirmation()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    private fun showDeleteWorkoutConfirmation() {
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.delete_workout))
            .setMessage(getString(R.string.confirm_delete_workout))
            .setPositiveButton(getString(R.string.delete)) { _, _ ->
                workout?.let { viewModel.deleteWorkout(it.id) }
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    override fun onResume() {
        super.onResume()
        // Refresh workout data when returning from edit
        workout?.let { viewModel.refreshWorkout(it.id) }
    }
}

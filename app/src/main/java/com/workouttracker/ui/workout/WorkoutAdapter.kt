package com.workouttracker.ui.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.workouttracker.R
import com.workouttracker.data.model.ExerciseCategory
import com.workouttracker.data.model.Workout
import com.workouttracker.databinding.ItemWorkoutBinding
import java.text.SimpleDateFormat
import java.util.*

class WorkoutAdapter(
    private val onWorkoutClick: (Workout) -> Unit,
    private val onEditClick: (Workout) -> Unit,
    private val onDeleteClick: (Workout) -> Unit
) : ListAdapter<Workout, WorkoutAdapter.WorkoutViewHolder>(WorkoutDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ItemWorkoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WorkoutViewHolder(
        private val binding: ItemWorkoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(workout: Workout) {
            binding.apply {
                textWorkoutName.text = workout.name
                textWorkoutDate.text = formatDate(workout.date)
                
                // Format duration
                textWorkoutDuration.text = when {
                    workout.duration > 0 -> "${workout.duration} min"
                    else -> "Duration not recorded"
                }
                
                // Show exercise count
                val exerciseCount = workout.exercises.size
                textExerciseCount.text = root.context.getString(
                    when (exerciseCount) {
                        0 -> R.string.no_exercises_yet
                        1 -> R.string.exercises // This would need to be "1 exercise"
                        else -> R.string.exercises // This would need to be "$exerciseCount exercises"
                    }
                ).let { 
                    if (exerciseCount == 0) it 
                    else "$exerciseCount ${if (exerciseCount == 1) "exercise" else "exercises"}"
                }
                
                // Show notes if available
                if (workout.notes.isNotBlank()) {
                    textWorkoutNotes.text = workout.notes
                    textWorkoutNotes.visibility = android.view.View.VISIBLE
                } else {
                    textWorkoutNotes.visibility = android.view.View.GONE
                }
                
                // Show exercise categories as colored chips
                updateExerciseCategories(workout)
                
                // Set click listeners
                root.setOnClickListener { onWorkoutClick(workout) }
                buttonEdit.setOnClickListener { onEditClick(workout) }
                buttonDelete.setOnClickListener { onDeleteClick(workout) }
            }
        }
        
        private fun updateExerciseCategories(workout: Workout) {
            val categories = workout.exercises
                .map { ExerciseCategory.fromString(it.category) }
                .distinct()
                .take(3) // Show max 3 categories
            
            binding.apply {
                when (categories.size) {
                    0 -> {
                        chipCategory1.visibility = android.view.View.GONE
                        chipCategory2.visibility = android.view.View.GONE
                        chipCategory3.visibility = android.view.View.GONE
                    }
                    1 -> {
                        chipCategory1.text = categories[0].displayName
                        chipCategory1.visibility = android.view.View.VISIBLE
                        chipCategory2.visibility = android.view.View.GONE
                        chipCategory3.visibility = android.view.View.GONE
                        setChipColor(chipCategory1, categories[0])
                    }
                    2 -> {
                        chipCategory1.text = categories[0].displayName
                        chipCategory1.visibility = android.view.View.VISIBLE
                        setChipColor(chipCategory1, categories[0])
                        
                        chipCategory2.text = categories[1].displayName
                        chipCategory2.visibility = android.view.View.VISIBLE
                        setChipColor(chipCategory2, categories[1])
                        
                        chipCategory3.visibility = android.view.View.GONE
                    }
                    else -> {
                        chipCategory1.text = categories[0].displayName
                        chipCategory1.visibility = android.view.View.VISIBLE
                        setChipColor(chipCategory1, categories[0])
                        
                        chipCategory2.text = categories[1].displayName
                        chipCategory2.visibility = android.view.View.VISIBLE
                        setChipColor(chipCategory2, categories[1])
                        
                        chipCategory3.text = categories[2].displayName
                        chipCategory3.visibility = android.view.View.VISIBLE
                        setChipColor(chipCategory3, categories[2])
                    }
                }
            }
        }
        
        private fun setChipColor(chip: com.google.android.material.chip.Chip, category: ExerciseCategory) {
            val context = chip.context
            val colorResId = when (category) {
                ExerciseCategory.CHEST -> R.color.category_chest
                ExerciseCategory.BACK -> R.color.category_back
                ExerciseCategory.SHOULDERS -> R.color.category_shoulders
                ExerciseCategory.ARMS -> R.color.category_arms
                ExerciseCategory.LEGS -> R.color.category_legs
                ExerciseCategory.CORE -> R.color.category_core
                ExerciseCategory.CARDIO -> R.color.category_cardio
                ExerciseCategory.OTHER -> R.color.category_other
            }
            chip.chipBackgroundColor = context.getColorStateList(colorResId)
        }
        
        private fun formatDate(dateString: String): String {
            return try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
                val date = inputFormat.parse(dateString)
                date?.let { outputFormat.format(it) } ?: dateString
            } catch (e: Exception) {
                // Try alternative format
                try {
                    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
                    val date = inputFormat.parse(dateString)
                    date?.let { outputFormat.format(it) } ?: dateString
                } catch (e2: Exception) {
                    dateString
                }
            }
        }
    }

    class WorkoutDiffCallback : DiffUtil.ItemCallback<Workout>() {
        override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
            return oldItem == newItem
        }
    }
}

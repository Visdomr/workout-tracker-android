package com.workouttracker.ui.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.workouttracker.R
import com.workouttracker.data.model.Exercise
import com.workouttracker.data.model.ExerciseCategory
import com.workouttracker.databinding.ItemExerciseBinding

class ExerciseAdapter(
    private val onExerciseClick: (Exercise) -> Unit,
    private val onEditExerciseClick: (Exercise) -> Unit,
    private val onDeleteExerciseClick: (Exercise) -> Unit
) : ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(ExerciseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val binding = ItemExerciseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ExerciseViewHolder(
        private val binding: ItemExerciseBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            binding.apply {
                textExerciseName.text = exercise.name
                
                val category = ExerciseCategory.fromString(exercise.category)
                textExerciseCategory.text = category.displayName
                
                // Set category color
                val categoryColor = getCategoryColor(category)
                chipCategory.chipBackgroundColor = root.context.getColorStateList(categoryColor)
                chipCategory.text = category.displayName
                
                // Show set count
                val setCount = exercise.sets.size
                textSetCount.text = "$setCount ${if (setCount == 1) "set" else "sets"}"
                
                // Show total weight/reps summary if available
                if (exercise.sets.isNotEmpty()) {
                    val totalReps = exercise.sets.sumOf { it.reps }
                    val maxWeight = exercise.sets.maxOfOrNull { it.weight } ?: 0.0
                    
                    textSetSummary.text = when {
                        maxWeight > 0 && totalReps > 0 -> "$totalReps reps • ${maxWeight}kg max"
                        totalReps > 0 -> "$totalReps total reps"
                        maxWeight > 0 -> "${maxWeight}kg max"
                        else -> "No sets recorded"
                    }
                    textSetSummary.visibility = android.view.View.VISIBLE
                } else {
                    textSetSummary.visibility = android.view.View.GONE
                }
                
                // Set click listeners
                root.setOnClickListener { onExerciseClick(exercise) }
                buttonEdit.setOnClickListener { onEditExerciseClick(exercise) }
                buttonDelete.setOnClickListener { onDeleteExerciseClick(exercise) }
            }
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
    }

    class ExerciseDiffCallback : DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }
    }
}

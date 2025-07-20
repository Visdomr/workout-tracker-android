package com.workouttracker.ui.workout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.workouttracker.data.model.CreateWorkoutRequest
import com.workouttracker.data.model.Workout
import com.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.launch

sealed class CreateWorkoutState {
    object Idle : CreateWorkoutState()
    object Loading : CreateWorkoutState()
    data class Success(val message: String) : CreateWorkoutState()
    data class Error(val message: String) : CreateWorkoutState()
}

class CreateWorkoutViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = WorkoutRepository.getInstance(application)
    
    private val _createState = MutableLiveData<CreateWorkoutState>(CreateWorkoutState.Idle)
    val createState: LiveData<CreateWorkoutState> = _createState
    
    fun createWorkout(name: String, date: String, duration: Int, notes: String) {
        _createState.value = CreateWorkoutState.Loading
        viewModelScope.launch {
            val request = CreateWorkoutRequest(
                name = name,
                date = date,
                duration = duration,
                notes = notes
            )
            
            repository.createWorkout(request)
                .onSuccess { workout ->
                    _createState.value = CreateWorkoutState.Success("Workout created successfully!")
                }
                .onFailure { throwable ->
                    val message = when {
                        throwable.message?.contains("401") == true -> 
                            "Session expired. Please log in again."
                        throwable.message?.contains("400") == true ->
                            "Invalid workout data. Please check your input."
                        throwable.message?.contains("network", ignoreCase = true) == true ->
                            "Network error. Please check your connection."
                        throwable.message?.contains("timeout", ignoreCase = true) == true ->
                            "Connection timeout. Please try again."
                        else -> throwable.message ?: "Failed to create workout. Please try again."
                    }
                    _createState.value = CreateWorkoutState.Error(message)
                }
        }
    }
    
    fun updateWorkout(id: Long, workout: Workout) {
        _createState.value = CreateWorkoutState.Loading
        viewModelScope.launch {
            repository.updateWorkout(id, workout)
                .onSuccess { updatedWorkout ->
                    _createState.value = CreateWorkoutState.Success("Workout updated successfully!")
                }
                .onFailure { throwable ->
                    val message = when {
                        throwable.message?.contains("401") == true -> 
                            "Session expired. Please log in again."
                        throwable.message?.contains("404") == true ->
                            "Workout not found. It may have been deleted."
                        throwable.message?.contains("400") == true ->
                            "Invalid workout data. Please check your input."
                        throwable.message?.contains("network", ignoreCase = true) == true ->
                            "Network error. Please check your connection."
                        throwable.message?.contains("timeout", ignoreCase = true) == true ->
                            "Connection timeout. Please try again."
                        else -> throwable.message ?: "Failed to update workout. Please try again."
                    }
                    _createState.value = CreateWorkoutState.Error(message)
                }
        }
    }
    
    fun resetState() {
        _createState.value = CreateWorkoutState.Idle
    }
}

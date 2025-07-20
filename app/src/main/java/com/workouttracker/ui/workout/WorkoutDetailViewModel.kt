package com.workouttracker.ui.workout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.workouttracker.data.model.Workout
import com.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.launch

class WorkoutDetailViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = WorkoutRepository.getInstance(application)
    
    private val _workout = MutableLiveData<Workout?>()
    val workout: LiveData<Workout?> = _workout
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    private val _workoutDeleted = MutableLiveData<Boolean>()
    val workoutDeleted: LiveData<Boolean> = _workoutDeleted
    
    fun refreshWorkout(workoutId: Long) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getWorkout(workoutId)
                .onSuccess { updatedWorkout ->
                    _workout.value = updatedWorkout
                    _isLoading.value = false
                }
                .onFailure { throwable ->
                    _error.value = throwable.message ?: "Failed to load workout details"
                    _isLoading.value = false
                }
        }
    }
    
    fun deleteWorkout(workoutId: Long) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.deleteWorkout(workoutId)
                .onSuccess {
                    _isLoading.value = false
                    _workoutDeleted.value = true
                }
                .onFailure { throwable ->
                    _error.value = throwable.message ?: "Failed to delete workout"
                    _isLoading.value = false
                }
        }
    }
    
    fun deleteExercise(exerciseId: Long) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.deleteExercise(exerciseId)
                .onSuccess {
                    // Refresh the workout to show updated exercise list
                    _workout.value?.let { currentWorkout ->
                        refreshWorkout(currentWorkout.id)
                    }
                }
                .onFailure { throwable ->
                    _error.value = throwable.message ?: "Failed to delete exercise"
                    _isLoading.value = false
                }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}

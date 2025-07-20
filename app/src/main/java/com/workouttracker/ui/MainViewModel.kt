package com.workouttracker.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.workouttracker.data.model.Workout
import com.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = WorkoutRepository.getInstance(application)
    
    private val _workouts = MutableLiveData<List<Workout>>()
    val workouts: LiveData<List<Workout>> = _workouts
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    private val _isLoggedOut = MutableLiveData<Boolean>()
    val isLoggedOut: LiveData<Boolean> = _isLoggedOut
    
    fun loadWorkouts() {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getWorkouts()
                .onSuccess { workoutList ->
                    _workouts.value = workoutList.sortedByDescending { it.date }
                    _isLoading.value = false
                }
                .onFailure { throwable ->
                    _error.value = throwable.message ?: "Failed to load workouts"
                    _isLoading.value = false
                    
                    // Check if it's an authentication error
                    if (throwable.message?.contains("401") == true || 
                        throwable.message?.contains("unauthorized", ignoreCase = true) == true) {
                        _isLoggedOut.value = true
                    }
                }
        }
    }
    
    fun deleteWorkout(workoutId: Long) {
        viewModelScope.launch {
            repository.deleteWorkout(workoutId)
                .onSuccess {
                    // Refresh the workout list
                    loadWorkouts()
                }
                .onFailure { throwable ->
                    _error.value = throwable.message ?: "Failed to delete workout"
                }
        }
    }
    
    fun logout() {
        viewModelScope.launch {
            repository.logout()
                .onSuccess {
                    _isLoggedOut.value = true
                }
                .onFailure { throwable ->
                    // Even if logout fails on server, clear local session
                    _isLoggedOut.value = true
                }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}

package com.workouttracker.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.workouttracker.data.model.User
import com.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = WorkoutRepository.getInstance(application)
    
    private val _authState = MutableLiveData<AuthState>(AuthState.Idle)
    val authState: LiveData<AuthState> = _authState
    
    fun login(username: String, password: String) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            repository.login(username, password)
                .onSuccess { user ->
                    _authState.value = AuthState.Success(user)
                }
                .onFailure { throwable ->
                    val message = when {
                        throwable.message?.contains("401") == true -> "Invalid username or password"
                        throwable.message?.contains("network", ignoreCase = true) == true -> 
                            "Network error. Please check your connection."
                        throwable.message?.contains("timeout", ignoreCase = true) == true -> 
                            "Connection timeout. Please try again."
                        else -> throwable.message ?: "Login failed. Please try again."
                    }
                    _authState.value = AuthState.Error(message)
                }
        }
    }
    
    fun register(username: String, email: String, password: String) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            repository.register(username, email, password)
                .onSuccess { user ->
                    _authState.value = AuthState.Success(user)
                }
                .onFailure { throwable ->
                    val message = when {
                        throwable.message?.contains("409") == true || 
                        throwable.message?.contains("conflict", ignoreCase = true) == true ||
                        throwable.message?.contains("already exists", ignoreCase = true) == true -> 
                            "Username or email already exists"
                        throwable.message?.contains("400") == true -> 
                            "Invalid registration data. Please check your input."
                        throwable.message?.contains("network", ignoreCase = true) == true -> 
                            "Network error. Please check your connection."
                        throwable.message?.contains("timeout", ignoreCase = true) == true -> 
                            "Connection timeout. Please try again."
                        else -> throwable.message ?: "Registration failed. Please try again."
                    }
                    _authState.value = AuthState.Error(message)
                }
        }
    }
    
    fun resetState() {
        _authState.value = AuthState.Idle
    }
}

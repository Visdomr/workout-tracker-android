package com.workouttracker.data.repository

import android.content.Context
import com.workouttracker.data.api.ApiClient
import com.workouttracker.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class WorkoutRepository private constructor(private val context: Context) {
    
    companion object {
        @Volatile
        private var INSTANCE: WorkoutRepository? = null
        
        fun getInstance(context: Context): WorkoutRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: WorkoutRepository(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
    
    private val apiClient = ApiClient.getInstance(context)
    private val api = apiClient.api
    
    // Authentication
    suspend fun login(username: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.login(username, password)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Login failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun register(username: String, email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.register(username, email, password)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Registration failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun logout(): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.logout()
                apiClient.clearSession()
                if (response.isSuccessful) {
                    Result.success(Unit)
                } else {
                    Result.failure(Exception("Logout failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                apiClient.clearSession() // Clear session anyway
                Result.success(Unit) // Don't fail logout due to network issues
            }
        }
    }
    
    // Workouts
    suspend fun getWorkouts(): Result<List<Workout>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getWorkouts()
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to load workouts: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun getWorkout(id: Long): Result<Workout> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getWorkout(id)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to load workout: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun createWorkout(request: CreateWorkoutRequest): Result<Workout> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.createWorkout(request)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to create workout: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun updateWorkout(id: Long, workout: Workout): Result<Workout> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.updateWorkout(id, workout)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to update workout: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun deleteWorkout(id: Long): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.deleteWorkout(id)
                if (response.isSuccessful) {
                    Result.success(Unit)
                } else {
                    Result.failure(Exception("Failed to delete workout: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    // Exercises
    suspend fun createExercise(request: CreateExerciseRequest): Result<Exercise> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.createExercise(request)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to create exercise: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun updateExercise(id: Long, exercise: Exercise): Result<Exercise> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.updateExercise(id, exercise)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to update exercise: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun deleteExercise(id: Long): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.deleteExercise(id)
                if (response.isSuccessful) {
                    Result.success(Unit)
                } else {
                    Result.failure(Exception("Failed to delete exercise: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    // Sets
    suspend fun createSet(request: CreateSetRequest): Result<WorkoutSet> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.createSet(request)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to create set: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun updateSet(id: Long, set: WorkoutSet): Result<WorkoutSet> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.updateSet(id, set)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to update set: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun deleteSet(id: Long): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.deleteSet(id)
                if (response.isSuccessful) {
                    Result.success(Unit)
                } else {
                    Result.failure(Exception("Failed to delete set: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    // Predefined exercises
    suspend fun getPredefinedExercises(): Result<List<PredefinedExercise>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPredefinedExercises()
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to load predefined exercises: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    suspend fun getPredefinedExercisesByCategory(category: String): Result<List<PredefinedExercise>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPredefinedExercisesByCategory(category)
                if (response.isSuccessful && response.body() != null) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Failed to load exercises for category: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}

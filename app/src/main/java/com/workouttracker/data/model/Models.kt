package com.workouttracker.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class User(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class Workout(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("duration")
    val duration: Int = 0, // Duration in minutes
    @SerializedName("notes")
    val notes: String = "",
    @SerializedName("exercises")
    val exercises: List<Exercise> = emptyList(),
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class Exercise(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("workout_id")
    val workoutId: Long = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("sets")
    val sets: List<WorkoutSet> = emptyList(),
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class WorkoutSet(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("exercise_id")
    val exerciseId: Long = 0,
    @SerializedName("set_number")
    val setNumber: Int,
    @SerializedName("reps")
    val reps: Int = 0,
    @SerializedName("weight")
    val weight: Double = 0.0,
    @SerializedName("distance")
    val distance: Double = 0.0,
    @SerializedName("duration")
    val duration: Int = 0, // Duration in seconds
    @SerializedName("rest_time")
    val restTime: Int = 0, // Rest time in seconds
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class PredefinedExercise(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
) : Parcelable

// Request models for API calls
data class LoginRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

data class RegisterRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

data class CreateWorkoutRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("duration")
    val duration: Int = 0,
    @SerializedName("notes")
    val notes: String = ""
)

data class CreateExerciseRequest(
    @SerializedName("workout_id")
    val workoutId: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("category")
    val category: String
)

data class CreateSetRequest(
    @SerializedName("exercise_id")
    val exerciseId: Long,
    @SerializedName("set_number")
    val setNumber: Int,
    @SerializedName("reps")
    val reps: Int = 0,
    @SerializedName("weight")
    val weight: Double = 0.0,
    @SerializedName("distance")
    val distance: Double = 0.0,
    @SerializedName("duration")
    val duration: Int = 0,
    @SerializedName("rest_time")
    val restTime: Int = 0
)

// Response wrapper for API responses
data class ApiResponse<T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("success")
    val success: Boolean = true
)

// Exercise categories enum
enum class ExerciseCategory(val displayName: String) {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    LEGS("Legs"),
    CORE("Core"),
    CARDIO("Cardio"),
    OTHER("Other");
    
    companion object {
        fun fromString(category: String): ExerciseCategory {
            return values().find { 
                it.name.equals(category, ignoreCase = true) ||
                it.displayName.equals(category, ignoreCase = true)
            } ?: OTHER
        }
    }
}

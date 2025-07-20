package com.workouttracker.data.api

import com.workouttracker.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface WorkoutApi {
    
    // Authentication endpoints
    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<User>
    
    @POST("register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>
    
    @POST("logout")
    suspend fun logout(): Response<Unit>
    
    // Workout endpoints
    @GET("api/workouts")
    suspend fun getWorkouts(): Response<List<Workout>>
    
    @GET("api/workouts/{id}")
    suspend fun getWorkout(@Path("id") id: Long): Response<Workout>
    
    @POST("api/workouts")
    suspend fun createWorkout(@Body request: CreateWorkoutRequest): Response<Workout>
    
    @PUT("api/workouts/{id}")
    suspend fun updateWorkout(
        @Path("id") id: Long,
        @Body workout: Workout
    ): Response<Workout>
    
    @DELETE("api/workouts/{id}")
    suspend fun deleteWorkout(@Path("id") id: Long): Response<Unit>
    
    // Exercise endpoints
    @POST("api/exercises")
    suspend fun createExercise(@Body request: CreateExerciseRequest): Response<Exercise>
    
    @PUT("api/exercises/{id}")
    suspend fun updateExercise(
        @Path("id") id: Long,
        @Body exercise: Exercise
    ): Response<Exercise>
    
    @DELETE("api/exercises/{id}")
    suspend fun deleteExercise(@Path("id") id: Long): Response<Unit>
    
    // Set endpoints
    @POST("api/sets")
    suspend fun createSet(@Body request: CreateSetRequest): Response<WorkoutSet>
    
    @PUT("api/sets/{id}")
    suspend fun updateSet(
        @Path("id") id: Long,
        @Body set: WorkoutSet
    ): Response<WorkoutSet>
    
    @DELETE("api/sets/{id}")
    suspend fun deleteSet(@Path("id") id: Long): Response<Unit>
    
    // Predefined exercise endpoints
    @GET("api/predefined-exercises")
    suspend fun getPredefinedExercises(): Response<List<PredefinedExercise>>
    
    @GET("api/predefined-exercises/category/{category}")
    suspend fun getPredefinedExercisesByCategory(
        @Path("category") category: String
    ): Response<List<PredefinedExercise>>
    
    @POST("api/predefined-exercises")
    suspend fun createPredefinedExercise(
        @Body exercise: PredefinedExercise
    ): Response<PredefinedExercise>
}

package com.workouttracker.data.api;

import com.workouttracker.data.model.*;
import retrofit2.Response;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u00032\b\b\u0001\u0010\u001f\u001a\u00020 H\u00a7@\u00a2\u0006\u0002\u0010!J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001c0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ(\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010&\u001a\u00020 2\b\b\u0001\u0010\'\u001a\u00020 H\u00a7@\u00a2\u0006\u0002\u0010(J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u001dJ2\u0010*\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010&\u001a\u00020 2\b\b\u0001\u0010+\u001a\u00020 2\b\b\u0001\u0010\'\u001a\u00020 H\u00a7@\u00a2\u0006\u0002\u0010,J(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\n\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010.J(\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u00100\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u00101J(\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u00103\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u00104\u00a8\u00065"}, d2 = {"Lcom/workouttracker/data/api/WorkoutApi;", "", "createExercise", "Lretrofit2/Response;", "Lcom/workouttracker/data/model/Exercise;", "request", "Lcom/workouttracker/data/model/CreateExerciseRequest;", "(Lcom/workouttracker/data/model/CreateExerciseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPredefinedExercise", "Lcom/workouttracker/data/model/PredefinedExercise;", "exercise", "(Lcom/workouttracker/data/model/PredefinedExercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSet", "Lcom/workouttracker/data/model/WorkoutSet;", "Lcom/workouttracker/data/model/CreateSetRequest;", "(Lcom/workouttracker/data/model/CreateSetRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWorkout", "Lcom/workouttracker/data/model/Workout;", "Lcom/workouttracker/data/model/CreateWorkoutRequest;", "(Lcom/workouttracker/data/model/CreateWorkoutRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExercise", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSet", "deleteWorkout", "getPredefinedExercises", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPredefinedExercisesByCategory", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWorkout", "getWorkouts", "login", "Lcom/workouttracker/data/model/User;", "username", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "register", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExercise", "(JLcom/workouttracker/data/model/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSet", "set", "(JLcom/workouttracker/data/model/WorkoutSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWorkout", "workout", "(JLcom/workouttracker/data/model/Workout;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface WorkoutApi {
    
    @retrofit2.http.POST(value = "login")
    @retrofit2.http.FormUrlEncoded()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Field(value = "username")
    @org.jetbrains.annotations.NotNull()
    java.lang.String username, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.User>> $completion);
    
    @retrofit2.http.POST(value = "register")
    @retrofit2.http.FormUrlEncoded()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Field(value = "username")
    @org.jetbrains.annotations.NotNull()
    java.lang.String username, @retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull()
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.User>> $completion);
    
    @retrofit2.http.POST(value = "logout")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/workouts")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWorkouts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.workouttracker.data.model.Workout>>> $completion);
    
    @retrofit2.http.GET(value = "api/workouts/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWorkout(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.Workout>> $completion);
    
    @retrofit2.http.POST(value = "api/workouts")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createWorkout(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.CreateWorkoutRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.Workout>> $completion);
    
    @retrofit2.http.PUT(value = "api/workouts/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWorkout(@retrofit2.http.Path(value = "id")
    long id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.Workout workout, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.Workout>> $completion);
    
    @retrofit2.http.DELETE(value = "api/workouts/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWorkout(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "api/exercises")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createExercise(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.CreateExerciseRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.Exercise>> $completion);
    
    @retrofit2.http.PUT(value = "api/exercises/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateExercise(@retrofit2.http.Path(value = "id")
    long id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.Exercise>> $completion);
    
    @retrofit2.http.DELETE(value = "api/exercises/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteExercise(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "api/sets")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createSet(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.CreateSetRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.WorkoutSet>> $completion);
    
    @retrofit2.http.PUT(value = "api/sets/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSet(@retrofit2.http.Path(value = "id")
    long id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.WorkoutSet set, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.WorkoutSet>> $completion);
    
    @retrofit2.http.DELETE(value = "api/sets/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSet(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/predefined-exercises")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPredefinedExercises(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.workouttracker.data.model.PredefinedExercise>>> $completion);
    
    @retrofit2.http.GET(value = "api/predefined-exercises/category/{category}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPredefinedExercisesByCategory(@retrofit2.http.Path(value = "category")
    @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.workouttracker.data.model.PredefinedExercise>>> $completion);
    
    @retrofit2.http.POST(value = "api/predefined-exercises")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createPredefinedExercise(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.PredefinedExercise exercise, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.workouttracker.data.model.PredefinedExercise>> $completion);
}
package com.workouttracker.ui.workout;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.workouttracker.data.model.CreateWorkoutRequest;
import com.workouttracker.data.model.Workout;
import com.workouttracker.data.repository.WorkoutRepository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/workouttracker/ui/workout/CreateWorkoutViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_createState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/workouttracker/ui/workout/CreateWorkoutState;", "createState", "Landroidx/lifecycle/LiveData;", "getCreateState", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/workouttracker/data/repository/WorkoutRepository;", "createWorkout", "", "name", "", "date", "duration", "", "notes", "resetState", "updateWorkout", "id", "", "workout", "Lcom/workouttracker/data/model/Workout;", "app_debug"})
public final class CreateWorkoutViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.workouttracker.data.repository.WorkoutRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.workouttracker.ui.workout.CreateWorkoutState> _createState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.workouttracker.ui.workout.CreateWorkoutState> createState = null;
    
    public CreateWorkoutViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.workouttracker.ui.workout.CreateWorkoutState> getCreateState() {
        return null;
    }
    
    public final void createWorkout(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String date, int duration, @org.jetbrains.annotations.NotNull()
    java.lang.String notes) {
    }
    
    public final void updateWorkout(long id, @org.jetbrains.annotations.NotNull()
    com.workouttracker.data.model.Workout workout) {
    }
    
    public final void resetState() {
    }
}
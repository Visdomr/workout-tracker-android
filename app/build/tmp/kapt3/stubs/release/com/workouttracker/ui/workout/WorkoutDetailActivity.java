package com.workouttracker.ui.workout;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0014J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010\'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/workouttracker/ui/workout/WorkoutDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/workouttracker/databinding/ActivityWorkoutDetailBinding;", "exerciseAdapter", "Lcom/workouttracker/ui/workout/ExerciseAdapter;", "viewModel", "Lcom/workouttracker/ui/workout/WorkoutDetailViewModel;", "getViewModel", "()Lcom/workouttracker/ui/workout/WorkoutDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workout", "Lcom/workouttracker/data/model/Workout;", "displayWorkoutDetails", "", "formatDate", "", "dateString", "getCategoryColor", "", "category", "Lcom/workouttracker/data/model/ExerciseCategory;", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "setupFab", "setupRecyclerView", "setupToolbar", "showDeleteExerciseConfirmation", "exerciseId", "", "showDeleteWorkoutConfirmation", "showError", "message", "updateCategorySummary", "updateExerciseList", "Companion", "app_release"})
public final class WorkoutDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_WORKOUT = "extra_workout";
    private com.workouttracker.databinding.ActivityWorkoutDetailBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.workouttracker.ui.workout.ExerciseAdapter exerciseAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.workouttracker.data.model.Workout workout;
    @org.jetbrains.annotations.NotNull()
    public static final com.workouttracker.ui.workout.WorkoutDetailActivity.Companion Companion = null;
    
    public WorkoutDetailActivity() {
        super();
    }
    
    private final com.workouttracker.ui.workout.WorkoutDetailViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupFab() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void displayWorkoutDetails(com.workouttracker.data.model.Workout workout) {
    }
    
    private final void updateExerciseList(com.workouttracker.data.model.Workout workout) {
    }
    
    private final void updateCategorySummary(com.workouttracker.data.model.Workout workout) {
    }
    
    private final int getCategoryColor(com.workouttracker.data.model.ExerciseCategory category) {
        return 0;
    }
    
    private final java.lang.String formatDate(java.lang.String dateString) {
        return null;
    }
    
    private final void showDeleteExerciseConfirmation(long exerciseId) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void showDeleteWorkoutConfirmation() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/workouttracker/ui/workout/WorkoutDetailActivity$Companion;", "", "()V", "EXTRA_WORKOUT", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
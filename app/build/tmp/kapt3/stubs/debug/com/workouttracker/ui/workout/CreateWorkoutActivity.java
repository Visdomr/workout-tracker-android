package com.workouttracker.ui.workout;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0018\u0010!\u001a\u00020\u00132\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\'\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/workouttracker/ui/workout/CreateWorkoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/workouttracker/databinding/ActivityCreateWorkoutBinding;", "isEditMode", "", "selectedDate", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "viewModel", "Lcom/workouttracker/ui/workout/CreateWorkoutViewModel;", "getViewModel", "()Lcom/workouttracker/ui/workout/CreateWorkoutViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workoutToEdit", "Lcom/workouttracker/data/model/Workout;", "observeViewModel", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "populateFields", "workout", "saveWorkout", "setupToolbar", "setupUI", "setupValidation", "showCancelConfirmation", "onConfirm", "Lkotlin/Function0;", "showDatePicker", "showDurationPicker", "showError", "message", "", "showSuccess", "updateDateDisplay", "validateForm", "Companion", "app_debug"})
public final class CreateWorkoutActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_WORKOUT = "extra_workout";
    private com.workouttracker.databinding.ActivityCreateWorkoutBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean isEditMode = false;
    @org.jetbrains.annotations.Nullable()
    private com.workouttracker.data.model.Workout workoutToEdit;
    private java.util.Calendar selectedDate;
    @org.jetbrains.annotations.NotNull()
    public static final com.workouttracker.ui.workout.CreateWorkoutActivity.Companion Companion = null;
    
    public CreateWorkoutActivity() {
        super();
    }
    
    private final com.workouttracker.ui.workout.CreateWorkoutViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupUI() {
    }
    
    private final void setupValidation() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void populateFields(com.workouttracker.data.model.Workout workout) {
    }
    
    private final void showDatePicker() {
    }
    
    private final void showDurationPicker() {
    }
    
    private final void updateDateDisplay() {
    }
    
    private final void validateForm() {
    }
    
    private final void saveWorkout() {
    }
    
    private final void showCancelConfirmation(kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm) {
    }
    
    private final void showSuccess(java.lang.String message) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/workouttracker/ui/workout/CreateWorkoutActivity$Companion;", "", "()V", "EXTRA_WORKOUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
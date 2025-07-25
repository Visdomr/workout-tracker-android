package com.workouttracker.ui.workout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.workouttracker.R;
import com.workouttracker.data.model.Exercise;
import com.workouttracker.data.model.ExerciseCategory;
import com.workouttracker.databinding.ItemExerciseBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013BA\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/workouttracker/ui/workout/ExerciseAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/workouttracker/data/model/Exercise;", "Lcom/workouttracker/ui/workout/ExerciseAdapter$ExerciseViewHolder;", "onExerciseClick", "Lkotlin/Function1;", "", "onEditExerciseClick", "onDeleteExerciseClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ExerciseDiffCallback", "ExerciseViewHolder", "app_debug"})
public final class ExerciseAdapter extends androidx.recyclerview.widget.ListAdapter<com.workouttracker.data.model.Exercise, com.workouttracker.ui.workout.ExerciseAdapter.ExerciseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.workouttracker.data.model.Exercise, kotlin.Unit> onExerciseClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.workouttracker.data.model.Exercise, kotlin.Unit> onEditExerciseClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.workouttracker.data.model.Exercise, kotlin.Unit> onDeleteExerciseClick = null;
    
    public ExerciseAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workouttracker.data.model.Exercise, kotlin.Unit> onExerciseClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workouttracker.data.model.Exercise, kotlin.Unit> onEditExerciseClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workouttracker.data.model.Exercise, kotlin.Unit> onDeleteExerciseClick) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workouttracker.ui.workout.ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.workouttracker.ui.workout.ExerciseAdapter.ExerciseViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/workouttracker/ui/workout/ExerciseAdapter$ExerciseDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/workouttracker/data/model/Exercise;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ExerciseDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.workouttracker.data.model.Exercise> {
        
        public ExerciseDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.workouttracker.data.model.Exercise oldItem, @org.jetbrains.annotations.NotNull()
        com.workouttracker.data.model.Exercise newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.workouttracker.data.model.Exercise oldItem, @org.jetbrains.annotations.NotNull()
        com.workouttracker.data.model.Exercise newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/workouttracker/ui/workout/ExerciseAdapter$ExerciseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/workouttracker/databinding/ItemExerciseBinding;", "(Lcom/workouttracker/ui/workout/ExerciseAdapter;Lcom/workouttracker/databinding/ItemExerciseBinding;)V", "bind", "", "exercise", "Lcom/workouttracker/data/model/Exercise;", "getCategoryColor", "", "category", "Lcom/workouttracker/data/model/ExerciseCategory;", "app_debug"})
    public final class ExerciseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.workouttracker.databinding.ItemExerciseBinding binding = null;
        
        public ExerciseViewHolder(@org.jetbrains.annotations.NotNull()
        com.workouttracker.databinding.ItemExerciseBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.workouttracker.data.model.Exercise exercise) {
        }
        
        private final int getCategoryColor(com.workouttracker.data.model.ExerciseCategory category) {
            return 0;
        }
    }
}
package com.workouttracker.data.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlinx.parcelize.Parcelize;
import java.util.Date;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/workouttracker/data/model/ExerciseCategory;", "", "displayName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "CHEST", "BACK", "SHOULDERS", "ARMS", "LEGS", "CORE", "CARDIO", "OTHER", "Companion", "app_debug"})
public enum ExerciseCategory {
    /*public static final*/ CHEST /* = new CHEST(null) */,
    /*public static final*/ BACK /* = new BACK(null) */,
    /*public static final*/ SHOULDERS /* = new SHOULDERS(null) */,
    /*public static final*/ ARMS /* = new ARMS(null) */,
    /*public static final*/ LEGS /* = new LEGS(null) */,
    /*public static final*/ CORE /* = new CORE(null) */,
    /*public static final*/ CARDIO /* = new CARDIO(null) */,
    /*public static final*/ OTHER /* = new OTHER(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.workouttracker.data.model.ExerciseCategory.Companion Companion = null;
    
    ExerciseCategory(java.lang.String displayName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workouttracker.data.model.ExerciseCategory> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/workouttracker/data/model/ExerciseCategory$Companion;", "", "()V", "fromString", "Lcom/workouttracker/data/model/ExerciseCategory;", "category", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.workouttracker.data.model.ExerciseCategory fromString(@org.jetbrains.annotations.NotNull()
        java.lang.String category) {
            return null;
        }
    }
}
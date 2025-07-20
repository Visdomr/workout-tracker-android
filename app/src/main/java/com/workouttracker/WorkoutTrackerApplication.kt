package com.workouttracker

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class WorkoutTrackerApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize ThreeTenABP for date/time handling
        AndroidThreeTen.init(this)
    }
}

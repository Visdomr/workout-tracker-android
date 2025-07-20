package com.workouttracker.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.workouttracker.R
import com.workouttracker.data.api.ApiClient
import com.workouttracker.databinding.ActivityMainBinding
import com.workouttracker.ui.auth.LoginActivity
import com.workouttracker.ui.workout.CreateWorkoutActivity
import com.workouttracker.ui.workout.WorkoutAdapter
import com.workouttracker.ui.workout.WorkoutDetailActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var workoutAdapter: WorkoutAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupRecyclerView()
        setupFab()
        setupSwipeRefresh()
        observeViewModel()
        
        // Load workouts
        viewModel.loadWorkouts()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }
    
    private fun setupRecyclerView() {
        workoutAdapter = WorkoutAdapter(
            onWorkoutClick = { workout ->
                val intent = Intent(this, WorkoutDetailActivity::class.java).apply {
                    putExtra(WorkoutDetailActivity.EXTRA_WORKOUT, workout)
                }
                startActivity(intent)
            },
            onEditClick = { workout ->
                val intent = Intent(this, CreateWorkoutActivity::class.java).apply {
                    putExtra(CreateWorkoutActivity.EXTRA_WORKOUT, workout)
                }
                startActivity(intent)
            },
            onDeleteClick = { workout ->
                showDeleteConfirmation(workout.id)
            }
        )
        
        binding.recyclerViewWorkouts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = workoutAdapter
        }
    }
    
    private fun setupFab() {
        binding.fabAddWorkout.setOnClickListener {
            startActivity(Intent(this, CreateWorkoutActivity::class.java))
        }
    }
    
    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadWorkouts()
        }
    }
    
    private fun observeViewModel() {
        viewModel.workouts.observe(this) { workouts ->
            workoutAdapter.submitList(workouts)
            updateEmptyState(workouts.isEmpty())
        }
        
        viewModel.isLoading.observe(this) { isLoading ->
            binding.swipeRefreshLayout.isRefreshing = isLoading
        }
        
        viewModel.error.observe(this) { error ->
            error?.let {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage(it)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
                viewModel.clearError()
            }
        }
        
        viewModel.isLoggedOut.observe(this) { isLoggedOut ->
            if (isLoggedOut) {
                navigateToLogin()
            }
        }
    }
    
    private fun updateEmptyState(isEmpty: Boolean) {
        if (isEmpty) {
            binding.recyclerViewWorkouts.visibility = android.view.View.GONE
            binding.layoutEmpty.visibility = android.view.View.VISIBLE
            binding.textEmptyTitle.text = getString(R.string.no_workouts_yet)
            binding.textEmptyMessage.text = getString(R.string.create_first_workout)
        } else {
            binding.recyclerViewWorkouts.visibility = android.view.View.VISIBLE
            binding.layoutEmpty.visibility = android.view.View.GONE
        }
    }
    
    private fun showDeleteConfirmation(workoutId: Long) {
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.delete_workout))
            .setMessage(getString(R.string.confirm_delete_workout))
            .setPositiveButton(getString(R.string.delete)) { _, _ ->
                viewModel.deleteWorkout(workoutId)
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {
                viewModel.loadWorkouts()
                true
            }
            R.id.action_settings -> {
                // TODO: Implement settings
                true
            }
            R.id.action_logout -> {
                showLogoutConfirmation()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    private fun showLogoutConfirmation() {
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.logout))
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton(getString(R.string.logout)) { _, _ ->
                viewModel.logout()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
    
    override fun onResume() {
        super.onResume()
        // Refresh workouts when returning to the activity
        viewModel.loadWorkouts()
    }
}

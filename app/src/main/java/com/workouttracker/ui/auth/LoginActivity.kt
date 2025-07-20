package com.workouttracker.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.workouttracker.R
import com.workouttracker.databinding.ActivityLoginBinding
import com.workouttracker.ui.MainActivity

class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AuthViewModel by viewModels()
    private var isLoginMode = true
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupUI()
        setupValidation()
        observeViewModel()
    }
    
    private fun setupUI() {
        binding.apply {
            buttonLogin.setOnClickListener {
                if (isLoginMode) {
                    performLogin()
                } else {
                    performRegister()
                }
            }
            
            textToggleMode.setOnClickListener {
                toggleMode()
            }
            
            // Set initial state
            updateUIMode()
        }
    }
    
    private fun setupValidation() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateForm()
            }
        }
        
        binding.apply {
            editTextUsername.addTextChangedListener(textWatcher)
            editTextEmail.addTextChangedListener(textWatcher)
            editTextPassword.addTextChangedListener(textWatcher)
            editTextConfirmPassword.addTextChangedListener(textWatcher)
        }
    }
    
    private fun observeViewModel() {
        viewModel.authState.observe(this) { state ->
            when (state) {
                is AuthState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.buttonLogin.isEnabled = false
                }
                is AuthState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    navigateToMain()
                }
                is AuthState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.buttonLogin.isEnabled = true
                    showError(state.message)
                }
                is AuthState.Idle -> {
                    binding.progressBar.visibility = View.GONE
                    binding.buttonLogin.isEnabled = true
                }
            }
        }
    }
    
    private fun performLogin() {
        val username = binding.editTextUsername.text.toString().trim()
        val password = binding.editTextPassword.text.toString()
        
        if (validateLoginForm(username, password)) {
            viewModel.login(username, password)
        }
    }
    
    private fun performRegister() {
        val username = binding.editTextUsername.text.toString().trim()
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString()
        val confirmPassword = binding.editTextConfirmPassword.text.toString()
        
        if (validateRegisterForm(username, email, password, confirmPassword)) {
            viewModel.register(username, email, password)
        }
    }
    
    private fun validateLoginForm(username: String, password: String): Boolean {
        var isValid = true
        
        if (username.isEmpty()) {
            binding.textInputLayoutUsername.error = getString(R.string.error_required_field)
            isValid = false
        } else {
            binding.textInputLayoutUsername.error = null
        }
        
        if (password.isEmpty()) {
            binding.textInputLayoutPassword.error = getString(R.string.error_required_field)
            isValid = false
        } else {
            binding.textInputLayoutPassword.error = null
        }
        
        return isValid
    }
    
    private fun validateRegisterForm(
        username: String, 
        email: String, 
        password: String, 
        confirmPassword: String
    ): Boolean {
        var isValid = true
        
        if (username.isEmpty()) {
            binding.textInputLayoutUsername.error = getString(R.string.error_required_field)
            isValid = false
        } else {
            binding.textInputLayoutUsername.error = null
        }
        
        if (email.isEmpty()) {
            binding.textInputLayoutEmail.error = getString(R.string.error_required_field)
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.textInputLayoutEmail.error = getString(R.string.error_invalid_email)
            isValid = false
        } else {
            binding.textInputLayoutEmail.error = null
        }
        
        if (password.isEmpty()) {
            binding.textInputLayoutPassword.error = getString(R.string.error_required_field)
            isValid = false
        } else if (password.length < 6) {
            binding.textInputLayoutPassword.error = getString(R.string.error_password_too_short)
            isValid = false
        } else {
            binding.textInputLayoutPassword.error = null
        }
        
        if (confirmPassword.isEmpty()) {
            binding.textInputLayoutConfirmPassword.error = getString(R.string.error_required_field)
            isValid = false
        } else if (password != confirmPassword) {
            binding.textInputLayoutConfirmPassword.error = getString(R.string.error_password_mismatch)
            isValid = false
        } else {
            binding.textInputLayoutConfirmPassword.error = null
        }
        
        return isValid
    }
    
    private fun validateForm() {
        val username = binding.editTextUsername.text.toString().trim()
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString()
        val confirmPassword = binding.editTextConfirmPassword.text.toString()
        
        val isFormValid = if (isLoginMode) {
            username.isNotEmpty() && password.isNotEmpty()
        } else {
            username.isNotEmpty() && 
            email.isNotEmpty() && 
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            password.length >= 6 && 
            password == confirmPassword
        }
        
        binding.buttonLogin.isEnabled = isFormValid
    }
    
    private fun toggleMode() {
        isLoginMode = !isLoginMode
        updateUIMode()
        clearErrors()
        validateForm()
    }
    
    private fun updateUIMode() {
        binding.apply {
            if (isLoginMode) {
                textTitle.text = getString(R.string.login)
                textInputLayoutEmail.visibility = View.GONE
                textInputLayoutConfirmPassword.visibility = View.GONE
                buttonLogin.text = getString(R.string.sign_in)
                textToggleMode.text = getString(R.string.dont_have_account)
            } else {
                textTitle.text = getString(R.string.register)
                textInputLayoutEmail.visibility = View.VISIBLE
                textInputLayoutConfirmPassword.visibility = View.VISIBLE
                buttonLogin.text = getString(R.string.sign_up)
                textToggleMode.text = getString(R.string.already_have_account)
            }
        }
    }
    
    private fun clearErrors() {
        binding.apply {
            textInputLayoutUsername.error = null
            textInputLayoutEmail.error = null
            textInputLayoutPassword.error = null
            textInputLayoutConfirmPassword.error = null
        }
    }
    
    private fun showError(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
    
    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}

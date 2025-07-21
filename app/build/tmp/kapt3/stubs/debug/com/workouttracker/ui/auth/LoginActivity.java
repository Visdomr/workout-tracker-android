package com.workouttracker.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.workouttracker.R;
import com.workouttracker.databinding.ActivityLoginBinding;
import com.workouttracker.ui.MainActivity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0002J(\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006$"}, d2 = {"Lcom/workouttracker/ui/auth/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/workouttracker/databinding/ActivityLoginBinding;", "isLoginMode", "", "viewModel", "Lcom/workouttracker/ui/auth/AuthViewModel;", "getViewModel", "()Lcom/workouttracker/ui/auth/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clearErrors", "", "navigateToMain", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performLogin", "performRegister", "setupUI", "setupValidation", "showError", "message", "", "toggleMode", "updateUIMode", "validateForm", "validateLoginForm", "username", "password", "validateRegisterForm", "email", "confirmPassword", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.workouttracker.databinding.ActivityLoginBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean isLoginMode = true;
    
    public LoginActivity() {
        super();
    }
    
    private final com.workouttracker.ui.auth.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupValidation() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void performLogin() {
    }
    
    private final void performRegister() {
    }
    
    private final boolean validateLoginForm(java.lang.String username, java.lang.String password) {
        return false;
    }
    
    private final boolean validateRegisterForm(java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String confirmPassword) {
        return false;
    }
    
    private final void validateForm() {
    }
    
    private final void toggleMode() {
    }
    
    private final void updateUIMode() {
    }
    
    private final void clearErrors() {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void navigateToMain() {
    }
}
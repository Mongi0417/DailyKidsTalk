package com.mongi0417.dailykidstalk.viewmodel;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends ViewModel {
    private boolean hasAccount = false;
    private String email, password;

    public LoginViewModel() {
    }

    public boolean canLogin(String email, String password) {
        this.email = email;
        this.password = password;
        loginUser();
        return hasAccount;
    }

    private void loginUser() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> hasAccount = task.isSuccessful());
    }
}

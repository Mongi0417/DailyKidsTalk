package com.mongi0417.dailykidstalk.viewmodel;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends ViewModel {
    private boolean hasAccount = false;

    public LoginViewModel() {
    }

    public boolean canLogin(String email, String password) {
        return loginUser(email, password);
    }

    private boolean loginUser(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> hasAccount = task.isSuccessful());
        return hasAccount;
    }
}

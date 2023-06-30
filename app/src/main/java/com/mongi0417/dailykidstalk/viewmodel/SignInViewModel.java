package com.mongi0417.dailykidstalk.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends ViewModel {
    private MutableLiveData<String> _email = new MutableLiveData<>();
    private MutableLiveData<String> _password = new MutableLiveData<>();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    public SignInViewModel() {
        _email.setValue("");
        _password.setValue("");
    }

    public void setAccount(String email, String password) {
        _email.setValue(email);
        _password.setValue(password);
    }

    private void setAuthListener() {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = auth.getCurrentUser();
                if (user != null) {
                }
            }
        };
    }

    public boolean canLogin() {
        return false;
    }

    @Override
    protected void onCleared() {
        if (authListener != null)
            auth.removeAuthStateListener(authListener);
        super.onCleared();
    }
}

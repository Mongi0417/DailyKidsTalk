package com.mongi0417.dailykidstalk.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mongi0417.dailykidstalk.databinding.LayoutLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private LayoutLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = LayoutLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());

    }
}
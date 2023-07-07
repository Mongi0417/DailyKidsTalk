package com.mongi0417.dailykidstalk.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mongi0417.dailykidstalk.databinding.LayoutSignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private LayoutSignUpBinding signUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = LayoutSignUpBinding.inflate(getLayoutInflater());
        setContentView(signUpBinding.getRoot());
    }
}
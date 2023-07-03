package com.mongi0417.dailykidstalk.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mongi0417.dailykidstalk.databinding.LayoutHomeBinding;

public class HomeActivity extends AppCompatActivity {
    LayoutHomeBinding homeBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = LayoutHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());
    }
}

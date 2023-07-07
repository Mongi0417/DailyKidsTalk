package com.mongi0417.dailykidstalk.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mongi0417.dailykidstalk.databinding.FragmentSignUpImageBinding;

public class SignUpImageFragment extends Fragment {
    private FragmentSignUpImageBinding signUpImageBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        signUpImageBinding = FragmentSignUpImageBinding.inflate(inflater, container, false);
        return signUpImageBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        signUpImageBinding = null;
    }
}
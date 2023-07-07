package com.mongi0417.dailykidstalk.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mongi0417.dailykidstalk.R;
import com.mongi0417.dailykidstalk.databinding.FragmentSignUpAccountBinding;
import com.mongi0417.dailykidstalk.viewmodel.SignUpViewModel;

public class SignUpAccountFragment extends Fragment implements View.OnClickListener {
    private FragmentSignUpAccountBinding signUpAccountBinding;
    private SignUpViewModel signUpViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        signUpAccountBinding = FragmentSignUpAccountBinding.inflate(inflater, container, false);

        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        return signUpAccountBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == signUpAccountBinding.signUpBtnCheckEmail.getId()) { // 이메일 중복 검사
            if(signUpViewModel.hasDuplicateEmail())
                Toast.makeText(getActivity(), R.string.duplicate_email, Toast.LENGTH_SHORT).show();
            else {

            }
        } else if (view.getId() == signUpAccountBinding.signUpBtnCheckNickname.getId()) { // 닉네임 중복 검사
            if(signUpViewModel.hasDuplicateNickname())
                Toast.makeText(getActivity(), R.string.duplicate_nickname, Toast.LENGTH_SHORT).show();
            else {

            }
        } else { // 다음 버튼

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        signUpAccountBinding = null; // View Binding 사용 시, View보다 오래 지속되기 때문에 메모리 누수가 발생할 수 있음. 이를 방지.
    }
}

package com.mongi0417.dailykidstalk.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mongi0417.dailykidstalk.databinding.LayoutSignInBinding;
import com.mongi0417.dailykidstalk.viewmodel.SignInViewModel;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private LayoutSignInBinding signinBinding;
    private SignInViewModel signInViewModel;
    private long waitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signinBinding = LayoutSignInBinding.inflate(getLayoutInflater());
        setContentView(signinBinding.getRoot());

        signInViewModel = new ViewModelProvider(this).get(SignInViewModel.class);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId() == signinBinding.loginBtnSignIn.getId()) {
            if (!TextUtils.isEmpty(signinBinding.loginEdtEmail.getText().toString()) && !TextUtils.isEmpty(signinBinding.loginEdtEmail.getText().toString())) {
                if (signInViewModel.canLogin()) {
                    intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(this, "아이디 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            } else {
                intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 2000) {
            waitTime = System.currentTimeMillis();
            Toast.makeText(SignInActivity.this, "뒤로 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
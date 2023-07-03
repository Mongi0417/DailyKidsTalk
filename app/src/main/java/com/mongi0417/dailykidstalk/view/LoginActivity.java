package com.mongi0417.dailykidstalk.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mongi0417.dailykidstalk.databinding.LayoutLoginBinding;
import com.mongi0417.dailykidstalk.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LayoutLoginBinding loginBinding;
    private LoginViewModel loginViewModel;
    private long waitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = LayoutLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        setClickListener();
    }

    private void setClickListener() {
        loginBinding.loginBtnLogin.setOnClickListener(this);
        loginBinding.loginBtnSignUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId() == loginBinding.loginBtnLogin.getId()) { // 로그인 버튼을 누를 시
            String email = loginBinding.loginEdtEmail.getText().toString();
            String password = loginBinding.loginEdtPassword.getText().toString();
            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) { // 공백이 존재하지 않을 때
                if (loginViewModel.canLogin(email, password)) { // 계정이 존재한다면,
                    intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(this, "이메일 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            } else // 공백이 존재할 때
                Toast.makeText(this, "이메일과 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
        } else { // 회원 가입 버튼을 누를 시
            intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 2000) {
            waitTime = System.currentTimeMillis();
            Toast.makeText(LoginActivity.this, "뒤로 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
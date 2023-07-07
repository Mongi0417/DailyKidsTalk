package com.mongi0417.dailykidstalk.viewmodel;

import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {
    private boolean hasDuplicateEmail = false;
    private boolean hasDuplicateNickname = false;

    public SignUpViewModel() {
    }
    
    public boolean hasDuplicateEmail() {

        return hasDuplicateEmail;
    }

    public boolean hasDuplicateNickname() {

        return hasDuplicateNickname;
    }

    private boolean checkDuplicateEmail() {

        return true;
    }
}
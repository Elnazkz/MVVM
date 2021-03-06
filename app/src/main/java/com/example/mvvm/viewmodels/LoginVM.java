package com.example.mvvm.viewmodels;

import androidx.databinding.BaseObservable;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvm.model.User;

public class LoginVM extends BaseObservable {
    private static final String successMsg = "You've Logged in!";
    private static final String errorMsg = "Email/Pass not valid!";
    private User user;

    public LoginVM(){
        user = new User("","");
    }

    @Bindable
    private String message=null;

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    public String getMessage() {
        return message;
    }

    @Bindable
    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPass() {
        return user.getPassword();
    }

    public void setPass(String pass) {
        user.setPassword(pass);
        notifyPropertyChanged(BR.pass);
    }

    public boolean isInputValid(){
        return
                !TextUtils.isEmpty(getEmail()) &&
                getPass().length()>4 &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    public void onLoginClicked(){
        if(isInputValid()){
            setMessage(successMsg);
        }else{
            setMessage(errorMsg);
        }
    }
}

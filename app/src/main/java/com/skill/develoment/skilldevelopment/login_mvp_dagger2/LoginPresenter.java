package com.skill.develoment.skilldevelopment.login_mvp_dagger2;

import android.support.annotation.Nullable;

public class LoginPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    LoginActivityMVP.View view;
    LoginActivityMVP.Model model;

    public LoginPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getUserId().trim().equals("") || view.getPassword().trim().equals(""))
                view.showErrorMessage("Sorry enter valid input");
            else {
                model.createUser(view.getUserId(), view.getPassword());
                view.showSuccessMessage("User CreatedSuccessFully");
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null)
            view.showErrorMessage("Sorry no user saved yet !");
        else if (view != null) {
            view.setUserId(user.getUserName());
            view.setPassword(user.getPassword());
        }
    }
}

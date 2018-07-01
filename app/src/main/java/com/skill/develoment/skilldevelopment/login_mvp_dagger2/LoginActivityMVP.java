package com.skill.develoment.skilldevelopment.login_mvp_dagger2;

public interface LoginActivityMVP {
    public interface View{
        String getUserId();
        String getPassword();

        void setUserId(String userId);
        void setPassword(String password);

        void showErrorMessage(String message);
        void showSuccessMessage(String message);
    }

    public interface Model{
        void createUser(String useraId, String password);
        User getUser();
    }

    public interface Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

}

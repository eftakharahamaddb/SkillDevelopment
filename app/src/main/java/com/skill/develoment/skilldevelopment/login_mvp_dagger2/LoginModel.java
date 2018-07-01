package com.skill.develoment.skilldevelopment.login_mvp_dagger2;

public class LoginModel implements LoginActivityMVP.Model {

    public LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LoginRepository loginRepository;
    static int id = 0;

    @Override
    public void createUser(String userId, String password) {
        User user = new User(++id, userId, password);
        loginRepository.setUser(user);
    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}

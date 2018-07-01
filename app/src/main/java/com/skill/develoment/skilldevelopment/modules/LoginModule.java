package com.skill.develoment.skilldevelopment.modules;

import com.skill.develoment.skilldevelopment.login_mvp_dagger2.LoginActivityMVP;
import com.skill.develoment.skilldevelopment.login_mvp_dagger2.LoginModel;
import com.skill.develoment.skilldevelopment.login_mvp_dagger2.LoginPresenter;
import com.skill.develoment.skilldevelopment.login_mvp_dagger2.LoginRepository;
import com.skill.develoment.skilldevelopment.login_mvp_dagger2.MemoryRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository loginRepository) {
        return new LoginModel(loginRepository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }
}

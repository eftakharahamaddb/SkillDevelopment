package com.skill.develoment.skilldevelopment.components;

import android.app.Activity;

import com.skill.develoment.skilldevelopment.login_mvp_dagger2.LoginActivity;
import com.skill.develoment.skilldevelopment.modules.ImageLoaderModules;
import com.skill.develoment.skilldevelopment.modules.LoginModule;
import com.skill.develoment.skilldevelopment.modules.NetworkApiModule;
import com.skill.develoment.skilldevelopment.modules.SampleAppModule;
import com.skill.develoment.skilldevelopment.modules.SharedPreferenceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkApiModule.class,
        SharedPreferenceModule.class,
        ImageLoaderModules.class,
        SampleAppModule.class,
        LoginModule.class
})
public interface ControllerComponent {
    void inject(LoginActivity activity);
}


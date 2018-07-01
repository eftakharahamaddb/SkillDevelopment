package com.skill.develoment.skilldevelopment.businesslogic;

import android.app.Application;

import com.skill.develoment.skilldevelopment.components.ControllerComponent;
import com.skill.develoment.skilldevelopment.components.DaggerControllerComponent;
import com.skill.develoment.skilldevelopment.modules.ImageLoaderModules;
import com.skill.develoment.skilldevelopment.modules.LoginModule;
import com.skill.develoment.skilldevelopment.modules.NetworkApiModule;
import com.skill.develoment.skilldevelopment.modules.SampleAppModule;
import com.skill.develoment.skilldevelopment.modules.SharedPreferenceModule;

public class SampleApp extends Application {
    public ControllerComponent getControllerComponent() {
        return controllerComponent;
    }

    private ControllerComponent controllerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        controllerComponent = DaggerControllerComponent
                .builder()
                .imageLoaderModules(new ImageLoaderModules(new ImageLoader()))
                .sharedPreferenceModule(new SharedPreferenceModule(new SharedPreference()))
                .networkApiModule(new NetworkApiModule())
                .sampleAppModule(new SampleAppModule(this))
                .loginModule(new LoginModule())
                .build();
    }
}

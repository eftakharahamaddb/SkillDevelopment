package com.skill.develoment.skilldevelopment.businesslogic;

import android.app.Application;

import com.skill.develoment.skilldevelopment.components.ControllerComponent;
import com.skill.develoment.skilldevelopment.components.DaggerControllerComponent;
import com.skill.develoment.skilldevelopment.modules.ImageLoaderModules;
import com.skill.develoment.skilldevelopment.modules.NetworkApiModule;
import com.skill.develoment.skilldevelopment.modules.SampleAppModule;
import com.skill.develoment.skilldevelopment.modules.SharedPreferenceModule;

public class SampleApp extends Application {

    private ControllerComponent controllerComponent;
    @Override
    public void onCreate() {
        controllerComponent = DaggerControllerComponent
                .builder()
                .imageLoaderModules(new ImageLoaderModules(new ImageLoader()))
                .sharedPreferenceModule(new SharedPreferenceModule(new SharedPreference()))
                .networkApiModule(new NetworkApiModule(new NetworkApi()))
                .sampleAppModule(new SampleAppModule(this))
                .build();
        super.onCreate();
    }
}

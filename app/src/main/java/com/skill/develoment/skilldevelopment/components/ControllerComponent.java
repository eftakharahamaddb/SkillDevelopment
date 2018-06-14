package com.skill.develoment.skilldevelopment.components;

import android.app.Activity;

import com.skill.develoment.skilldevelopment.modules.ImageLoaderModules;
import com.skill.develoment.skilldevelopment.modules.NetworkApiModule;
import com.skill.develoment.skilldevelopment.modules.SampleAppModule;
import com.skill.develoment.skilldevelopment.modules.SharedPreferenceModule;

import dagger.Component;

@Component(modules = {
        NetworkApiModule.class,
        SharedPreferenceModule.class,
        ImageLoaderModules.class,
        SampleAppModule.class
})
public interface ControllerComponent {
    void inject(Activity activity);
}


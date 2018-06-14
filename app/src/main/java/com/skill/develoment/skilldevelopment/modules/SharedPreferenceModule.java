package com.skill.develoment.skilldevelopment.modules;

import com.skill.develoment.skilldevelopment.businesslogic.SharedPreference;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {
    private SharedPreference sharedPreference;
    public SharedPreferenceModule(SharedPreference sharedPreference) {
        this.sharedPreference = sharedPreference;
    }

    @Provides
    public SharedPreference provideSharedPreference() {
        return this.sharedPreference;
    }

}

package com.skill.develoment.skilldevelopment.modules;

import com.skill.develoment.skilldevelopment.businesslogic.SampleApp;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleAppModule {
    private SampleApp sampleApp;
    public SampleAppModule(SampleApp sampleApp) {
        this.sampleApp = sampleApp;
    }
    @Provides
    public SampleApp provideSampleApp()
    {
        return sampleApp;
    }
}

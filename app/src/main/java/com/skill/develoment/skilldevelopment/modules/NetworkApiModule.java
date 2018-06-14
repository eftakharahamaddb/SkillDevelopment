package com.skill.develoment.skilldevelopment.modules;

import com.skill.develoment.skilldevelopment.businesslogic.NetworkApi;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkApiModule {
    private NetworkApi networkApi;

    public NetworkApiModule(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    @Provides
    public NetworkApi networkApi() {
        return networkApi;
    }
}

package com.skill.develoment.skilldevelopment.modules;

import com.skill.develoment.skilldevelopment.businesslogic.ImageLoader;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageLoaderModules {

    private ImageLoader imageLoader;

    public ImageLoaderModules(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Provides
    public ImageLoader imageLoader() {
        return imageLoader;
    }
}

package com.gelort.studymvp;

import android.app.Application;

import com.gelort.studymvp.di.component.ApplicationComponent;
import com.gelort.studymvp.di.component.DaggerApplicationComponent;
import com.gelort.studymvp.di.module.ApplicationModule;

/**
 * Created by gelort on 05.08.2016.
 */

public class SAApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
    }

    private void initializeInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }
}

package com.germey.andservertest;




import android.app.Application;

public class App extends Application {
    private static App app;
    public static App getInstance() {
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}


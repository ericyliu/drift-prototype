package com.originate.drift_prototype.app.models;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.Window;

public class DriftApplication extends Application {

    public User user;

    public static void hideAndroidUI (Window window, ActionBar actionBar) {
        View decorView = window.getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}

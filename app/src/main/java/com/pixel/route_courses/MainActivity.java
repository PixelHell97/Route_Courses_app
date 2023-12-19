package com.pixel.route_courses;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button android_btn;
    Button ios_btn;
    Button fs_btn;


    private static final int SPLASH_SCREEN = 3000;
    private int currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        hideActionBar();
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(this::mainScreen,SPLASH_SCREEN);
    }

    private void mainScreen() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        showActionBar();
        setContentView(R.layout.activity_main);
        currentLayout = R.layout.activity_main;
        android_btn = findViewById(R.id.android);
        ios_btn = findViewById(R.id.ios);
        fs_btn = findViewById(R.id.full_stack);
        android_btn.setOnClickListener(v -> {
            openAndroidActivity();
        });
        ios_btn.setOnClickListener(v -> {
            openIOSActivity();
        });
        fs_btn.setOnClickListener(v -> {
            openFullStackActivity();
        });
    }

    private void openAndroidActivity() {
        setContentView(R.layout.activity_android_course);
        currentLayout = R.layout.activity_android_course;
    }
    private void openIOSActivity() {
        setContentView(R.layout.activity_ios_course);
        currentLayout = R.layout.activity_ios_course;
    }
    private void openFullStackActivity() {
        setContentView(R.layout.activity_full_stack_course);
        currentLayout = R.layout.activity_full_stack_course;
    }

    @Override
    public void onBackPressed() {
        if (   currentLayout == R.layout.activity_android_course
            || currentLayout == R.layout.activity_ios_course
            || currentLayout == R.layout.activity_full_stack_course ) {
            currentLayout = R.layout.activity_main;
            mainScreen();
        } else {
            super.onBackPressed();
        }
    }
    private void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }
    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
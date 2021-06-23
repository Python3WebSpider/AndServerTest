package com.germey.andservertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.goldze.mvvmhabit.utils.NativeUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(NativeUtils.encrypt("/api/movie", 0));
    }
}
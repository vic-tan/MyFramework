package com.vic.framework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.vic.framework.main.test.http.HttpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rxJava_Retrofit(View v){
        ActivityUtils.startActivity(this, HttpActivity.class);
    }
}

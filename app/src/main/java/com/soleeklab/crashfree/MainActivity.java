package com.soleeklab.crashfree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.soleeklab.crashfree.crashHandler.CrashReportActivity;
import com.soleeklab.crashfree.crashHandler.HandleAppCrash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandleAppCrash.deploy(MainActivity.this, CrashReportActivity.class);

    }

    public void SimulateCrash(View view) {
        int x = 1/0;
    }
}

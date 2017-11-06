package com.falconnect.buffetbee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.falconnect.buffetbee.Modalclass.AppPreferences;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    AppPreferences objAppPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objAppPreferences = new AppPreferences(MainActivity.this);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //open activity
                if(objAppPreferences.Get_Branchcode().length() > 1) {
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                // activity finish
                MainActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

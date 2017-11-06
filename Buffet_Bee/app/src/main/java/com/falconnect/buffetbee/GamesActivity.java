package com.falconnect.buffetbee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.falconnect.buffetbee.Adapter.Menucategory_Adapter;
import com.falconnect.buffetbee.Widgets.ExpandableHeightGridView;

import java.util.ArrayList;
import java.util.List;

public class GamesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GamesActivity.this,DashboardActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(GamesActivity.this,DashboardActivity.class));
    }
}

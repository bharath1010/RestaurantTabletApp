package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menucategory_Adapter;
import com.falconnect.buffetbee.Adapter.Settings_Adapter;
import com.falconnect.buffetbee.Modalclass.AppPreferences;
import com.falconnect.buffetbee.Widgets.ExpandableHeightGridView;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    ExpandableHeightGridView mGridView;
    AppPreferences objAppPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        List<String> objMenu = new ArrayList<String>();
        objMenu.add("Reset");
        objMenu.add("Logout");
        ImageView Backbutton = (ImageView) findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, DashboardActivity.class));
            }
        });
        objAppPreferences = new AppPreferences(SettingsActivity.this);
        mGridView = (ExpandableHeightGridView) findViewById(R.id.menulistview);
        mGridView.setColumnWidth(getResources().getDisplayMetrics().widthPixels / 6);
        mGridView.setAdapter(new Settings_Adapter(this, objMenu));
        mGridView.setExpanded(true);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0: {
                        Commonclass.objOrderModel = new ArrayList<>();
                        Commonclass.objOrderedlist = new ArrayList<>();
                        objAppPreferences.Set_Alerttime("");
                        objAppPreferences.Set_Napkintime("");
                        objAppPreferences.Set_Othertime("");
                        objAppPreferences.Set_Watertime("");
                        startActivity(new Intent(SettingsActivity.this, DashboardActivity.class));
                        break;
                    }
                    case 1: {
                        objAppPreferences.Set_Branchcode("");
                        objAppPreferences.Set_Tablecode("");
                        objAppPreferences.Set_Alerttime("");
                        objAppPreferences.Set_Napkintime("");
                        objAppPreferences.Set_Othertime("");
                        objAppPreferences.Set_Watertime("");
                        startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                        break;
                    }
                    case 2: {
                        break;
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingsActivity.this,DashboardActivity.class));
    }
}

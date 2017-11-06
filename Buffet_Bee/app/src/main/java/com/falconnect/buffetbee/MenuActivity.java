package com.falconnect.buffetbee;

import android.Manifest;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Category_Adapter;
import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menu_Adapter;
import com.falconnect.buffetbee.Adapter.Menucategory_Adapter;
import com.falconnect.buffetbee.Modalclass.OrderModel;
import com.falconnect.buffetbee.Widgets.ExpandableHeightGridView;

import java.security.acl.Permission;
import java.util.ArrayList;
import java.util.List;

import static com.falconnect.buffetbee.Adapter.Commonclass.Menu_img;

public class MenuActivity extends AppCompatActivity implements Commonclass.GetRequestDetails {
    RecyclerView mRecyclerView;
    EditText Search_Edit;
    LinearLayout Filter_layout;
    ExpandableHeightGridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,DashboardActivity.class));
            }
        });
        ImageView Expand_image = (ImageView)findViewById(R.id.Expand_image);
        Expand_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(MenuActivity.this, MenuviewActivity.class);
                objIntent.putExtra("position",0);
                startActivity(objIntent);
            }
        });
        LoadDatas();
        ImageView Voice_image = (ImageView)findViewById(R.id.Voice_image);
        Search_Edit = (EditText)findViewById(R.id.Search_Edit);
        Voice_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VoiceButton();
            }
        });

        TextView Cart_button = (TextView)findViewById(R.id.Cart_button);
        Cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,CartActivity.class));
            }
        });
        Filter_layout = (LinearLayout)findViewById(R.id.Filter_layout);
        ImageView Filter_image = (ImageView)findViewById(R.id.Filter_image);
        Filter_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filter_layout.setVisibility(View.VISIBLE);
            }
        });
        ImageView Closebutton = (ImageView)findViewById(R.id.Closebutton);
        Closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filter_layout.setVisibility(View.GONE);
            }
        });
        TextView Filter_Submit = (TextView)findViewById(R.id.Filter_Submit);
        Filter_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filter_layout.setVisibility(View.GONE);
            }
        });
        mGridView = (ExpandableHeightGridView) findViewById(R.id.menulistview);
        List<String> objMenu = new ArrayList<String>();
        objMenu.add("Soup's");
        objMenu.add("Pasta");
        objMenu.add("Pizza");
        objMenu.add("Burgers");
        objMenu.add("Chicken");
        objMenu.add("Salad");
        objMenu.add("Sea Food");
        objMenu.add("Punjabi Cuisine");
        objMenu.add("Chinese Cuisine");
        objMenu.add("Mexican Cuisine");
        objMenu.add("Italian Cuisine");
        objMenu.add("Muffins");
        objMenu.add("Soft Drinks");
        objMenu.add("Desserts");
//        mGridView.setColumnWidth(getResources().getDisplayMetrics().widthPixels / 4);
        mGridView.setAdapter(new Category_Adapter(this,objMenu));
        mGridView.setExpanded(true);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        TextView Submit_button = (TextView)findViewById(R.id.Submit_button);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int j = 0;
                for(int i=0;i<Commonclass.objOrderModel.size();i++)
                {
                    if(Commonclass.objOrderModel.get(i).getorder_nos()>0 && Commonclass.objOrderModel.get(i).getorder_status().equals("1")) {
                        if(j==3 && j==4)
                            Commonclass.objOrderModel.get(i).setorder_status("3");
                        else
                            Commonclass.objOrderModel.get(i).setorder_status("2");
                        Commonclass.objOrderedlist.add(Commonclass.objOrderModel.get(i));
                        j++;
                    }
                }
                Commonclass.objOrderModel = new ArrayList<>();
                Commonclass.AddMenus(Commonclass.objOrderModel);
                startActivity(new Intent(MenuActivity.this,OrderviewActivity.class));
            }
        });
    }
    void LoadDatas()
    {
        Menu_Adapter mAdapter = new Menu_Adapter(MenuActivity.this,Commonclass.objOrderModel);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MenuActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    void VoiceButton() {
        Voice_popup objVoice_popup = new Voice_popup(MenuActivity.this, this);
        objVoice_popup.Show();
    }

    @Override
    public void Callback(String result) {
        Search_Edit.setText(result);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MenuActivity.this,DashboardActivity.class));
    }
}

package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menu_Adapter;
import com.falconnect.buffetbee.Adapter.Order_Adapter;
import com.falconnect.buffetbee.Modalclass.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TextView menu_count,menu_amount;
    List<OrderModel> objOrderModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        menu_count = (TextView)findViewById(R.id.menu_count);
        menu_amount = (TextView)findViewById(R.id.menu_amount);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView Filterbutton = (ImageView)findViewById(R.id.Filterbutton);
        Filterbutton.setVisibility(View.GONE);
        Filterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        LoadDatas();

        TextView Submit_button = (TextView)findViewById(R.id.Submit_button);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int j = 0;
            for(int i=0;i< Commonclass.objOrderModel.size();i++)
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
            startActivity(new Intent(CartActivity.this,OrderviewActivity.class));
            }
        });
    }
    void LoadDatas()
    {
        float amount = 0;
        for(int i=0;i< Commonclass.objOrderModel.size();i++)
        {
            if(Commonclass.objOrderModel.get(i).getorder_nos()>0) {
                objOrderModel.add(Commonclass.objOrderModel.get(i));
                amount += Float.parseFloat(Commonclass.objOrderModel.get(i).getorder_amount());
            }
        }
        menu_count.setText(String.valueOf(objOrderModel.size()));
        menu_amount.setText(Commonclass.Currencyvalue + String.valueOf(amount));
        Menu_Adapter mAdapter = new Menu_Adapter(CartActivity.this,objOrderModel);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(CartActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

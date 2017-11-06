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
import android.widget.Toast;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menu_Adapter;
import com.falconnect.buffetbee.Adapter.Order_Adapter;
import com.falconnect.buffetbee.Modalclass.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderviewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    TextView menu_count,menu_amount,Progressbutton,Deliveredbutton;
    List<OrderModel> objOrderModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);
        ImageView Backbutton = (ImageView) findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView Filterbutton = (ImageView) findViewById(R.id.Filterbutton);
        menu_count = (TextView) findViewById(R.id.menu_count);
        menu_amount = (TextView) findViewById(R.id.menu_amount);
        Progressbutton = (TextView) findViewById(R.id.Progressbutton);
        Deliveredbutton = (TextView) findViewById(R.id.Deliveredbutton);
        Progressbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Progressbutton.setBackgroundResource(R.drawable.accent_roundleft);
                Deliveredbutton.setBackgroundColor(getResources().getColor(R.color.transparent));
                LoadProgessDatas();
            }
        });
        Deliveredbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Deliveredbutton.setBackgroundResource(R.drawable.accent_roundright);
                Progressbutton.setBackgroundColor(getResources().getColor(R.color.transparent));
                LoadDeliveredDatas();
            }
        });
        Filterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(OrderviewActivity.this, view);
                popup.getMenu().add(Menu.NONE, 1, 1, "All Orders");
                popup.getMenu().add(Menu.NONE, 2, 2, "In Progress");
                popup.getMenu().add(Menu.NONE, 3, 3, "Delivered");
                //Inflating the Popup using xml file
                //popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        List<OrderModel> objOrderModelfilter = new ArrayList<>();
                        if (item.getItemId() == 1) {
                            LoadDatas();
                            return true;
                        } else {
                            if (item.getItemId() == 2) {
                                for (int i = 0; i < objOrderModel.size(); i++) {
                                    if (objOrderModel.get(i).getorder_status().equals("2"))
                                        objOrderModelfilter.add(objOrderModel.get(i));
                                }
                            } else if (item.getItemId() == 3) {
                                for (int i = 0; i < objOrderModel.size(); i++) {
                                    if (objOrderModel.get(i).getorder_status().equals("3"))
                                        objOrderModelfilter.add(objOrderModel.get(i));
                                }
                            }
                            Order_Adapter mAdapter = new Order_Adapter(OrderviewActivity.this, objOrderModelfilter);
                            mRecyclerView.setHasFixedSize(true);
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(OrderviewActivity.this);
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mRecyclerView.setAdapter(mAdapter);
                            return true;
                        }
                    }
                });
                popup.show();//showing popup menu

            }
        });

        TextView Submit_button = (TextView) findViewById(R.id.Submit_button);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderviewActivity.this, BillviewActivity.class));
            }
        });
        LoadDatas();
    }
    void LoadDeliveredDatas()
    {
        List<OrderModel> objOrderModelfilter = new ArrayList<>();
        for (int i = 0; i < objOrderModel.size(); i++) {
            if (objOrderModel.get(i).getorder_status().equals("3"))
                objOrderModelfilter.add(objOrderModel.get(i));
        }
        Order_Adapter mAdapter = new Order_Adapter(OrderviewActivity.this, objOrderModelfilter);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(OrderviewActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    void LoadProgessDatas()
    {
        List<OrderModel> objOrderModelfilter = new ArrayList<>();
        for (int i = 0; i < objOrderModel.size(); i++) {
            if (objOrderModel.get(i).getorder_status().equals("2"))
                objOrderModelfilter.add(objOrderModel.get(i));
        }
        Order_Adapter mAdapter = new Order_Adapter(OrderviewActivity.this, objOrderModelfilter);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(OrderviewActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    void LoadDatas() {
        objOrderModel = Commonclass.objOrderedlist;
        float amount = 0;
        int p = 0;
        for (int i = 0; i < objOrderModel.size(); i++) {
            amount += Float.parseFloat(objOrderModel.get(i).getorder_amount()) * objOrderModel.get(i).getorder_nos();
            p++;
            if (p == 3) {
                p = 0;
                objOrderModel.get(i).setorder_status("3");
            }
        }
        menu_count.setText(String.valueOf(objOrderModel.size()));
        menu_amount.setText(Commonclass.Currencyvalue + String.valueOf(amount));
        Order_Adapter mAdapter = new Order_Adapter(OrderviewActivity.this, objOrderModel);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(OrderviewActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

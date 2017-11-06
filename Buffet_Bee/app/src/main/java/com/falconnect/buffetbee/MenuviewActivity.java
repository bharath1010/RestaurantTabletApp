package com.falconnect.buffetbee;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menuview_Adapter;
import com.falconnect.buffetbee.Modalclass.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class MenuviewActivity extends AppCompatActivity {
    ViewPager mPager;
    int Currentposition;
    public ImageView Backbutton;
    public TextView menu_amount, menu_name;
    public TextView Addbutton, Order_minus, Order_plus, Order_text;
    public RelativeLayout Ordercount_layout;
    List<OrderModel> objOrderModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuview);
        mPager = (ViewPager) findViewById(R.id.pager);
        menu_name = (TextView) findViewById(R.id.menu_name);
        menu_amount = (TextView) findViewById(R.id.menu_amount);
        Addbutton = (TextView) findViewById(R.id.Addbutton);
        Ordercount_layout = (RelativeLayout) findViewById(R.id.Ordercount_layout);
        Order_minus = (TextView) findViewById(R.id.Order_minus);
        Order_plus = (TextView) findViewById(R.id.Order_plus);
        Order_text = (TextView) findViewById(R.id.Order_count);
        Backbutton = (ImageView) findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addbutton.setVisibility(View.GONE);
                Ordercount_layout.setVisibility(View.VISIBLE);
                Order_text.setText(String.valueOf(1));
                objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(1);
            }
        });
        Order_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(Order_text.getText().toString()) > 1) {
                    Order_text.setText(String.valueOf(Integer.parseInt(Order_text.getText().toString()) - 1));
                    objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(Integer.parseInt(Order_text.getText().toString())-1);
                } else {
                    Addbutton.setVisibility(View.VISIBLE);
                    Ordercount_layout.setVisibility(View.GONE);
                    objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(0);
                }
            }
        });
        Order_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order_text.setText(String.valueOf(Integer.parseInt(Order_text.getText().toString())+1));
                objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(Integer.parseInt(Order_text.getText().toString())+1);
            }
        });
        objOrderModel = Commonclass.objOrderModel;
        mPager.setAdapter(new Menuview_Adapter(MenuviewActivity.this, Commonclass.objOrderModel));
        Currentposition = getIntent().getIntExtra("position",0);
        mPager.setCurrentItem(Currentposition);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
                Currentposition = state;
            }
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                Currentposition = position;
                Changepagerposition();
            }
        });
        Changepagerposition();
    }
    void Changepagerposition()    {
        menu_name.setText(objOrderModel.get(Currentposition).getorder_name());
        menu_amount.setText(Commonclass.Currencyvalue + objOrderModel.get(Currentposition).getorder_amount());
        if(objOrderModel.get(Currentposition).getorder_nos() == 0)
        {
            Order_text.setText("0");
            Addbutton.setVisibility(View.VISIBLE);
            Ordercount_layout.setVisibility(View.GONE);
        } else {
            Order_text.setText(String.valueOf(objOrderModel.get(Currentposition).getorder_nos()));
            Addbutton.setVisibility(View.GONE);
            Ordercount_layout.setVisibility(View.VISIBLE);
        }
        Addbutton.setTag(Currentposition);
        Order_minus.setTag(Currentposition);
        Order_plus.setTag(Currentposition);
    }
}

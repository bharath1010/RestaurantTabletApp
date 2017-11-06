package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Billing_Adapter;
import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Modalclass.OrderModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillviewActivity extends AppCompatActivity implements Commonclass.GetRequestDetails  {
    TextView menu_amount;
    TextView coupon_name,amount_line;
    Coupon_popup objCoupon_popup;
    RelativeLayout coupon_layout;
    ExpandableListView objExpandablelistview;
    List<OrderModel> objOrderModel = new ArrayList<OrderModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billview);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BillviewActivity.this,OrderviewActivity.class));
            }
        });
        coupon_layout = (RelativeLayout)findViewById(R.id.coupon_layout);
        amount_line = (TextView)findViewById(R.id.amount_line);
        coupon_name = (TextView)findViewById(R.id.coupon_name);
        TextView Submit_button = (TextView)findViewById(R.id.Submit_button);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(BillviewActivity.this,PaymentActivity.class);
                objIntent.putExtra("menu_amount",menu_amount.getText());
                startActivity(objIntent);
            }
        });
        objCoupon_popup = new Coupon_popup(this,this);
        TextView Discount_button = (TextView)findViewById(R.id.Discount_button);
        Discount_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objCoupon_popup.Show();
            }
        });

        menu_amount = (TextView)findViewById(R.id.menu_amount);
        objExpandablelistview = (ExpandableListView) findViewById(R.id.Expandablelistview);
        LoadingDatas();
    }
    float amount = 0;
    void LoadingDatas()
    {
        for(int i = 0; i< Commonclass.objOrderedlist.size(); i++)
        {
            amount += ((Float.parseFloat(Commonclass.objOrderedlist.get(i).getorder_amount()) * Commonclass.objOrderedlist.get(i).getorder_nos()) + 10);
        }
        menu_amount.setText(Commonclass.Currencyvalue + amount);
        objOrderModel = Commonclass.objOrderedlist;
        Billing_Adapter listAdapter = new Billing_Adapter(this,objOrderModel);
        // setting list adapter
        objExpandablelistview.setAdapter(listAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BillviewActivity.this,OrderviewActivity.class));
    }

    @Override
    public void Callback(String result) {
        coupon_layout.setVisibility(View.VISIBLE);
        amount_line.setVisibility(View.GONE);
        coupon_name.setText(result);
        menu_amount.setText(Commonclass.Currencyvalue + (amount-100));
    }
}

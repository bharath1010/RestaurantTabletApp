package com.falconnect.buffetbee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Modalclass.AppPreferences;

import java.util.ArrayList;

public class CashpaymentActivity extends Activity {
    LinearLayout Confirm_layout;
    RelativeLayout Processing_layout,Success_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashpayment);
        TextView Change_button = (TextView)findViewById(R.id.Change_button);
        TextView Submit_button = (TextView)findViewById(R.id.Submit_button);
        TextView Table_text = (TextView)findViewById(R.id.Table_text);
        AppPreferences objAppPreferences = new AppPreferences(this);
        Table_text.setText(objAppPreferences.Get_Tablecode());
        TextView menu_amount = (TextView)findViewById(R.id.menu_amount);
        Confirm_layout = (LinearLayout)findViewById(R.id.Confirm_layout);
        Processing_layout = (RelativeLayout)findViewById(R.id.Processing_layout);
        Success_layout = (RelativeLayout)findViewById(R.id.Success_layout);
        if(getIntent().getStringExtra("menu_amount") != null) {
            menu_amount.setText(getIntent().getStringExtra("menu_amount"));
        }
        Change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CashpaymentActivity.this,PaymentActivity.class));
            }
        });
        Confirm_layout.setVisibility(View.VISIBLE);
        Processing_layout.setVisibility(View.GONE);
        Success_layout.setVisibility(View.GONE);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirm_layout.setVisibility(View.GONE);
                Processing_layout.setVisibility(View.VISIBLE);
                Success_layout.setVisibility(View.GONE);
                Paymentprocess(false,5000);
            }
        });
    }
    void Paymentprocess(final boolean value,long valuetime)
    {
        new CountDownTimer(valuetime, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                if(value) {
                    startActivity(new Intent(CashpaymentActivity.this, RatingActivity.class));
                } else {
                    Confirm_layout.setVisibility(View.GONE);
                    Processing_layout.setVisibility(View.GONE);
                    Success_layout.setVisibility(View.VISIBLE);
                    Paymentprocess(true,3000);
                }
            }
        }.start();
    }
    @Override
    public void onBackPressed() {

    }
}

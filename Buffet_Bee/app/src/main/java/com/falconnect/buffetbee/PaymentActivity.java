package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentActivity.this,BillviewActivity.class));
            }
        });
        TextView menu_amount = (TextView)findViewById(R.id.menu_amount);
        if(getIntent().getStringExtra("menu_amount") != null) {
            menu_amount.setText(getIntent().getStringExtra("menu_amount"));
        }
        TextView payment_name1 = (TextView)findViewById(R.id.payment_name1);
        payment_name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ratingscreen();
            }
        });
        TextView payment_name2 = (TextView)findViewById(R.id.payment_name2);
        payment_name2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ratingscreen();
            }
        });
        TextView payment_name3 = (TextView)findViewById(R.id.payment_name3);
        payment_name3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ratingscreen();
            }
        });
        TextView payment_name4 = (TextView)findViewById(R.id.payment_name4);
        payment_name4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(PaymentActivity.this,CashpaymentActivity.class);
                objIntent.putExtra("menu_amount",getIntent().getStringExtra("menu_amount"));
                startActivity(objIntent);
            }
        });
    }
    void Ratingscreen()
    {
        startActivity(new Intent(PaymentActivity.this,RatingActivity.class));
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(PaymentActivity.this,BillviewActivity.class));
    }
}

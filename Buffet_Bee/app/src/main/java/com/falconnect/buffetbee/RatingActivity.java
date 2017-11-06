package com.falconnect.buffetbee;

import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Modalclass.AppPreferences;
import com.falconnect.buffetbee.Modalclass.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {
    TextView Star_text1,Star_text2,Star_text3,Star_text4,Star_text5;
    TextView Submit_button;
    AppPreferences objAppPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        Star_text1 = (TextView)findViewById(R.id.Star_text1);
        Star_text2 = (TextView)findViewById(R.id.Star_text2);
        Star_text3 = (TextView)findViewById(R.id.Star_text3);
        Star_text4 = (TextView)findViewById(R.id.Star_text4);
        Star_text5 = (TextView)findViewById(R.id.Star_text5);
        ImageView Star_image1 = (ImageView)findViewById(R.id.Star_image1);
        ImageView Star_image2 = (ImageView)findViewById(R.id.Star_image2);
        ImageView Star_image3 = (ImageView)findViewById(R.id.Star_image3);
        ImageView Star_image4 = (ImageView)findViewById(R.id.Star_image4);
        ImageView Star_image5 = (ImageView)findViewById(R.id.Star_image5);
        Star_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(1);
            }
        });
        Star_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(1);
            }
        });
        Star_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(2);
            }
        });
        Star_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(2);
            }
        });
        Star_text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(3);
            }
        });
        Star_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(3);
            }
        });
        Star_text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(4);
            }
        });
        Star_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(4);
            }
        });
        Star_text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(5);
            }
        });
        Star_image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectRating(5);
            }
        });
        Submit_button = (TextView) findViewById(R.id.Submit_button);
        RelativeLayout Submit_layout = (RelativeLayout) findViewById(R.id.Submit_layout);
        ImageView Submit_image = (ImageView) findViewById(R.id.Submit_image);
        objAppPreferences = new AppPreferences(RatingActivity.this);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog Popup_Layout = new Dialog(RatingActivity.this, R.style.MaterialDialogSheet);
                Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Popup_Layout.setContentView(R.layout.vistagain_popup);
                Popup_Layout.setCancelable(true);
                Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                ImageView Bg_image = (ImageView) Popup_Layout.findViewById(R.id.Bg_image);
                Glide.with(RatingActivity.this)
                        .load(R.drawable.thankyou)
                        .skipMemoryCache(true)
                        .override(getResources().getDisplayMetrics().widthPixels,getResources().getDisplayMetrics().heightPixels)
                        .into(Bg_image);
                Popup_Layout.show();
                new CountDownTimer(5000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }
                    public void onFinish() {
                        Commonclass.objOrderModel = new ArrayList<>();
                        Commonclass.objOrderedlist = new ArrayList<>();
                        objAppPreferences.Set_Alerttime("");
                        objAppPreferences.Set_Napkintime("");
                        objAppPreferences.Set_Othertime("");
                        objAppPreferences.Set_Watertime("");
                        startActivity(new Intent(RatingActivity.this, DashboardActivity.class));
                    }
                }.start();

            }
        });
        Submit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit_button.performClick();
            }
        });
        Submit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit_button.performClick();
            }
        });
    }
    void SelectRating(int value) {
        if (value == 1) {
            Star_text1.setBackgroundResource(R.drawable.accent_round);
            Star_text2.setBackgroundResource(R.color.transparent);
            Star_text3.setBackgroundResource(R.color.transparent);
            Star_text4.setBackgroundResource(R.color.transparent);
            Star_text5.setBackgroundResource(R.color.transparent);
            Star_text1.setTextColor(getResources().getColor(R.color.white));
            Star_text2.setTextColor(getResources().getColor(R.color.black));
            Star_text3.setTextColor(getResources().getColor(R.color.black));
            Star_text4.setTextColor(getResources().getColor(R.color.black));
            Star_text5.setTextColor(getResources().getColor(R.color.black));
        } else if (value == 2) {
            Star_text2.setBackgroundResource(R.drawable.accent_round);
            Star_text1.setBackgroundResource(R.color.transparent);
            Star_text3.setBackgroundResource(R.color.transparent);
            Star_text4.setBackgroundResource(R.color.transparent);
            Star_text5.setBackgroundResource(R.color.transparent);
            Star_text2.setTextColor(getResources().getColor(R.color.white));
            Star_text1.setTextColor(getResources().getColor(R.color.black));
            Star_text3.setTextColor(getResources().getColor(R.color.black));
            Star_text4.setTextColor(getResources().getColor(R.color.black));
            Star_text5.setTextColor(getResources().getColor(R.color.black));
        } else if (value == 3) {
            Star_text3.setBackgroundResource(R.drawable.accent_round);
            Star_text2.setBackgroundResource(R.color.transparent);
            Star_text1.setBackgroundResource(R.color.transparent);
            Star_text4.setBackgroundResource(R.color.transparent);
            Star_text5.setBackgroundResource(R.color.transparent);
            Star_text3.setTextColor(getResources().getColor(R.color.white));
            Star_text2.setTextColor(getResources().getColor(R.color.black));
            Star_text1.setTextColor(getResources().getColor(R.color.black));
            Star_text4.setTextColor(getResources().getColor(R.color.black));
            Star_text5.setTextColor(getResources().getColor(R.color.black));
        } else if (value == 4) {
            Star_text4.setBackgroundResource(R.drawable.accent_round);
            Star_text2.setBackgroundResource(R.color.transparent);
            Star_text3.setBackgroundResource(R.color.transparent);
            Star_text1.setBackgroundResource(R.color.transparent);
            Star_text5.setBackgroundResource(R.color.transparent);
            Star_text4.setTextColor(getResources().getColor(R.color.white));
            Star_text2.setTextColor(getResources().getColor(R.color.black));
            Star_text3.setTextColor(getResources().getColor(R.color.black));
            Star_text1.setTextColor(getResources().getColor(R.color.black));
            Star_text5.setTextColor(getResources().getColor(R.color.black));
        } else if (value == 5) {
            Star_text5.setBackgroundResource(R.drawable.accent_round);
            Star_text2.setBackgroundResource(R.color.transparent);
            Star_text3.setBackgroundResource(R.color.transparent);
            Star_text4.setBackgroundResource(R.color.transparent);
            Star_text1.setBackgroundResource(R.color.transparent);
            Star_text5.setTextColor(getResources().getColor(R.color.white));
            Star_text2.setTextColor(getResources().getColor(R.color.black));
            Star_text3.setTextColor(getResources().getColor(R.color.black));
            Star_text4.setTextColor(getResources().getColor(R.color.black));
            Star_text1.setTextColor(getResources().getColor(R.color.black));
        }
    }

    @Override
    public void onBackPressed() {

    }
}

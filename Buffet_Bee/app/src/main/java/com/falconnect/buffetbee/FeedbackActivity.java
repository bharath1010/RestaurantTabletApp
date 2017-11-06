package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;

public class FeedbackActivity extends AppCompatActivity {
    TextView Submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        final RelativeLayout Success_layout = (RelativeLayout) findViewById(R.id.Success_layout);
        final RelativeLayout Submit_layout = (RelativeLayout) findViewById(R.id.Submit_layout);
        RatingLoader();
        ImageView Submit_image = (ImageView) findViewById(R.id.Submit_image);
        Submit_button = (TextView) findViewById(R.id.Submit_button);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Success_layout.setVisibility(View.VISIBLE);
                Submit_layout.setVisibility(View.GONE);
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
    TextView Rating11, Rating12, Rating13;
    TextView Rating21, Rating22, Rating23;
    TextView Rating31, Rating32, Rating33;
    TextView Rating41, Rating42, Rating43;
    TextView Rating51, Rating52, Rating53;
    TextView Rating61, Rating62, Rating63;
    void RatingLoader() {
        Rating11 = (TextView) findViewById(R.id.Rating11);
        Rating12 = (TextView) findViewById(R.id.Rating12);
        Rating13 = (TextView) findViewById(R.id.Rating13);
        Rating11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(11);
            }
        });
        Rating12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(12);
            }
        });
        Rating13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(13);
            }
        });
        Rating21 = (TextView) findViewById(R.id.Rating21);
        Rating22 = (TextView) findViewById(R.id.Rating22);
        Rating23 = (TextView) findViewById(R.id.Rating23);

        Rating21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(21);
            }
        });
        Rating22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(22);
            }
        });
        Rating23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(23);
            }
        });
        Rating31 = (TextView) findViewById(R.id.Rating31);
        Rating32 = (TextView) findViewById(R.id.Rating32);
        Rating33 = (TextView) findViewById(R.id.Rating33);

        Rating31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(31);
            }
        });
        Rating32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(32);
            }
        });
        Rating33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(33);
            }
        });
        Rating41 = (TextView) findViewById(R.id.Rating41);
        Rating42 = (TextView) findViewById(R.id.Rating42);
        Rating43 = (TextView) findViewById(R.id.Rating43);

        Rating41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(41);
            }
        });
        Rating42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(42);
            }
        });
        Rating43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(43);
            }
        });
        Rating51 = (TextView) findViewById(R.id.Rating51);
        Rating52 = (TextView) findViewById(R.id.Rating52);
        Rating53 = (TextView) findViewById(R.id.Rating53);

        Rating51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(51);
            }
        });
        Rating52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(52);
            }
        });
        Rating53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(53);
            }
        });
        Rating61 = (TextView) findViewById(R.id.Rating61);
        Rating62 = (TextView) findViewById(R.id.Rating62);
        Rating63 = (TextView) findViewById(R.id.Rating63);

        Rating61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(61);
            }
        });
        Rating62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(62);
            }
        });
        Rating63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRating(63);
            }
        });

        Rating11.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating12.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating13.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating11.setTextColor(getResources().getColor(R.color.black));
        Rating12.setTextColor(getResources().getColor(R.color.black));
        Rating13.setTextColor(getResources().getColor(R.color.black));

        Rating21.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating22.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating23.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating21.setTextColor(getResources().getColor(R.color.black));
        Rating22.setTextColor(getResources().getColor(R.color.black));
        Rating23.setTextColor(getResources().getColor(R.color.black));

        Rating31.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating32.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating33.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating31.setTextColor(getResources().getColor(R.color.black));
        Rating32.setTextColor(getResources().getColor(R.color.black));
        Rating33.setTextColor(getResources().getColor(R.color.black));

        Rating41.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating42.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating43.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating41.setTextColor(getResources().getColor(R.color.black));
        Rating42.setTextColor(getResources().getColor(R.color.black));
        Rating43.setTextColor(getResources().getColor(R.color.black));

        Rating51.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating52.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating53.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating51.setTextColor(getResources().getColor(R.color.black));
        Rating52.setTextColor(getResources().getColor(R.color.black));
        Rating53.setTextColor(getResources().getColor(R.color.black));

        Rating61.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating62.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating63.setBackgroundResource(R.drawable.greybrwhite_round);
        Rating61.setTextColor(getResources().getColor(R.color.black));
        Rating62.setTextColor(getResources().getColor(R.color.black));
        Rating63.setTextColor(getResources().getColor(R.color.black));
    }
    void ClickRating(int value)
    {
        switch (value)
        {
            case 11:
            {
                Rating11.setBackgroundResource(R.drawable.accent_round);
                Rating12.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating13.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating11.setTextColor(getResources().getColor(R.color.white));
                Rating12.setTextColor(getResources().getColor(R.color.black));
                Rating13.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 12:
            {
                Rating12.setBackgroundResource(R.drawable.accent_round);
                Rating11.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating13.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating12.setTextColor(getResources().getColor(R.color.white));
                Rating11.setTextColor(getResources().getColor(R.color.black));
                Rating13.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 13:
            {
                Rating13.setBackgroundResource(R.drawable.accent_round);
                Rating12.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating11.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating13.setTextColor(getResources().getColor(R.color.white));
                Rating12.setTextColor(getResources().getColor(R.color.black));
                Rating11.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 21:
            {
                Rating21.setBackgroundResource(R.drawable.accent_round);
                Rating22.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating23.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating21.setTextColor(getResources().getColor(R.color.white));
                Rating22.setTextColor(getResources().getColor(R.color.black));
                Rating23.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 22:
            {
                Rating22.setBackgroundResource(R.drawable.accent_round);
                Rating21.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating23.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating22.setTextColor(getResources().getColor(R.color.white));
                Rating21.setTextColor(getResources().getColor(R.color.black));
                Rating23.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 23:
            {
                Rating23.setBackgroundResource(R.drawable.accent_round);
                Rating22.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating21.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating23.setTextColor(getResources().getColor(R.color.white));
                Rating22.setTextColor(getResources().getColor(R.color.black));
                Rating21.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 31:
            {
                Rating31.setBackgroundResource(R.drawable.accent_round);
                Rating32.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating33.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating31.setTextColor(getResources().getColor(R.color.white));
                Rating32.setTextColor(getResources().getColor(R.color.black));
                Rating33.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 32:
            {
                Rating32.setBackgroundResource(R.drawable.accent_round);
                Rating31.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating33.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating32.setTextColor(getResources().getColor(R.color.white));
                Rating31.setTextColor(getResources().getColor(R.color.black));
                Rating33.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 33:
            {
                Rating33.setBackgroundResource(R.drawable.accent_round);
                Rating32.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating31.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating33.setTextColor(getResources().getColor(R.color.white));
                Rating32.setTextColor(getResources().getColor(R.color.black));
                Rating31.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 41:
            {
                Rating41.setBackgroundResource(R.drawable.accent_round);
                Rating42.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating43.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating41.setTextColor(getResources().getColor(R.color.white));
                Rating42.setTextColor(getResources().getColor(R.color.black));
                Rating43.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 42:
            {
                Rating42.setBackgroundResource(R.drawable.accent_round);
                Rating41.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating43.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating42.setTextColor(getResources().getColor(R.color.white));
                Rating41.setTextColor(getResources().getColor(R.color.black));
                Rating43.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 43:
            {
                Rating43.setBackgroundResource(R.drawable.accent_round);
                Rating42.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating41.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating43.setTextColor(getResources().getColor(R.color.white));
                Rating42.setTextColor(getResources().getColor(R.color.black));
                Rating41.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 51:
            {
                Rating51.setBackgroundResource(R.drawable.accent_round);
                Rating52.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating53.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating51.setTextColor(getResources().getColor(R.color.white));
                Rating52.setTextColor(getResources().getColor(R.color.black));
                Rating53.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 52:
            {
                Rating52.setBackgroundResource(R.drawable.accent_round);
                Rating51.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating53.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating52.setTextColor(getResources().getColor(R.color.white));
                Rating51.setTextColor(getResources().getColor(R.color.black));
                Rating53.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 53:
            {
                Rating53.setBackgroundResource(R.drawable.accent_round);
                Rating52.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating51.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating53.setTextColor(getResources().getColor(R.color.white));
                Rating52.setTextColor(getResources().getColor(R.color.black));
                Rating51.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 61:
            {
                Rating61.setBackgroundResource(R.drawable.accent_round);
                Rating62.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating63.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating61.setTextColor(getResources().getColor(R.color.white));
                Rating62.setTextColor(getResources().getColor(R.color.black));
                Rating63.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 62:
            {
                Rating62.setBackgroundResource(R.drawable.accent_round);
                Rating61.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating63.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating62.setTextColor(getResources().getColor(R.color.white));
                Rating61.setTextColor(getResources().getColor(R.color.black));
                Rating63.setTextColor(getResources().getColor(R.color.black));
                break;
            }
            case 63:
            {
                Rating63.setBackgroundResource(R.drawable.accent_round);
                Rating62.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating61.setBackgroundResource(R.drawable.greybrwhite_round);
                Rating63.setTextColor(getResources().getColor(R.color.white));
                Rating62.setTextColor(getResources().getColor(R.color.black));
                Rating61.setTextColor(getResources().getColor(R.color.black));
                break;
            }
        }

    }
}

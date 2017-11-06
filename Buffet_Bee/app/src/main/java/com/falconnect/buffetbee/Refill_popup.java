package com.falconnect.buffetbee;

import android.app.Activity;
import android.app.Dialog;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Modalclass.AppPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Android on 10/11/2017.
 */

public class Refill_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    AppPreferences objAppPreferences;
    TextView Water_tick,Napkin_tick,Other_tick;
    TextView Water_button,Napkin_button,Other_button;
    TextView Water_text,Napkin_text,Other_text;
    long Water_Delay = 1000 * 60,Napkin_Delay = 1000 * 60,Other_Delay = 1000 * 60;
    long Water_Delay_Count = 1000 * 60,Napkin_Delay_Count = 1000 * 60,Other_Delay_Count = 1000 * 60;
    public Refill_popup(Activity objActivityv) {
        objActivity = objActivityv;
        objAppPreferences = new AppPreferences(objActivity);
        Popup_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Popup_Layout.setContentView(R.layout.refill_popup);
        Popup_Layout.setCancelable(true);
        Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView Backbutton = (ImageView)Popup_Layout.findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });

        Water_tick = (TextView)Popup_Layout.findViewById(R.id.Water_tick);
        Napkin_tick = (TextView)Popup_Layout.findViewById(R.id.Napkin_tick);
        Other_tick = (TextView)Popup_Layout.findViewById(R.id.Other_tick);

        Water_button = (TextView)Popup_Layout.findViewById(R.id.Water_button);
        Napkin_button = (TextView)Popup_Layout.findViewById(R.id.Napkin_button);
        Other_button = (TextView)Popup_Layout.findViewById(R.id.Other_button);
        Water_button.setBackgroundResource(R.drawable.accent_round);
        Napkin_button.setBackgroundResource(R.drawable.accent_round);
        Other_button.setBackgroundResource(R.drawable.accent_round);
        Water_text = (TextView)Popup_Layout.findViewById(R.id.Water_text);
        Napkin_text = (TextView)Popup_Layout.findViewById(R.id.Napkin_text);
        Other_text = (TextView)Popup_Layout.findViewById(R.id.Other_text);

        Water_tick.setVisibility(View.GONE);
        Napkin_tick.setVisibility(View.GONE);
        Other_tick.setVisibility(View.GONE);
        Water_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Water_tick.setVisibility(View.VISIBLE);
                objAppPreferences.Set_Watertime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                Water_Timer();
            }
        });
        Napkin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Napkin_tick.setVisibility(View.VISIBLE);
                objAppPreferences.Set_Napkintime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                Napkin_Timer();
            }
        });
        Other_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Other_tick.setVisibility(View.VISIBLE);
                objAppPreferences.Set_Othertime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                Other_Timer();
            }
        });
        LoadDatas();
    }
    void LoadDatas()    {
        if(!objAppPreferences.Get_Watertime().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date date1 = simpleDateFormat.parse(objAppPreferences.Get_Watertime());
                Date date2 = simpleDateFormat.parse(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                long value = CheckDifference(date1, date2);
                if(value < Water_Delay_Count)
                {
                    Water_Delay = Water_Delay_Count - value;
                    Water_tick.setVisibility(View.VISIBLE);
                    Water_Timer();
                } else {
                    Water_Delay = Water_Delay_Count;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!objAppPreferences.Get_Napkintime().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date date1 = simpleDateFormat.parse(objAppPreferences.Get_Napkintime());
                Date date2 = simpleDateFormat.parse(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                long value = CheckDifference(date1, date2);
                if(value < Napkin_Delay_Count)
                {
                    Napkin_Delay = Napkin_Delay_Count - value;
                    Napkin_tick.setVisibility(View.VISIBLE);
                    Napkin_Timer();
                } else {
                    Napkin_Delay = Napkin_Delay_Count;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!objAppPreferences.Get_Othertime().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date date1 = simpleDateFormat.parse(objAppPreferences.Get_Othertime());
                Date date2 = simpleDateFormat.parse(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                long value = CheckDifference(date1, date2);
                if(value < Other_Delay_Count)
                {
                    Other_Delay = Other_Delay_Count - value;
                    Other_tick.setVisibility(View.VISIBLE);
                    Other_Timer();
                } else {
                    Other_Delay = Other_Delay_Count;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public void Show() {
        Popup_Layout.show();
    }
    void Napkin_Timer() {

        new CountDownTimer(Napkin_Delay, 1000) {
            public void onTick(long millisUntilFinished) {
                Napkin_button.setEnabled(false);
                Napkin_button.setText((millisUntilFinished / 1000)+" seconds");
                Napkin_button.setBackgroundResource(R.drawable.ashaaa_round);
                Napkin_text.setText("Please wait...");
            }

            public void onFinish() {
                Napkin_button.setEnabled(true);
                Napkin_button.setText("Re-Fill");
                Napkin_tick.setVisibility(View.GONE);
                Napkin_button.setBackgroundResource(R.drawable.accent_round);
                Napkin_text.setText("Click to Refill Napkin");
                Napkin_Delay = Napkin_Delay_Count;
            }

        }.start();
    }
    void Other_Timer() {

    new CountDownTimer(Other_Delay, 1000) {
        public void onTick(long millisUntilFinished) {
            Other_button.setEnabled(false);
            Other_button.setText((millisUntilFinished / 1000)+" seconds");
            Other_button.setBackgroundResource(R.drawable.ashaaa_round);
            Other_text.setText("Please wait...");
        }

        public void onFinish() {
            Other_button.setEnabled(true);
            Other_button.setText("Re-Fill");
            Other_tick.setVisibility(View.GONE);
            Other_button.setBackgroundResource(R.drawable.accent_round);
            Other_text.setText("Click to others Options");
            Other_Delay = Other_Delay_Count;
        }

    }.start();
}
    void Water_Timer() {

    new CountDownTimer(Water_Delay, 1000) {
        public void onTick(long millisUntilFinished) {
            Water_button.setEnabled(false);
            Water_button.setText((millisUntilFinished / 1000)+" seconds");
            Water_button.setBackgroundResource(R.drawable.ashaaa_round);
            Water_text.setText("Please wait...");
        }
        public void onFinish() {
            Water_button.setEnabled(true);
            Water_button.setText("Re-Fill");
            Water_tick.setVisibility(View.GONE);
            Water_button.setBackgroundResource(R.drawable.accent_round);
            Water_text.setText("Click to Refill Water");
            Water_Delay = Water_Delay_Count;
        }

    }.start();


}
    public void Dismiss() {
        Popup_Layout.dismiss();
    }
    public long CheckDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        different = different % daysInMilli;
        different = different % hoursInMilli;
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        long elapsedSeconds = different / secondsInMilli;
        System.out.printf("%d seconds%n",elapsedSeconds + (elapsedMinutes*60));
        if(elapsedMinutes == 0) {
            return (elapsedSeconds * 1000);
        } else {
            return (80 * 1000);
        }
    }

}

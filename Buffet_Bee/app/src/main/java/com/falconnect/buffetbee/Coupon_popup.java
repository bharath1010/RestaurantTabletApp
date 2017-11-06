package com.falconnect.buffetbee;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Coupon_Adpater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/11/2017.
 */

public class Coupon_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    ListView objListView;
    TextView Search_button;
    List<String> objcouponlist = new ArrayList<>();
    Commonclass.GetRequestDetails objGetRequestDetails;
    public Coupon_popup(Activity objActivityv, Commonclass.GetRequestDetails objGetRequestDetailsv) {
        objActivity = objActivityv;
        objGetRequestDetails = objGetRequestDetailsv;
        Popup_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Popup_Layout.setContentView(R.layout.coupon_popup);
        Popup_Layout.setCancelable(true);
        Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView Backbutton = (ImageView) Popup_Layout.findViewById(R.id.Backbutton);
        objListView = (ListView) Popup_Layout.findViewById(R.id.listview);
        Search_button = (TextView) Popup_Layout.findViewById(R.id.Search_button);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });
        objcouponlist = new ArrayList<>();
        objcouponlist.add("Coupon Code : BUFF123");
        objcouponlist.add("Coupon Code : FALCON777");
        objcouponlist.add("Coupon Code : BEE005");
        objListView.setAdapter(new Coupon_Adpater(objActivity,objcouponlist));
        objListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Popup_Layout.dismiss();
                if (objGetRequestDetails != null) objGetRequestDetails.Callback(objcouponlist.get(position));
            }
        });
        Search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void Show() {
        Popup_Layout.show();
    }

    public void Dismiss() {
        Popup_Layout.dismiss();
    }

}

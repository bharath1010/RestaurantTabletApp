package com.falconnect.buffetbee;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
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

public class Admin_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    EditText Enter_password;
    TextView Submit_button;
    public Admin_popup(Activity objActivityv) {
        objActivity = objActivityv;
        Popup_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Popup_Layout.setContentView(R.layout.admin_popup);
        Popup_Layout.setCancelable(true);
        Popup_Layout.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView Backbutton = (ImageView) Popup_Layout.findViewById(R.id.Backbutton);
        Enter_password = (EditText) Popup_Layout.findViewById(R.id.Enter_password);
        Submit_button = (TextView) Popup_Layout.findViewById(R.id.Submit_button);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Enter_password.getText().toString().equals("admin123"))
                {
                    Popup_Layout.dismiss();
                    objActivity.startActivity(new Intent(objActivity,SettingsActivity.class));
                } else {
                    Enter_password.setError("Invalid Password");
                }
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

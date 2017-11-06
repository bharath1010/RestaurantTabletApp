package com.falconnect.buffetbee;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Android on 10/11/2017.
 */

public class More_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    public More_popup(final Activity objActivityv) {
        objActivity = objActivityv;
        Popup_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Popup_Layout.setContentView(R.layout.more_popup);
        Popup_Layout.setCancelable(true);
        Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView Backbutton = (ImageView) Popup_Layout.findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });
        TextView Settingsbutton = (TextView) Popup_Layout.findViewById(R.id.Settingbutton);
        Settingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Admin_popup(objActivity).Show();
            }
        });
        TextView Feedbackbutton = (TextView) Popup_Layout.findViewById(R.id.Feedbackbutton);
        Feedbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objActivity.startActivity(new Intent(objActivity,FeedbackActivity.class));
            }
        });
        TextView Supportbutton = (TextView) Popup_Layout.findViewById(R.id.Supportbutton);
        Supportbutton.setOnClickListener(new View.OnClickListener() {
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

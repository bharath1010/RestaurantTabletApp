package com.falconnect.buffetbee;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.falconnect.buffetbee.Adapter.Branch_Adpater;
import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Table_Adpater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/11/2017.
 */

public class Table_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    ListView objListView;
    List<String> objcouponlist = new ArrayList<>();
    Commonclass.GetRequestDetails objGetRequestDetails;
    public Table_popup(Activity objActivityv, Commonclass.GetRequestDetails objGetRequestDetailsv) {
        objActivity = objActivityv;
        objGetRequestDetails = objGetRequestDetailsv;
        Popup_Layout = new Dialog(objActivity, R.style.MaterialDialogSheet);
        Popup_Layout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Popup_Layout.setContentView(R.layout.branch_popup);
        Popup_Layout.setCancelable(true);
        Popup_Layout.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Popup_Layout.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView Backbutton = (ImageView) Popup_Layout.findViewById(R.id.Backbutton);
        objListView = (ListView) Popup_Layout.findViewById(R.id.listview);
        EditText Search_Edit = (EditText) Popup_Layout.findViewById(R.id.Search_Edit);
        Search_Edit.setHint("Search Table");
        LinearLayout Recentlayout = (LinearLayout) Popup_Layout.findViewById(R.id.Recentlayout);
        Recentlayout.setVisibility(View.GONE);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });
        objcouponlist = new ArrayList<>();
        objcouponlist.add("TABLE001");
        objcouponlist.add("TABLE002");
        objcouponlist.add("TABLE003");
        objcouponlist.add("TABLE004");
        objcouponlist.add("TABLE005");
        objcouponlist.add("TABLE006");
        objcouponlist.add("TABLE007");
        objcouponlist.add("TABLE008");
        objcouponlist.add("TABLE009");
        objcouponlist.add("TABLE010");
        objListView.setAdapter(new Table_Adpater(objActivity,objcouponlist));
        Commonclass.ListViewHeight(objListView);
        objListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Popup_Layout.dismiss();
                if (objGetRequestDetails != null) objGetRequestDetails.Callback(objcouponlist.get(position));
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

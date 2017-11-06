package com.falconnect.buffetbee;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.BranchModel;
import com.falconnect.buffetbee.Adapter.Branch_Adpater;
import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Coupon_Adpater;
import com.falconnect.buffetbee.Adapter.Table_Adpater;
import com.falconnect.buffetbee.Modalclass.AppPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 10/11/2017.
 */

public class Branch_popup {
    Activity objActivity;
    Dialog Popup_Layout;
    ListView objListView;
    AppPreferences objAppPreferences;
    List<BranchModel> objcouponlist = new ArrayList<>();
    List<String> objrecentlist = new ArrayList<>();
    Commonclass.GetRequestDetails objGetRequestDetails;
    public Branch_popup(Activity objActivityv, Commonclass.GetRequestDetails objGetRequestDetailsv) {
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
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup_Layout.dismiss();
            }
        });
        objAppPreferences = new AppPreferences(objActivity);
        objcouponlist = new ArrayList<>();
        objcouponlist.add(new BranchModel("BUFF001","Adayar,Chennai,Tamil nadu."));
        objcouponlist.add(new BranchModel("BUFF002","T-Nagar,Chennai,Tamil nadu."));
        objcouponlist.add(new BranchModel("BUFF003","Egmore,Chennai,Tamil nadu."));
        objcouponlist.add(new BranchModel("BUFF004","Chrompet,Chennai,Tamil nadu."));
        objcouponlist.add(new BranchModel("BUFF005","Thamabaram,Chennai,Tamil nadu."));
        objcouponlist.add(new BranchModel("BUFF006","Vadapalani,Chennai,Tamil nadu."));
        objListView.setAdapter(new Branch_Adpater(objActivity,objcouponlist));
        Commonclass.ListViewHeight(objListView);
        ListView listviewrecent = (ListView) Popup_Layout.findViewById(R.id.listviewrecent);
        LinearLayout Recentlayout = (LinearLayout) Popup_Layout.findViewById(R.id.Recentlayout);
        objrecentlist = objAppPreferences.Get_Branchdata();
        if(objrecentlist.size() > 0)
        {
            Recentlayout.setVisibility(View.VISIBLE);
            List<BranchModel> objbranchrecentlist = new ArrayList<>();
            for(int i=0;i<objcouponlist.size();i++)
            {
                if(objrecentlist.contains(objcouponlist.get(i).getbranch_code()))
                {
                    objbranchrecentlist.add(objcouponlist.get(i));
                }
                if(objbranchrecentlist.size()==3) {
                    break;
                }
            }
            listviewrecent.setAdapter(new Branch_Adpater(objActivity,objbranchrecentlist));
            Commonclass.ListViewHeight(listviewrecent);
        } else Recentlayout.setVisibility(View.GONE);
        Recentlayout.setVisibility(View.GONE);
        objListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Popup_Layout.dismiss();
                if(objrecentlist.contains(objcouponlist.get(position).getbranch_code())) {
                    objrecentlist.remove(objcouponlist.get(position).getbranch_code());
                    objrecentlist.add(0, objcouponlist.get(position).getbranch_code());
                } else {
                    objrecentlist.add(0, objcouponlist.get(position).getbranch_code());
                }
                objAppPreferences.Set_Branchdata(objrecentlist);
                if (objGetRequestDetails != null) objGetRequestDetails.Callback(objcouponlist.get(position).getbranch_code());
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

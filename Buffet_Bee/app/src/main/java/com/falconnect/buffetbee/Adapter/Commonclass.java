package com.falconnect.buffetbee.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.falconnect.buffetbee.Modalclass.OrderModel;
import com.falconnect.buffetbee.R;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by Android on 10/11/2017.
 */

public class Commonclass {
    public static void Alert_OK(Activity objActivity,String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(objActivity);

        // Setting Dialog Title
        alertDialog.setTitle("");

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // On pressing OK button
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
    public interface GetRequestDetails
    {
        public void Callback(String result);
    }
    public static int Topixels(Context objActivity, int value)
    {
        Resources r = objActivity.getResources();
        return Integer.parseInt(String.valueOf(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, r.getDisplayMetrics())));
    }
    public static String Currencyvalue = "$ ";
    public static  List<OrderModel> objOrderModel = new ArrayList<>();
    public static  List<OrderModel> objOrderedlist = new ArrayList<>();
    public static void AddMenus(List<OrderModel> objOrderModel)
    {
        objOrderModel.add(new OrderModel("1","Menu Name - 1","1","100",0));
        objOrderModel.add(new OrderModel("2","Menu Name - 2","1","140",0));
        objOrderModel.add(new OrderModel("3","Menu Name - 3","1","90",0));
        objOrderModel.add(new OrderModel("4","Menu Name - 4","1","200",0));
        objOrderModel.add(new OrderModel("5","Menu Name - 5","1","160",0));
        objOrderModel.add(new OrderModel("6","Menu Name - 6","1","200",0));
        objOrderModel.add(new OrderModel("7","Menu Name - 7","1","150",0));
        objOrderModel.add(new OrderModel("8","Menu Name - 8","1","80",0));
        objOrderModel.add(new OrderModel("9","Menu Name - 9","1","140",0));
    }
    public static int[] Menu_img = {
            R.drawable.menu_1,
            R.drawable.menu_2,
            R.drawable.menu_3,
            R.drawable.menu_4,
            R.drawable.menu_5,
            R.drawable.menu_6,
            R.drawable.menu_7,
            R.drawable.menu_8,
            R.drawable.menu_9,
            R.drawable.menu_10,
            R.drawable.menu_11,
            R.drawable.menu_12,
            R.drawable.menu_13,
            R.drawable.menu_14,
            R.drawable.menu_15,
            R.drawable.menu_16,
            R.drawable.menu_17,
            R.drawable.menu_18,
            R.drawable.menu_19,
            R.drawable.menu_20,
            R.drawable.menu_21,
            R.drawable.menu_22,
            R.drawable.menu_23
    };
    public static int[] Settings_img = {
            R.drawable.reset,
            R.drawable.logout,
            R.drawable.menu_3,
    };
    /**
     * Hides the soft keyboard
     */
//    public static void HideKeyboard(Activity objActivity) {
//        if(objActivity.getCurrentFocus()!= null) {
//            InputMethodManager inputMethodManager = (InputMethodManager) objActivity.getSystemService(objActivity.INPUT_METHOD_SERVICE);
//            inputMethodManager.hideSoftInputFromWindow(objActivity.getCurrentFocus().getWindowToken(), 0);
//        }
//    }
    public static void ListViewHeight(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();
        }
    }
}

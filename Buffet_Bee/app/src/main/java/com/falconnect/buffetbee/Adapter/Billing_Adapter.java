package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.falconnect.buffetbee.Modalclass.OrderModel;
import com.falconnect.buffetbee.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Android on 10/16/2017.
 */

public class Billing_Adapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<OrderModel> objOrderModel; // header titles

    public Billing_Adapter(Context context, List<OrderModel> listDataHeader) {
        this._context = context;
        this.objOrderModel = listDataHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.objOrderModel.get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.bill_itemexp, null);
        }
        TextView menu_singleamount = (TextView) convertView.findViewById(R.id.menu_singleamount);
        menu_singleamount.setText(Commonclass.Currencyvalue + objOrderModel.get(groupPosition).getorder_amount());
        TextView menu_amount = (TextView) convertView.findViewById(R.id.menu_amount);
        float Totalamount = (Float.parseFloat(objOrderModel.get(groupPosition).getorder_amount())*objOrderModel.get(groupPosition).getorder_nos()) + 10;
        menu_amount.setText(Commonclass.Currencyvalue + Totalamount);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this.objOrderModel.get(groupPosition))
//                .size();
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.objOrderModel.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.objOrderModel.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
        //String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.bill_item, null);
        }
        TextView menu_name = (TextView) convertView.findViewById(R.id.menu_name);
        menu_name.setText(objOrderModel.get(groupPosition).getorder_name());
        TextView menu_quantity = (TextView) convertView.findViewById(R.id.menu_nos);
        menu_quantity.setText(String.valueOf(objOrderModel.get(groupPosition).getorder_nos()));
        TextView menu_amount = (TextView) convertView.findViewById(R.id.menu_amount);
        float Totalamount = Float.parseFloat(objOrderModel.get(groupPosition).getorder_amount())*objOrderModel.get(groupPosition).getorder_nos();
        menu_amount.setText(Commonclass.Currencyvalue + Totalamount);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

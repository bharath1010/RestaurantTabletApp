package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.falconnect.buffetbee.R;

import java.util.List;

public class Coupon_Adpater extends BaseAdapter {

	private Context context;
	private List<String> launchmodel;

	public Coupon_Adpater(Context context, List<String> launchmodel) {
		this.context = context;
		this.launchmodel = launchmodel;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return launchmodel.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return launchmodel.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.coupon_item, null);
		}

		TextView coupon_name = (TextView) convertView.findViewById(R.id.coupon_name);
		coupon_name.setText(launchmodel.get(position));


		return convertView;
	}
}
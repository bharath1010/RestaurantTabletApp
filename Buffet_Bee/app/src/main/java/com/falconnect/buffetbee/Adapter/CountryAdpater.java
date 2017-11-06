package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.falconnect.buffetbee.R;

import java.util.ArrayList;
import java.util.List;

public class CountryAdpater extends BaseAdapter {

	private Context context;
	private List<CountryModel> launchmodel;
	SharedPreferences sharedpreferences ;
	String userId;

	public CountryAdpater(Context context,List<CountryModel> launchmodel) {
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
			//convertView = mInflater.inflate(R.layout.countrylist, null);
		}

//		TextView Countryname = (TextView) convertView.findViewById(R.id.cname);
//		TextView Countrycode = (TextView) convertView.findViewById(R.id.ccode);
//		Countryname.setText(launchmodel.get(position).getcountry_name());
//		Countrycode.setText(launchmodel.get(position).getcountry_code());

		System.out.println("--LIst Size In Inflater--" + launchmodel.size());

		return convertView;
	}
}
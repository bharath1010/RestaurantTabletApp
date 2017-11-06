package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.falconnect.buffetbee.R;

import java.util.List;

/**
 * Created by Android on 10/12/2017.
 */

public class Settings_Adapter extends BaseAdapter {
    private Context context;
    private List<String> launchmodel;
    SharedPreferences sharedpreferences ;
    String userId;

    public Settings_Adapter(Context context, List<String> launchmodel) {
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
            convertView = mInflater.inflate(R.layout.settings_item, null);
        }
        ImageView menu_image = (ImageView) convertView.findViewById(R.id.menu_image);
		TextView menu_name = (TextView) convertView.findViewById(R.id.menu_name);
        menu_name.setText(launchmodel.get(position));
        Glide.with(context)
                .load(Commonclass.Settings_img[position])
                .skipMemoryCache(true)
                .override(150,150)
                .into(menu_image);
        System.out.println("--LIst Size In Inflater--" + launchmodel.size());

        return convertView;
    }
}

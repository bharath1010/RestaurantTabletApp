package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.falconnect.buffetbee.R;

import java.util.List;

import static com.falconnect.buffetbee.DashboardActivity.layoutwidth;

/**
 * Created by Android on 10/12/2017.
 */

public class Category_Adapter extends BaseAdapter {
    private Context context;
    private List<String> launchmodel;
    SharedPreferences sharedpreferences ;
    String userId;

    public Category_Adapter(Context context, List<String> launchmodel) {
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
            convertView = mInflater.inflate(R.layout.category_item, null);
        }
        LinearLayout menu_layout = (LinearLayout) convertView.findViewById(R.id.menu_layout);
        ImageView menu_image = (ImageView) convertView.findViewById(R.id.menu_image);
		TextView menu_name = (TextView) convertView.findViewById(R.id.menu_name);
		TextView menu_count = (TextView) convertView.findViewById(R.id.menu_count);
        menu_name.setText(launchmodel.get(position));
        menu_count.setText("More than 10 varieties");
//        menu_image.setImageResource(Commonclass.Menu_img[position]);
        Glide.with(context)
                .load(Commonclass.Menu_img[position])
                .skipMemoryCache(true)
                .override(100,100)
                .into(menu_image);
//        menu_image.setVisibility(View.GONE);
//        System.out.println("--LIst Size In Inflater--" + launchmodel.size());
        return convertView;
    }
    int value = 0;
    void Loadimage(final ImageView menu_image)
    {
        new CountDownTimer((1000 * 60 * 60), 3000) {
            public void onTick(long millisUntilFinished) {
                if(value == 15)
                {
                    value = 0;
                }
                Glide.with(context)
                        .load(Commonclass.Menu_img[value])
                        .skipMemoryCache(true)
                        .override(250,250)
                        .into(menu_image);
                value++;
            }

            public void onFinish() {
            }

        }.start();
    }
}

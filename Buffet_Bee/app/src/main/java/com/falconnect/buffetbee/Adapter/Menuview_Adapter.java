package com.falconnect.buffetbee.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.falconnect.buffetbee.Modalclass.OrderModel;
import com.falconnect.buffetbee.R;

import java.util.ArrayList;
import java.util.List;

public class Menuview_Adapter extends PagerAdapter {
    Activity mContext;
//    ItemViewHolder viewHolder;
    List<OrderModel> objOrderModel = new ArrayList<>();

    public ImageView menu_image;
    public Menuview_Adapter(Activity context, List<OrderModel> objOrderModelv) {
        mContext = context;
        objOrderModel = objOrderModelv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return objOrderModel.size();
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menuview_item, parent, false);
        menu_image = (ImageView) itemView.findViewById(R.id.menu_image);
        Glide.with(mContext)
                .load(Commonclass.Menu_img[position])
                .skipMemoryCache(true)
                .override(150,150)
                .into(menu_image);
        parent.addView(itemView, 0);
        return itemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


}
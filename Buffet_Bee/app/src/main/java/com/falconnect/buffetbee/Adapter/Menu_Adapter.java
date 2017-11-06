package com.falconnect.buffetbee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.falconnect.buffetbee.MenuviewActivity;
import com.falconnect.buffetbee.Modalclass.OrderModel;
import com.falconnect.buffetbee.R;

import java.util.ArrayList;
import java.util.List;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.ItemViewHolder> {
    Context mContext;
    ItemViewHolder viewHolder;
    List<OrderModel> objOrderModel = new ArrayList<>();
    public Menu_Adapter(Context context,List<OrderModel> objOrderModelv) {
        mContext = context;
        objOrderModel = objOrderModelv;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        viewHolder = new ItemViewHolder(rowView,objOrderModel,mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.menu_name.setText(objOrderModel.get(position).getorder_name());
        holder.menu_amount.setText(Commonclass.Currencyvalue + objOrderModel.get(position).getorder_amount());
        if(objOrderModel.get(position).getorder_nos() == 0)
        {
            holder.Order_text.setText("0");
            holder.Addbutton.setVisibility(View.VISIBLE);
            holder.Ordercount_layout.setVisibility(View.GONE);
        } else {
            holder.Order_text.setText(String.valueOf(objOrderModel.get(position).getorder_nos()));
            holder.Addbutton.setVisibility(View.GONE);
            holder.Ordercount_layout.setVisibility(View.VISIBLE);
        }
        holder.menu_name.setTag(position);
        holder.menu_amount.setTag(position);
        holder.Addbutton.setTag(position);
        holder.Order_minus.setTag(position);
        holder.Order_plus.setTag(position);
        Glide.with(mContext)
                .load(Commonclass.Menu_img[position])
                .skipMemoryCache(true)
                .override(150,150)
                .into(holder.menu_image);
    }

    @Override
    public int getItemCount() {
        return objOrderModel.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView menu_amount, menu_name;
        public final TextView Addbutton, Order_minus, Order_plus, Order_text;
        public final ImageView menu_image;
        public final RelativeLayout Ordercount_layout;

        public ItemViewHolder(View itemView,final List<OrderModel> objOrderModelv, final Context context) {
            super(itemView);
            menu_name = (TextView) itemView.findViewById(R.id.menu_name);
            menu_amount = (TextView) itemView.findViewById(R.id.menu_amount);
            menu_image = (ImageView) itemView.findViewById(R.id.menu_image);
            Addbutton = (TextView) itemView.findViewById(R.id.Addbutton);
            Ordercount_layout = (RelativeLayout) itemView.findViewById(R.id.Ordercount_layout);
            Order_minus = (TextView) itemView.findViewById(R.id.Order_minus);
            Order_plus = (TextView) itemView.findViewById(R.id.Order_plus);
            Order_text = (TextView) itemView.findViewById(R.id.Order_count);
            menu_amount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent objIntent = new Intent(context, MenuviewActivity.class);
                    objIntent.putExtra("position",Integer.valueOf(view.getTag().toString()));
                    context.startActivity(objIntent);
                }
            });
            menu_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent objIntent = new Intent(context, MenuviewActivity.class);
                    objIntent.putExtra("position",Integer.valueOf(view.getTag().toString()));
                    context.startActivity(objIntent);
                }
            });
            Addbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Addbutton.setVisibility(View.GONE);
                    Ordercount_layout.setVisibility(View.VISIBLE);
                    Order_text.setText(String.valueOf(1));
                    objOrderModelv.get(Integer.valueOf(view.getTag().toString())).setorder_nos(1);
                }
            });
            Order_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Integer.parseInt(Order_text.getText().toString()) > 1) {
                        Order_text.setText(String.valueOf(Integer.parseInt(Order_text.getText().toString()) - 1));
                        objOrderModelv.get(Integer.valueOf(view.getTag().toString())).setorder_nos(Integer.parseInt(Order_text.getText().toString())-1);
                    } else {
                        Addbutton.setVisibility(View.VISIBLE);
                        Ordercount_layout.setVisibility(View.GONE);
                        objOrderModelv.get(Integer.valueOf(view.getTag().toString())).setorder_nos(0);
                    }
                }
            });
            Order_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Order_text.setText(String.valueOf(Integer.parseInt(Order_text.getText().toString())+1));
                    objOrderModelv.get(Integer.valueOf(view.getTag().toString())).setorder_nos(Integer.parseInt(Order_text.getText().toString())+1);
                }
            });

        }
    }

}
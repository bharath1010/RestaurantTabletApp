package com.falconnect.buffetbee.Adapter;

import android.content.Context;
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

public class Order_Adapter extends RecyclerView.Adapter<Order_Adapter.ItemViewHolder> {
    Context mContext;
    ItemViewHolder viewHolder;
    List<OrderModel> objOrderModel = new ArrayList<>();
    public Order_Adapter(Context context, List<OrderModel> objOrderModelv) {
        mContext = context;
        objOrderModel = objOrderModelv;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        viewHolder = new ItemViewHolder(rowView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.menu_name.setText(objOrderModel.get(position).getorder_name());
        if (objOrderModel.get(position).getorder_status() == "1") {
            holder.menu_status.setText("");
            holder.Removebutton.setVisibility(View.GONE);
            holder.menu_progress.setVisibility(View.GONE);
            holder.Confirmbutton.setVisibility(View.VISIBLE);
            holder.Cancelbutton.setVisibility(View.VISIBLE);
        } else if (objOrderModel.get(position).getorder_status() == "2") {
            holder.menu_status.setText("In Progress");
            holder.Removebutton.setVisibility(View.VISIBLE);
            holder.Removebutton.setBackgroundResource(R.drawable.hourglass);
            holder.Cancelbutton.setVisibility(View.GONE);
            holder.Confirmbutton.setVisibility(View.GONE);
            holder.menu_progress.setVisibility(View.VISIBLE);
        } else if (objOrderModel.get(position).getorder_status() == "3") {
            holder.menu_status.setText("Delivered");
            holder.Removebutton.setVisibility(View.VISIBLE);
            holder.Removebutton.setBackgroundResource(R.drawable.tick);
            holder.Cancelbutton.setVisibility(View.GONE);
            holder.Confirmbutton.setVisibility(View.GONE);
            holder.menu_progress.setVisibility(View.GONE);
        }
        holder.Confirmbutton.setTag(position);
        holder.Cancelbutton.setTag(position);
//        float Totalamount = Float.parseFloat(objOrderModel.get(position).getorder_amount())*objOrderModel.get(position).getorder_nos();
        holder.menu_amount.setText(Commonclass.Currencyvalue + objOrderModel.get(position).getorder_amount());
//        holder.menu_image.setImageResource(Commonclass.Menu_img[position]);
        Glide.with(mContext)
                .load(Commonclass.Menu_img[position])
                .skipMemoryCache(true)
                .override(150,150)
                .into(holder.menu_image);
        holder.Confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderModel objorder = new OrderModel();
                objorder = objOrderModel.get(Integer.valueOf(view.getTag().toString()));
                Commonclass.objOrderedlist.add(new OrderModel(objorder.getorder_id(),objorder.getorder_name(),"2",objorder.getorder_amount(),objorder.getorder_nos()));
                objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(0);
                objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_status("1");
                holder.menu_amount.setText(Commonclass.Currencyvalue + objOrderModel.get(Integer.valueOf(view.getTag().toString())).getorder_amount());
                holder.Removebutton.setVisibility(View.VISIBLE);
                holder.Cancelbutton.setVisibility(View.GONE);
                holder.Confirmbutton.setVisibility(View.GONE);
                holder.Removebutton.setBackgroundResource(R.drawable.hourglass);
                holder.menu_status.setText("In Progress");
            }
        });
        holder.Cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objOrderModel.get(Integer.valueOf(view.getTag().toString())).setorder_nos(0);
                holder.menu_status.setText("Canceled");
                holder.Removebutton.setVisibility(View.GONE);
                holder.Cancelbutton.setVisibility(View.GONE);
                holder.Confirmbutton.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objOrderModel.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView menu_amount, menu_name,menu_status,Confirmbutton,Cancelbutton,Removebutton;
        public final ImageView menu_image;
        public final RelativeLayout menu_progress;

        public ItemViewHolder(View itemView) {
            super(itemView);
            menu_name = (TextView) itemView.findViewById(R.id.menu_name);
            menu_amount = (TextView) itemView.findViewById(R.id.menu_amount);
            menu_status = (TextView) itemView.findViewById(R.id.menu_status);
            Cancelbutton = (TextView) itemView.findViewById(R.id.Cancelbutton);
            Confirmbutton = (TextView) itemView.findViewById(R.id.Confirmbutton);
            Removebutton = (TextView) itemView.findViewById(R.id.Removebutton);
            menu_image = (ImageView) itemView.findViewById(R.id.menu_image);
            menu_progress = (RelativeLayout) itemView.findViewById(R.id.menu_progress);

        }
    }

}
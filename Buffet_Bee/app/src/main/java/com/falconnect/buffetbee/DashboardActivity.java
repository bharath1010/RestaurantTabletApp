package com.falconnect.buffetbee;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Adapter.Menucategory_Adapter;
import com.falconnect.buffetbee.Modalclass.AppPreferences;
import com.falconnect.buffetbee.Widgets.ExpandableHeightGridView;
import com.falconnect.buffetbee.Widgets.ProgressIndicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
import static android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
import static android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;

public class DashboardActivity extends AppCompatActivity {
    ImageView Alert_bell;
    TextView Alert_timer;
    LinearLayout Mainscreen;
    Refill_popup objRefill_popup;
    ProgressIndicator Alert_progress;
    ExpandableHeightGridView mGridView;
    AppPreferences objAppPreferences;
    RelativeLayout Alert_layout,Alert_layout2,Alert_belllayout;
    public static int layoutwidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        objRefill_popup = new Refill_popup(DashboardActivity.this);
        Loadview_Events();
        List<String> objMenu = new ArrayList<>();
        objMenu.add("Soup's");
        objMenu.add("Pasta");
        objMenu.add("Pizza");
        objMenu.add("Burgers");
        objMenu.add("Chicken");
        objMenu.add("Salad");
        objMenu.add("Sea Food");
        objMenu.add("Punjabi Cuisine");
        objMenu.add("Chinese Cuisine");
        objMenu.add("Mexican Cuisine");
        objMenu.add("Italian Cuisine");
        objMenu.add("Muffins");
        objMenu.add("Soft Drinks");
        objMenu.add("Desserts");
        layoutwidth = getResources().getDisplayMetrics().widthPixels / 5;
        mGridView.setColumnWidth(layoutwidth);
//        mGridView.setColumnWidth(getResources().getDisplayMetrics().widthPixels / 4);
        mGridView.setAdapter(new Menucategory_Adapter(this,objMenu));
        mGridView.setExpanded(true);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(DashboardActivity.this, MenuActivity.class));
            }
        });
    }
    void Loadview_Events()
    {
        mGridView = (ExpandableHeightGridView) findViewById(R.id.menulistview);
        Mainscreen = (LinearLayout) findViewById(R.id.Mainscreen);
        Alert_bell = (ImageView)findViewById(R.id.Alert_bell);
        Alert_layout2 = (RelativeLayout)findViewById(R.id.Alert_layout2);
        Alert_belllayout = (RelativeLayout)findViewById(R.id.Alert_belllayout);
        Alert_progress = (ProgressIndicator)findViewById(R.id.Alert_progress);
        Alert_timer = (TextView)findViewById(R.id.Alert_timer);
        objAppPreferences = new AppPreferences(this);
        TextView headingtext = (TextView)findViewById(R.id.headingtext);
        headingtext.setText("Buffet Bee - Branch Code : "+objAppPreferences.Get_Branchcode()+" - Table Code : "+objAppPreferences.Get_Tablecode());
        final ImageView Order_image = (ImageView)findViewById(R.id.Order_image);
        RelativeLayout Order_layout = (RelativeLayout)findViewById(R.id.Order_layout);
        TextView Order_text = (TextView)findViewById(R.id.Order_text);
        final ImageView Cart_image = (ImageView)findViewById(R.id.Cart_image);
        RelativeLayout Cart_layout = (RelativeLayout)findViewById(R.id.Cart_layout);
        TextView Cart_text = (TextView)findViewById(R.id.Cart_text);
        final ImageView Refill_image = (ImageView)findViewById(R.id.Refill_image);
        Refill_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objRefill_popup.Show();
            }
        });
        RelativeLayout Refill_layout = (RelativeLayout)findViewById(R.id.Refill_layout);
        Refill_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objRefill_popup.Show();
            }
        });
        TextView Refill_text = (TextView)findViewById(R.id.Refill_text);
        Refill_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objRefill_popup.Show();
            }
        });
        ImageView Morebutton = (ImageView)findViewById(R.id.Morebutton);
        Morebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new More_popup(DashboardActivity.this).Show();
            }
        });
        TextView Moretext = (TextView)findViewById(R.id.Moretext);
        Moretext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new More_popup(DashboardActivity.this).Show();
            }
        });
        RelativeLayout Morelayout = (RelativeLayout)findViewById(R.id.Morelayout);
        Morelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new More_popup(DashboardActivity.this).Show();
            }
        });
        final ImageView Games_image = (ImageView)findViewById(R.id.Games_image);
        Games_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, OffersActivity.class));
            }
        });
        RelativeLayout Games_layout = (RelativeLayout)findViewById(R.id.Games_layout);
        Games_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, OffersActivity.class));
            }
        });
        TextView Games_text = (TextView)findViewById(R.id.Games_text);
        Games_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, OffersActivity.class));
            }
        });
        final ImageView Alert_image = (ImageView)findViewById(R.id.Alert_image);
        Alert_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertbuttonClick();
            }
        });
        Alert_layout = (RelativeLayout)findViewById(R.id.Alert_layout);
        Alert_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertbuttonClick();
            }
        });
        TextView Alert_text = (TextView)findViewById(R.id.Alert_text);
        Alert_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertbuttonClick();
            }
        });

        TextView Cart_count = (TextView)findViewById(R.id.Cart_count);
        TextView Order_count = (TextView)findViewById(R.id.Order_count);
        Order_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,OrderviewActivity.class));
            }
        });

        Order_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,OrderviewActivity.class));
            }
        });
        Order_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,OrderviewActivity.class));
            }
        });
        Cart_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,CartActivity.class));
            }
        });
        Cart_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,CartActivity.class));
            }
        });
        Cart_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this,CartActivity.class));
            }
        });
        Alert_progress.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        Alert_progress.setForegroundColor(getResources().getColor(R.color.colorAccent));
        Alert_progress.setPieStyle(true);
        Alert_layout.setVisibility(View.VISIBLE);
        Alert_belllayout.setVisibility(View.GONE);
        Alert_layout2.setVisibility(View.GONE);
        if(Commonclass.objOrderModel.size() == 0)
        {
            Commonclass.AddMenus(Commonclass.objOrderModel);
            Cart_count.setVisibility(View.GONE);
            Cart_layout.setEnabled(false);
            Cart_image.setEnabled(false);
            Cart_text.setEnabled(false);
            Cart_text.setTextColor(getResources().getColor(R.color.ashaaa));
            Cart_image.setImageResource(R.drawable.cart_grey);
        } else {
            int j = 0;
            for(int i=0;i< Commonclass.objOrderModel.size();i++)
            {
                if(Commonclass.objOrderModel.get(i).getorder_nos()>0 && Commonclass.objOrderModel.get(i).getorder_status().equals("1")) {
                    j++;
                }
            }
            if(j!=0)
            {
                Cart_count.setText(String.valueOf(j));
                Cart_count.setVisibility(View.VISIBLE);
                Cart_layout.setEnabled(true);
                Cart_image.setEnabled(true);
                Cart_text.setEnabled(true);
                Cart_text.setTextColor(getResources().getColor(R.color.white));
                Cart_image.setImageResource(R.drawable.cart);
            } else {
                Cart_count.setVisibility(View.GONE);
                Cart_layout.setEnabled(false);
                Cart_image.setEnabled(false);
                Cart_text.setEnabled(false);
                Cart_text.setTextColor(getResources().getColor(R.color.ashaaa));
                Cart_image.setImageResource(R.drawable.cart_grey);
            }
        }
        if(Commonclass.objOrderedlist.size()!=0)
        {
            Order_count.setVisibility(View.VISIBLE);
            Order_count.setText(String.valueOf(Commonclass.objOrderedlist.size()));
            Order_layout.setEnabled(true);
            Order_image.setEnabled(true);
            Order_text.setEnabled(true);
            Order_text.setTextColor(getResources().getColor(R.color.white));
            Order_image.setImageResource(R.drawable.list);
        } else {
            Order_count.setVisibility(View.GONE);
            Order_layout.setEnabled(false);
            Order_image.setEnabled(false);
            Order_text.setEnabled(false);
            Order_text.setTextColor(getResources().getColor(R.color.ashaaa));
            Order_image.setImageResource(R.drawable.list_grey);
        }
        LoadALertdata();
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    void AlertbuttonClick()
    {
        Alert_layout.setVisibility(View.GONE);
        Alert_belllayout.setVisibility(View.VISIBLE);
        Alert_layout2.setVisibility(View.VISIBLE);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Alert_bell.startAnimation(animShake);
        animShake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Alert_belllayout.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        objAppPreferences.Set_Alerttime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
        StartAlert_timer();
    }
    float update = 0;
    long Alert_Delay = 1000 * 60, Alert_Delay_Count = 1000 * 60;
    void LoadALertdata()
    {

        if(!objAppPreferences.Get_Alerttime().isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date date1 = simpleDateFormat.parse(objAppPreferences.Get_Alerttime());
                Date date2 = simpleDateFormat.parse(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
                long value = CheckDifference(date1, date2);
                if(value < Alert_Delay_Count)
                {
                    Alert_Delay = Alert_Delay_Count - value;
                    StartAlert_timer();
                } else {
                    Alert_Delay = Alert_Delay_Count;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    void StartAlert_timer()
    {
        Alert_layout.setVisibility(View.GONE);
        Alert_layout2.setVisibility(View.VISIBLE);
        long pervalue = (Alert_Delay_Count - Alert_Delay)/1000;
        if(pervalue != 0) {
            for (int i = 0; i < pervalue; i++) {
                update += 0.017;
            }
        } else update = 0;
        new CountDownTimer(Alert_Delay, 1000) {
            public void onTick(long millisUntilFinished) {
                update += 0.017;
                Alert_progress.setValue(update);
                Alert_timer.setText((millisUntilFinished / 1000)+" seconds");
            }

            public void onFinish() {
                Alert_Delay = Alert_Delay_Count;
                Alert_layout.setVisibility(View.VISIBLE);
                Alert_layout2.setVisibility(View.GONE);
            }

        }.start();
    }
    public long CheckDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        different = different % daysInMilli;
        different = different % hoursInMilli;
        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;
        long elapsedSeconds = different / secondsInMilli;
        System.out.printf("%d seconds%n",elapsedSeconds + (elapsedMinutes*60));
        if(elapsedMinutes == 0) {
            return (elapsedSeconds * 1000);
        } else {
            return (80 * 1000);
        }
    }
}
//        Use GSON liabrary
//
//        Best way and very fast parsing of JSON is GSON liabrary
//
//        dependacy for android studio compile 'com.google.code.gson:gson:2.3.1' OR you can download jar.
//
//        Make DTO names of all strings exactly same json of resonse.
//
//
//        Class YourDTO{
//        String Title;
//        String Value;
//
//        take gettters & setters
//
//        }
//
//        Just include this lines in your code.
//        List<YourDTO> list = new ArrayList<YourDTO>();
//        String json = "[{"Title":"name","Value":"Sam"}, {"Title":"mobile","Value":"(606) 87-0238"}]";
//
//        JSONArray array=new JSONArray(json);
//        if (array.length() > 0) {
//        Gson gson = new Gson();
//        int i = 0;
//        while (i < array.length()) {
//        list.add(gson.fromJson(array.getJSONObject(i).toString(), YourDTO.class));
//        i++;
//        }
//        } else {
//        Toast.makeText(this, "No Objects", Toast.LENGTH_LONG).show();
//        }
//        ChecktoDisableHomeButton();
//        OverlayDialog mOverlayDialog = new OverlayDialog(this);
//        mOverlayDialog.show();
//    void ChecktoDisableHomeButton()
//    {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (android.support.v4.content.ContextCompat.checkSelfPermission(this, Manifest.permission.DISABLE_KEYGUARD) != PackageManager.PERMISSION_GRANTED) {
//                // Permission has never been accepted
//                // So, I ask the user for permission
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.DISABLE_KEYGUARD}, 100);
//            } else DisableHomeButtons();
//        } else DisableHomeButtons();
//    }
//    public void DisableHomeButtons() {
//        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
//        KeyguardManager.KeyguardLock lock = keyguardManager.newKeyguardLock(KEYGUARD_SERVICE);
//        lock.disableKeyguard();
////        Intent i = new Intent(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
////        i.addCategory(Intent.CATEGORY_HOME);
//        Intent i2 = new Intent(Intent.ACTION_MAIN);
//        i2.addCategory(Intent.CATEGORY_HOME);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        ChecktoDisableHomeButton();
//    }
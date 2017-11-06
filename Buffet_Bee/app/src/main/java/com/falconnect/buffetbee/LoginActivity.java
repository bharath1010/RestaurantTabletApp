package com.falconnect.buffetbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.falconnect.buffetbee.Adapter.Commonclass;
import com.falconnect.buffetbee.Modalclass.AppPreferences;

public class LoginActivity extends AppCompatActivity implements Commonclass.GetRequestDetails {
    TextView Submit_button,Branch_header,Table_header;
    TextView Branch_text,Table_text;
    boolean tablestatus;
    RelativeLayout Table_layout;
    AppPreferences objAppPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Submit_button = (TextView) findViewById(R.id.Submit_button);
        Branch_header = (TextView) findViewById(R.id.Branch_header);
        Table_header = (TextView) findViewById(R.id.Table_header);
        Branch_text = (TextView) findViewById(R.id.Branch_text);
        Table_text = (TextView) findViewById(R.id.Table_text);
        Table_layout = (RelativeLayout) findViewById(R.id.Table_layout);
        RelativeLayout Submit_layout = (RelativeLayout) findViewById(R.id.Submit_layout);
        ImageView Submit_image = (ImageView) findViewById(R.id.Submit_image);
        objAppPreferences = new AppPreferences(LoginActivity.this);
        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Branch_text.getText().length() < 2) {
                    Commonclass.Alert_OK(LoginActivity.this, "Please Select the Branch Code");
                    return;
                }
                if (Table_text.getText().length() < 2) {
                    Commonclass.Alert_OK(LoginActivity.this, "Please Select the Table Code");
                    return;
                }
                objAppPreferences.Set_Branchcode(Branch_text.getText().toString());
                objAppPreferences.Set_Tablecode(Table_text.getText().toString());
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });
        Submit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit_button.performClick();
            }
        });
        Submit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit_button.performClick();
            }
        });
        Branch_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tablestatus = false;
                Branch_popup objBranch_popup = new Branch_popup(LoginActivity.this,LoginActivity.this);
                objBranch_popup.Show();
            }
        });
        Table_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tablestatus = true;
                Table_popup objBranch_popup = new Table_popup(LoginActivity.this,LoginActivity.this);
                objBranch_popup.Show();
            }
        });
        Branch_header.setVisibility(View.GONE);
        Table_header.setVisibility(View.GONE);
        Table_layout.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void Callback(String result) {
        if (tablestatus) {
            Table_text.setText(result);
            Table_header.setVisibility(View.VISIBLE);
        } else {
            Table_text.setText("");
            Table_header.setVisibility(View.GONE);
            Branch_text.setText(result);
            Branch_header.setVisibility(View.VISIBLE);
            Table_layout.setVisibility(View.VISIBLE);
        }
    }
}

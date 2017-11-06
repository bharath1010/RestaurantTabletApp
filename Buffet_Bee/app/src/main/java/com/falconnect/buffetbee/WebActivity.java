package com.falconnect.buffetbee;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ImageView Backbutton = (ImageView)findViewById(R.id.Backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WebActivity.this,GamesActivity.class));
            }
        });
        String Nameurl = getIntent().getStringExtra("name");
        WebView web_view = (WebView)findViewById(R.id.webview);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setPluginState(WebSettings.PluginState.ON);
        web_view.getSettings().setAllowFileAccess(true);
        web_view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        web_view.setBackgroundColor(getResources().getColor(R.color.transparent));
       // web_view.SetWebViewClient(new Webviewclient(this));
        String LoadData = "<html>" +
                "<head></head>" +
                "<body style='background-color: #383C3F;'>" +
                "<object width='100%' height='100%'>" +
                "<param name='movie' value='file:///android_asset/"+Nameurl+".swf'>" +
                "<embed src='file:///android_asset/"+Nameurl+".swf' width='100%' height='100%'>" +
                "</embed>" +
                "</object>" +
                "</body>" +
                "</html>";
        web_view.loadData(LoadData, "text/html", "UTF-8");
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(WebActivity.this,GamesActivity.class));
    }
}

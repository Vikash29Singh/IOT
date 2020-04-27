package com.example.index;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class Feeder extends AppCompatActivity {
    ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeder);
        mProgress = new ProgressDialog(Feeder.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        mProgress.setIndeterminate(true);
        //mProgress.setTitle("Processing...");
        mProgress.setMessage("Loading");
        mProgress.setCancelable(false);
        mProgress.show();
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://thingspeak.com/channels/966258/private_show");
        mProgress.dismiss();
    }
}

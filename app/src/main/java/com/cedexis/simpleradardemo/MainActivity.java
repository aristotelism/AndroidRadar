package com.cedexis.simpleradardemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cedexis.androidradar.Cedexis;
import com.cedexis.androidradar.RadarScheme;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button radarButton;
    private int requestorZoneId = 1;
    private int requestorCustomerId = 10660;
    private Cedexis cedexis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radarButton = (Button) findViewById(R.id.radar_button);
        radarButton.setOnClickListener(this);

        long l = System.currentTimeMillis();
        //cedexis = Cedexis.init(this);
        //Log.d("INIT WITH ACTIVITY", "Time: " + (System.currentTimeMillis() - l));

        //l = System.currentTimeMillis();
        //cedexis = Cedexis.init((WebView) findViewById(R.id.webview));
        //Log.d("INIT WITH WEBVIEW", "Time: " + (System.currentTimeMillis() - l));

        l = System.currentTimeMillis();
        cedexis = Cedexis.init((ViewGroup) findViewById(R.id.content));
        Log.d("INIT WITH VIEWGROUP", "Time: " + (System.currentTimeMillis() - l));

    }

    @Override
    public void onClick(View v) {
        // New SDK Usage
        cedexis.start(requestorZoneId, requestorCustomerId, RadarScheme.HTTPS);
    }
}
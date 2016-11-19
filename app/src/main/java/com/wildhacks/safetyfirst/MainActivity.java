package com.wildhacks.safetyfirst;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView batteryStatusTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BatteryLevelReceiver bt = new BatteryLevelReceiver();
        setContentView(R.layout.activity_main);
        this.registerReceiver(bt, new IntentFilter(
                android.content.Intent.ACTION_BATTERY_LOW));

        Button panicModeBtn = (Button) findViewById(R.id.panicModeBtn);
        Button seeContactsBtn = (Button) findViewById(R.id.seeContactsBtn);
        seeContactsBtn.setOnClickListener(this);
        batteryStatusTxtView = (TextView) findViewById(R.id.batteryStatusTxtView);

        panicModeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.panicModeBtn: {
                IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);

                int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

                float batteryPct = level / (float) scale;
                batteryStatusTxtView.setText("Battery: " + batteryPct);
                break;
            }
            case R.id.seeContactsBtn: {
                Intent intent = new Intent(this, ManuallyAddContacts.class);
                startActivity(intent);
                break;
            }

        }

    }
}

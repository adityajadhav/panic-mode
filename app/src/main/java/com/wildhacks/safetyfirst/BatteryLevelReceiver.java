package com.wildhacks.safetyfirst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by neo on 19-11-2016.
 */

public class BatteryLevelReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "BAttery's dying!!", Toast.LENGTH_LONG).show();
        Log.e("", "BATTERY LOW!!");

    }
}
package com.wildhacks.safetyfirst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by neo on 19-11-2016.
 */

public class BatteryLevelReceiver extends BroadcastReceiver {

    public static final String ACCOUNT_SID = "AC21649542a1c9d23a04ca12c85a900cc5";
    public static final String AUTH_TOKEN = "7c19f057bbf0d8603305906e7bd86c5b";


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "BAttery's dying!!", Toast.LENGTH_LONG).show();
        Log.e("", "BATTERY LOW!!");



        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("3128717684", null, "sms message", null, null);

    }
}
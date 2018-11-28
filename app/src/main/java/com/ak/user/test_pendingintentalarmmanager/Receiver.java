package com.ak.user.test_pendingintentalarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver
{

    final String LOG_TAG = "myLogs";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(LOG_TAG, "onReceive");
        Log.d(LOG_TAG, "action = " +intent.getAction());
        Log.d(LOG_TAG, "extra =" + intent.getStringExtra("extra"));
    }

}

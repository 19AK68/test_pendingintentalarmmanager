package com.ak.user.test_pendingintentalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MainActivity extends  AppCompatActivity
{
    private static final int NOTIFY_ID = 101;

    private String sContentTitle = "НАПОМИНАНИЕ";
    private String sContentText = "Пора что-то сделать";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view)

    {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent =  PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        Resources res = this.getResources();

        //android 8.0

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(sContentTitle)
                .setContentText(sContentText)
                .setTicker("Последнее китайское предупреждение!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID,builder.build());



    }


}

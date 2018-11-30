package com.ak.user.test_pendingintentalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void sendActionNotification(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Намерение для запуска второй активности
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Строим уведомление
        Notification builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Посылка")
                .setContentText(
                        "Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Открыть", pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Отказаться", pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Другой вариант", pendingIntent)
                .build();

        // убираем уведомление, когда его выбрали
        builder.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, builder);
    }



}

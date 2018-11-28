package com.ak.user.test_pendingintentalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MainActivity extends Activity
{
    final  String LOG_TAG = "myLogs";

    NotificationManager notificationManager;
    AlarmManager alarmManager;
    Intent intent1,intent2;
    PendingIntent pendingIntent1,pendingIntent2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void onClick1(View view)
    {
        intent1 =  createIntent("action 1", "extra 1");
    }

    Intent createIntent(String action, String extra)
    {

        Intent intent = new Intent(this, Receiver.class);
        intent.setAction(action);
        intent.putExtra("extra", extra);
        return intent;
    }

    void compare()
    {
        Log.d(LOG_TAG, "intent1 = intent2: " + intent1.filterEquals(intent2));
        Log.d(LOG_TAG, " pendingIntent1 =  pendingIntent2: " + pendingIntent1.equals(pendingIntent2));
    }

    void sendNotif(int id, PendingIntent pendingIntent) {

       Notification notif = new Notification(R.mipmap.ic_launcher, "Notif "
                + id, System.currentTimeMillis());
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.setLatestEventInfo(this, "Title " + id, "Content " + id, pendingIntent);
        notificationManager.notify(id, notif);
    }

    public void onClick2(View view) {

    }
}

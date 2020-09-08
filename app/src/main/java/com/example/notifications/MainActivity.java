package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

                     NotificationChannel channel=new NotificationChannel("govi","android_channel",NotificationManager.IMPORTANCE_DEFAULT);
                     manager.createNotificationChannel(channel);
                 }
                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                 PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),
                         1,
                         intent,
                         PendingIntent.FLAG_CANCEL_CURRENT);
                 NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"govi");
                 builder.setContentTitle("GOVARDHAN");
                 builder.setContentText("HI BUDDY!");
                 builder.setSmallIcon(R.drawable.noteimage);
                 builder.setDefaults(NotificationCompat.DEFAULT_ALL);
                 builder.setPriority(NotificationCompat.PRIORITY_MAX);
                 builder.setContentIntent(pi);
                 builder.addAction(R.drawable.reply,"reply",pi);

                 manager.notify(1,builder.build());

             }
         });


    }
}
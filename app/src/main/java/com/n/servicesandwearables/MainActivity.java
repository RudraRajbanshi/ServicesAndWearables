package com.n.servicesandwearables;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createChannel.createChannel;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        createChannel channel = new createChannel(this);
        channel.channelCreate();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });
    }
    private void displayNotification1(){
        Notification builder = new NotificationCompat.Builder(this,createChannel.CHANNEL1)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("First Message")
                .setContentText("This is First Message")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(1,builder);

    }

    private void displayNotification2(){
        Notification builder = new NotificationCompat.Builder(this,createChannel.CHANNEL2)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("Second Message")
                .setContentText("This is Second Message")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(2,builder);
    }
}

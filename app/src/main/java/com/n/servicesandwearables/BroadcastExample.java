package com.n.servicesandwearables;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import createChannel.createChannel;

public class BroadcastExample extends BroadcastReceiver {
    NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        notificationManagerCompat = NotificationManagerCompat.from(context);

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);

            if (noConnectivity){
                Toast.makeText(context,"Disconnected",Toast.LENGTH_LONG).show();
                displayNotification1();

            }else{
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();
                displayNotification2();
            }
        }
    }
    private void displayNotification1(){
        Notification builder = new NotificationCompat.Builder(context, createChannel.CHANNEL1)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("No Connection")
                .setContentText("No Connectivity, please connect")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(1,builder);

    }

    private void displayNotification2(){
        Notification builder = new NotificationCompat.Builder(context,createChannel.CHANNEL2)
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("Connected")
                .setContentText("You have been connected")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(2,builder);
    }
}

package createChannel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class createChannel {
    Context context;
    public final static String CHANNEL1 = "channel1";
    public final static String CHANNEL2 = "channel2";

    public createChannel(Context context) {
        this.context = context;
    }

    public void channelCreate(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL1,"channel1", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL2,"channel2", NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("This is channel 2");

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channel2);
        }
    }
}

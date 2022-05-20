package com.example.petfeeder;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channel1id = "channel1ID";
    public static final String channel1name = "Channel1";
    public static final String channel2id = "channel2ID";
    public static final String channel2name = "Channel2";
    private NotificationManager mManager;
    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            createChannels();
        };
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels(){
        NotificationChannel channel1 = new NotificationChannel(channel1id,channel1name, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.colorPrimary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getmManager().createNotificationChannel(channel1);

    }

    public NotificationManager getmManager(){
        if (mManager==null){
            mManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getchannel1notification ()
    {
        return new NotificationCompat.Builder(getApplicationContext(),channel1id)
                .setContentTitle("PetFeeder")
                .setContentText("Your Pet have been fed")
                .setSmallIcon(R.drawable.ic_petfeed);

    }

}

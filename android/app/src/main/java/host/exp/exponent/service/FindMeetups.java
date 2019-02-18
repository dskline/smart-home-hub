package host.exp.exponent.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import host.exp.exponent.R;

public class FindMeetups extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(FindMeetups.class.getSimpleName(), "onReceive() called");
        Log.d(FindMeetups.class.getSimpleName(), intent.toString());

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "meetup")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }
}

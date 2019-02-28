package host.exp.exponent.feature.meetup.task;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.util.List;

import host.exp.exponent.R;
import host.exp.exponent.feature.meetup.model.MeetupResult;
import host.exp.exponent.system.NotificationSender;

public class SendMeetupNotifications {

    public static void send(Context context, List<MeetupResult> meetups) {
        int i = 0;
        for (MeetupResult meetup : meetups) {
            NotificationSender.send(context, getNotification(context, meetup, i++));
        }
    }

    private static Notification getNotification(Context context, MeetupResult meetup, int notificationIndex) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(meetup.getUrl()));
        PendingIntent notificationIntent = PendingIntent.getActivity(
                context, notificationIndex, browserIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(context, context.getString(R.string.default_notification_channel))
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(meetup.getTitle())
                .setContentText("Forecast: " + meetup.getTemperature() + "°F")
                .setContentIntent(notificationIntent)
                .setAutoCancel(true)
                .build();
    }
}

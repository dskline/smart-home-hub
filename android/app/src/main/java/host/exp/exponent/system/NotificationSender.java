package host.exp.exponent.system;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;

import host.exp.exponent.R;

public class NotificationSender {

    public static void send(Context context, Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(
                    context.getString(R.string.default_notification_channel),
                    "Home Hub",
                    NotificationManager.IMPORTANCE_LOW);

            manager.createNotificationChannel(channel);
        }
        NotificationManagerCompat notifier = NotificationManagerCompat.from(context);
        notifier.notify("HOME_HUB", 0, notification);
    }
}

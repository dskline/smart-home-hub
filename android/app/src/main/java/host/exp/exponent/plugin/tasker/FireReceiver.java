package host.exp.exponent.plugin.tasker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.twofortyfouram.locale.sdk.client.receiver.AbstractPluginSettingReceiver;

import host.exp.exponent.R;

public class FireReceiver extends AbstractPluginSettingReceiver {

    @Override
    protected boolean isBundleValid(@NonNull Bundle bundle) {
        return true;
    }

    @Override
    protected boolean isAsync() {
        return false;
    }

    @Override
    protected void firePluginSetting(@NonNull Context context, @NonNull Bundle bundle) {
        Log.d(FireReceiver.class.getSimpleName(), "cool beans");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "HOME_HUB_NOTIFICATION_CHANNEL")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Meetup Found")
                .setContentText("Touch to view details");

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "HOME_HUB_NOTIFICATION_CHANNEL",
                    "Home Hub",
                    NotificationManager.IMPORTANCE_LOW);

            manager.createNotificationChannel(channel);
        }
        NotificationManagerCompat notifier = NotificationManagerCompat.from(context);
        notifier.notify("HOME_HUB", 0, mBuilder.build());
    }
}

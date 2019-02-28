package net.dinglisch.android.tasker;

import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.Keep;

@Keep
public class PluginResultReceiver extends ResultReceiver {

    public PluginResultReceiver(Handler handler) {
        super(handler);
    }
}
package host.exp.exponent.plugin.tasker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.twofortyfouram.locale.sdk.client.receiver.AbstractPluginSettingReceiver;

import host.exp.exponent.feature.meetup.FindMeetupsAction;

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
        // TODO: Pick the correct handler based on trigger (for now, there's only one)
        new FindMeetupsAction().start(context);
    }
}

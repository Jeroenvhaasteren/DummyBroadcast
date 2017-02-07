package org.bts.atry.dummybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SystemBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = SystemBroadcastReceiver.class.getSimpleName();

    public SystemBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(SystemBroadcastReceiver.TAG,"Type" + intent.getType() +"|" + intent.getAction() );

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.w(SystemBroadcastReceiver.TAG, "Airplane mode");
                break;
            case Intent.ACTION_BATTERY_LOW:
                Log.w(SystemBroadcastReceiver.TAG, "Battery low");
                break;
            default:
                Log.w(SystemBroadcastReceiver.TAG, "Unidentified Event");
                break;
        }

    }
}

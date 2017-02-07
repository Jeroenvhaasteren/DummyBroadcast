package org.bts.atry.dummybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = CustomBroadcastReceiver.class.getSimpleName();

    public CustomBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(CustomBroadcastReceiver.TAG, "CSUTOM-ACTION event Caught!");
        Toast.makeText(context, "CUSTOM ACTION TRIGGERD", Toast.LENGTH_SHORT).show();

    }
}

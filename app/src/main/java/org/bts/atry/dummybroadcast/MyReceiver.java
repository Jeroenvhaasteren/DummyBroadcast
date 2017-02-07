package org.bts.atry.dummybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private final static String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(MyReceiver.TAG, "MyReceiver fired");
        Toast.makeText(context, "MyREceiver fired", Toast.LENGTH_SHORT).show();

    }
}

package org.bts.atry.dummybroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private BroadcastReceiver MyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnCustomBroadcast = (Button) findViewById(R.id.btnTrigBroadcast);
        final Button btnBroadcast = (Button) findViewById(R.id.btnTrigLocalBroadcast);

        btnCustomBroadcast.setOnClickListener(this);
        btnBroadcast.setOnClickListener(this);

        this.MyReceiver = new MyReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(
                MyReceiver,
                new IntentFilter("org.bts.atry.dummybroadcast.CUSTOM_LOCAL_ACTION")
        );
    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(MyReceiver);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnTrigLocalBroadcast:
                Log.i(MainActivity.TAG,"Local btn Clicked");
                Intent intent = new Intent();

                LocalBroadcastManager.getInstance(this).sendBroadcast(
                        new Intent().setAction("org.bts.atry.dummybroadcast.CUSTOM_LOCAL_ACTION")
                );

            break;
            case R.id.btnTrigBroadcast:
                Log.i(MainActivity.TAG,"Custom btn Clicked");
                Intent intent2 = new Intent();
                intent2.setAction(getString(R.string.action_custom_broadcast));
                sendBroadcast(intent2);
                break;
            default:
                Log.w(MainActivity.TAG,"Btn not defined");
                break;
        }
    }
}

package org.bts.atry.dummybroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnCustomBroadcast = (Button) findViewById(R.id.btnTrigBroadcast);
        final Button btnBroadcast = (Button) findViewById(R.id.btnTrigLocalBroadcast);

        btnCustomBroadcast.setOnClickListener(this);
        btnBroadcast.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnTrigLocalBroadcast:
                Log.i(MainActivity.TAG,"Local btn Clicked");
                Intent intent = new Intent();
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

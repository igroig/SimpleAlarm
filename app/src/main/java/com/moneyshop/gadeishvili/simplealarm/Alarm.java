package com.moneyshop.gadeishvili.simplealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Long time = bundle.getLong("a",0);

        String ab = new SimpleDateFormat("HH.MM").format(time);


        Toast.makeText(context, ab +
                "", Toast.LENGTH_SHORT).show();



        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);

    }
}

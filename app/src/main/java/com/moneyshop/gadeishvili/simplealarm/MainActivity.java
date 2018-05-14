package com.moneyshop.gadeishvili.simplealarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etTime;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etTime = (EditText)findViewById(R.id.etTime) ;
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                int seconds = Integer.parseInt(etTime.getText().toString());

                Intent intent = new Intent(MainActivity.this, Alarm.class);
                intent.putExtra("a" , System.currentTimeMillis() + seconds * 1000);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);


                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds * 1000, pendingIntent);


                break;
        }
    }
}

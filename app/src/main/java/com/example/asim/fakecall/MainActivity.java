package com.example.asim.fakecall;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private EditText fakeName;
    private EditText fakeNumber;

    private RadioGroup radioGroup;
    private RadioButton firstOption;
    private RadioButton secondOption;
    private RadioButton thirdOption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        fakeName = (EditText)findViewById(R.id.fakename);
        fakeNumber = (EditText)findViewById(R.id.fakenumber);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        firstOption = (RadioButton)findViewById(R.id.radio0);
        secondOption = (RadioButton)findViewById(R.id.radio1);
        thirdOption = (RadioButton)findViewById(R.id.radio2);

        Button fakeCallButton = (Button)findViewById(R.id.fakecalls);



        fakeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int interval=1000000;
                setUpAlarm();


            }
        });



    }



    public void setUpAlarm(){

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, FakeCallReceiver.class);



       PendingIntent fakePendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5 * 1000, fakePendingIntent);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),(5*1000),fakePendingIntent);
        Toast.makeText(getApplicationContext(), "Your fake call time has been set", Toast.LENGTH_SHORT).show();

//        Intent intents = new Intent(this, MainActivity.class);
//        startActivity(intents);
        this.finish();

    }

}

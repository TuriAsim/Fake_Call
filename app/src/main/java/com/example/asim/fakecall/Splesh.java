package com.example.asim.fakecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asim on 4/17/2016.
 */
public class Splesh extends AppCompatActivity {

    Button button;
    Button buttont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);
        button= (Button) findViewById(R.id.button);
        buttont= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Splesh.this,MainActivity.class);
                startActivity(i);

            }
        });

        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}

package com.example.adityakumarsharma.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout r1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_main);
        r1=(RelativeLayout) findViewById(R.id.relative);

        r1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                Intent is = new Intent(MainActivity.this, login.class);
                startActivity(is);
                return true;
            }
        });
    }}

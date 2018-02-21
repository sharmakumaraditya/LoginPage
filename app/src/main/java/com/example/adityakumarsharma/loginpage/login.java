package com.example.adityakumarsharma.loginpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity  {
    Database_Help myd;
    EditText username,pass;
    TextView tt;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.editText4);
        pass = (EditText)findViewById(R.id.editText5);
        myd = new Database_Help(this);
        tt = (TextView)findViewById(R.id.textView);
        b1 = (Button)findViewById(R.id.button3);
        b2 = (Button)findViewById(R.id.button4);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ip = new Intent(login.this,signup.class);
                startActivity(ip);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=username.getText().toString();
                String password= myd.list(str);
                if (pass.equals(password))
                {
                    Intent ip = new Intent(login.this,navigation.class);
                    startActivity(ip);
                }
                else {
                    Toast.makeText(getApplicationContext(),"enter correct credentials",Toast.LENGTH_LONG).show();}
            }});}
/*
    public void showmsg(String title , String msg)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(msg);
        b.show();
    }*/


          /*  case R.id.button3:
                String s1 = username.getText().toString();
                String s2 = pass.getText().toString();
                boolean b = myd.list(s1,s2);
                if(b=true)
                {
                  //  Intent is = new Intent(login.this,navigation.class);
                  //  startActivity(is);
                    Toast.makeText(getApplicationContext()," Correct Credentials",Toast.LENGTH_LONG).show();

                }
                else if (b=false)
                {
                    Toast.makeText(getApplicationContext(),"Enter Correct Credentials",Toast.LENGTH_LONG).show();
                }
                break;*/

}
package com.example.adityakumarsharma.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends Activity {
    Database_Help mydb;
    EditText editname,editusername,editpassword,editcnfpass;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mydb = new Database_Help(this);
        editname = (EditText)findViewById(R.id.editText1);
        editusername = (EditText)findViewById(R.id.editText2);
        editpassword = (EditText)findViewById(R.id.editText3);
        editcnfpass = (EditText)findViewById(R.id.editText4);
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = editpassword.getText().toString();
                String s2 = editcnfpass.getText().toString();
                if(s1.contentEquals(s2))
                {
                    boolean inser = mydb.insertData(editname.getText().toString(), editusername.getText().toString(), editpassword.getText().toString());
                    if(inser == true)
                    {
                        Toast.makeText(getApplicationContext(), "Registration Done Successfully", Toast.LENGTH_LONG).show();
                        Intent ip = new Intent(signup.this,login.class);
                        startActivity(ip);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "inserted unsucces", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

    }
}

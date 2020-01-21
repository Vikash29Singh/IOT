package com.example.index;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText password, email;
    Button sign;
   // ProgressDialog progressBar;
    int count=0,count1=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email_id);

        sign=(Button)findViewById(R.id.sign);

       // final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);





    sign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        /*Intent intent = new Intent(getApplicationContext(), Dashboard.class);


        intent.putExtra("Name", email.getText().toString());
        startActivity(intent);*/

        /*count=count+1;
        count1=count1-1;*/
       // Toast.makeText(Login.this, email.getText().toString(), Toast.LENGTH_SHORT).show();

        if (email.getText().toString().matches("iot") && password.getText().toString().matches("123")) {
            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Login.this, Index2.class);
            //simpleProgressBar.setVisibility(View.VISIBLE);

           intent.putExtra("Name", email.getText().toString());
            startActivity(intent);

            //startActivity(intent);
        }
         else {


            Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            //\n Attempt left : "+count1

           /* if(count>2) {
                     System.exit(0);
                    finish();
                }*/
        }
    }
});
    }
    public void registration(View view) {
    }
}



package com.example.index;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText password, email;
    Button sign;
    ProgressDialog mProgress;
    int count = 0, count1 = 3;

    AlertDialog.Builder builder;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();


        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email_id);

        sign = (Button) findViewById(R.id.sign);

        // final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
//progress bar
        mProgress = new ProgressDialog(Login.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        mProgress.setIndeterminate(true);
        //mProgress.setTitle("Processing...");
        mProgress.setMessage("Authenticating");
        mProgress.setCancelable(false);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(getApplicationContext(), "User logged in ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(I);
                } else {
                    Toast.makeText(getApplicationContext(), "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgress.show();
                String userEmail = email.getText().toString();
                String userPaswd = password.getText().toString();
                if (userEmail.isEmpty()) {
                    email.setError("Provide your Email first!");
                    email.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    password.setError("Enter Password!");
                    password.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(Login.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                //Toast.makeText(getApplicationContext(), "Not sucessfull", Toast.LENGTH_SHORT).show();
                                mProgress.dismiss();
                                builder = new AlertDialog.Builder(Login.this);
                                builder.setTitle("Alert")
                                        .setIcon(R.drawable.alerticon)
                                        .setMessage("Wrong Credential")
                                        .setCancelable(false)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                              /* finish();


                                finish();*/

                                                FirebaseAuth.getInstance().signOut();
                                                Intent I = new Intent(Login.this, Index.class);
                                                startActivity(I);
                                                //System.exit(0);
                                                finish();

                                            }
                                        });

                                AlertDialog alertDialog1 = builder.create();
                                alertDialog1.show();

                                Toast.makeText(getApplicationContext(), "Not sucessfull", Toast.LENGTH_SHORT).show();
                            } else {
                                mProgress.dismiss();
                                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }


/*
    sign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        *//*Intent intent = new Intent(getApplicationContext(), Dashboard.class);


        intent.putExtra("Name", email.getText().toString());
        startActivity(intent);*//*

     *//*count=count+1;
        count1=count1-1;*//*
       // Toast.makeText(Login.this, email.getText().toString(), Toast.LENGTH_SHORT).show();

        if (email.getText().toString().matches("iot") && password.getText().toString().matches("123")) {
            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Login.this, Dashboard.class);
            //simpleProgressBar.setVisibility(View.VISIBLE);

           intent.putExtra("Name", email.getText().toString());
            startActivity(intent);

            //startActivity(intent);
        }
         else {


            Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            //\n Attempt left : "+count1

           *//* if(count>2) {
                     System.exit(0);
                    finish();
                }*//*
        }
    }
});*/

/*    public void registration(View view) {
    }*/
}



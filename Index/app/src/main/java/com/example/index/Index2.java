package com.example.index;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Index2 extends AppCompatActivity {
    EditText password, email;
    Button sign;
    //ProgressDialog progressBar;
    //int count=0,count1=3;
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId())
        {
            case R.id.action_data:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Server Down ")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Please try letter..")

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Index2.this,Index2.class));
                                finish();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Toast.makeText(this, "Server Down\nPlease try letter", Toast.LENGTH_SHORT).show();


                return true;
            case R.id.action_analysis:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Server Down ")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Please try letter..")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Index2.this,Index2.class));
                                finish();
                            }
                        });

                AlertDialog alertDialoga = builder.create();
                alertDialoga.show();
                Toast.makeText(this, "Server Down\nPlease try letter", Toast.LENGTH_SHORT).show();

                return  true;

            case R.id.action_logout:
                 builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Are you sure you want to logout ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               finish();
                               System.exit(0);

                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog alertDialog1 = builder.create();
                alertDialog1.show();

            default:

                return super.onOptionsItemSelected(item);


        }

    }

}
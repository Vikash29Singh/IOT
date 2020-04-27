package com.example.index;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    EditText password, email;
    Button sign;
    //ProgressDialog progressBar;
    //int count=0,count1=3;
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;
    CardView data, graph, feeder;

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    WebView myWebView;
    private static final int PERMISSION_STORAGE_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        data = findViewById(R.id.data);
        graph = findViewById(R.id.graph);
       // feeder = findViewById(R.id.feeder);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(),Datacollection.class));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                            .PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_STORAGE_CODE);

                    } else {
                        startDownloading();
                    }
                } else {

                }
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myWebView.loadUrl("https://www.example.com");
                String url = "https://thingspeak.com/channels/966258/private_show";
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
               //startActivity(new Intent(getApplicationContext(),Feeder.class));
            }
        });

        /*feeder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Feeder.class));
            }
        });
*/

    }

    public void setProgressDialog()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        //set Trasparent background
        progressDialog.setIndeterminate(true);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void onBackPressed() {
         progressDialog.dismiss();
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
                setProgressDialog();
                /*builder = new AlertDialog.Builder(this);
                builder.setTitle("Server Down ")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Please try letter..")

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(Dashboard.this,Dashboard.class));
                                finish();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();*/

                Toast.makeText(this, "Server Down\nPlease try letter", Toast.LENGTH_SHORT).show();


                return true;
            case R.id.action_analysis:
                String url = "https://thingspeak.com/channels/966258/private_show";
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
//https://thingspeak.com/channels/966258/field/1.csv
               /* builder = new AlertDialog.Builder(this);
                builder.setTitle("Server Down ")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Please try letter..")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               *//* String url = "https://thingspeak.com/channels/966258/private_show";
                                Intent intent= new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(url));
                                startActivity(intent);
*//*                            }
                        });

                AlertDialog alertDialoga = builder.create();
                alertDialoga.show();
                Toast.makeText(this, "Server Down\nPlease try letter", Toast.LENGTH_SHORT).show();
*/
                return  true;

            case R.id.action_logout:
                 builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert")
                        .setIcon(R.drawable.alerticon)
                        .setMessage("Are you sure you want to logout ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                              /* finish();


                                finish();*/

                                FirebaseAuth.getInstance().signOut();
                                Intent I = new Intent(Dashboard.this, Login.class);
                                startActivity(I);
                                //System.exit(0);
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
    private void startDownloading() {
        String url = "https://thingspeak.com/channels/966258/field/1.csv";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("Download")
                .setDescription("Download File...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "" + System.currentTimeMillis());
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startDownloading();
                } else {
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
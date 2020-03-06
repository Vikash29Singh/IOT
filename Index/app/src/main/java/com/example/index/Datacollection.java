package com.example.index;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Datacollection extends AppCompatActivity {
DatabaseReference databaseAqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datacollection);

        databaseAqua = FirebaseDatabase.getInstance().getReference("");
    }
}

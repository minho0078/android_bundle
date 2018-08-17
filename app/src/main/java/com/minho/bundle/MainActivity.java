package com.minho.bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private String user_network;

    private TextView main_tv_user_network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        user_network = intent.getStringExtra("network");

        Log.d(TAG, "onCreate: user_network : "+user_network);

        main_tv_user_network = findViewById(R.id.main_tv_user_network);
        main_tv_user_network.setText(user_network);
    }
}

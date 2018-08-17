package com.minho.bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.minho.bundle.util.dialog.ChesedCustomDialog;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private String user_network;

    private TextView main_tv_user_network;
    private ChesedCustomDialog chesedDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        user_network = intent.getStringExtra("network");

        Log.d(TAG, "onCreate: user_network : "+user_network);

        main_tv_user_network = findViewById(R.id.main_tv_user_network);
        main_tv_user_network.setText(user_network);

        chesedDialog = new ChesedCustomDialog(this, "공지", "안녕하세요, 공지사항입니다.", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chesedDialog.dismiss();
            }
        });
        chesedDialog.setCanceledOnTouchOutside(false);
        chesedDialog.show();
    }
}

package com.minho.bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.minho.bundle.util.CheckConnect;
import com.minho.bundle.util.Utils;

public class SplashActivity extends AppCompatActivity {

    private String TAG = "SplashActivity";
    public static final String CONNECTION_CONFIRM_CLIENT_URL = "http://clients3.google.com/generate_204";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String user_network = Utils.GET_WHAT_KIND_OF_NETWORK(this);

        Intent intent = new Intent(this, MainActivity.class);

        switch (user_network){
            case Utils.NONE_STATE:
                Log.d(TAG, "onCreate: user_network is none");
                intent.putExtra("network", Utils.NONE_STATE);
                break;
            case Utils.MOBILE_STATE:
                Log.d(TAG, "onCreate: user_network is mobile_state");
                if(isOnline()){
                    intent.putExtra("network", Utils.MOBILE_STATE);
                }
                break;
            case Utils.WIFI_STATE:
                Log.d(TAG, "onCreate: user_network is wifi");
                if(isOnline()){
                    intent.putExtra("network", Utils.WIFI_STATE);
                }
                break;
        }

        startActivity(intent);
        finish();
    }

    public static boolean isOnline() {
        CheckConnect cc = new CheckConnect(CONNECTION_CONFIRM_CLIENT_URL);
        cc.start();
        try{
            cc.join();
            return cc.isSuccess();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}

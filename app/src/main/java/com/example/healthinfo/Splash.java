package com.example.healthinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread th= new Thread(){

            @Override
            public void run() {

                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent obj = new Intent(Splash.this, LoginActivity.class);
                    startActivity(obj);
                };


            }
        };
        th.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

package com.example.tyq19.lbs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;


public class SplashScreen extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

        setContentView(R.layout.splashscreen);
        overridePendingTransition(R.anim.layout_in_long, 0);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent =new Intent(SplashScreen.this,MainActivity.class);
               SplashScreen.this.startActivity(intent);
               overridePendingTransition(R.anim.layout_in_long,0);
               SplashScreen.this.finish();
           }
       },1000);
    }
    @Override
    public void onBackPressed()
    {
        System.exit(0);
    }

}
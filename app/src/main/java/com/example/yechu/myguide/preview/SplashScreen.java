package com.example.yechu.myguide.preview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yechu.myguide.MainActivity;
import com.example.yechu.myguide.R;

public class SplashScreen extends AppCompatActivity {

     private static final int SPLASH_TIMER = 3000;
    //var
    ImageView backgroundImage;
    TextView poweredBy;

    //anim
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //hooks
        backgroundImage = findViewById(R.id.mapImage);
        poweredBy = findViewById(R.id.power_by);

        //anim
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set anim on elements
        backgroundImage.setAnimation(sideAnim);
        poweredBy.setAnimation(bottomAnim);

        //파라미터 없는 거만 deprecated 됨
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}

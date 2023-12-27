package com.example.supersantarun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    ImageButton ibStartGame;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });
        mAdView = findViewById(R.id.adViewMainActivity);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MainActivity.mediaPlayer = MediaPlayer.create(this, R.raw.bg_music);
        if(MainActivity.mediaPlayer != null)
        {
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }

        AppConstants.initialization(this.getApplicationContext());
        ibStartGame = findViewById(R.id.ibStartGame);
        ibStartGame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    // Suppress the deprecated WARNING

    @SuppressWarnings("deprecation")
    @Override
    public void onBackPressed()
    {
        if(MainActivity.mediaPlayer != null)
        {
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
        super.onBackPressed();
    }




}
package com.creditscoreinfo.report.check.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.creditscoreinfo.report.check.ads.BackInterAds;
import com.creditscoreinfo.report.check.ads.InterAds;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityMainBinding;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onResume() {
        super.onResume();
        if (PowerPreference.getDefaultFile().getBoolean(Constant.FULL_SCREEN, true)) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        new LargeNativeAds().showNativeAds(this, null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCheckCreditScoreOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new InterAds().showInterAds(MainActivity.this, new InterAds.OnAdClosedListener() {
                    @Override
                    public void onAdClosed() {
                        startActivity(new Intent(MainActivity.this, CreditOptionActivity.class));
                    }
                });

            }
        });

        binding.btnCheckCreditScoreOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new InterAds().showInterAds(MainActivity.this, new InterAds.OnAdClosedListener() {
                    @Override
                    public void onAdClosed() {
                        startActivity(new Intent(MainActivity.this, OfflineScoreActivity.class));
                    }
                });

            }
        });

        binding.btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InterAds().showInterAds(MainActivity.this, new InterAds.OnAdClosedListener() {
                    @Override
                    public void onAdClosed() {
                        startActivity(new Intent(MainActivity.this, CreditMainTipsActivity.class));
                    }
                });

            }
        });

        binding.btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new InterAds().showInterAds(MainActivity.this, new InterAds.OnAdClosedListener() {
                    @Override
                    public void onAdClosed() {
                        startActivity(new Intent(MainActivity.this, EmiCalculaterActivity.class));
                    }
                });

            }
        });

    }

    @Override
    public void onBackPressed() {
        new BackInterAds().showInterAds(this, new BackInterAds.OnAdClosedListener() {
            @Override
            public void onAdClosed() {
                finish();
            }
        });
    }
}
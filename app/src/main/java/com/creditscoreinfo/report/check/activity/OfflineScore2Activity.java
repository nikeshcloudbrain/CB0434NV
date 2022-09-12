package com.creditscoreinfo.report.check.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;


import com.creditscoreinfo.report.check.ads.BackInterAds;
import com.creditscoreinfo.report.check.ads.InterAds;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.ads.MiniNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityOfflineScore2Binding;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

public class OfflineScore2Activity extends AppCompatActivity {
    ActivityOfflineScore2Binding binding;
    int a, a2;

    @Override
    protected void onResume() {
        super.onResume();
        if (PowerPreference.getDefaultFile().getBoolean(Constant.FULL_SCREEN, true)) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        new LargeNativeAds().showNativeAds(this, null);
        new MiniNativeAds().showNativeAds(this, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOfflineScore2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.include2.toolbarText.setText("Check Score Offline");

        binding.seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {

                binding.text1.setText("₹" + i);
                a = i;
            }
        });
        binding.seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                binding.text2.setText("₹" + i);
                a2 = i;
            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PowerPreference.getDefaultFile().putInt("a", a);
                PowerPreference.getDefaultFile().putInt("a2", a2);

                new InterAds().showInterAds(OfflineScore2Activity.this, new InterAds.OnAdClosedListener() {
                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(OfflineScore2Activity.this, OfflineScore3Activity.class));



                    }
                });
            }
        });

        binding.include2.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
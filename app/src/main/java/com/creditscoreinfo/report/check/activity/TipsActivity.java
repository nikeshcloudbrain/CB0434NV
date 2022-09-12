package com.creditscoreinfo.report.check.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.creditscoreinfo.report.check.Adapter.CreditTipsAdapter;
import com.creditscoreinfo.report.check.ads.BackInterAds;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.ads.MiniNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityTipsBinding;
import com.creditscoreinfo.report.check.model.Tips;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {

    ActivityTipsBinding binding;

    ArrayList<Tips> tips = new ArrayList<Tips>();

    @Override
    protected void onResume() {
        super.onResume();
        if (PowerPreference.getDefaultFile().getBoolean(Constant.FULL_SCREEN, true)) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        new MiniNativeAds().showNativeAds(this, null);
        //new LargeNativeAds().showNativeAds(this, null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTipsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tips = this.getIntent().getExtras().getParcelableArrayList("Birds");

        //Log.e("tips", tips.get(1).title);

        binding.rvTips.setLayoutManager(new LinearLayoutManager(this));

        CreditTipsAdapter creditTipsAdapter = new CreditTipsAdapter(tips, getApplicationContext(),this);
        binding.rvTips.setAdapter(creditTipsAdapter);


        binding.include2.toolbarText.setText(getIntent().getExtras().getString("toolbartext"));
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
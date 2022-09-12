package com.creditscoreinfo.report.check.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.creditscoreinfo.report.check.ads.BackInterAds;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.ads.MiniNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityEmiCalculatedBinding;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

public class EmiCalculatedActivity extends AppCompatActivity {
ActivityEmiCalculatedBinding binding;
Long month_emi,total_in,total_pay;

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
        binding=ActivityEmiCalculatedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        month_emi = this.getIntent().getExtras().getLong("month_emi");
        total_in = this.getIntent().getExtras().getLong("total_in");
        total_pay = this.getIntent().getExtras().getLong("total_pay");

        binding.emiMonthly.setText("Monthly EMI(₹)       "+month_emi+"(₹)");
        binding.totalInterest.setText("Total interest(₹)       "+total_in+"(₹)");
        binding.totalPayment.setText("Total Payment(₹)       "+total_pay+"(₹)");

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
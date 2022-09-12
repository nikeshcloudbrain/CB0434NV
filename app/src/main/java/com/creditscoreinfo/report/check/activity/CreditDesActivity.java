package com.creditscoreinfo.report.check.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.creditscoreinfo.report.check.ads.BackInterAds;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.ads.MiniNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityCreditDesBinding;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

public class CreditDesActivity extends AppCompatActivity {
    ActivityCreditDesBinding binding;
    String type, mainText, CopyLink;


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
        binding = ActivityCreditDesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainText = this.getIntent().getExtras().getString("Birds");
        type = this.getIntent().getExtras().getString("type");
        CopyLink = this.getIntent().getExtras().getString("copylink");
        if (type.equals("FAQ")) {

            binding.include2.toolbarText.setText("FAQs");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.GONE);
        } else if (type.equals("Home")) {

            binding.include2.toolbarText.setText("Home");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.VISIBLE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Buy")) {

            binding.include2.toolbarText.setText("Buy Credit Score");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Company")) {

            binding.include2.toolbarText.setText("Company Credit Score");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Calculate")) {

            binding.include2.toolbarText.setText("Calculate Score");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Dispute")) {

            binding.include2.toolbarText.setText("Dispute Resolution");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Media")) {

            binding.include2.toolbarText.setText("Media Center");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        } else if (type.equals("Mantri")) {

            binding.include2.toolbarText.setText("Credit Mantri");
            binding.cfirst.setVisibility(View.VISIBLE);
            binding.csecond.setVisibility(View.GONE);
            binding.btncopylink.setVisibility(View.VISIBLE);
        }


        binding.first.setText(mainText);
        binding.second.setText(CopyLink);

        binding.btncopylink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", CopyLink);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Copy Link", Toast.LENGTH_SHORT).show();
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
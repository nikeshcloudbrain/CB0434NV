package com.creditscoreinfo.report.check.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;


import com.creditscoreinfo.report.check.R;
import com.creditscoreinfo.report.check.ads.LargeNativeAds;
import com.creditscoreinfo.report.check.databinding.ActivityPolicyBinding;
import com.creditscoreinfo.report.check.util.Constant;
import com.preference.PowerPreference;

public class PolicyActivity extends AppCompatActivity {
    ActivityPolicyBinding binding;

    String policylink;

    @Override
    protected void onResume() {
        super.onResume();
        if (PowerPreference.getDefaultFile().getBoolean(Constant.FULL_SCREEN, true)) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    @Override
    public void onBackPressed() {

        back();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        policylink = PowerPreference.getDefaultFile().getString(Constant.POLICY);

        binding.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String packageName = "com.android.chrome";
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(ContextCompat.getColor(PolicyActivity.this, R.color.colorPrimaryDark));
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setPackage(packageName);
                    customTabsIntent.launchUrl(PolicyActivity.this, Uri.parse(policylink));
                } catch (Exception e) {
                    Log.e("TAG", e.toString());
                }
            }
        });

        binding.link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String packageName = "com.android.chrome";
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(ContextCompat.getColor(PolicyActivity.this, R.color.colorPrimaryDark));
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setPackage(packageName);
                    customTabsIntent.launchUrl(PolicyActivity.this, Uri.parse(policylink));
                } catch (Exception e) {
                    Log.e("TAG", e.toString());
                }
            }
        });




        binding.agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.conti.setBackgroundResource(R.drawable.button_bg);
                    binding.conti.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            PowerPreference.getDefaultFile().putBoolean(Constant.POLICY_ACCEPT,true);
                            if (PowerPreference.getDefaultFile().getBoolean(Constant.CustomAdsOnOff, true)) {
                                startActivity(new Intent(PolicyActivity.this, SkipActivity.class));

                            } else {
                                startActivity(new Intent(PolicyActivity.this, HomeScreenActivity.class));

                            }
                        }
                    });
                }
                if (!isChecked) {
                    binding.conti.setBackgroundResource(R.drawable.policy_back);
                    binding.conti.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "Accept Term And Condition", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {

                }
            }
        });

    }

    public void back() {

        final android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(PolicyActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.exit_dialog_layout, null);
        Button btn_no = (Button) mView.findViewById(R.id.btnno);
        Button btn_rate = (Button) mView.findViewById(R.id.btnRateus);
        Button btn_yes = (Button) mView.findViewById(R.id.btnyes);

        alert.setView(mView);
        final android.app.AlertDialog alertDialog = alert.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.setCanceledOnTouchOutside(false);

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                rateus();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent = new Intent(PolicyActivity.this, ExitActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                new LargeNativeAds().showNativeAds(PolicyActivity.this, alertDialog);
            }
        });
        alertDialog.show();
    }

    public void rateus() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

}
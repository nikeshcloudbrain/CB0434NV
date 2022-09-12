package com.creditscoreinfo.report.check.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.creditscoreinfo.report.check.databinding.NativeAdBannerBinding;


public class SmallAdViewHolder extends RecyclerView.ViewHolder {
    public NativeAdBannerBinding binding;

    public SmallAdViewHolder(@NonNull NativeAdBannerBinding itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}
package com.creditscoreinfo.report.check.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.creditscoreinfo.report.check.databinding.NativeAdNormalSmallBinding;


public class LargeAdViewHolder extends RecyclerView.ViewHolder {
        public NativeAdNormalSmallBinding binding;

        public LargeAdViewHolder(@NonNull NativeAdNormalSmallBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

package com.will.ui.banner.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WiCircleIndicator extends FrameLayout implements IWiIndicator<FrameLayout> {
    public WiCircleIndicator(@NonNull Context context) {
        this(context, null);
    }

    public WiCircleIndicator(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WiCircleIndicator(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public FrameLayout get() {
        return null;
    }

    @Override
    public void onInflate(int count) {

    }

    @Override
    public void onIndicatorChange(int current, int count) {

    }
}

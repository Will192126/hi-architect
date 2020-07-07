package com.will.ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.will.ui.R;

public class WiTextOverView extends WiOverView {
    ImageView mImageView;
    TextView mTextView;
    public WiTextOverView(@NonNull Context context) {
        super(context);
    }

    public WiTextOverView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WiTextOverView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init() {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.wi_text_over_view, this, true);
        mImageView = root.findViewById(R.id.iv_rotate);
        mTextView = root.findViewById(R.id.tv_refresh_text);
    }

    @Override
    protected void onScroll(int scrollY, int pullRefreshHeight) {

    }

    @Override
    protected void onVisible() {

    }

    @Override
    public void onOver() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    void onFinish() {

    }
}

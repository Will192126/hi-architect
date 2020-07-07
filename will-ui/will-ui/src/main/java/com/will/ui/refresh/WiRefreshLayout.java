package com.will.ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WiRefreshLayout extends FrameLayout implements IWiRefresh {
    private WiOverView mOverView;
    private GestureDetector mGestureDetector;
    private int mLastY;

    WiGestureDetector mDetector = new WiGestureDetector() {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            View header = getChildAt(0);
            View child = getChildAt(1);
            int speed;
            if (child.getTop() < mOverView.mPullRefreshHeight) {
                speed = (int) (mLastY / mOverView.minDamp);
            } else {
                speed = (int) (mLastY / mOverView.maxDamp);
            }
            boolean bool = moveDown(speed, true);
            mLastY = (int) -distanceY;
            return bool;
        }
    };

    private boolean moveDown(int speed, boolean b) {
        View header = getChildAt(0);
        View child = getChildAt(1);
        header.offsetTopAndBottom(speed);
        child.offsetTopAndBottom(speed);
        return true;
    }

    public WiRefreshLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    public WiRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WiRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mGestureDetector = new GestureDetector(getContext(), mDetector);
    }

    @Override
    public void setDisableRefreshScroll(boolean isDisabled) {

    }

    @Override
    public void refreshFinished() {

    }

    @Override
    public void setRefreshOverView(WiOverView overView) {
        if (mOverView != null) {
            removeView(mOverView);
        }
        mOverView = overView;
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(overView, 0, params);
    }

    @Override
    public void setRefreshListener(RefreshListener listener) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean consumed = mGestureDetector.onTouchEvent(ev);
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View header = getChildAt(0);
        View child = getChildAt(1);
        if (header != null && child != null) {
            int childTop = child.getTop();
            header.layout(0, childTop - header.getMeasuredHeight(), right, childTop);
            child.layout(0, childTop, right, childTop + header.getMeasuredHeight());
        }
    }
}

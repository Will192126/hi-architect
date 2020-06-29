package com.will.ui.tab.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.will.ui.tab.bottom.WiTabBottom;
import com.will.ui.tab.bottom.WiTabBottomInfo;
import com.will.ui.tab.common.IHiTab;
import com.will.ui.tab.common.IHiTabLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WiTabTopLayout extends HorizontalScrollView implements IHiTabLayout<WiTabTop, WiTabTopInfo<?>> {
    private static final String TAG_TAB_TOP = "TAG_TAB_TOP";

    private List<OnTabSelectedListener<WiTabTopInfo<?>>> tabSelectedChangeListeners = new ArrayList<>();
    private WiTabTopInfo<?> mSelectedInfo;
    private List<WiTabTopInfo<?>> mInfoList;

    public WiTabTopLayout(Context context) {
        this(context, null, 0);
    }

    public WiTabTopLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WiTabTopLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVerticalScrollBarEnabled(false);
    }

    @Override
    public WiTabTop findTab(@NonNull WiTabTopInfo<?> data) {
        ViewGroup ll = getRootLayout(false);
        for (int i = 0; i < ll.getChildCount(); i++) {
            View child = ll.getChildAt(i);
            if (child instanceof WiTabBottom) {
                WiTabTop tabTop = (WiTabTop) child;
                if (tabTop.getTabInfo() == data) {
                    return tabTop;
                }
            }
        }
        return null;
    }

    @Override
    public void addTabSelectedChangeListener(OnTabSelectedListener<WiTabTopInfo<?>> listener) {
        tabSelectedChangeListeners.add(listener);
    }

    @Override
    public void defaultSelected(@NonNull WiTabTopInfo<?> defaultInfo) {
        onSelected(defaultInfo);
    }

    @Override
    public void inflateInfo(@NonNull List<WiTabTopInfo<?>> infoList) {
        if (infoList.isEmpty()) {
            return;
        }
        this.mInfoList = infoList;

        // 移除之前已添加的View
        for (int i = getChildCount() - 1; i > 0; i--) {
            removeViewAt(i);
        }
        Iterator<OnTabSelectedListener<WiTabTopInfo<?>>> iterator = tabSelectedChangeListeners.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() instanceof WiTabTop) {
                iterator.remove();
            }
        }
        mSelectedInfo = null;
        LinearLayout linearLayout = getRootLayout(true);
        for (int i = 0; i < infoList.size(); i++) {
            final WiTabTopInfo info = infoList.get(i);
            WiTabTop tabTop = new WiTabTop(getContext());
            tabSelectedChangeListeners.add(tabTop);
            tabTop.setHiTabInfo(info);
            linearLayout.addView(tabTop);
            tabTop.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSelected(info);
                }
            });
        }
    }

    private void onSelected(@NonNull WiTabTopInfo<?> nextInfo) {
        for (OnTabSelectedListener<WiTabTopInfo<?>> listener : tabSelectedChangeListeners) {
            listener.onTabSelectedChange(mInfoList.indexOf(nextInfo), mSelectedInfo, nextInfo);
        }
        this.mSelectedInfo = nextInfo;
    }

    private LinearLayout getRootLayout(boolean clear) {
        LinearLayout rootView = (LinearLayout) getChildAt(0);
        if (rootView == null) {
            rootView = new LinearLayout(getContext());
            rootView.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            addView(rootView, params);
        } else if (clear) {
            rootView.removeAllViews();
        }

        return rootView;
    }
}

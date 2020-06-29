package com.will.willshop;

import android.os.Bundle;

import com.will.common.ui.component.WiBaseActivity;
import com.will.ui.tab.bottom.WiTabBottomLayout;
import com.will.willshop.logic.MainActivityLogic;

public class MainActivity extends WiBaseActivity implements MainActivityLogic.ActivityProvider {
    MainActivityLogic mActivityLogic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivityLogic = new MainActivityLogic(this);
    }
}

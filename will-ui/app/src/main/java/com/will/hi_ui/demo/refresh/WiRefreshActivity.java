package com.will.hi_ui.demo.refresh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.will.hi_ui.R;
import com.will.ui.refresh.WiRefreshLayout;
import com.will.ui.refresh.WiTextOverView;

public class WiRefreshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_refresh);

        WiRefreshLayout refreshLayout = findViewById(R.id.refresh_layout);
        WiTextOverView overView = new WiTextOverView(this);
        overView.init();
        refreshLayout.setRefreshOverView(overView);
    }
}

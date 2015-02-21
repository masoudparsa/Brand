package com.rayweb.brand;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.rayweb.brand.Infrastructure.Global;


public class AdvertiseActivity extends ActionBarActivity {

    @Override
    protected void onResume() {
        Global.currentActivity = this;
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}

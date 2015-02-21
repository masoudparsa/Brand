package com.rayweb.brand;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.rayweb.brand.Business.AdvertiseBusiness;
import com.rayweb.brand.Infrastructure.Global;
import com.rayweb.brand.Model.Advertise;


public class AdvertiseActivity extends ActionBarActivity {

    @Override
    protected void onResume() {
        Global.currentActivity = this;
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);

        AdvertiseBusiness advertiseBusiness=new AdvertiseBusiness(this.getBaseContext());

        final TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        final TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();
        int position = 0;
        if (extras != null) {
            position = extras.getInt("POSITION");
        }
        // too arraye injoori update mikonim :
        //   final StructureAdvertise advertise = Global.advertises.get(position);
        //   textViewTitle.setText(advertise.advertise_Title);
        //   textViewDescription.setText(advertise.advertise_Description);

        try {
            Advertise advertise = advertiseBusiness.getAdvertiseById(position);
            textViewTitle.setText(advertise.title);
            textViewDescription.setText(advertise.description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

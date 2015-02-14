package com.rayweb.brand;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rayweb.brand.Business.AdvertiseBusiness;
import com.rayweb.brand.Business.BrandBusiness;
import com.rayweb.brand.Business.CategoryBusiness;
import com.rayweb.brand.Business.ShopBusiness;
import com.rayweb.brand.Model.Advertise;
import com.rayweb.brand.Model.Brand;
import com.rayweb.brand.Model.Category;
import com.rayweb.brand.Model.Shop;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}

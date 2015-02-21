package com.rayweb.brand;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.rayweb.brand.Business.AdvertiseBusiness;
import com.rayweb.brand.Business.BrandBusiness;
import com.rayweb.brand.Business.CategoryBusiness;
import com.rayweb.brand.Business.ShopBusiness;
import com.rayweb.brand.Infrastructure.Global;
import com.rayweb.brand.Model.Advertise;
import com.rayweb.brand.Model.Brand;
import com.rayweb.brand.Model.Category;
import com.rayweb.brand.Model.Shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    public ArrayAdapter adapter;

    @Override
    protected void onResume() {
        Global.currentActivity = this;
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        CategoryBusiness categoryBusiness=new CategoryBusiness(this.getBaseContext());
        ShopBusiness shopBusiness =new ShopBusiness(this.getBaseContext());
        BrandBusiness brandBusiness=new BrandBusiness(this.getBaseContext());
        AdvertiseBusiness advertiseBusiness=new AdvertiseBusiness(this.getBaseContext());
        Category cat=new Category();
        cat.id=1;
        cat.name="test";
        cat.active=true;
        try {
            categoryBusiness.createCategoryIfNotExist(cat);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Category> category= null;
        try {
            category = categoryBusiness.getAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TextView tv=(TextView) findViewById(R.id.MainText);
        //tv.setText(category.get(0).name);

        Shop shop=new Shop();
        shop.id=1;
        shop.active=true;
        shop.address="shopAddress";
        shop.description="shopTest";
        shop.managerName="shopManager";
        shop.name="shopName";
        shop.telephone="shopTel";
        try {
            shopBusiness.createShopIfNotExist(shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Shop> shopList= null;
        try {
            shopList = shopBusiness.getAllShop();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Brand brand=new Brand();
        brand.id=1;
        brand.active=true;
        brand.name="brandName";
        try {
            brandBusiness.createBrandIfNotExist(brand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Brand> brandList= null;
        try {
            brandList = brandBusiness.getAllBrand();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Advertise adv=new Advertise();
        adv.id=1;
        adv.active=true;
        adv.description="test2";
        adv.isNew=true;
        adv.hasDiscount=false;
        adv.isSendDetail=false;
        adv.likeCount=0;
        adv.name="test2";
        adv.brand=brand;
        adv.shop=shop;
        adv.percentDiscount=0;
        adv.price=10000;
        adv.registerDate=new Date();
        adv.title="advTitle";

        Advertise adv2=new Advertise();
        adv.id=1;
        adv.title="advTitle";

        Advertise adv7=new Advertise();
        adv.id=17;
        adv.title="advTitle7";
        Advertise adv3=new Advertise();
        adv.id=13;
        adv.title="advTitle3";

        Advertise adv4=new Advertise();
        adv.id=12;
        adv.title="advTitle4";

        Advertise adv5=new Advertise();
        adv.id=11;
        adv.title="advTitle5";

        Advertise adv6=new Advertise();
        adv.id=10;
        adv.title="advTitle01";

        Advertise adv16=new Advertise();
        adv.id=105;
        adv.title="advTitle01";

        Advertise adv116=new Advertise();
        adv.id=106;
        adv.title="advTitle01";

        Advertise adv136=new Advertise();
        adv.id=126;
        adv.title="advTitle01";

        Advertise adv126=new Advertise();
        adv.id=136;
        adv.title="advTitle01";

        Advertise adv166=new Advertise();
        adv.id=166;
        adv.title="advTitle01";

        Advertise adv176=new Advertise();
        adv.id=176;
        adv.title="advTitle01";



        try {
           Advertise advertise = advertiseBusiness.createAdvertiseIfNotExist(adv);
              advertise = advertiseBusiness.createAdvertiseIfNotExist(adv2);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv3);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv4);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv5);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv6);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv7);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv16);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv116);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv126);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv136);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv166);
            advertise = advertiseBusiness.createAdvertiseIfNotExist(adv176);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Advertise> advertiseList= null;
        try {
            advertiseList = advertiseBusiness.getAllAdvertise();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            ListView listViewAdvertises = (ListView) findViewById(R.id.listViewAdvertises);

            adapter = new AdvertiseAdapter(advertiseList);
            listViewAdvertises.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }catch(Exception e){
            e.printStackTrace();
        }

        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"تنظیمات").setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(1,2,2,"درباره برندز").setIcon(android.R.drawable.ic_menu_info_details);
        return super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch(id){
            case 1 :
                Intent settingIntent = new Intent(MainActivity.this,SettingsActivity.class);
                MainActivity.this.startActivity(settingIntent);
                break;
            case 2 :
                Intent aboutIntent = new Intent(MainActivity.this,AboutActivity.class);
                MainActivity.this.startActivity(aboutIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

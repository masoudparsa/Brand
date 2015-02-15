package com.rayweb.brand;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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


public class MainActivity extends ActionBarActivity {
    
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
        TextView tv=(TextView) findViewById(R.id.MainText);
        tv.setText(category.get(0).name);

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

        Brand brand=new Brand();
        brand.id=1;
        brand.active=true;
        brand.name="brandName";
        try {
            brandBusiness.createBrandIfNotExist(brand);
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
        try {
            advertiseBusiness.createAdvertiseIfNotExist(adv);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Advertise> advertiseList=  advertiseBusiness.getAdvertisesByBrandId(1);

        TextView textView2= (TextView) findViewById(R.id.MainText2);
        try {
            textView2.setText(advertiseList.get(0).name);
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

        TextView textView = (TextView) findViewById(R.id.MainText2);
        try {
            String full_name = Global.preferences.getString("example_text", "Full Name");
            textView.setText(full_name);
        }catch(NullPointerException e){
            e.printStackTrace();
        }

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

package com.rayweb.brand.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.rayweb.brand.Model.Advertise;
import com.rayweb.brand.Model.AdvertiseImage;
import com.rayweb.brand.Model.Brand;
import com.rayweb.brand.Model.BrandCategory;
import com.rayweb.brand.Model.Category;
import com.rayweb.brand.Model.Shop;
import com.rayweb.brand.Model.ShopBrand;

import java.sql.SQLException;

/**
 * Created by parsa on 2/3/2015.
 */
public class DatabaseHelper  extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "brands.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<Category,Integer> categoryDao = null;
    private Dao<Advertise,Integer> advertiseDao = null;
    private Dao<Brand,Integer> brandDao = null;
    private Dao<BrandCategory,Integer> brandCategoryDao = null;
    private Dao<Shop,Integer> shopDao = null;
    private Dao<ShopBrand,Integer> shopBrandDao = null;
    private Dao<AdvertiseImage,Integer> advertiseImageDao = null;
    private RuntimeExceptionDao<Category, Integer> categoryRuntimeDao = null;
    private RuntimeExceptionDao<Advertise, Integer> advertiseRuntimeDao = null;
    private RuntimeExceptionDao<Brand, Integer> brandRuntimeDao = null;
    private RuntimeExceptionDao<BrandCategory, Integer> brandCategoryRuntimeDao = null;
    private RuntimeExceptionDao<Shop, Integer> shopRuntimeDao = null;
    private RuntimeExceptionDao<ShopBrand, Integer> shopBrandRuntimeDao = null;
    private RuntimeExceptionDao<AdvertiseImage, Integer> advertiseImageRuntimeDao = null;
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Advertise.class);
            TableUtils.createTable(connectionSource, Brand.class);
            TableUtils.createTable(connectionSource, BrandCategory.class);
            TableUtils.createTable(connectionSource, Category.class);
            TableUtils.createTable(connectionSource, Shop.class);
            TableUtils.createTable(connectionSource, ShopBrand.class);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            throw  e;
        }
        // here we try inserting data in the on-create as a test
        /*RuntimeExceptionDao<Comment, Integer> dao = getCommentsDataDao();
        // create some entries in the onCreate
        Comment comment = new Comment("First Test Comment");
        dao.create(comment);
        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Advertise.class, true);
            TableUtils.dropTable(connectionSource, Brand.class, true);
            TableUtils.dropTable(connectionSource, BrandCategory.class, true);
            TableUtils.dropTable(connectionSource, Category.class, true);
            TableUtils.dropTable(connectionSource, Shop.class, true);
            TableUtils.dropTable(connectionSource, ShopBrand.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }
    public DatabaseHelper(Context context)
    {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);



    }


    public Dao<Category,Integer> getCategoryDao() throws SQLException {
        try
        {
            if (categoryDao == null) {

               categoryDao =getDao (Category.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return categoryDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Category, Integer> getCategoryDataDao() {
        if (categoryRuntimeDao == null) {
            categoryRuntimeDao = getRuntimeExceptionDao(Category.class);
        }
        return categoryRuntimeDao;
    }
    public Dao<Advertise,Integer> getAdvertiseDao() throws SQLException {
        try
        {
            if (advertiseDao == null) {

                advertiseDao =getDao (Advertise.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return advertiseDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Advertise, Integer> getAdvertiseDataDao() {
        if (advertiseRuntimeDao == null) {
            advertiseRuntimeDao = getRuntimeExceptionDao(Advertise.class);
        }
        return advertiseRuntimeDao;
    }
    public Dao<Brand,Integer> getBrandDao() throws SQLException {
        try
        {
            if (brandDao == null) {

                brandDao =getDao (Brand.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return brandDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Brand, Integer> getBrandDataDao() {
        if (brandRuntimeDao == null) {
            brandRuntimeDao = getRuntimeExceptionDao(Brand.class);
        }
        return brandRuntimeDao;
    }

    public Dao<BrandCategory,Integer> getBrandCategoryDao() throws SQLException {
        try
        {
            if (brandCategoryDao == null) {

                brandCategoryDao =getDao (BrandCategory.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return brandCategoryDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<BrandCategory, Integer> getBrandCategoryDataDao() {
        if (brandCategoryRuntimeDao == null) {
            brandCategoryRuntimeDao = getRuntimeExceptionDao(BrandCategory.class);
        }
        return brandCategoryRuntimeDao;
    }
    public Dao<Shop,Integer> getShopDao() throws SQLException {
        try
        {
            if (shopDao == null) {

                shopDao =getDao (Shop.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return shopDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Shop, Integer> getShopDataDao() {
        if (shopRuntimeDao == null) {
            shopRuntimeDao = getRuntimeExceptionDao(Shop.class);
        }
        return shopRuntimeDao;
    }
    public Dao<ShopBrand,Integer> getShopBrandDao() throws SQLException {
        try
        {
            if (shopBrandDao == null) {

                shopBrandDao =getDao (ShopBrand.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return shopBrandDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<ShopBrand, Integer> getShopBrandDataDao() {
        if (shopBrandRuntimeDao == null) {
            shopBrandRuntimeDao = getRuntimeExceptionDao(ShopBrand.class);
        }
        return shopBrandRuntimeDao;
    }

    public Dao<AdvertiseImage,Integer> getAdvertiseImageDao() throws SQLException {
        try
        {
            if (advertiseImageDao == null) {

                advertiseImageDao =getDao (AdvertiseImage.class);
            }

        }
        catch (Exception e) {
            throw e;
        }


        return advertiseImageDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<AdvertiseImage, Integer> getAdvertiseImageDataDao() {
        if (advertiseImageRuntimeDao == null) {
            advertiseImageRuntimeDao = getRuntimeExceptionDao(AdvertiseImage.class);
        }
        return advertiseImageRuntimeDao;
    }
    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        categoryDao = null;
    }
}

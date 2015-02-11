package com.rayweb.brand.Repository;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.rayweb.brand.Model.Shop;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by parsa on 2/6/2015.
 */
public class ShopRepository {
    private DatabaseHelper databaseHelper;
    Dao<Shop, Integer> shopDao;
    public ShopRepository(Context context)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();


            databaseHelper = dbManager.getHelper(context);
            databaseHelper.getWritableDatabase();
            shopDao = databaseHelper.getShopDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }

    public int createShop(Shop shop) throws SQLException {
        try {
            return shopDao.create(shop);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return 0;
    }
    public Shop createShopIfNotExist(Shop shop) throws SQLException {
        try {
            return shopDao.createIfNotExists(shop);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return null;
    }
    public int updateShop(Shop shop)
    {
        try {
            return shopDao.update(shop);
        } catch (SQLException e) {
            // TODO: Exception Handling

        }
        return 0;
    }
    public int deleteShop(Shop shop)
    {
        try {
            return shopDao.delete(shop);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<Shop> getAllShop()
    {
        try {
            return shopDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public Shop getShopById(int id)
    {
        try {
            return shopDao.queryForId(id);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}

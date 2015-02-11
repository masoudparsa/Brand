package com.rayweb.brand.Business;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import com.rayweb.brand.Repository.ShopRepository;
import com.rayweb.brand.Model.Shop;

/**
 * Created by parsa on 2/6/2015.
 */
public class ShopBusiness {
    ShopRepository shopRepository;

    public  ShopBusiness(Context context)
    {
        try
        {
            shopRepository=new ShopRepository(context);
        }
        catch (Exception e)
        {
            throw  e;
        }
    }

    public  int createShop(Shop shop) throws SQLException {
        try
        {
            return shopRepository.createShop(shop);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Shop createShopIfNotExist(Shop shop) throws SQLException {
        try
        {
            return shopRepository.createShopIfNotExist(shop);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int updateShop(Shop shop) throws SQLException {
        try
        {
            return shopRepository.updateShop(shop);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int deleteShop(Shop shop) throws SQLException {
        try
        {
            return shopRepository.deleteShop(shop);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<Shop> getAllShop() throws SQLException {
        try
        {
            return shopRepository.getAllShop();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Shop getShopById(int id) {
        try
        {
            return  shopRepository.getShopById(id);
        }
        catch (Exception e) {
            throw e;
        }

    }
}

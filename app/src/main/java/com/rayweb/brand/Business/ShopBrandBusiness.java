package com.rayweb.brand.Business;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import com.rayweb.brand.Repository.ShopBrandRepository;
import com.rayweb.brand.Model.ShopBrand;

/**
 * Created by parsa on 2/6/2015.
 */
public class ShopBrandBusiness {
    ShopBrandRepository shopBrandRepository;

    public  ShopBrandBusiness(Context context)
    {
        try
        {
            shopBrandRepository=new ShopBrandRepository(context);
        }
        catch (Exception e)
        {
            throw  e;
        }
    }

    public  int createShopBrand(ShopBrand shopBrand) throws SQLException {
        try
        {
            return shopBrandRepository.createShopBrand(shopBrand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public ShopBrand createShopBrandIfNotExist(ShopBrand shopBrand) throws SQLException {
        try
        {
            return shopBrandRepository.createShopBrandIfNotExist(shopBrand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int updateShopBrand(ShopBrand shopBrand) throws SQLException {
        try
        {
            return shopBrandRepository.updateShopBrand(shopBrand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int deleteShopBrand(ShopBrand shopBrand) throws SQLException {
        try
        {
            return shopBrandRepository.deleteShopBrand(shopBrand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<ShopBrand> getAllShopBrand() throws SQLException {
        try
        {
            return shopBrandRepository.getAllShopBrand();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public ShopBrand getShopBrandById(int id) {
        try
        {
            return  shopBrandRepository.getShopBrandById(id);
        }
        catch (Exception e) {
            throw e;
        }

    }
}

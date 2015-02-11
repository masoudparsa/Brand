package com.rayweb.brand.Business;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import com.rayweb.brand.Repository.BrandRepository;
import com.rayweb.brand.Model.Brand;

/**
 * Created by parsa on 2/6/2015.
 */
public class BrandBusiness {
    BrandRepository brandRepository;

    public  BrandBusiness(Context context)
    {
        try
        {
            brandRepository=new BrandRepository(context);
        }
        catch (Exception e)
        {
            throw  e;
        }
    }

    public  int createBrand(Brand brand) throws SQLException {
        try
        {
            return brandRepository.createBrand(brand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Brand createBrandIfNotExist(Brand brand) throws SQLException {
        try
        {
            return brandRepository.createBrandIfNotExist(brand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int updateBrand(Brand brand) throws SQLException {
        try
        {
            return brandRepository.updateBrand(brand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int deleteBrand(Brand brand) throws SQLException {
        try
        {
            return brandRepository.deleteBrand(brand);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<Brand> getAllBrand() throws SQLException {
        try
        {
            return brandRepository.getAllBrand();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<Brand> getAllActiveBrand() throws SQLException {
        try
        {
            return brandRepository.getAllActiveBrand();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Brand getBrandById(int id) {
        try
        {
            return  brandRepository.getBrandById(id);
        }
        catch (Exception e) {
            throw e;
        }

    }
}

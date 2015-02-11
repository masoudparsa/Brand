package com.rayweb.brand.Repository;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.rayweb.brand.Model.Brand;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by parsa on 2/6/2015.
 */
public class BrandRepository {
    private DatabaseHelper databaseHelper;
    Dao<Brand, Integer> brandDao;
    public BrandRepository(Context context)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();


            databaseHelper = dbManager.getHelper(context);
            databaseHelper.getWritableDatabase();
            brandDao = databaseHelper.getBrandDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }
    public int createBrand(Brand brand) throws SQLException {
        try {
            return brandDao.create(brand);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return 0;
    }
    public Brand createBrandIfNotExist(Brand brand) throws SQLException {
        try {
            return brandDao.createIfNotExists(brand);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public int updateBrand(Brand brand)
    {
        try {
            return brandDao.update(brand);
        } catch (SQLException e) {
            // TODO: Exception Handling

        }
        return 0;
    }
    public int deleteBrand(Brand brand)
    {
        try {
            return brandDao.delete(brand);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<Brand> getAllBrand()
    {
        try {
            return brandDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<Brand> getAllActiveBrand()
    {
        try {
            return brandDao.queryForEq("brands_Active",true);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public Brand getBrandById(int id)
    {
        try {
            return brandDao.queryForId(id);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}

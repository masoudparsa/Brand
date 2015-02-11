package com.rayweb.brand.Repository;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.rayweb.brand.Model.BrandCategory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by parsa on 2/6/2015.
 */
public class BrandCategoryRepository {
    private DatabaseHelper databaseHelper;
    Dao<BrandCategory, Integer> brandCategoryDao;
    public BrandCategoryRepository(Context context)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();


            databaseHelper = dbManager.getHelper(context);
            databaseHelper.getWritableDatabase();
            brandCategoryDao = databaseHelper.getBrandCategoryDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }
    public int createBrandCategory(BrandCategory brandCategory) throws SQLException {
        try {
            return brandCategoryDao.create(brandCategory);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return 0;
    }
    public BrandCategory createBrandCategoryIfNotExist(BrandCategory brandCategory) throws SQLException {
        try {
            return brandCategoryDao.createIfNotExists(brandCategory);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return null;
    }
    public int updateBrandCategory(BrandCategory brandCategory)
    {
        try {
            return brandCategoryDao.update(brandCategory);
        } catch (SQLException e) {
            // TODO: Exception Handling

        }
        return 0;
    }
    public int deleteBrandCategory(BrandCategory brandCategory)
    {
        try {
            return brandCategoryDao.delete(brandCategory);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<BrandCategory> getAllBrandCategory()
    {
        try {
            return brandCategoryDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public BrandCategory getBrandCategoryById(int id)
    {
        try {
            return brandCategoryDao.queryForId(id);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}

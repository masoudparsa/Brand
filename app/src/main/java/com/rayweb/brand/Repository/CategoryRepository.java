package com.rayweb.brand.Repository;


import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.rayweb.brand.Model.Category;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by parsa on 2/3/2015.
 */
public class CategoryRepository {
    private DatabaseHelper databaseHelper;
    Dao<Category, Integer> categoryDao;
    public CategoryRepository(Context context)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();


            databaseHelper = dbManager.getHelper(context);
            databaseHelper.getWritableDatabase();
            categoryDao = databaseHelper.getCategoryDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }
    public int createCategory(Category category) throws SQLException {
        try {
            return categoryDao.create(category);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return 0;
    }
    public Category createCategoryIfNotExist(Category category) throws SQLException {
        try {
            return categoryDao.createIfNotExists(category);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return null;
    }
    public int updateCategory(Category category)
    {
        try {
            return categoryDao.update(category);
        } catch (SQLException e) {
            // TODO: Exception Handling

        }
        return 0;
    }
    public int deleteCategory(Category category)
    {
        try {
            return categoryDao.delete(category);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<Category> getAllCategory()
    {
        try {
            return categoryDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<Category> getAllActiveCategory()
    {
        try {
            return categoryDao.queryForEq("categories_Active",true);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public Category getCategoryById(int id)
    {
        try {
            return categoryDao.queryForId(id);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}

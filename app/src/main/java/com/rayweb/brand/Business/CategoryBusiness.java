package com.rayweb.brand.Business;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

import com.rayweb.brand.Repository.CategoryRepository;
import com.rayweb.brand.Model.Category;

/**
 * Created by parsa on 2/4/2015.
 */
public class CategoryBusiness {

    CategoryRepository categoryRepository;

    public  CategoryBusiness(Context context)
    {
        try
        {
            categoryRepository=new CategoryRepository(context);
        }
        catch (Exception e)
        {
          throw  e;
        }
    }

    public  int createCategory(Category category) throws SQLException {
        try
        {
            return categoryRepository.createCategory(category);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Category createCategoryIfNotExist(Category category) throws SQLException {
        try
        {
            return categoryRepository.createCategoryIfNotExist(category);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int updateCategory(Category category) throws SQLException {
        try
        {
            return categoryRepository.updateCategory(category);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public  int deleteCategory(Category category) throws SQLException {
        try
        {
            return categoryRepository.deleteCategory(category);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<Category> getAllCategory() throws SQLException {
        try
        {
            return categoryRepository.getAllCategory();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public List<Category> getAllActiveCategory() throws SQLException {
        try
        {
            return categoryRepository.getAllActiveCategory();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    public Category getCategoryById(int id) {
    try
    {
        return  categoryRepository.getCategoryById(id);
    }
    catch (Exception e) {
        throw e;
    }

    }

}

package com.rayweb.brand.Repository;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.rayweb.brand.Model.AdvertiseImage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by parsa on 2/11/2015.
 */
public class AdvertiseImageRepository {
    private DatabaseHelper databaseHelper;
    Dao<AdvertiseImage, Integer> advertiseImageDao;
    public AdvertiseImageRepository(Context context)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();


            databaseHelper = dbManager.getHelper(context);
            databaseHelper.getWritableDatabase();
            advertiseImageDao = databaseHelper.getAdvertiseImageDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }

    }
    public int createAdvertiseImage(AdvertiseImage advertiseImage) throws SQLException {
        try {
            return advertiseImageDao.create(advertiseImage);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return 0;
    }
    public AdvertiseImage createAdvertiseImageIfNotExist(AdvertiseImage advertiseImage) throws SQLException {
        try {
            return advertiseImageDao.createIfNotExists(advertiseImage);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();

        }
        catch (Exception e)
        {

        }
        return null;
    }
    public int updateAdvertiseImage(AdvertiseImage advertiseImage)
    {
        try {
            return advertiseImageDao.update(advertiseImage);
        } catch (SQLException e) {
            // TODO: Exception Handling

        }
        return 0;
    }
    public int deleteAdvertiseImage(AdvertiseImage advertiseImage)
    {
        try {
            return advertiseImageDao.delete(advertiseImage);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public List<AdvertiseImage> getAllAdvertiseImages(int advertiseId)
    {
        try {
            return advertiseImageDao.queryForEq("advertiseImages_AdvertiseID",advertiseId);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public AdvertiseImage getAdvertiseImageById(int id)
    {
        try {
            return advertiseImageDao.queryForId(id);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }


}

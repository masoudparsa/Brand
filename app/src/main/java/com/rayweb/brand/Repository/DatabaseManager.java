package com.rayweb.brand.Repository;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;


/**
 * Created by parsa on 2/3/2015.
 */
public class DatabaseManager {
    private DatabaseHelper databaseHelper = null;


    //gets a helper once one is created ensures it doesnt create a new one
    public  DatabaseHelper getHelper(Context context)
    {
        try {
        if (databaseHelper == null) {

            databaseHelper =OpenHelperManager.getHelper(context,DatabaseHelper.class);


        }


        }


        catch (Exception e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return databaseHelper;
    }

    //releases the helper once usages has ended
    public void releaseHelper(DatabaseHelper helper)
    {
        try{
            if (databaseHelper != null) {
                OpenHelperManager.releaseHelper();
                databaseHelper = null;
            }
        }
        catch (Exception e)
        {

        }

    }
}

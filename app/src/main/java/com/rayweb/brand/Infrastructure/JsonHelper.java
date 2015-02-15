package com.rayweb.brand.Infrastructure;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by parsa on 2/15/2015.
 */
public class JsonHelper {
    Gson gson;
    public JsonHelper()
    {
        gson=new Gson();
    }
    public  String getJsonFromObject(Object object)
    {
        try
        {

            return gson.toJson(object);
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public Object getObjectFromJson(String json,Type typeOf)
    {
        try
        {
            Gson gson=new Gson();
            return gson.fromJson(json,typeOf);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}

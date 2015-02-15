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
    public String getJsonFromObject(Object object, Type type)
    {
        try
        {

            return gson.toJson(object,type);
        }
        catch (Exception e)
        {
            throw e;
        }

    }

    public Object getObjectFromJson(String json,Type type)
    {
        try
        {
             return gson.fromJson(json,type);
        }
        catch (Exception e)
        {
            throw e;
        }
    }


    /*Json Format Sample*/
   /* String json =
            "{\"name\":\"John\",\"surname\":\"Doe\",\"cars\":
                    [{\"manufacturer\":\"Audi\",\"model\":\"A4\",\"capacity\":1.8,\"accident\":false},
    {\"manufacturer\":\"Škoda\",\"model\":\"Octavia\",\"capacity\":2.0,\"accident\":true}],
        \"phone\":245987453}";*/
}

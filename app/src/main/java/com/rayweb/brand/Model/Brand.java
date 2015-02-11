package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "Brands")
public class Brand {
    /*Label Table Name*/
   /* public static final String Table_Name="Brands";

    *//*Labels Columns Name In DB*//*
    public  static final String Column_ID="brands_ID";
    public  static final String Column_Name="brands_Name";
    public  static final String Column_Active="brands_Active";*/

    /*Properties*/
    @DatabaseField(columnDefinition = "brands_ID",id = true ,columnName = "brands_ID")
    public int id;

    @DatabaseField(columnDefinition = "brands_Name",columnName = "brands_Name")
    public String name;

    @DatabaseField(columnDefinition = "brands_Active",columnName = "brands_Active")
    public Boolean active;
}

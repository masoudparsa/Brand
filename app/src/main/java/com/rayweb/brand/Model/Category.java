package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "Categories")
public class Category {

    /*Properties*/
    @DatabaseField(columnDefinition = "categories_ID",id = true,columnName = "categories_ID")
    public int id;

    @DatabaseField(columnDefinition = "categories_Name",columnName = "categories_Name")
    public String name;

    @DatabaseField(columnDefinition = "categories_Active",columnName = "categories_Active")
    public Boolean active;


}

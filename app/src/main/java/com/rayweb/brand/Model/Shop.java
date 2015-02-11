package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "Shops")
public class Shop {

    @DatabaseField(columnDefinition = "shops_ID" , id=true,columnName = "shops_ID")
    public int id;

    @DatabaseField(columnDefinition = "shops_Name" , columnName = "shops_Name")
    public String name;

    @DatabaseField(columnDefinition = "shops_Description" , columnName = "shops_Description")
    public String description;

    @DatabaseField(columnDefinition = "shops_Active" , columnName = "shops_Active")
    public Boolean active;

    @DatabaseField(columnDefinition = "shops_ManagerName" ,columnName = "shops_ManagerName")
    public String managerName;

    @DatabaseField(columnDefinition = "shops_Telephone" ,columnName = "shops_Telephone")
    public String telephone;

    @DatabaseField(columnDefinition = "shops_Address" ,columnName = "shops_Address")
    public String address;
}

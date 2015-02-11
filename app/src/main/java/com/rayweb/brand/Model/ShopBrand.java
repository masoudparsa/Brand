package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "ShopBrand")
public class ShopBrand {

    @DatabaseField(columnDefinition = "shopBrand_ID" ,id = true,columnName = "shopBrand_ID")
    public int id;

    @DatabaseField(columnDefinition = "shopBrand_ShopID" ,columnName = "shopBrand_ShopID",canBeNull = false,foreign = true,foreignColumnName = "shops_ID")
    public Shop shop;

    @DatabaseField(columnDefinition = "shopBrand_BrandID" ,columnName = "shopBrand_BrandID",canBeNull = false,foreign = true,foreignColumnName = "brands_ID")
    public Brand brand;
}

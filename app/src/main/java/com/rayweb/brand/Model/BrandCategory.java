package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "BrandCategory")
public class BrandCategory {

    /*Properties*/
   @DatabaseField(columnDefinition = "brandCategory_ID",id = true,columnName = "brandCategory_ID")
    public int id;

    @DatabaseField(columnDefinition = "brandCategory_CategoryID",columnName = "brandCategory_CategoryID",canBeNull = false,foreign = true,foreignColumnName = "categories_ID")
    public Category category;

    @DatabaseField(columnDefinition = "brandCategory_BrandID" ,columnName = "brandCategory_BrandID",canBeNull = false,foreign = true,foreignColumnName = "brands_ID")
    public Brand brand;
}

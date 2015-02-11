package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by parsa on 2/3/2015.
 */
@DatabaseTable(tableName = "Advertises")
public class Advertise {

    @DatabaseField( columnDefinition = "advertises_ID" ,columnName = "advertises_ID")
    public int id;

    @DatabaseField(columnDefinition = "advertises_Name",columnName = "advertises_Name")
    public String name;

    @DatabaseField(columnDefinition = "advertises_Title" ,columnName = "advertises_Title")
    public String title;

    @DatabaseField(columnDefinition = "advertises_Description" ,columnName = "advertises_Description")
    public String description;

    @DatabaseField(columnDefinition = "advertises_RegisterDate" , columnName = "advertises_RegisterDate")
    public Date registerDate;

    public String persianRegisterDate;

    @DatabaseField(columnDefinition = "advertises_Active" ,columnName = "advertises_Active")
    public Boolean active;

    @DatabaseField(columnDefinition = "advertises_BrandID" ,columnName = "advertises_BrandID", canBeNull = false,foreign = true , foreignColumnName = "brands_ID")
    public Brand brand;

    @DatabaseField(columnDefinition = "advertises_ShopID" ,columnName = "advertises_ShopID",canBeNull = false,foreign = true ,foreignColumnName = "shops_ID")
    public Shop shop;

    @DatabaseField(columnDefinition = "advertises_LikeCount" ,columnName = "advertises_LikeCount")
    public int likeCount;

    @DatabaseField(columnDefinition = "advertises_Price" ,columnName = "advertises_Price")
    public int price;

    @DatabaseField(columnDefinition = "advertises_HasDiscount" ,columnName = "advertises_HasDiscount")
    public Boolean hasDiscount;

    @DatabaseField(columnDefinition = "advertises_PercentDiscount" ,columnName = "advertises_PercentDiscount")
    public int percentDiscount;

    @DatabaseField(columnDefinition = "advertises_IsSendDetail" ,columnName = "advertises_IsSendDetail")
    public Boolean isSendDetail;

    @DatabaseField(columnDefinition = "advertise_IsNew",columnName = "advertise_IsNew")
    public Boolean isNew;
}

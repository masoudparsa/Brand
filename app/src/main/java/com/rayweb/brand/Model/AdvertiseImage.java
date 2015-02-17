package com.rayweb.brand.Model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by parsa on 2/11/2015.
 */
public class AdvertiseImage {

    @DatabaseField( columnDefinition = "advertiseImages_ID", id=true ,columnName = "advertiseImages_ID")
    public int id;

    @DatabaseField(columnDefinition = "advertiseImages_AdvertiseID" ,columnName = "advertiseImages_AdvertiseID", canBeNull = false,foreign = true , foreignColumnName = "advertises_ID")
    public Advertise advertise;

    @DatabaseField(columnDefinition = "advertiseImages_ImageUrl",columnName = "advertiseImages_ImageUrl")
    public String ImageUrl;

    @DatabaseField(columnDefinition = "advertiseImages_ImageThumbnailUrl" ,columnName = "advertiseImages_ImageThumbnailUrl")
    public String ImageThumbnailUrl;
}

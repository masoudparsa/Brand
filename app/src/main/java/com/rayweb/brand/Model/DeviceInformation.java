package com.rayweb.brand.Model;

/**
 * Created by parsa on 2/15/2015.
 */
public class DeviceInformation {

    public DeviceInformation()
    {
           baseInformation=new BaseInformation();
           specificationInformation=new SpecificationInformation();
           displayInformation =new DisplayInformation();
    }
    public class BaseInformation
    {
        public String imei;

        public String deviceSoftwareVersion;

        public String operatorName;

        public String voiceMailBoxNumber;
    }
public class SpecificationInformation
{
    public String modelL;

    public String board;

    public String bootLoader;

    public String cpu_ABI;

    public String device;

    public String display;

    public String fingerPrint;

    public String hardware;

    public String  manufacturer;

    public String product;

    public String osVersion;

}
public class DisplayInformation
{
    public int widthPixels;

    public int heightPixels;

    public float density;

    public int densityDpi;

    public float xdpi;

    public float ydpi;


}
    public BaseInformation baseInformation;
    public SpecificationInformation specificationInformation;
    public DisplayInformation displayInformation;
}

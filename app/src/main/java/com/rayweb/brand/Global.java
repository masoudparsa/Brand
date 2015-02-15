package com.rayweb.brand;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * Created by ICT on 2/14/2015.
 */
public class Global extends Application{
    public static Context context;
    public static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);


        String networkStateString = "";
        int networkState = readNetworkStatus();
        switch (networkState) {
            case 0:
                networkStateString = "Disconnected";
                break;

            case 1:
                networkStateString = "Connecting";
                break;

            case 2:
                networkStateString = "Mobile Network";
                break;

            case 3:
                networkStateString = "Wifi Network, Signal Level: " ;//+ linkSpeed;
                break;
        }
        Log.i("LOG", "Network Type : " + networkStateString);



        // moshakhasate karbaran :D
        readImei();
        readInstalledPackages();
        readDeviceSpecification();
        readDisplaySpecification();
    }


    private void readImei() {
        TelephonyManager telephonyManager = (TelephonyManager) Global.context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        String deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
        String simOperator = telephonyManager.getSimOperator();
        String simOperatorName = telephonyManager.getSimOperatorName();
        String voiceMailNumber = telephonyManager.getVoiceMailNumber();

        Log.i("LOG", "IMEI: " + imei);
        Log.i("LOG", "Device Software Version: " + deviceSoftwareVersion);
        Log.i("LOG", "Simcard Operator: " + simOperator);
        Log.i("LOG", "Simcard Operator Name: " + simOperatorName);
        Log.i("LOG", "Voice Mail Number: " + voiceMailNumber);
    }


    private void readInstalledPackages() {
        PackageManager packageManager = Global.context.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA | PackageManager.GET_PERMISSIONS);

        for (PackageInfo packageInfo: installedPackages) {
            Log.i("LOG", "Package: " + packageInfo.packageName + ", VersionName: " + packageInfo.versionName + ", VersionCode: " + packageInfo.versionCode);
            if (packageInfo.requestedPermissions != null) {
                for (String permission: packageInfo.requestedPermissions) {
                    Log.i("LOG", "    " + permission);
                }
            }
        }
    }


    public static String readDeviceSpecification() {
        String output = "Model: " + Build.MODEL + "\n" +
                "Board: " + Build.BOARD + "\n" +
                "Boot Loader: " + Build.BOOTLOADER + "\n" +
                "Brand: " + Build.BRAND + "\n" +
                "CPU ABI: " + Build.CPU_ABI + "\n" +
                "Device: " + Build.DEVICE + "\n" +
                "Display: " + Build.DISPLAY + "\n" +
                "Finger Print: " + Build.FINGERPRINT + "\n" +
                "Hardware: " + Build.HARDWARE + "\n" +
                "Manufacturer: " + Build.MANUFACTURER + "\n" +
                "Product: " + Build.PRODUCT + "\n" +
                "OS Version: " + Build.VERSION.RELEASE + "\n";

        Log.i("LOG", output);
        return output;
    }


    public static String readDisplaySpecification() {
        DisplayMetrics displayMetrics = Global.context.getResources().getDisplayMetrics();

        String output = "Width: " + displayMetrics.widthPixels + "\n" +
                "Height: " + displayMetrics.heightPixels + "\n" +
                "Density: " + displayMetrics.density + "\n" +
                "DPI: " + displayMetrics.densityDpi + "\n" +
                "X DPI: " + displayMetrics.xdpi + "\n" +
                "Y DPI: " + displayMetrics.ydpi;

        Log.i("LOG", output);
        return output;
    }

    private int readNetworkStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Global.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo.isConnected();
        boolean isConnectedOrConnecting = networkInfo.isConnectedOrConnecting();

        if (isConnected) {
            int networkType = networkInfo.getType();
            if (networkType == ConnectivityManager.TYPE_WIFI) {
                WifiManager wifiManager = (WifiManager) Global.context.getSystemService(Context.WIFI_SERVICE);
                //linkSpeed = wifiManager.getConnectionInfo().getLinkSpeed();
                return 3;
            } else if (networkType == ConnectivityManager.TYPE_MOBILE) {
                return 2;
            }

        } else if (isConnectedOrConnecting) {
            return 1;
        }

        return 0;
    }
}

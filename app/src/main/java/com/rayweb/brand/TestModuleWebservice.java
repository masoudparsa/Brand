package com.rayweb.brand;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import android.util.Log;

import com.rayweb.brand.Infrastructure.Global;


public class TestModuleWebservice {

    public static void test1() {
        ModuleWebservice module = new ModuleWebservice();
        ModuleWebservice.Listener listener = new ModuleWebservice.Listener() {

            @Override
            public void onDataReceive(String data) {
                Log.i("LOG", "Webservice Data: " + data);
            }


            @Override
            public void onFail(int statusCode) {
                switch (statusCode) {
                    case ModuleWebservice.IO_EXCEPTION:
                        Log.i("LOG", "IO Exception");
                        break;

                    case ModuleWebservice.PROTOCOL_EXCEPTION:
                        Log.i("LOG", "PROTOCOL Exception");
                        break;

                    case ModuleWebservice.UNKNOWN_EXCEPTION:
                        Log.i("LOG", "UNKNOWN Exception");
                        break;
                }
            }
        };

        ArrayList<NameValuePair> input = new ArrayList<NameValuePair>();
        input.add(new BasicNameValuePair("name", "Pooya"));

        module.url("http://192.168.1.10/webserviceModule/index.php")
                .inputArguments(input)
                .listener(listener)
                .cacheDir(Global.DIR_CACHE)
                .enableCache(true)
                .cacheExpireTime(30)
                .connectionTimeout(3000)
                .socketTimeout(5000)
                .read();

    }
}

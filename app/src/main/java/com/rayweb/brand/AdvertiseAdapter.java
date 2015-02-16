package com.rayweb.brand;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.rayweb.brand.Infrastructure.Global;

import java.util.ArrayList;

/**
 * Created by ICT on 2/16/2015.
 */
public class AdvertiseAdapter extends ArrayAdapter<StructureAdvertise> {
    public AdvertiseAdapter(ArrayList<StructureAdvertise> advertises){
        super(Global.context , R.layout.adapter_advertise , advertises);
    }
}

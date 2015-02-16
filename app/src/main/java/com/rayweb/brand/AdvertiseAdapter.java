package com.rayweb.brand;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.rayweb.brand.Infrastructure.Global;

import java.util.ArrayList;

/**
 * Created by ICT on 2/16/2015.
 */
public class AdvertiseAdapter extends ArrayAdapter<StructureAdvertise> {
    public AdvertiseAdapter(ArrayList<StructureAdvertise> advertises){
        super(Global.context , R.layout.adapter_advertise , advertises);
    }

    private static class ViewHolder{
        public ViewHolder(View view){

        }
        public void fill(ArrayAdapter<StructureAdvertise> adapter,StructureAdvertise item,int position){

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        ViewHolder holder;
        StructureAdvertise item = getItem(position);
        if(convertView == null){
            convertView = Global.inflater.inflate(R.layout.adapter_advertise , parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(this,item,position);
        return convertView;
    }
}

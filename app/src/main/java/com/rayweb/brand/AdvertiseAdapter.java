package com.rayweb.brand;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.rayweb.brand.Infrastructure.Global;
import com.rayweb.brand.Model.Advertise;

import java.util.List;
/**
 * Created by ICT on 2/16/2015.
 */
public class AdvertiseAdapter extends ArrayAdapter<Advertise> {
    public AdvertiseAdapter(List<Advertise> advertiseList){
        super(Global.context , R.layout.adapter_advertise , advertiseList);
    }


    private static class ViewHolder{
        public TextView textViewTitle;
        public TextView textViewDescription;
        public CheckBox checkBoxFavorite;
        public ImageView imageViewBrand;
        public ViewHolder(View view){

            textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
            checkBoxFavorite = (CheckBox) view.findViewById(R.id.checkBoxFavorite);
            imageViewBrand = (ImageView) view.findViewById(R.id.imageViewBrand);
        }
        public void fill(ArrayAdapter<Advertise> adapter,Advertise item,int position){

            textViewTitle.setText(item.title);
            textViewDescription.setText(item.description);
        /*    checkBoxFavorite.setChecked(item.);*/
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        ViewHolder holder;
        Advertise item = getItem(position);
        if(convertView == null){
            convertView = Global.inflater.inflate(R.layout.adapter_advertise, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(this,item,position);
        return convertView;
    }
}

package com.rayweb.brand;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        public ViewGroup layoutRoot;
        public TextView textViewTitle;
        public TextView textViewDescription;
        public CheckBox checkBoxFavorite;
        public ImageView imageViewBrand;
        public ViewHolder(View view){

            layoutRoot = (ViewGroup) view.findViewById(R.id.layoutAdvertise);
            textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
            checkBoxFavorite = (CheckBox) view.findViewById(R.id.checkBoxFavorite);
            imageViewBrand = (ImageView) view.findViewById(R.id.imageViewBrand);

        }
        public void fill(ArrayAdapter<Advertise> adapter,final Advertise item, final int position){

            textViewTitle.setText(item.title);
            textViewDescription.setText(item.description);

            layoutRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //item.title = "Clicked";
                    //textViewTitle.setText(item.title);
                    Intent intent = new Intent(Global.currentActivity,AdvertiseActivity.class);
                    intent.putExtra("POSITION" , position);
                    Global.currentActivity.startActivity(intent);
                }
            });


           try{
               checkBoxFavorite.setChecked(item.isNew);
           }catch(Exception e){
                e.printStackTrace();
           }
            checkBoxFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CheckBox checkBox = (CheckBox) view;
                    item.isNew = checkBox.isChecked();
                    if(item.isNew){
                        textViewTitle.setTextColor(Color.parseColor("#ff0000"));
                    }else{
                        textViewTitle.setTextColor(Color.parseColor("#ffffff"));
                    }
                }
            });

            try {
                if (item.isNew) {
                    textViewTitle.setTextColor(Color.parseColor("#ff0000"));
                } else {
                    textViewTitle.setTextColor(Color.parseColor("#ffffff"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }



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

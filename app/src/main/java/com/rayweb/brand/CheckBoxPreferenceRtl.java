package com.rayweb.brand;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by ICT on 2/14/2015.
 * baraye android 4.2 be bad mitoonim settings ro rtl konim faghat :(
 */
public class CheckBoxPreferenceRtl extends CheckBoxPreference {
    public CheckBoxPreferenceRtl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        return super.onCreateView(parent);

//        RelativeLayout layout = (RelativeLayout) ((LinearLayout) view).getChildAt(1);
//        layout.setGravity(Gravity.RIGHT);
//        return view;
    }
}

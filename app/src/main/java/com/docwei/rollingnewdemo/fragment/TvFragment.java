package com.docwei.rollingnewdemo.fragment;


import com.docwei.rollingnewdemo.BaseFragement;
import com.docwei.rollingnewdemo.R;

/**
 * Created by tobo on 17/2/3.
 */

public class TvFragment extends BaseFragement {
    @Override
    protected String getText() {
        return "Tv";
    }

    @Override
    public int getColorId() {
        return R.color.brown;
    }
}

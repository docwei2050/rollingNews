package com.docwei.rollingnewdemo.fragment;


import com.docwei.rollingnewdemo.BaseFragement;
import com.docwei.rollingnewdemo.R;

/**
 * Created by tobo on 17/2/3.
 */

public class BookFragment extends BaseFragement {
    @Override
    protected String getText() {
        return "Book";
    }

    @Override
    public int getColorId() {
        return R.color.teal;
    }
}

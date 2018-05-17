package com.docwei.rollingnewdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.docwei.rollingnewdemo.fragment.FragmentFactory;


/**
 * Created by tobo on 17/2/3.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public BaseFragement getItem(int position) {
        BaseFragement fragement= FragmentFactory.createFragment(position);
        return fragement;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
    }
}

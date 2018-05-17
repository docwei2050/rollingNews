package com.docwei.rollingnewdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tobo on 17/2/3.
 */

public abstract class BaseFragement extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        TextView textView = new TextView(container.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(getText());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                            ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setBackgroundColor(getResources().getColor(getColorId()));
        textView.setTextSize(40);
        return textView;
    }

    protected abstract String getText();

    public abstract int getColorId();
}
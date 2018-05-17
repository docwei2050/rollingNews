package com.docwei.rollingnewdemo.newsrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.docwei.rollingnewdemo.R;

/**
 * Created by git on 2018/3/8.
 */

public class ViewRollingChildView extends RelativeLayout {

    private ImageView mFlipper_iv;
    private TextView  mFlipper_tv_prev;
    private TextView  mFlipper_tv_next;

    public ViewRollingChildView(Context context) {
        this(context,null);
    }

    public ViewRollingChildView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ViewRollingChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.ll_news_headline, this);
        mFlipper_iv = (ImageView) view.findViewById(R.id.home_iv_headline);
        mFlipper_tv_prev = (TextView) view.findViewById(R.id.home_tv_headline_prev);
        mFlipper_tv_next = (TextView) view.findViewById(R.id.home_tv_headline_next);

    }
    public ViewRollingChildView setPrevText(String content){
        mFlipper_tv_prev.setText(content);
        return this;
    }
    public ViewRollingChildView setNextText(String content){
        mFlipper_tv_next.setText(content);
        return this;
    }
    public ViewRollingChildView setRightIcon(String url){
        //使用Glide去加载图片TODO
        //mFlipper_iv.setImageResource(res);
        return this;
    }

}

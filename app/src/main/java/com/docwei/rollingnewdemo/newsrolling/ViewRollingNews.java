package com.docwei.rollingnewdemo.newsrolling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by git on 2018/5/14.
 * Linearlayout有一个很大的bug就是添加一个跟父容器一样的控件，下一个控件就添加不进去了，把我们下一个控件的
 * 重新布局，大小就是0了
 * ViewGroup就是必须得测量布局孩子的高度
 */

public class ViewRollingNews extends ViewGroup {

    private ViewRollingChildView mVchild0;
    private ViewRollingChildView mVchild1;
    private Scroller             mScroller;

    public ViewRollingNews(@NonNull Context context) {
        this(context, null);
    }

    public ViewRollingNews(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public ViewRollingNews(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        //平滑滚动必须
        mScroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //忽略padding
        int width  = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //保存父容器宽高
        setMeasuredDimension(width, height);
        //这里测量孩子就不遍历测量了，麻烦
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //布局孩子必须得遍历，写死两个2孩子
        int top    = 0;
        int bottom = 0;
        for (int i = 0; i < 2; i++) {
            View childView = getChildAt(i);
            bottom += childView.getMeasuredHeight();
            childView.layout(0, top, childView.getMeasuredWidth(), bottom);  //测量孩子
            top += childView.getMeasuredHeight();
        }
    }

    private int count = 0;

    public void updateData(List<NewsBean> list) {
        if (list == null) {
            return;
        }
        if (mNews == null) {
            mNews = new ArrayList<>();
        }

        mNews.clear();
        mNews.addAll(list);
        if (list.size() == 1) {
            NewsBean bean = list.get(0);
            //1个时候并不需要进行轮播
            mVchild0.setPrevText(bean.getHeadLinePrev())
                    .setNextText(bean.getHeadLineNext())
                    .setRightIcon(bean.getImageUrl());
        } else if (list.size() > 1) {
            NewsBean bean  = list.get(0);
            NewsBean bean2 = list.get(1);
            mVchild0 = (ViewRollingChildView) getChildAt(0);
            mVchild1 = (ViewRollingChildView) getChildAt(1);
            if (mVchild1.getY() == 0) {
                mVchild0.setPrevText(bean.getHeadLinePrev())
                        .setNextText(bean.getHeadLineNext())
                        .setRightIcon(bean.getImageUrl());
                mVchild1.setPrevText(bean2.getHeadLinePrev())
                        .setNextText(bean2.getHeadLineNext())
                        .setRightIcon(bean2.getImageUrl());
            } else {
                mVchild1.setPrevText(bean.getHeadLinePrev())
                        .setNextText(bean.getHeadLineNext())
                        .setRightIcon(bean.getImageUrl());
                mVchild0.setPrevText(bean2.getHeadLinePrev())
                        .setNextText(bean2.getHeadLineNext())
                        .setRightIcon(bean2.getImageUrl());
            }

            count = 0;
        }

    }

    private List<NewsBean> mNews;
    private WeakHandler mHandler = new WeakHandler();


    public void startAutoPlay() {
        mHandler.removeCallbacks(mTask);
        isStopTask=false;
        mHandler.postDelayed(mTask, 2000);

    }

    private int height = 0;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (h != oldh) {
            height = getChildAt(0).getMeasuredHeight();
        }
    }
    private boolean isStopTask=false;
    public  void stopPlay() {
        mHandler.removeCallbacks(mTask);
        isStopTask=true;
    }

    private boolean  mSrollFlag = false;
    public  Runnable mTask      = new Runnable() {
        @Override
        public void run() {
            if(isStopTask){
                return;
            }
            count++;
            if (count >= mNews.size()) {
                count = 0;
            }
            if (!mSrollFlag) {
                updateChildData(mVchild1, mNews.get((count) % mNews.size()));
                mVchild0.setY(0);
                mVchild1.setY(height);
            } else {
                mVchild1.setY(0);
                updateChildData(mVchild0, mNews.get((count) % mNews.size()));
                mVchild0.setY(height);
            }

            scrollerView();
        }

        private void scrollerView() {
            mSrollFlag = !mSrollFlag;
            mScroller.startScroll(0, 0, 0, height, 1000);
            invalidate();
            postDelayed(this, 2000);
        }

    };

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    public void updateChildData(ViewRollingChildView view, NewsBean bean) {
        view.setPrevText(bean.getHeadLinePrev())
            .setNextText(bean.getHeadLineNext())
            .setRightIcon(bean.getImageUrl());
    }
}

package com.docwei.rollingnewdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.docwei.rollingnewdemo.BaseFragement;
import com.docwei.rollingnewdemo.newsrolling.NewsBean;
import com.docwei.rollingnewdemo.R;
import com.docwei.rollingnewdemo.newsrolling.ViewRollingNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobo on 17/2/3.
 */

public class HomeFragment extends BaseFragement {

    private ViewRollingNews mViewFlipperNews;

    @Override
    protected String getText() {
        return "Home";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fragment_news, null);
        initData(view);
        return view;
    }

    private void initData(View view) {
        Button button =view.findViewById(R.id.startBtn);


        mViewFlipperNews = view.findViewById(R.id.viewflipper);
        List<NewsBean>        list            =new ArrayList<>();
        for(int i=0;i<3;i++) {
            NewsBean bean = new NewsBean();
            bean.setHeadLinePrev("新闻第" + i + "上一个");
            bean.setHeadLineNext("新闻第" + i + "下一个");
            bean.setImageUrl("i");
            list.add(bean);
        }
        //第一次赋值
        mViewFlipperNews.updateData(list);
        //启动滚动
        mViewFlipperNews.startAutoPlay();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新数据
                List<NewsBean> list =new ArrayList<>();
                for(int i=0;i<5;i++) {
                    NewsBean bean = new NewsBean();
                    bean.setHeadLinePrev(" 新闻第二波第二波第二波" + i + "上一个");
                    bean.setHeadLineNext(" 新闻第二波第二波第二波" + i + "下一个");
                    bean.setImageUrl("i");
                    list.add(bean);
                }
                mViewFlipperNews.updateData(list);
            }
        });

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewFlipperNews.stopPlay();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(mViewFlipperNews!=null){
            if(isVisibleToUser){
               mViewFlipperNews.startAutoPlay();
            }else{
                mViewFlipperNews.stopPlay();
            }
        }
    }



    @Override
    public int getColorId() {
        return R.color.orange;
    }
}

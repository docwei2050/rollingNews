package com.docwei.rollingnewdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private ViewPager           mVp;
    private BottomNavigationBar mNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        FragmentManager   fragmentManager = getSupportFragmentManager();
        MyFragmentAdapter adapter         =new MyFragmentAdapter(fragmentManager);
        mVp.setAdapter(adapter);



        BadgeItem badgeItem=new BadgeItem().setBorderWidth(1).setBackgroundColorResource(R.color.colorAccent).setText("2").setHideOnSelect(true);


        mNavigationBar.setMode(mNavigationBar.MODE_SHIFTING);
       /* mNavigationBar.setBackgroundStyle(mNavigationBar.BACKGROUND_STYLE_RIPPLE);*/
        mNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp,"首页").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.ic_favorite_white_24dp,"最爱").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "书本").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.grey))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "电视").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(0)
                .initialise();

        mNavigationBar.setTabSelectedListener(this);




        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabSelected(int position) {
        //点击底部导航，Viewpager跟着变化
        mVp.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

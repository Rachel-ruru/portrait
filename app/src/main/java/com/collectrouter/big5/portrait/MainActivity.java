package com.collectrouter.big5.portrait;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    protected ViewPager mViewPager = null;
    private MainPagerAdapter mPagerAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initUI();
        fillData2UI();

    }

    private void fillData2UI() {

    }

    private void initUI() {
        mPagerAdapter = new MainPagerAdapter(this);
        mViewPager = (ViewPager)findViewById(R.id.vp_container);
        mViewPager.setAdapter( mPagerAdapter );

    }

    private void initData() {
    }

    public static boolean gotoPage(Context context, int pageId) {
        if (context == null || !(context instanceof MainActivity)) {
            return false;
        }
        MainActivity activity = (MainActivity)context;
        if (activity.mViewPager == null) {
            return false;
        }
        activity.mViewPager.setCurrentItem(pageId);
        return true;
    }
}

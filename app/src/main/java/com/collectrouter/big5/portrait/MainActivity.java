package com.collectrouter.big5.portrait;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

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
        gotoPage(this, RunState.PAGE_SELECT_MODE);
    }

    private void initData() {
        PagerLogic.getInstance().reset();
    }

    public static boolean gotoPage(Context context, int pageId) {
        if (context == null || !(context instanceof MainActivity)) {
            return false;
        }
        MainActivity activity = (MainActivity)context;
        if (activity.mViewPager == null) {
            return false;
        }
        int nCount = activity.mPagerAdapter.getCount();
        if (pageId >= nCount) {
            return false;
        }
        activity.mPagerAdapter.initItem(pageId);
        activity.mViewPager.setCurrentItem(pageId);
        PagerLogic.getInstance().pushPager(pageId);
        Log.i("ROM_DEBUG", "gotoPage Id: " + String.valueOf(pageId));
        return true;
    }

    public static void backPage(Context context) {
        if (context == null || !(context instanceof MainActivity)) {
            return;
        }
        MainActivity activity = (MainActivity)context;
        if (activity.mViewPager == null) {
            return;
        }
        if (!PagerLogic.getInstance().canGoback()) {
            return;
        }
        PagerLogic.getInstance().popPager();
        int pageId = PagerLogic.getInstance().getCurPageId();
        Log.i("ROM_DEBUG", "backPage Id: " + String.valueOf(pageId));
        if (pageId < 0) {
            return;
        }
        activity.mViewPager.setCurrentItem(pageId);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("ROM_DEBUG", "enter onKeyDown");
        if (keyCode == KeyEvent. KEYCODE_BACK && event.getRepeatCount() == 0) {
            backPage(this);
            Log.i("ROM_DEBUG", "after call backPage.");
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}

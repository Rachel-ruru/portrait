package com.collectrouter.big5.portrait;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 18/1/1.
 */

public class MainPagerAdapter extends PagerAdapter {
    private Context mContext = null;
    private Map<Integer, MainPagerBase> mapPager = new HashMap<>();

    public MainPagerAdapter(Context context) {
        mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        addPager( RunState.PAGE_SELECT_MODE, new PagerSelectMode(context), layoutInflater );
        addPager( RunState.PAGE_USERINFO_INPUT, new PagerUserInfoInput(context), layoutInflater );
        addPager( RunState.PAGE_USERINFO_SHOW, new PagerUserInfoShow(context), layoutInflater );
        addPager( RunState.PAGE_PORTRAIT_TEST, new PagerPortraitTest(context), layoutInflater );
        addPager( RunState.PAGE_PORTRAIT_TRAIN, new PagerPortraitTrain(context), layoutInflater );
    }

    private void addPager(int nPageId, MainPagerBase pager, LayoutInflater layoutInflater) {
        if ((pager == null) || (layoutInflater == null)) {
            return;
        }
        mapPager.put( nPageId, pager );
    }

    @Override
    public int getCount() {
        return mapPager.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        MainPagerBase pager = mapPager.get(position);
        if (pager == null) {
            return;
        }
        View viewPage = pager.getRootView();
        if (viewPage == null) {
            return;
        }
        container.removeView(viewPage);

    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        MainPagerBase pager = mapPager.get(position);
        if (pager == null) {
            return null;
        }
        return pager.getPageTitle();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i("ROM_DEBUG", "enter instantiateItem, position:" + String.valueOf(position));
        MainPagerBase pager = mapPager.get(position);
        if (pager == null) {
            return null;
        }
        View viewPage = pager.getRootView();
        if (viewPage == null) {
            return null;
        }
        container.addView(viewPage);
        return viewPage;
    }


}


package com.collectrouter.big5.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by apple on 18/1/6.
 */

public class PagerPortraitTest implements MainPagerBase {
    private Context mContext = null;
    public PagerPortraitTest(Context context) {
        mContext = context;
    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View viewPage = layoutInflater.inflate(R.layout.page_protrait_test_start, null);
        if (viewPage == null) {
            return null;
        }
        return viewPage;
    }

    @Override
    public String getPageTitle() {
        return "Test Your Portrait";
    }

    @Override
    public void init() {

    }
}

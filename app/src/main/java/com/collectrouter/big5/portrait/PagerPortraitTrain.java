package com.collectrouter.big5.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by apple on 18/1/7.
 */

public class PagerPortraitTrain implements MainPagerBase {
    private Context mContext = null;
    public PagerPortraitTrain(Context context) {
        mContext = context;
    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View viewPage = layoutInflater.inflate(R.layout.page_protrait_train_start, null);
        if (viewPage == null) {
            return null;
        }
        return viewPage;
    }

    @Override
    public String getPageTitle() {
        return "Test Your Portrait";
    }
}

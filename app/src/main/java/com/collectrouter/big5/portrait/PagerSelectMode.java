package com.collectrouter.big5.portrait;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by apple on 18/1/6.
 */

public class PagerSelectMode implements MainPagerBase {
    private Context mContext = null;

    public PagerSelectMode(Context context) {
        mContext = context;
    }

    public String getPageTitle() {
        return "ModelSelect";
    }

    @Override
    public void init() {

    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View viewPage = layoutInflater.inflate(R.layout.page_model_select, null);
        if (viewPage == null) {
            return null;
        }
        viewPage.findViewById(R.id.btn_train).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ROM_DEBUG", "click Train Button");
                MainActivity.gotoPage(mContext, RunState.PAGE_PORTRAIT_TRAIN);

            }
        });
        viewPage.findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.gotoPage(mContext, RunState.PAGE_PORTRAIT_TEST);
            }
        });

        return viewPage;
    }
}

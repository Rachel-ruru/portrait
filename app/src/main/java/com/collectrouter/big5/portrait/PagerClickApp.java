package com.collectrouter.big5.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.collectrouter.big5.portrait.ui.AppAdapter;

/**
 * Created by apple on 18/1/11.
 */

public class PagerClickApp implements MainPagerBase {
    private Context mContext = null;
    private ListView mListView = null;

    public PagerClickApp(Context context) {
        mContext = context;
    }

    public String getPageTitle() {
        return "UserInfoInput";
    }

    @Override
    public void init() {

    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (layoutInflater == null) {
            return null;
        }
        View viewPage = layoutInflater.inflate(R.layout.page_click_app, null);
        if (viewPage == null) {
            return null;
        }
        mListView = (ListView)viewPage.findViewById(R.id.lv_apps);
        AppAdapter appAdapter = new AppAdapter(mContext);
        mListView.setAdapter(appAdapter);
        viewPage.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.gotoPage(mContext, RunState.PAGE_TAGS_SHOW);

            }
        });

        return viewPage;
    }
}

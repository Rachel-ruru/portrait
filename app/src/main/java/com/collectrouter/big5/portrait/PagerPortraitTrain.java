package com.collectrouter.big5.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.collectrouter.big5.portrait.depot.TrainCaseDepot;

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
        TextView tvWellCome = (TextView) viewPage.findViewById(R.id.tv_welcome);
        if (tvWellCome == null) {
            return null;
        }
        tvWellCome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 训练开始前清空数据
                TrainCaseDepot.getInstance().reset();
                //
                MainActivity.gotoPage(mContext, RunState.PAGE_USERINFO_INPUT);
            }
        });

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

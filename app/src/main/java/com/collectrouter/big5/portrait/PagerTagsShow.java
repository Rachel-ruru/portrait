package com.collectrouter.big5.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.collectrouter.big5.portrait.ui.TagsAdapter;

/**
 * Created by apple on 18/1/11.
 */

public class PagerTagsShow implements MainPagerBase {
    private Context mContext = null;
    private TagsAdapter mTagsAdapter = null;
    ListView lvTags = null;
    public PagerTagsShow(Context context) {
        mContext = context;
    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View viewPage = layoutInflater.inflate(R.layout.page_tags_show, null);
        if (viewPage == null) {
            return null;
        }

        lvTags = (ListView) viewPage.findViewById(R.id.lv_tags);
        if (lvTags == null) {
            return null;
        }
        viewPage.findViewById(R.id.btn_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.gotoPage(mContext, RunState.PAGE_PORTRAIT_TRAIN);
            }
        });

        return viewPage;
    }

    @Override
    public String getPageTitle() {
        return "标签分析结果";
    }

    @Override
    public void init() {
        if (lvTags == null) {
            return;
        }
        lvTags.setAdapter(new TagsAdapter(mContext));
    }
}

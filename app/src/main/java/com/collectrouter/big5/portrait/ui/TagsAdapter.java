package com.collectrouter.big5.portrait.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.collectrouter.big5.portrait.R;
import com.collectrouter.big5.portrait.TagDef;
import com.collectrouter.big5.portrait.depot.AppDepot;
import com.collectrouter.big5.portrait.model.AppObj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 18/1/11.
 */

public class TagsAdapter extends BaseAdapter {
    private Map<Integer, Integer> mMapTagsSum = new HashMap<>();
    private List<String> mListTagsInfo = new ArrayList<>();
    private Context mContext;

    public TagsAdapter(Context context) {
        mContext = context;
        List<AppObj> listChecked = AppDepot.getInstance().getAllCheckedItems();
        if (listChecked == null) {
            return;
        }
        for (AppObj app : listChecked) {
            if (!app.mChecked)
                continue;
            for (Integer tag : app.mListTags) {
                addTagRecord(tag);
            }
        }
        //
        for (Map.Entry<Integer, Integer> entry : mMapTagsSum.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            mListTagsInfo.add( String.format("%d: %s", entry.getValue(), TagDef.id2TagStr(entry.getKey().intValue())));
            //mListTagsInfo.add( String.format("%d:  ", entry.getValue()));
        }

        Collections.sort(mListTagsInfo, new ComparatorString());
    }

    class ComparatorString implements Comparator{
        @Override
        public int compare(Object o, Object t1) {
            String str1 = (String)o;
            String str2 = (String)t1;
            return str2.compareTo(str1);
        }
    }

    private void addTagRecord(Integer tag) {
        Object objCount = mMapTagsSum.get(tag);
        if (objCount == null) {
            mMapTagsSum.put(tag, 1);
        } else {
            Integer count = (Integer)objCount;
            ++count;
            mMapTagsSum.put(tag, count);
        }
    }

    @Override
    public int getCount() {
        return mListTagsInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TagsAdapter.ViewHolder holder;
        AppObj appObj = AppDepot.getInstance().getItem(i);
        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_tag_item, null);
            holder = new TagsAdapter.ViewHolder();
            //holder.weakAppObj = new WeakReference<AppObj>(appObj);
            holder.mtvTagInfo = (TextView) view.findViewById(R.id.tv_tag_info);
            view.setTag(holder);

        } else {
            holder = (TagsAdapter.ViewHolder)view.getTag();
        }

        String strTagInfo = mListTagsInfo.get(i);
        if (!TextUtils.isEmpty(strTagInfo)) {
            holder.mtvTagInfo.setText(strTagInfo);
        }
        Log.i("ROM_DEBUG", "enter getView : " + String.valueOf(i) + (appObj.mChecked ? " Checked" : ""));
        return view;
    }


    class ViewHolder {
        //WeakReference<AppObj> weakAppObj;
        TextView mtvTagInfo;
    }
}

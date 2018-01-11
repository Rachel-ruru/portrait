package com.collectrouter.big5.portrait.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/1/10.
 */

public class AppObj extends StuffObj {
    public boolean mChecked = false;
    private String mstrAppName;
    public List<Integer> mListTags = new ArrayList<>();

    public AppObj(String strAppName, List<Integer> listTags) {
        mstrAppName = strAppName;
        if (listTags != null) {
            mListTags.addAll(listTags);
        }
    }

    public String getName() {
        return mstrAppName;
    }


}

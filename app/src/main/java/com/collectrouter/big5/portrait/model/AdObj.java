package com.collectrouter.big5.portrait.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/1/9.
 */

public class AdObj extends StuffObj{
    public List<Integer> mTags = new ArrayList<>();

    public AdObj( List<Integer> listTags ) {
        mTags = listTags;
    }




}

package com.collectrouter.big5.portrait;

import java.util.Stack;

/**
 * Created by apple on 18/1/6.
 */

public class PagerLogic {
    private static PagerLogic sInst = null;
    private Stack<Integer> mStackPager = new Stack<>();
    private PagerLogic() {}

    public static PagerLogic getInstance() {
        if (sInst != null) {
            return sInst;
        }
        synchronized ( PagerLogic.class ) {
            if (sInst != null) {
                return sInst;
            }
            sInst = new PagerLogic();
        }
        return sInst;
    }

    public void pushPager(int nPagerId) {
        mStackPager.add(nPagerId);
    }

    public boolean canGoback() {
        if (mStackPager == null) {
            return false;
        }
        return mStackPager.size() > 1;
    }

    public int popPager() {
        if (mStackPager.size() == 0) {
            return -1;
        }
        return mStackPager.pop();
    }

    public int getCurPageId() {
        int nSize = mStackPager.size();
        if ( nSize == 0) {
            return -1;
        }
        return mStackPager.get(nSize - 1);
    }

    public void reset() {
        mStackPager.clear();
    }
}

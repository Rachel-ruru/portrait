package com.collectrouter.big5.portrait;

/**
 * Created by apple on 18/1/1.
 */

public class RunState {
    public static int STATE_UNKNOWN = 0; //
    public static int STATE_TRAINNING = 1; // 训练
    public static int STATE_VERIFICATION = 2; // 验证
    private int mState = STATE_UNKNOWN;

    public static int PAGE_SELECT_MODE = 0;
    public static int PAGE_USERINFO_INPUT = 1;
    public static int PAGE_USERINFO_SHOW = 2;
    public static int PAGE_PORTRAIT_TEST = 3;
    public static int PAGE_PORTRAIT_TRAIN = 4;


    public void setState( int state ) {
        mState = state;
    }

    public int getState() {
        return mState;
    }



}

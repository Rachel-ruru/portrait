package com.collectrouter.big5.portrait.depot;

import com.collectrouter.big5.portrait.model.TrainCaseObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/1/11.
 */

public class TrainCaseDepot {
    private static TrainCaseDepot sInst = null;
    private static List<TrainCaseObj> mlistApps = new ArrayList<>();
    private static TrainCaseObj mTrainCaseObj = new TrainCaseObj();

    private TrainCaseDepot() {
        init();
    }

    private void init() {

    }

    public static TrainCaseDepot getInstance() {
        if (sInst != null) {
            return sInst;
        }
        synchronized (TrainCaseDepot.class) {
            if (sInst != null) {
                return sInst;
            }
            sInst = new TrainCaseDepot();
        }

        return sInst;
    }

    public TrainCaseObj getCurTrainCaseObj() {
        return mTrainCaseObj;
    }

    public void reset() {
        AppDepot.getInstance().resetAll();
        mTrainCaseObj.mUserObj.mAge = "";
        mTrainCaseObj.mUserObj.mGender = 0;
        mTrainCaseObj.mUserObj.mJob = 0;
    }
}

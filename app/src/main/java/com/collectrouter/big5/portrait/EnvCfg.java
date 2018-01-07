package com.collectrouter.big5.portrait;

/**
 * Created by apple on 18/1/1.
 */

public class EnvCfg {
    private EnvCfg sInst = null;
    public RunState mStateRun = new RunState();

    private EnvCfg() {}

    public EnvCfg getInstance() {
        if (sInst != null) {
            return sInst;
        }
        synchronized (EnvCfg.class) {
            if (sInst != null) {
                return sInst;
            }
            sInst = new EnvCfg();
        }
        return sInst;
    }



}

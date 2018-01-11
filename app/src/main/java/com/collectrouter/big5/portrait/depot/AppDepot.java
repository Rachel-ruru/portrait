package com.collectrouter.big5.portrait.depot;

import com.collectrouter.big5.portrait.TagDef;
import com.collectrouter.big5.portrait.model.AppObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/1/10.
 */

public class AppDepot {
    private static AppDepot sInst = null;
    private static List<AppObj> mlistApps = new ArrayList<>();

    private AppDepot() {
        init();
    }

    public static AppDepot getInstance() {
        if (sInst != null) {
            return sInst;
        }
        synchronized (AppDepot.class) {
            if (sInst != null) {
                return sInst;
            }
            sInst = new AppDepot();
        }

        return sInst;
    }

    public int getCount() {
        return mlistApps.size();
    }

    public AppObj getItem( int pos ) {
        if (pos < 0 || pos >= mlistApps.size() ) {
            return null;
        }
        AppObj appObj = mlistApps.get(pos);
        return appObj;
    }

    private void init() {
        mlistApps.add(new AppObj("网易新闻", createListTags()));
        mlistApps.add(new AppObj("今日头条", createListTags()));
        mlistApps.add(new AppObj("新浪新闻", createListTags()));
        mlistApps.add(new AppObj("天猫", createListTags(TagDef.TAG_SHOP_ONLINE)));
        mlistApps.add(new AppObj("京东", createListTags(TagDef.TAG_SHOP_ONLINE)));
        mlistApps.add(new AppObj("亚马逊", createListTags(TagDef.TAG_SHOP_ONLINE)));
        mlistApps.add(new AppObj("网易严选", createListTags(TagDef.TAG_SHOP_ONLINE, TagDef.TAG_QUALITY_HIGH)));
        mlistApps.add(new AppObj("拼多多", createListTags(TagDef.TAG_SHOP_ONLINE, TagDef.TAG_QUALITY_CHEAP)));
        mlistApps.add(new AppObj("唯品会", createListTags(TagDef.TAG_SHOP_ONLINE, TagDef.TAG_WOMAN)));
        mlistApps.add(new AppObj("网易公开课", createListTags(TagDef.TAG_EDUCATION)));
        mlistApps.add(new AppObj("王者荣耀", createListTags(TagDef.TAG_GAME)));
        mlistApps.add(new AppObj("当前Activity", createListTags(TagDef.TAG_DEVELOPER)));
        mlistApps.add(new AppObj("Facebook", createListTags(TagDef.TAG_MAKE_FRIENDS)));
        mlistApps.add(new AppObj("腾讯动漫", createListTags(TagDef.TAG_COMIC)));
        mlistApps.add(new AppObj("火山小视频", createListTags(TagDef.TAG_VIDEO)));
        mlistApps.add(new AppObj("头牌", createListTags(TagDef.TAG_VIDEO)));
        mlistApps.add(new AppObj("有道云协作", createListTags(TagDef.TAG_OFFICE)));
        mlistApps.add(new AppObj("MotionPro", createListTags(TagDef.TAG_OFFICE, TagDef.TAG_DEVELOPER)));
        mlistApps.add(new AppObj("熊猫直播", createListTags(TagDef.TAG_LIVE_SHOW, TagDef.TAG_VIDEO, TagDef.TAG_GAME)));
        mlistApps.add(new AppObj("GG大玩家", createListTags(TagDef.TAG_GAME, TagDef.TAG_APP_MARKET)));
        mlistApps.add(new AppObj("优选", createListTags(TagDef.TAG_SHOP_ONLINE)));
        mlistApps.add(new AppObj("魅族商城", createListTags(TagDef.TAG_SHOP_ONLINE)));
        mlistApps.add(new AppObj("优酷", createListTags(TagDef.TAG_VIDEO)));
        mlistApps.add(new AppObj("腾讯视频", createListTags(TagDef.TAG_VIDEO)));
        mlistApps.add(new AppObj("美图秀秀", createListTags(TagDef.TAG_WOMAN)));
        mlistApps.add(new AppObj("迅雷", createListTags(TagDef.TAG_VIDEO)));
        mlistApps.add(new AppObj("斗鱼直播", createListTags(TagDef.TAG_LIVE_SHOW)));
        mlistApps.add(new AppObj("快手", createListTags(TagDef.TAG_SHORT_VIDEO)));
        mlistApps.add(new AppObj("Live.me", createListTags(TagDef.TAG_LIVE_SHOW)));
        mlistApps.add(new AppObj("YY", createListTags(TagDef.TAG_LIVE_SHOW, TagDef.TAG_GAME)));
        mlistApps.add(new AppObj("陌陌", createListTags(TagDef.TAG_MAKE_FRIENDS)));
        mlistApps.add(new AppObj("有道云笔记", createListTags(TagDef.TAG_OFFICE)));
        mlistApps.add(new AppObj("图说", createListTags(TagDef.TAG_CAMERA)));
        mlistApps.add(new AppObj("宝宝亲子相机", createListTags(TagDef.TAG_BABY, TagDef.TAG_PARENT, TagDef.TAG_CAMERA)));
        mlistApps.add(new AppObj("有道翻译官", createListTags(TagDef.TAG_EDUCATION)));
        mlistApps.add(new AppObj("喜马拉雅", createListTags(TagDef.TAG_MUSIC)));
        mlistApps.add(new AppObj("应用宝", createListTags(TagDef.TAG_APP_MARKET)));
        mlistApps.add(new AppObj("出国翻译官", createListTags(TagDef.TAG_EDUCATION, TagDef.TAG_TRAFFIC)));
        mlistApps.add(new AppObj("西瓜视频", createListTags(TagDef.TAG_SHORT_VIDEO)));
        mlistApps.add(new AppObj("猎豹清理大师", createListTags()));
        mlistApps.add(new AppObj("欢乐斗地主", createListTags(TagDef.TAG_GAME)));
        mlistApps.add(new AppObj("VUE视频相机", createListTags(TagDef.TAG_CAMERA, TagDef.TAG_SHORT_VIDEO)));
        mlistApps.add(new AppObj("抖音短视频", createListTags(TagDef.TAG_MUSIC, TagDef.TAG_SHORT_VIDEO)));
        mlistApps.add(new AppObj("Philm黑咔", createListTags(TagDef.TAG_CAMERA)));
        mlistApps.add(new AppObj("Soul", createListTags(TagDef.TAG_MAKE_FRIENDS)));
        mlistApps.add(new AppObj("VipKid英语", createListTags(TagDef.TAG_EDUCATION, TagDef.TAG_BABY)));
    }

    private static List<Integer> createListTags(Integer ... args) {
        if (args == null || args.length == 0) {
            return null;
        }
        List<Integer> listRet = new ArrayList<>();
        for (int i = 0; i<args.length; ++i) {
            listRet.add(args[i]);
        }
        return listRet;
    }

    public void resetAll() {
        AppObj appObj = null;
        for (int i = 0; i<mlistApps.size(); ++i) {
            appObj = mlistApps.get(i);
            appObj.mChecked = false;
        }
    }

    public List<AppObj> getAllCheckedItems() {
        List<AppObj> appsRet = new ArrayList<>();
        for (int i = 0; i<mlistApps.size(); ++i) {
            AppObj appObj = mlistApps.get(i);
            if ( appObj != null && appObj.mChecked ) {
                appsRet.add(appObj);
            }
        }
        return appsRet;
    }
}

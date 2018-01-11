package com.collectrouter.big5.portrait.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/1/9.
 */

public class UserObj {
    public static int GENDER_MAN = 1;
    public static int GENDER_WOMAN = 2;

    public static int JOB_SOFTWARE_ENGINNER = 1;
    public static int JOB_PRODUCT_MANAGER = 2;
    public static int JOB_MARKET_RESEARCH = 3;


    public String mAge;
    public int mGender;
    public int mJob;

    public List<AdObj> mListAds = new ArrayList<>();
    public List<NewsObj> mListNews = new ArrayList<>();

    public UserObj(String age, int gender, int job) {
        mAge = age;
        mGender = gender;
        mJob = job;
    }

    public void doClickAd(AdObj adObj) {
        mListAds.add(adObj);
    }

    public void doClickNews(NewsObj newsObj) {
        mListNews.add(newsObj);
    }




}

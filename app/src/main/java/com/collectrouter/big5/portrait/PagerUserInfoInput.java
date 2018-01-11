package com.collectrouter.big5.portrait;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.collectrouter.big5.portrait.depot.TrainCaseDepot;

/**
 * Created by apple on 18/1/6.
 */

public class PagerUserInfoInput implements MainPagerBase {
    public static String[] ageSection=   {"<14", "15~22", "23~32", "33~45", ">46"};
    private Context mContext = null;

    public PagerUserInfoInput(Context context) {
        mContext = context;
    }

    public String getPageTitle() {
        return "UserInfoInput";
    }

    @Override
    public void init() {

    }

    @Override
    public View getRootView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (layoutInflater == null) {
            return null;
        }
        View viewPage = layoutInflater.inflate(R.layout.page_userinfo_input, null);
        if (viewPage == null) {
            return null;
        }
        final Spinner spinnerAge = (Spinner) viewPage.findViewById(R.id.spinner_age);
        if (spinnerAge != null) {
            ArrayAdapter<String> aa = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_dropdown_item,ageSection); //第二个参数表示spinner没有展开前的UI类型
            //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAge.setAdapter(aa);
        }

        final Spinner spinnerGender = (Spinner)viewPage.findViewById(R.id.spinner_gender);
        if (spinnerGender != null) {
            String[] items = {"Man", "Woman"};
            ArrayAdapter<String> aa = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_dropdown_item,items); //第二个参数表示spinner没有展开前的UI类型
            //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGender.setAdapter(aa);
        }

        final Spinner spinnerJob = (Spinner)viewPage.findViewById(R.id.spinner_job);
        if (spinnerJob != null) {
            String[] items = {"SoftwareEnginner", "ProductManager", "MarketReseach"};
            ArrayAdapter<String> aa = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_dropdown_item,items); //第二个参数表示spinner没有展开前的UI类型
            //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerJob.setAdapter(aa);
        }

        viewPage.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posAge = spinnerAge.getSelectedItemPosition();
                Log.i("ROM_DEBUG", "posAge: " + String.valueOf(posAge));
                int posGender = spinnerGender.getSelectedItemPosition();
                Log.i("ROM_DEBUG", "posGender: " + String.valueOf(posGender));
                int posJob = spinnerJob.getSelectedItemPosition();
                Log.i("ROM_DEBUG", "posJob: " + String.valueOf(posJob));

                //
                TrainCaseDepot.getInstance().getCurTrainCaseObj().mUserObj.mAge = ageSection[posAge];
                TrainCaseDepot.getInstance().getCurTrainCaseObj().mUserObj.mJob = posJob;
                TrainCaseDepot.getInstance().getCurTrainCaseObj().mUserObj.mGender = posGender;


                MainActivity.gotoPage(mContext, RunState.PAGE_CLICK_APP);
            }
        });

        return viewPage;
    }
}

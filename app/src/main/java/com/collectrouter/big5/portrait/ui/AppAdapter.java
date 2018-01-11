package com.collectrouter.big5.portrait.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.collectrouter.big5.portrait.R;
import com.collectrouter.big5.portrait.depot.AppDepot;
import com.collectrouter.big5.portrait.model.AppObj;

/**
 * Created by apple on 18/1/11.
 */

public class AppAdapter extends BaseAdapter {
    private Context mContext;

    public AppAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return AppDepot.getInstance().getCount();
    }

    @Override
    public Object getItem(int i) {
        return AppDepot.getInstance().getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ItemOnClick implements View.OnClickListener {
        private int mPos = 0;
        public ItemOnClick( int pos ) {
            mPos = pos;
        }

        @Override
        public void onClick(View view) {
            AppObj appObj = AppDepot.getInstance().getItem(mPos);
            if (appObj != null) {
                appObj.mChecked = !appObj.mChecked;
                view.setBackgroundColor( appObj.mChecked ? Color.BLUE : Color.WHITE );
                view.invalidate();
            }
        }
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        AppObj appObj = AppDepot.getInstance().getItem(i);
        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_app_item, null);
            holder = new ViewHolder();
            //holder.weakAppObj = new WeakReference<AppObj>(appObj);
            holder.mtvAppName = (TextView) view.findViewById(R.id.tv_app_name);
            view.setTag(holder);

        } else {
            holder = (ViewHolder)view.getTag();
        }

        view.setOnClickListener(new ItemOnClick(i));
        holder.mtvAppName.setText(appObj.getName());
        view.setBackgroundColor( appObj.mChecked ? Color.BLUE : Color.WHITE );
        view.invalidate();

        Log.i("ROM_DEBUG", "enter getView : " + String.valueOf(i) + (appObj.mChecked ? " Checked" : ""));
        return view;
    }

    class ViewHolder {
        //WeakReference<AppObj> weakAppObj;
        TextView mtvAppName;
    }
}

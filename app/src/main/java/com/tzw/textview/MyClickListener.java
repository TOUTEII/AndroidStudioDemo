package com.tzw.textview;

import android.app.Activity;
import android.view.View;

import com.tzw.textview.Util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity activity;

    public MyClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(activity, "click...");
    }
}

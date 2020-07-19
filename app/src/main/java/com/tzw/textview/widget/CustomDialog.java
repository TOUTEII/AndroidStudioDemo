package com.tzw.textview.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tzw.textview.R;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView mTvTitle,mTvMessage,mTvCancel,mTvConfirm;

    private IOnCancelListener cancelListener;
    private IOnComfirmListener comfirmListener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMesssage(String messsage) {
        this.messsage = messsage;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener=listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnComfirmListener listener) {
        this.confirm = confirm;
        this.comfirmListener=listener;
        return this;
    }

    private String title,messsage,cancel,confirm;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context,int themeId) {
        super(context,themeId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        WindowManager m=getWindow().getWindowManager();
        Display d=m.getDefaultDisplay();
        WindowManager.LayoutParams p=getWindow().getAttributes();
        Point size=new Point();
        d.getSize(size);
        p.width=(int) (size.x *0.8);
        getWindow().setAttributes(p);


        mTvTitle=findViewById(R.id.tv_title);
        mTvMessage=findViewById(R.id.tv_message);
        mTvCancel=findViewById(R.id.tv_cancel);
        mTvConfirm=findViewById(R.id.tv_comfirm);
        if(!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(messsage)) {
            mTvMessage.setText(messsage);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }

        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_cancel:
                if(cancelListener!=null){
                    cancelListener.onCancel(this);

                }
                dismiss();
                break;
            case R.id.tv_comfirm:
                if(comfirmListener!=null){
                    comfirmListener.onComfirm(this);
                }
                dismiss();
                break;
        }
    }

    public  interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public  interface IOnComfirmListener{
        void onComfirm(CustomDialog dialog);
    }
}

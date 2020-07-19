package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzw.textview.Util.ToastUtil;
import com.tzw.textview.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);


        mBtnDialog=findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("Info").setMesssage("Do you sure to delete?").setCancel("cancel", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"cancel...");
                    }
                }).setConfirm("OK", new CustomDialog.IOnComfirmListener() {
                    @Override
                    public void onComfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"comfirm...");
                    }
                }).show();
            }
        });
    }
}

package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.tzw.textview.Util.ToastUtil;

public class ProgressVeiwActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button mBtnStart,mBtnProgressDialog1,mBtnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_veiw);
        mPb3=findViewById(R.id.pd3);
        mBtnStart=findViewById(R.id.btn_start);
        mBtnProgressDialog1=findViewById(R.id.btn_progress_dialog1);
        mBtnProgressDialog2=findViewById(R.id.btn_progress_dialog2);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);

            }
        });
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressVeiwActivity.this);
                progressDialog.setTitle("Warning");
                progressDialog.setMessage("Loading");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressVeiwActivity.this,"canceled");
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressVeiwActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("info");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                progressDialog.show();
            }
        });

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            if(mPb3.getProgress()<100){
                handler.postDelayed(runnable,500);
            }else{
                ToastUtil.showMsg(ProgressVeiwActivity.this,"successfully install");
            }
        }
    };

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}

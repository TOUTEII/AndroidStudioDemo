package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.tzw.textview.Util.ToastUtil;

public class HandActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand);
//        mHandler=new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(HandActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);

        mHandler =new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(HandActivity.this,"thread success");
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run(){
                super.run();
                Message message=new Message();
                message.what=1;
                mHandler.sendMessage(message);
            }
        }.start();
    }
}
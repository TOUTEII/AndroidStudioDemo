package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tzw.textview.Util.ToastUtil;

public class PopActivity extends AppCompatActivity {

    private Button mBtnPop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        mBtnPop=findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView=view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopActivity.this,"nice");
                    }
                });
                mPop=new PopupWindow(view,mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mBtnPop.setFocusable(true);
                mPop.showAsDropDown(mBtnPop);
            }
        });
  }
}

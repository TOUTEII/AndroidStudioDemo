package com.tzw.textview.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tzw.textview.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private AFragment aFragment;
    private TextView mTextView;
//    private BFragment bFragment;
//    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTextView=findViewById(R.id.tv_title);
//        mBtnChange=findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                if(bFragment==null){
//                    bFragment=new BFragment();
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//            }
//        });

        aFragment=AFragment.newInstance("l am values");

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();
    }

    public void setData(String text){
        mTextView.setText(text);
    }


    @Override
    public void onClick(String text) {
        mTextView.setText(text);
    }
}

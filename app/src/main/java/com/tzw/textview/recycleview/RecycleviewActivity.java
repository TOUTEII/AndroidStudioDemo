package com.tzw.textview.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzw.textview.R;
import com.tzw.textview.gridview.GridViewActivity;

public class RecycleviewActivity extends AppCompatActivity {

    private Button mBtnLinear,mBtnHor,mBtnGrid,mBtnPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        mBtnLinear=findViewById(R.id.btn_linear);
        mBtnHor=findViewById(R.id.btn_hor);
        mBtnGrid=findViewById(R.id.btn_gridrv);
        mBtnPu=findViewById(R.id.btn_pu);
        mBtnLinear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(RecycleviewActivity.this,LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleviewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleviewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleviewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}

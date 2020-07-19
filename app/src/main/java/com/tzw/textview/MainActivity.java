package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzw.textview.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI,mBtnEvent,mBtnAnime,mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI=findViewById(R.id.btn_ui);
        mBtnEvent=findViewById(R.id.btn_event);
        mBtnAnime=findViewById(R.id.btn_anime);
        mBtnData=findViewById(R.id.btn_data);
        OnClick onClick=new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnAnime.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent=null;
            switch(v.getId()){
                case R.id.btn_ui:
                    intent=new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent=new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_anime:
                    intent=new Intent(MainActivity.this,ObjectAnimActivityActivity.class);
                    break;
                case R.id.btn_data:
                    intent=new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

package com.tzw.textview.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzw.textview.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreences,mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreences = findViewById(R.id.btn_sharedprefernces);
        mBtnFile=findViewById(R.id.btn_file);
        mBtnSharedPreences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.btn_sharedprefernces:
                intent=new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                startActivity(intent);
            case R.id.btn_file:
                intent=new Intent(DataStorageActivity.this,FileActivity.class);
                startActivity(intent);

        }
    }
}
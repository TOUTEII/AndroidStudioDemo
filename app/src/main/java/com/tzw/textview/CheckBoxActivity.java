package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb5,mCb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCb5=findViewById(R.id.cb_5);
        mCb6=findViewById(R.id.cb_6);

        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"5checked":"5not check",Toast.LENGTH_SHORT).show();
            }
        });

        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"6checked":"6not check",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

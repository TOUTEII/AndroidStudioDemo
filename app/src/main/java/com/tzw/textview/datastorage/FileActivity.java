package com.tzw.textview.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tzw.textview.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private SharedPreferences.Editor mEditor;
    private final String mfileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_show);


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    save(mEtName.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());

            }
        });


    }

    //save Message
    private void save(String content) throws Exception {
        FileOutputStream fileOutputStream = null;
//        fileOutputStream = openFileOutput(mfileName, MODE_PRIVATE);
        File dir=new File(getExternalFilesDir(null),"TEST");
        if(!dir.exists()){
            dir.mkdir();
        }

        File file=new File(dir,mfileName);
        if(!file.exists()){
            file.createNewFile();
        }
        fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

    ;

    //read Value
    private String read() {
        FileInputStream fileInputStream =null;
        try {
//            fileInputStream = openFileInput(mfileName);
            File file=new File(getExternalFilesDir(null).getAbsolutePath()+File.separator+"TEST",mfileName);
            fileInputStream=new FileInputStream(file);
            byte[] buff=new byte[1024];
            StringBuilder sb=new StringBuilder("");
            int len = 0;
            while((len=fileInputStream.read(buff))>0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
package com.tzw.textview.Jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzw.textview.R;
import com.tzw.textview.Util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","----OnCreate----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();
        mBtnJump=findViewById(R.id.btn_jump);
        mBtnJump2=findViewById(R.id.btn_jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //現す1
                Intent intent=new Intent(AActivity.this,BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","tzw");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);

                //現す2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //現す3
//                Intent intent=new Intent();
//                intent.setClassName(AActivity.this,"com.tzw.textview.Jump.BActivity");
//                startActivity(intent);

                //現す4
//

                //yingshi
//                Intent intent=new Intent();
//                intent.setAction("com.tzw.textview.BActivity");
//                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        Log.d("AActivity","----onNewIntent----");
        Log.d("AActivity","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try{
        ActivityInfo info=getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        Log.d("AActivity",info.taskAffinity);
    }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
}

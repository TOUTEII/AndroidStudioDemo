package com.tzw.textview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tzw.textview.Util.ToastUtil;

public class DiaLogActivity extends AppCompatActivity {

    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4,mBtnDialog5;
    private EditText etUserName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_log);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5=findViewById(R.id.btn_dialog5);
        OnClick click=new OnClick();
        mBtnDialog1.setOnClickListener(click);
        mBtnDialog2.setOnClickListener(click);
        mBtnDialog3.setOnClickListener(click);
        mBtnDialog4.setOnClickListener(click);
        mBtnDialog5.setOnClickListener(click);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DiaLogActivity.this);
                    builder.setTitle("answer the question").setMessage("what do you think of this app?").setIcon(R.drawable.forbidden).setPositiveButton("good", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DiaLogActivity.this,"thankyou");
                        }
                    }).setNeutralButton("so so", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DiaLogActivity.this,"have more try");
                        }
                    }).setNegativeButton("no good", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DiaLogActivity.this,"So bad");
                        }
                    }).show();

                    //builder.setMessage("what do you think of this app?");

                    break;
                case R.id.btn_dialog2:
                    final String[] sexArray=new String[]{"man","feman"};
                    AlertDialog.Builder builder1=new AlertDialog.Builder(DiaLogActivity.this);
                    builder1.setTitle("select your sex").setItems(sexArray, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DiaLogActivity.this,sexArray[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] sexArray2=new String[]{"man","feman"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(DiaLogActivity.this);
                    builder2.setTitle("select your sex").setSingleChoiceItems(sexArray2, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DiaLogActivity.this,sexArray2[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] sexArray3=new String[]{"singing","dancing","coding"};
                    boolean[] isSelected=new boolean[]{false,false,true};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(DiaLogActivity.this);
                    builder3.setTitle("choose your interest").setMultiChoiceItems(sexArray3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DiaLogActivity.this,sexArray3[which]+":"+isChecked);
                        }
                    }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder4=new AlertDialog.Builder(DiaLogActivity.this);
                    View view=LayoutInflater.from(DiaLogActivity.this).inflate(R.layout.layout_dialog,null);

                    etUserName=view.findViewById(R.id.et_username);

                    password=view.findViewById(R.id.et_password);

                    Button btnLogin=view.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String username="";
                            String pd="";
                            username=etUserName.getText().toString();
                            pd=password.getText().toString();
                            ToastUtil.showMsg(DiaLogActivity.this,"id:"+username+",pd:"+pd);
                        }
                    });

                    builder4.setTitle("login first").setView(view).show();
                    break;
            }
        }
    }

}

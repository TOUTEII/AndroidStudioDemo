package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tzw.textview.Jump.AActivity;
import com.tzw.textview.ListView.ListViewActivity;
import com.tzw.textview.fragment.ContainerActivity;
import com.tzw.textview.gridview.GridViewActivity;
import com.tzw.textview.recycleview.RecycleviewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnGridView;
    private Button mBtnListView;
    private Button mBtnRv;
    private Button mBtnWebView;
    private Button mBtnToastView;
    private Button mBtnDiaLogView;
    private Button mBtnProgressView;
    private Button mBtnCustomDialogView;
    private Button mBtnPopView;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnRv = findViewById(R.id.btn_recycleview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToastView = findViewById(R.id.btn_toastview);
        mBtnDiaLogView = findViewById(R.id.btn_dialogview);
        mBtnProgressView = findViewById(R.id.btn_progressview);
        mBtnCustomDialogView = findViewById(R.id.btn_customdialogview);
        mBtnPopView = findViewById(R.id.btn_popview);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycleview);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment=findViewById(R.id.btn_fragment);
        setListeners();

    }

    private void setListeners() {
        onClick onClick = new onClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnRv.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToastView.setOnClickListener(onClick);
        mBtnDiaLogView.setOnClickListener(onClick);
        mBtnProgressView.setOnClickListener(onClick);
        mBtnCustomDialogView.setOnClickListener(onClick);
        mBtnPopView.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);

    }

    private class onClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, imageActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_recycleview:
                    intent = new Intent(UIActivity.this, RecycleviewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebVeiwActivity.class);
                    break;
                case R.id.btn_toastview:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialogview:
                    intent = new Intent(UIActivity.this, DiaLogActivity.class);
                    break;
                case R.id.btn_progressview:
                    intent = new Intent(UIActivity.this, ProgressVeiwActivity.class);
                    break;
                case R.id.btn_customdialogview:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popview:
                    intent = new Intent(UIActivity.this, PopActivity.class);
                    break;
                case R.id.btn_lifecycleview:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}

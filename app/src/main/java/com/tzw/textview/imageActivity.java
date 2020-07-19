package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class imageActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4=findViewById(R.id.iv_4);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590679355707&di=c5aef55b4639a27de0c5ddbbd4b6210d&imgtype=0&src=http%3A%2F%2Fpp.qn.img-space.com%2Fg2%2FM00%2F06%2F5C%2FCg-4k1henG2ILcQJAAMdbxnplooAAJ3twKWx-kAAx2H995.jpg%3FimageView2%2F2%2Fw%2F1200%2Fq%2F100%2Fignore-error%2F1%2F").into(mIv4);

    }

}

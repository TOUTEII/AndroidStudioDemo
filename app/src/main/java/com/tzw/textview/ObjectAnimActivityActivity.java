package com.tzw.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ObjectAnimActivityActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim_activity);
        tvTest=findViewById(R.id.tv);

        //tvTest.animate().translationYBy(500).setDuration(2000).start();
        // tvTest.animate().translationYBy(view.get...).setDuration(2000).start();
        //tvTest.animate().alpha(0).setDuration(2000).start();

//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //valueAnimator实际的值
//                Log.d("test",animation.getAnimatedValue()+"");
//                //动画的进度0-1
//                Log.d("test",animation.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(tvTest,"translationY",0,500,200,300,800,300,800,300,800,300);
        objectAnimator.setDuration(2000);
//         valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        objectAnimator.start();

    }
}
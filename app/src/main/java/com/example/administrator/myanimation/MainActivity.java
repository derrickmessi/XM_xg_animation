package com.example.administrator.myanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myanimation.view.MySurfaceView;

import java.util.ArrayList;
import java.util.List;


import static android.R.attr.delay;


/**
 * Created by zz on 2017/10/17.
 */

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv,tv_test;
    private RelativeLayout rl_main;
    private static final String TIMES = "times";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new MySurfaceView(this));
        setContentView(R.layout.activity_main);
        rl_main = (RelativeLayout) findViewById(R.id.rl_main);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);
        tv_test = (TextView) findViewById(R.id.tv_test);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        rl_main.addView(new MySurfaceView(this, width, height - 180));
        floatAnim(tv1, 20f, 30f, 2500);
        floatAnim(tv2, -30f, -30f, 2000);
        floatAnim(tv4, 30f, 10f, 3000);
        floatAnim(tv3, 5f, 10f, 2000);
    }

    private void floatAnim(View view, float x, float y, long t) {
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator translationXAnim = ObjectAnimator.ofFloat(view, "translationX", -x, x, -x);
        translationXAnim.setDuration(t);
        translationXAnim.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        translationXAnim.setRepeatMode(ValueAnimator.RESTART);
        translationXAnim.start();
        animators.add(translationXAnim);
        ObjectAnimator translationYAnim = ObjectAnimator.ofFloat(view, "translationY", -y, y, -y);
        translationYAnim.setDuration(2500);
        translationYAnim.setRepeatCount(ValueAnimator.INFINITE);
        translationYAnim.setRepeatMode(ValueAnimator.RESTART);
        translationYAnim.start();
        animators.add(translationYAnim);

        AnimatorSet btnSexAnimatorSet = new AnimatorSet();
        btnSexAnimatorSet.playTogether(animators);
        btnSexAnimatorSet.setStartDelay(delay);
        btnSexAnimatorSet.start();
    }


}

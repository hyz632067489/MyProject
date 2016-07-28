package com.hyz.myproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;

import com.hyz.myproject.R;
import com.hyz.myproject.ui.base.BaseActivity;

/**
 * Created by hyz on 2016/7/28.
 * powered by company
 */
public class StartActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mCurrentActivity,MainActivity.class));
                mCurrentActivity.finish();
            }
        },2500);

    }

    private void startAnimation() {
        AlphaAnimation start_anima = new AlphaAnimation(0.1f, 1.0f);
        start_anima.setDuration(2500);
        findViewById(android.R.id.content).startAnimation(start_anima);
    }
}

package com.hyz.myproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.hyz.myproject.R;
import com.hyz.myproject.ui.base.BaseActivity;
import com.hyz.myproject.ui.fragment.FindFragment;
import com.hyz.myproject.ui.fragment.MeFragment;
import com.hyz.myproject.ui.fragment.SlidingTabFragment;

public class MainActivity extends BaseActivity {

    private final int LOGIN_CODE = 100;
    RadioGroup mRg;

    private FindFragment mFindFragment;
    private SlidingTabFragment mTouTiaoFrament;
    private MeFragment mMeFragment;

    //记录底部选中的按钮
    byte mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindFragment = FindFragment.newInstance();
        addFragment(mFindFragment);

        initUI();

    }

    private void initUI() {
        mRg = findView(R.id.rg);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbFind:
                        mCurrentIndex = 0;
                        showFragment(mFindFragment);
                        break;
                    case R.id.rbToutiao:
                        mCurrentIndex = 1;
                        if(mTouTiaoFrament == null){
                            mTouTiaoFrament = new SlidingTabFragment();
                        }
                        showFragment(mTouTiaoFrament);
                        break;
                    case R.id.rbMe:
                        mCurrentIndex = 2;
                        if(mMeFragment == null){
                            mMeFragment = new MeFragment();
                            addFragment(mMeFragment);
                        }
                        showFragment(mMeFragment);
                        break;
                }
            }
        });
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flComtent, fragment);
        transaction.commit();
    }


    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.hide(mFindFragment);
        if(mTouTiaoFrament != null ){
            transaction.hide(mTouTiaoFrament);
        }
        if(mMeFragment != null){
            transaction.hide(mMeFragment);
        }
        transaction.show(fragment);
        transaction.commit();
    }




}

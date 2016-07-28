package com.hyz.myproject.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyz.myproject.ui.base.BaseFragment;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class FindFragment extends BaseFragment {


    public FindFragment(){

    }

    public static FindFragment newInstance()
    {
        return new FindFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

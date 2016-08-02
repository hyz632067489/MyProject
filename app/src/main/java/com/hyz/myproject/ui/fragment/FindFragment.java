package com.hyz.myproject.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hyz.myproject.R;
import com.hyz.myproject.ui.base.BaseFragment;

import static android.R.attr.id;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class FindFragment extends BaseFragment {


      Button btnN1,btnN2,btnN3,btnN4;


    public FindFragment(){

    }

    public static FindFragment newInstance()
    {
        return new FindFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find,null);
        btnN1 = findView(view,R.id.btn_1);
        btnN2 = findView(view,R.id.btn_2);
        btnN3 = findView(view,R.id.btn_3);
        btnN4 = findView(view,R.id.btn_4);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


    public void OnClick(){

        switch (id){
            case R.id.btn_1:
            break;
        }
     }
}

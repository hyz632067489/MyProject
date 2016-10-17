package com.hyz.myproject.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hyz.myproject.R;
import com.hyz.myproject.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 画图板
 * Created by hyz on 2016/10/10.
 * powered by company
 */

public class DrawingBoardActivity extends BaseActivity {



    @BindView(R.id.tv_draw)
    MyDrawingView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

    }


    @OnClick({R.id.btn_draw})
    public void btnOnClick(View view) {

        switch (view.getId()) {
            case R.id.btn_draw:
                myView.clear();
                toast("清除画板");
                break;
        }
    }
}

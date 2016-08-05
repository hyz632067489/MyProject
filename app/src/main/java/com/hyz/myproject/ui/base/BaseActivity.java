package com.hyz.myproject.ui.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyz.myproject.ActivityManager;
import com.hyz.myproject.R;
import com.hyz.myproject.dialog.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class BaseActivity extends AppCompatActivity {

    protected Activity mCurrentActivity;
    protected LoadingDialog mLoadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState );

        ActivityManager.getActivityManager().pushActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏

        ButterKnife.bind(this);

        mCurrentActivity = this;
    }

    /**
     * 初始化标题，必须在setContentView后调用
     *
     * @param titleResurceId 标题资源id
     */
    public void initTitle(int titleResurceId){

        TextView title = (TextView) findViewById(R.id.top_title);
        title.setText(titleResurceId);
        findViewById(R.id.top_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentActivity.finish();
            }
        });
    }

    /**
     * 初始化标题,必须在setContentView后调用
     *
     * @param title
     */
    public void initTitle(String title){
        TextView tvTitle = (TextView) findViewById(R.id.top_title);
        tvTitle.setText(title);
        findViewById(R.id.top_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentActivity.finish();
            }
        });
    }

    /**
     * 设置标题和右边按钮图片
     *
     * @param titleResurceId
     * @param topRightIbSrc
     */
    public void initTitle(int titleResurceId, int topRightIbSrc){
        ImageView topRightIb = (ImageView) findViewById(R.id.top_right);
        topRightIb.setImageResource(topRightIbSrc);

        TextView title = (TextView) findViewById(R.id.top_title);
        title.setText(titleResurceId);

        findViewById(R.id.top_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentActivity.finish();
            }
        });
    }

    public void toast(String message) {
        Toast.makeText(mCurrentActivity, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 简化版的findviewbyid
     *
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends  View> T findView(int viewId){
        T view = (T) findViewById(viewId);
        return view;
    }

    /**
     * 显示加载dialog
     *
     * @param message messageIsChanged message是否已经改变
     */
    public void showLoading(String message){
        if(mLoadingDialog == null){
            mLoadingDialog = new LoadingDialog(mCurrentActivity,message);
        }
        mLoadingDialog.textView.setText(message);
        mLoadingDialog.show();
    }

    /**
     * 隐藏
     */
    public void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getActivityManager().popActivity(this);
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
    }

}

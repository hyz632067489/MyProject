package com.hyz.myproject.ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hyz.myproject.dialog.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class BaseFragment extends Fragment {

    protected LoadingDialog mLoadingDialog;

    protected FragmentActivity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
    }

    public <T extends View> T findView(View contentView, int viewId) {
        return (T) contentView.findViewById(viewId);
    }

    /**
     * 显示加载dialog
     *
     * @param message messageIsChanged message是否已经改变
     */

    protected void showLoading(String message) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(getActivity(), message);
        }
        mLoadingDialog.show();
    }

    /**
     * 隐藏
     */
    protected void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    protected void toast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}

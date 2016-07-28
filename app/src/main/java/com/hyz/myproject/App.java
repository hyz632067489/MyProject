package com.hyz.myproject;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;

import com.hyz.myproject.constant.AppConstant;
import com.hyz.myproject.constant.AppInfo;
import com.hyz.myproject.constant.Common;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        getScreenInfo();
        getAppInfo();
//        getChannelName();
    }


    /**
     * 获取渠道名
     */
    private void getChannelName() {
        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            Common.CHANNEL_NAME = info.metaData.getString("CHANNEL");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取app信息
    private void getAppInfo() {
        AppInfo.cachePath = getCacheDir().getPath();

        try {
            AppInfo.pakageName = this.getPackageName();
            AppInfo.versionName = this.getPackageManager().getPackageInfo(AppInfo.pakageName, 0).versionName;
            AppInfo.versionCode = this.getPackageManager().getPackageInfo(AppInfo.pakageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取手机屏幕信息
    private void getScreenInfo() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        AppConstant.Screen.DENSITY = dm.density;
        AppConstant.Screen.densityDpi = dm.densityDpi;
        AppConstant.Screen.WIDTH = dm.widthPixels;
        AppConstant.Screen.HEIGHT = dm.heightPixels;
    }
}

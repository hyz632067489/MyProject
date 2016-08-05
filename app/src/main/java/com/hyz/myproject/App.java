package com.hyz.myproject;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;

import com.hyz.myproject.constant.AppConstant;
import com.hyz.myproject.constant.AppInfo;
import com.hyz.myproject.constant.Common;

import okhttplib.CacheLevel;
import okhttplib.CacheType;
import okhttplib.OkHttpUtil;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class App extends Application{

    public static App myApp;

    public static  App getApplication(){
        return myApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;

        getScreenInfo();
        getAppInfo();
//        getChannelName();

        OkHttpUtil.init(this)
                .setConnectTimeout(30)//超时时间设置
                .setMaxCacheSize(10 * 1024 * 1024)//设置缓存空间大小
                .setCacheLevel(CacheLevel.FIRST_LEVEL)//缓存等级
                .setCacheType(CacheType.NETWORK_THEN_CACHE)//缓存类型
                .setShowHttpLog(true)//显示请求日志
                .setShowLifecycleLog(true)
                .setRetryOnConnectionFailure(true)
                .build();


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
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

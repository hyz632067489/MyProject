package com.hyz.myproject;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class ActivityManager {

    private static Stack<Activity> activityStack;
    private static ActivityManager instance = new ActivityManager();

    private ActivityManager(){

    }
    public static  ActivityManager getActivityManager(){
        return instance;
    }

    public void popActivity(Activity activity){
        if(activity != null){
            activity.finish();
            activityStack.remove(activity);
        }
    }

    public Activity currentActivity(){
        Activity activity = activityStack.lastElement();
        return activity;
    }

    public void pushActivity(Activity activity){
        if(activityStack == null ){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void popAllActivityExceptOne( Class cls){

        while (true){
            Activity activity = currentActivity();
            if(activity ==null){
                break;
            }
            if(activity.getClass().equals(cls)){
                break;
            }

            popActivity(activity);
        }
    }
}



package com.hyz.myproject.utils;


import android.util.Log;

import com.hyz.myproject.BuildConfig;


public class MLog {
    private static final Boolean LOG_OUT = BuildConfig.DEBUG;
    private static final int LENGTH = 5;

    public static int d(String TAG, String msg) {
        if (!LOG_OUT) {
            return -1;
        }
        return Log.d(TAG, msg);
    }

    public static int i(String TAG, String msg) {
        if (!LOG_OUT) {
            return -1;
        }
        return Log.i(TAG, msg);
    }

    public static int v(String TAG, String msg) {
        if (!LOG_OUT) {
            return -1;
        }
        return Log.v(TAG, msg);
    }

    public static int w(String TAG, String msg) {
        if (!LOG_OUT) {
            return -1;
        }
        return Log.w(TAG, msg);
    }

    public static int e(String TAG, String msg) {
        if (!LOG_OUT) {
            return -1;
        }
        return Log.e(TAG, msg);
    }

    public static int printStackTrace(String TAG) {
        if (!LOG_OUT) {
            return -1;
        }

        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();

        if (stackTraceElements != null) {
            MLog.d(TAG, "printStackTrace:");
            for (int i = 1; i < stackTraceElements.length; i++) {
                Log.d(TAG, stackTraceElements[i].toString());
            }
        }

        return 0;
    }

}

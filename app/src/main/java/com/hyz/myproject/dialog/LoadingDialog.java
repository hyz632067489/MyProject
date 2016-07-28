package com.hyz.myproject.dialog;

import android.content.Context;
import android.widget.TextView;

import com.hyz.myproject.R;

/**
 * Created by ${hyz} on 2016/7/28.
 */
public class LoadingDialog extends CustomDialog{

    public TextView textView;

    public LoadingDialog(Context context, String  message) {
        super(context, R.layout.dialog_loading);
        textView = (TextView) findViewById(R.id.message);
        textView.setText(message);
        setCanceledOnTouchOutside(false);
    }
}

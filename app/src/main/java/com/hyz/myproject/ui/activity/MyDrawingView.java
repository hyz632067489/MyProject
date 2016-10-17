package com.hyz.myproject.ui.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.hyz.myproject.R;

import static android.R.attr.path;

/**
 * 画板
 * Created by hyz on 2016/10/10.
 * powered by company
 */

public class MyDrawingView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener {

    Paint p = new Paint();
    Path path = new Path();

    public MyDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);

        p.setColor(getResources().getColor(R.color.colorAccent));
        p.setStyle(Paint.Style.STROKE);
        p.setTextSize(10);
        p.setAntiAlias(true);   //对画笔清理锯齿
        setOnTouchListener(this);
    }

    public void clear(){
        path.reset();//重置
        draw();
    }
    public void draw(){
        //锁定画布
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(getResources().getColor(R.color.white));
        canvas.drawPath(path,p);
        //解锁画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                draw();
            break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                draw();
                break;
        }
        return true;
    }
}

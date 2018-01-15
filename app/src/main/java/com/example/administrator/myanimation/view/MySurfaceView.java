package com.example.administrator.myanimation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zz on 2017/10/16.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Paint paint = new Paint();
    private Timer timer;
    private TimerTask task;
    //    private Bolls bolls;
    private int num = 0;
    private List<Bolls> bollsList;
    private int width;
    private int height;
    private Canvas canvas;

    public MySurfaceView(Context context, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
        paint.setColor(Color.parseColor("#eddfff"));
        getHolder().addCallback(this);
        setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);

//        bolls = new Bolls(this);
//        cx = bolls.getCx();
//        cy = bolls.getCy();
//        radius = bolls.getRadius();
        bollsList = new ArrayList<>();
        for (int i = 1; i < 120; i++) {
            if (i < 30) {
                float x = (float) (width / 2 + (4 * Math.random() * 100 + 400) * Math.sin(i * 3 * Math.PI / 180));
                float y = (float) (height / 2 + (4 * Math.random() * 100 + 400) * Math.cos(i * 3 * Math.PI / 180));
                bollsList.add(new Bolls(this, x, y, 4, width, height));
            }
            else if (i > 30 && i < 60) {
                float x = (float) (width / 2 + (4 * Math.random() * 100 + 400) * Math.sin((90 + (i - 30) * 3) * Math.PI / 180));
                float y = (float) (height / 2 + (4 * Math.random() * 100 + 400) * Math.cos((90 + (i - 30) * 3) * Math.PI / 180));
                bollsList.add(new Bolls(this, x, y, 1, width, height));
            }
            else if (i > 60 && i < 90) {
                float x = (float) (width / 2 + (4 * Math.random() * 100 + 400) * Math.sin((180 + (i - 60) * 3) * Math.PI / 180));
                float y = (float) (height / 2 + (4 * Math.random() * 100 + 400) * Math.cos((180 + (i - 60) * 3) * Math.PI / 180));
                bollsList.add(new Bolls(this, x, y, 2, width, height));
            }
            else {
                float x = (float) (width / 2 + (4 * Math.random() * 100 + 400) * Math.sin((270 + (i - 90) * 3) * Math.PI / 180));
                float y = (float) (height / 2 + (4 * Math.random() * 100 + 400) * Math.cos((270 + (i - 90) * 3) * Math.PI / 180));
                bollsList.add(new Bolls(this, x, y, 3, width, height));
            }
        }

    }

    public void draw() {
        // 锁定画布
        canvas = getHolder().lockCanvas();
        // 绘制图形
        if (canvas ==null) {
            stopTimer();
            return;
        }
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);// 初始化画布
//            bolls=new Bolls(this);
//        canvas.drawCircle(bolls.getCx() , bolls.getCy() , bolls.getRadius(), paint);
        for (Bolls item : bollsList) {
            canvas.drawCircle(item.getCx(), item.getCy(), item.getRadius(), paint);
//            bolls=new Bolls(this);
            item.draw();
        }
//        bolls.draw();

        getHolder().unlockCanvasAndPost(canvas);// 解锁画布
    }

    public void startTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                draw();
//                num++;
            }
        };
        timer.schedule(task, 500, 50);
    }

    public void stopTimer() {
        timer.cancel();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
//        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }
}

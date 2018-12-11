package com.project.androidlife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class ViewGrid extends View {

    private final Handler handler = new Handler();
    private Timer timer = new Timer(false);
    private Paint paint;
    private CellGrid grid;

    private long maxSpeed = 500L;
    private long minSpeed = 20L;

    private boolean playing;

    private long tickDelay = 250L;

    private final Runnable tickTask = new Runnable() {
        @Override
        public void run() {
            if (playing) grid.tick();
            handler.postDelayed(tickTask, tickDelay);
        }
    };


    public ViewGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        playing = false;
        this.setBackgroundColor(0xFF000000);
        paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        grid = new CellGrid(80, 100);
        final ViewGrid instance = this;
        TimerTask refreshTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        instance.postInvalidate();
                    }
                });
            }
        };
        timer.schedule(refreshTask, 1,1);

        handler.postDelayed(tickTask, tickDelay);

//        TimerTask tickTask = new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (playing) grid.tick();
//                    }
//                });
//            }
//        };
//        timer.schedule(tickTask, 500,100);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        float gridSizeX = grid.getxSize();
        float gridSizeY = grid.getySize();
        float sizeX = canvas.getWidth()/gridSizeX;
        float sizeY = canvas.getHeight()/gridSizeY;
        for (int y = 0; y < gridSizeY; y++) {
            for (int x = 0; x < gridSizeX; x++) {
                if (grid.getGrid()[x][y]) {
                    canvas.drawRect(x*sizeX, y*sizeY, (x+1)*sizeX, (y+1)*sizeY, paint);
                }
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        invalidate();
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public CellGrid getGrid() { return this.grid; }

    public void setSpeed(float frac) {
        tickDelay = Math.max(minSpeed, (long) (((float)maxSpeed)*(1-frac)));
    }

}

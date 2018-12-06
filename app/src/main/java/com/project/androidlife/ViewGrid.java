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

    private int gridSizeX, gridSizeY;
    private float viewportSize;

    public ViewGrid(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(0xFF000000);
        paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        gridSizeX = 30;
        gridSizeY = 40;
        grid = new CellGrid(gridSizeX, gridSizeY);
        final ViewGrid instance = this;
//        grid.setCell(grid.getGrid(), 17, 17, true);
//        grid.setCell(grid.getGrid(), 18, 17, true);
//        grid.setCell(grid.getGrid(), 19, 17, true);
//        grid.setCell(grid.getGrid(), 19, 18, true);
//        grid.setCell(grid.getGrid(), 18, 19, true);
        grid.setCell(grid.getGrid(), 0, 0, true);
        grid.setCell(grid.getGrid(), 0, 1, true);
        grid.setCell(grid.getGrid(), 0, 2, true);
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

        TimerTask tickTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        grid.tick();
                    }
                });
            }
        };
        timer.schedule(tickTask, 3000,500);


    }

    @Override
    protected void onDraw(Canvas canvas) {

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

}

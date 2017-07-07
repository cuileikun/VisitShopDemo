package com.visitshopdemo.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：popular cui
 * 时间：2017/7/7 14:02
 * 功能:是否自动滑动的viewpager
 */
public class AutoScrollViewPager extends ViewPager {
    /**
     * 切换页面的时间间隔
     */
    private int interval = 10 *1000;
    /**
     * 处理任务的Handler
     */
    private Handler handler;
    /**
     * 是否需要自动切换
     */
    //modify by clk on
    private boolean needAutoScroll = true;
    //modify by clk off

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 根据需要的延时时间开始自动滚动
     * @param delay 首次开始等待时间
     */
    public void startScrollDelay(int delay) {
        stopScrollRightNow();
        if (!needAutoScroll){
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getAdapter() != null) {
                    int currentItem = getCurrentItem();
                    if (currentItem == getAdapter().getCount() - 1) {
                        currentItem = -1;
                    }
                    setCurrentItem(++currentItem);
                }
                handler.postDelayed(this, interval);
            }
        }, delay);

    }

    /**
     * 清空任务队列，停止滚动
     */
    public void stopScrollRightNow() {
        handler.removeCallbacksAndMessages(null);
    }

    /**
     * 立即开始自动滚动
     */
    public void startScrollRightNow() {
        startScrollDelay(0);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                //当手指触摸到屏幕时，切换任务停止
                if (needAutoScroll){
                    stopScrollRightNow();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                //当手指离开屏幕时，再次开始自动滚动
                if (needAutoScroll){
                    startScrollDelay(interval);
                }
                break;
            default:
                break;

        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 设置是否需要自动滚动
     * @param needAutoScroll
     */
    public void setNeedAutoScroll(boolean needAutoScroll) {
        if (this.needAutoScroll != needAutoScroll){
            this.needAutoScroll = needAutoScroll;
            startScrollRightNow();
        }
    }

    /**
     * 设置自动滚动时间间隔
     * @param interval
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }
}

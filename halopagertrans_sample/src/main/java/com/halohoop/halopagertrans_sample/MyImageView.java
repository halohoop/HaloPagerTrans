package com.halohoop.halopagertrans_sample;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.halohoop.halopagertrans.BaseTransformer;

import static android.content.ContentValues.TAG;

/**
 * Created by Pooholah on 2017/6/23.
 */

public class MyImageView extends AppCompatImageView implements BaseTransformer.OnStateChangeListener {

    private AnimationDrawable drawable;
    private AnimationDrawable drawable_s;
    private Drawable drawable_kneel;

    public MyImageView(Context context) {
        super(context);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        drawable_s = (AnimationDrawable) context.getDrawable(R.drawable.run_s);
        drawable = (AnimationDrawable) context.getDrawable(R.drawable.run);
        drawable_kneel = context.getDrawable(R.drawable.run_on_kneel);
    }

    @Override
    public void onStateChange(int progressState, float positon) {
        Log.i(TAG, "onStateChange: " + progressState);
        if (progressState <= BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE2) {
            //改成大跑
            setImageDrawable(drawable_kneel);
            drawable_s.stop();
            drawable.stop();
        } else if (progressState <= BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE3) {
            //改成大跑
            setImageDrawable(drawable);
            drawable_s.stop();
            drawable.start();
        } else if (progressState <= BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE7) {
            //小跑快速，一开始就回调
            setImageDrawable(drawable_s);
            drawable.stop();
            drawable_s.start();
        }
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        String s = "vv";
        if (visibility == View.INVISIBLE) {
            s = "INVISIBLE";
            stopAnim();
        } else if (visibility == View.GONE) {
            s = "GONE";
            stopAnim();
        } else if (visibility == View.VISIBLE) {
            s = "VISIBLE";
            restartAnim();
        }
        Log.i(TAG, "onWindowSystemUiVisibilityChanged: " + s);
    }

    /**
     * 表示谁被停止了
     */
    private boolean isDrawable_SRunningWhenViewGone = false;

    /**
     * call when view is invisible or gone
     */
    private void stopAnim() {
        if (drawable.isRunning()) {
            isDrawable_SRunningWhenViewGone = false;
            drawable.stop();
        }
        if (drawable_s.isRunning()) {
            isDrawable_SRunningWhenViewGone = true;
            drawable_s.stop();
        }
    }

    /**
     * call when view is visible
     */
    private void restartAnim() {
        if (isDrawable_SRunningWhenViewGone) {
            drawable_s.start();
        } else {
            drawable.start();
        }
    }

}

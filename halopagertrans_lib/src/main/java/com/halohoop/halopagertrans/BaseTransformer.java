package com.halohoop.halopagertrans;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import static com.halohoop.halopagertrans.BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE0;
import static com.halohoop.halopagertrans.BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE1;
import static com.halohoop.halopagertrans.BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE2;
import static com.halohoop.halopagertrans.BaseTransformer.OnStateChangeListener.PROGRESS_LEVEL_STATE3;

/**
 * Created by Pooholah on 2017/6/22.
 */

public abstract class BaseTransformer implements ViewPager.PageTransformer {

    protected static final int KEY = Integer.MAX_VALUE >> 1;

    /**
     * 是否将滑动数据作用于每个子View
     */
    private boolean mIsSplitChildViews = true;

    public BaseTransformer() {
        this.mIsSplitChildViews = true;
    }

    public BaseTransformer(boolean isSplitChildViews) {
        this.mIsSplitChildViews = isSplitChildViews;
    }

    @Override
    public void transformPage(View page, float position) {
        final View view = page;
        final float pos = position;
        //当Vp.setOffscreenPageLimit设置了大于等于2的时候，就会出现pos大于1的情况
        if (view != null && pos >= -1 && pos <= 1) {
            final float fraction = 1 - Math.abs(pos);

            transformPage(view, pos, fraction);

            if (mIsSplitChildViews) {
                if (view instanceof ViewGroup) {
                    final ViewGroup vg = ViewGroup.class.cast(view);
                    final int childCount = vg.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        reportProgressState(vg.getChildAt(i), fraction);
                        transformPageChilds(view, vg.getChildAt(i), i, pos, fraction);
                    }
                }
            }
        }
    }

    private void reportProgressState(Object obj, float fraction) {
        if (obj == null || !(obj instanceof OnStateChangeListener)) {
            return;
        }
        //判断状态更新mProgressLevelState
        int currProgressLevelState;
        if (fraction <= 0.25f) {
            currProgressLevelState = PROGRESS_LEVEL_STATE0;
        } else if (fraction <= 0.5f) {
            currProgressLevelState = PROGRESS_LEVEL_STATE1;
        } else if (fraction <= 0.75f) {
            currProgressLevelState = PROGRESS_LEVEL_STATE2;
        } else {
            currProgressLevelState = PROGRESS_LEVEL_STATE3;
        }
        if (mProgressLevelState != currProgressLevelState) {
            final OnStateChangeListener onStateChangeListener = (OnStateChangeListener) obj;
            mProgressLevelState = currProgressLevelState;
            //和上次不一样，回调OnStateChangeListener
            onStateChangeListener.onStateChange(mProgressLevelState);
        }
    }

    /**
     * 重写这个方法的时候，参数不一定需要全部使用，按需求使用
     *
     * @param page
     * @param position 本次滑动的位置-1-0-1，float
     * @param fraction 本次滑动的百分比0-1-0 float
     */
    protected void transformPage(View page, float position, float fraction) {
    }

    /**
     * 重写这个方法的时候，参数不一定需要全部使用，按需求使用
     *
     * @param parent
     * @param child
     * @param childIndex 子view的index
     * @param position   本次滑动的位置-1-0-1，float
     * @param fraction   本次滑动的百分比
     */
    protected void transformPageChilds(View parent, View child, int childIndex, float position, float fraction) {
    }

    private int mProgressLevelState = PROGRESS_LEVEL_STATE0;

    /**
     * 自定义View实现这个接口，就能够获得滑动到不同长度时候四种状态见
     * {@link BaseTransformer#reportProgressState(Object, float)} }
     */
    public interface OnStateChangeListener {
        int PROGRESS_LEVEL_STATE0 = 0;
        int PROGRESS_LEVEL_STATE1 = 1;
        int PROGRESS_LEVEL_STATE2 = 2;
        int PROGRESS_LEVEL_STATE3 = 3;

        /**
         * @param progressState PROGRESS_LEVEL_STATE0-3,four progress state.
         */
        void onStateChange(int progressState);
    }
}

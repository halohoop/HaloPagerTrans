package com.halohoop.halopagertrans.pages;

import android.view.View;

/**
 * Created by Pooholah on 2017/6/28.
 */

public class PageAlphaTransFormer extends BasePageTransFormer {

    /**
     * 退出是否需要alpha变化
     */
    private boolean isStartAlpha = true;
    /**
     * 进入是否需要alpha变化
     */
    private boolean isEndAlpha = true;

    /**
     * @param isEndAlpha   进入是否需要alpha变化
     * @param isStartAlpha 退出是否需要alpha变化
     */
    public PageAlphaTransFormer(boolean isEndAlpha, boolean isStartAlpha) {
        this.isStartAlpha = isStartAlpha;
        this.isEndAlpha = isEndAlpha;
    }

    public PageAlphaTransFormer() {
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        if (position < -1) {
            view.setAlpha(0);
        } else if (position <= 0) {//退出的时候
            if (isStartAlpha) {
                view.setAlpha(1 + position);
            } else {
                view.setAlpha(1);
            }
        } else if (position <= 1) {//进入的时候
            if (isEndAlpha) {
                view.setAlpha(1 - position);
            } else {
                view.setAlpha(1);
            }
        } else {
            view.setAlpha(0);
        }
    }
}

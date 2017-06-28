package com.halohoop.halopagertrans.pages;

import android.view.View;

/**
 * 挤压
 */
public class PageExtrudingTransformer extends BasePageTransFormer {

    private float extrudingRatio = 0.5f;

    public PageExtrudingTransformer() {
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        if (position < -1) {
            view.setPivotX(view.getMeasuredWidth() * extrudingRatio);
            view.setPivotY(view.getMeasuredHeight() * extrudingRatio);
            view.setScaleX(1);
        } else if (position <= 0) {
            view.setPivotX(view.getMeasuredWidth());
            view.setPivotY(0);
            view.setScaleX(1 + position);
        } else if (position <= 1) {
            view.setPivotX(0);
            view.setPivotY(0);
            view.setScaleX(1 - position);
        } else {
            view.setPivotX(view.getMeasuredWidth() * extrudingRatio);
            view.setPivotY(view.getMeasuredHeight() * extrudingRatio);
            view.setScaleX(1);
        }
    }
}

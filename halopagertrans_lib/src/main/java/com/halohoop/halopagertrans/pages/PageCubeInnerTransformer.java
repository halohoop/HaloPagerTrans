package com.halohoop.halopagertrans.pages;

import android.view.View;

/**
 * 立方体内部
 */
public class PageCubeInnerTransformer extends BasePageTransFormer {

    private static float MIN_SCALE = 0.5f;
    /**
     * 最小缩放率
     */
    private float minScaleRatio = MIN_SCALE;

    public PageCubeInnerTransformer() {
    }

    public PageCubeInnerTransformer(float minScaleRatio) {
        this.minScaleRatio = minScaleRatio;
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        if (position == 0) {
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position < 0) {
            //position   :-1 <-- -0.5 <-- 0
            //fraction   : 0 <--  0.5 <-- 1
            //factor     : 1     最小     1
            float factor = position <= -0.5f ?
                    1 - fraction * (1 - minScaleRatio)
                    : 1 - (1 - fraction) * (1 - minScaleRatio);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() * 0.5f);
            view.setRotationY(-30f * position);
            view.setScaleX(factor);
            view.setScaleY(factor);
        } else if (position <= 1) {
            //position: 0 <-- 0.5 <-- 1
            //fraction: 1 <-- 0.5 <-- 0
            //factor  : 1     最小    1
            float factor = position >= 0.5 ?
                    1 - fraction * (1 - minScaleRatio)
                    : 1 - (1 - fraction) * (1 - minScaleRatio);
            view.setPivotX(0);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setRotationY(-30f * position);
            view.setScaleX(factor);
            view.setScaleY(factor);
        }
    }

}

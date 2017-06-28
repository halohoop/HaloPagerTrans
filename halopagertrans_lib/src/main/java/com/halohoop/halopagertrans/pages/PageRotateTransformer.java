package com.halohoop.halopagertrans.pages;

import android.view.View;

public class PageRotateTransformer extends BasePageTransFormer {

    private int rotateDegree = 15;
    /**
     * 旋转中心，百分比的形式
     */
    private float rotatePivotXRatio = 0.5f;
    private float rotatePivotYRatio = 1f;

    public PageRotateTransformer() {
    }

    public PageRotateTransformer(int rotateDegree) {
        this.rotateDegree = rotateDegree;
    }

    public PageRotateTransformer(int rotateDegree, float rotatePivotXRatio, float rotatePivotYRatio) {
        this.rotateDegree = rotateDegree;
        this.rotatePivotXRatio = rotatePivotXRatio;
        this.rotatePivotYRatio = rotatePivotYRatio;
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        if (position < -1) {
        } else if (position <= 0) {
            view.setPivotX(view.getWidth() * (1 - rotatePivotXRatio));
            view.setPivotY(view.getHeight() * rotatePivotYRatio);
            view.setRotation(rotateDegree * position);
        } else if (position <= 1) {
            view.setPivotX(view.getWidth() * rotatePivotXRatio);
            view.setPivotY(view.getHeight() * rotatePivotYRatio);
            view.setRotation(rotateDegree * position);
        } else {
        }
    }

}

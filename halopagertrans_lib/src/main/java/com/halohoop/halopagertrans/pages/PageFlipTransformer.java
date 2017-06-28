package com.halohoop.halopagertrans.pages;

import android.view.View;

public class PageFlipTransformer extends BasePageTransFormer {

    private final static float MIN_SCALE = 0.9f;
    private float minScale = MIN_SCALE;
    private float rotateDegree = 15f;

    public PageFlipTransformer() {
    }

    public PageFlipTransformer(float minScale, float rotateDegree) {
        this.minScale = minScale;
        this.rotateDegree = rotateDegree;
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        if (position <= 1 && position >= -1) {
            view.setScaleX(Math.max(minScale, 1 - Math.abs(position)));
            view.setScaleY(Math.max(minScale, 1 - Math.abs(position)));
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setRotationY(-position * rotateDegree);
        }
    }
}
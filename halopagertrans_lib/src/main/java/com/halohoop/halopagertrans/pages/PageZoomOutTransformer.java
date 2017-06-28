package com.halohoop.halopagertrans.pages;

import android.view.View;

public class PageZoomOutTransformer extends BasePageTransFormer {
    private static float MIN_SCALE = 0.85f;

    /**
     * 最小缩放率
     */
    private float minScaleRatio = MIN_SCALE;

    public PageZoomOutTransformer() {
    }

    public PageZoomOutTransformer(float minScaleRatio) {
        this.minScaleRatio = minScaleRatio;
    }

    @Override
    protected void transformPage(View view, float position, float fraction) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setTranslationX(0);
        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to
            // shrink the page as well
            float scaleFactor = Math.max(minScaleRatio, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }
            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setTranslationX(0);
        }
    }
}
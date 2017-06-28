package com.halohoop.halopagertrans.pages;

import android.view.View;

/**
 * 普通vp滑动
 */
public class PageDefaultTransformer extends BasePageTransFormer {

    @Override
    protected void transformPage(View view, float position, float fraction) {
        view.setAlpha(1);
        view.setTranslationX(0);
        view.setTranslationY(0);
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(1);
        view.setScaleY(1);
        view.setRotation(0);
    }

}

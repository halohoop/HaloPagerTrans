package com.halohoop.halopagertrans.pages;

import android.view.View;

public class PageInRightDownTransformer extends BasePageTransFormer {

    @Override
    protected void transformPage(View view, float position, float fraction) {
        int pageHeight = view.getHeight();
        if (position < -1) {
            view.setAlpha(1);
            view.setTranslationY(0);
        } else if (position <= 0) {
            view.setTranslationY(pageHeight * position);
            view.setAlpha(1 + position);

            // ViewHelper.setTranslationY(view, pageHeight * -position);
            // ViewHelper.setAlpha(view, 1 + position);
        } else if (position <= 1) {
            view.setTranslationY(view.getHeight() * position);
            view.setAlpha(1 - position);

            // ViewHelper.setTranslationY(view, pageHeight * -position);
            // ViewHelper.setAlpha(view, 1 - position);
        } else {
            view.setTranslationY(0);
            view.setAlpha(1);
        }
    }

}

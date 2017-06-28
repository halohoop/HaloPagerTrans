package com.halohoop.halopagertrans.childs;

import android.view.View;

import com.halohoop.halopagertrans.BaseTransformer;

/**
 * Created by Pooholah on 2017/6/22.
 */

public class ChildsAlphaTransformer extends BaseChildsTransformer {

    /**
     * 最小的透明度
     */
    public static final int KEY_MIN_ALPHA = KEY + 20;

    @Override
    protected void transformPage(View parent, View child, int childIndex, float position, float fraction) {
        final Object tagMinAlpha = child.getTag(KEY_MIN_ALPHA);
        if (tagMinAlpha != null) {
            final float _tagMinAlpha = (float) tagMinAlpha;
            child.setAlpha(Math.max(_tagMinAlpha, fraction));
        } else {//do nothing
        }
    }
}

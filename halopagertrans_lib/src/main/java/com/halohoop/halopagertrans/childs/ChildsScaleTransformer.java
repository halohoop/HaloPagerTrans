package com.halohoop.halopagertrans.childs;

import android.view.View;

/**
 * Created by Pooholah on 2017/6/22.
 */

public class ChildsScaleTransformer extends BaseChildsTransformer {

    public static final int KEY_MIN_SCALE_X = KEY + 10;
    public static final int KEY_MIN_SCALE_Y = KEY_MIN_SCALE_X + 1;
    public static final int KEY_SCALE_PIVOTX = KEY_MIN_SCALE_X + 2;
    public static final int KEY_SCALE_PIVOTY = KEY_MIN_SCALE_X + 3;
    public static final float DEFAULT_MIN_SCALE = 0;

    @Override
    protected void transformPageChilds(View parent, View child, int childIndex, float position, float fraction) {
        final Object tagPivotX = child.getTag(KEY_SCALE_PIVOTX);
        final Object tagPivotY = child.getTag(KEY_SCALE_PIVOTY);
        final Object tagMinScaleX = child.getTag(KEY_MIN_SCALE_X);
        final Object tagMinScaleY = child.getTag(KEY_MIN_SCALE_Y);
        if (tagPivotX != null) {
            child.setPivotX((float) tagPivotX);
        } else {//没设置就是中心

        }
        if (tagPivotY != null) {
            child.setPivotY((float) tagPivotY);
        } else {//没设置就是中心

        }
        if (tagMinScaleX != null) {
            child.setScaleX(Math.max((float) tagMinScaleX, fraction));
        } else {//do nothing
        }
        if (tagMinScaleY != null) {
            child.setScaleY(Math.max((float) tagMinScaleY, fraction));
        } else {//do nothing
        }
    }
}

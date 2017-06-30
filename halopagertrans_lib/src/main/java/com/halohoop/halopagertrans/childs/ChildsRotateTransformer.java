package com.halohoop.halopagertrans.childs;

import android.view.View;

/**
 * Created by Pooholah on 2017/6/22.
 */

public class ChildsRotateTransformer extends BaseChildsTransformer {

    /**
     * 从多少角度开始恢复到0
     */
    public static final int KEY_ROTATE = KEY + 1;
    public static final int KEY_ROTATE_PIVOTX_RATIO = KEY_ROTATE + 2;
    public static final int KEY_ROTATE_PIVOTY_RATIO = KEY_ROTATE + 3;

    @Override
    protected void transformPageChilds(View parent, View child, int childIndex, float position, float fraction) {
        final Object tagPivotXRatio = child.getTag(KEY_ROTATE_PIVOTX_RATIO);
        final Object tagPivotYRatio = child.getTag(KEY_ROTATE_PIVOTY_RATIO);
        final Object tagDegree = child.getTag(KEY_ROTATE);
        if (tagPivotXRatio != null) {
            child.setPivotX(child.getWidth() * ((float) tagPivotXRatio));
        } else {//没设置就是中心

        }
        if (tagPivotYRatio != null) {
            child.setPivotY(child.getHeight() * ((float) tagPivotYRatio));
        } else {//没设置就是中心

        }
        if (tagDegree != null) {
            child.setRotation(((float) tagDegree) * position);
        }
    }
}

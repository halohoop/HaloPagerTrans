package com.halohoop.halopagertrans.childs;

import android.view.View;

/**
 * Created by Pooholah on 2017/6/22.
 * 由于平移太多情况了，这里只给出一种我自己算法的实现，想要更多实现的可以自己去实现
 */

public class ChildsTranslateTransformer extends BaseChildsTransformer {

    /**
     * chlid的移动是否和parent的移动反过来，默认是true，反过来
     */
    public static final int KEY_IS_X_REVERSE = KEY + 30;
    public static final int KEY_IS_Y_REVERSE = KEY_IS_X_REVERSE + 1;
    /**
     * reverse才使用
     */
    public static final int KEY_MARGIN_X_WHEN_REVERSE = KEY_IS_X_REVERSE + 2;
    public static final int KEY_MARGIN_Y_WHEN_REVERSE = KEY_IS_X_REVERSE + 3;
    public static final int KEY_OFFSET_X_FACTOR = KEY_IS_X_REVERSE + 4;
    public static final int KEY_OFFSET_Y_FACTOR = KEY_IS_X_REVERSE + 5;

    @Override
    protected void transformPageChilds(View parent, View child, int childIndex, float position, float fraction) {
        final Object tagIsXReverse = child.getTag(KEY_IS_X_REVERSE);
        final Object tagIsYReverse = child.getTag(KEY_IS_Y_REVERSE);
        final Object tagKeyMarginXWhenReverse = child.getTag(KEY_MARGIN_X_WHEN_REVERSE);
        final Object tagKeyMarginYWhenReverse = child.getTag(KEY_MARGIN_Y_WHEN_REVERSE);
        final Object tagkeyOffsetXFactor = child.getTag(KEY_OFFSET_X_FACTOR);
        final Object tagkeyOffsetYFactor = child.getTag(KEY_OFFSET_Y_FACTOR);
        if (tagkeyOffsetXFactor == null && tagkeyOffsetYFactor == null) {
            return;
        }
        final float _tagkeyOffsetXFactor = (float) (tagkeyOffsetXFactor == null ? 0f : tagkeyOffsetXFactor);
        if (tagIsXReverse != null) {
            final boolean _isReverse = (boolean) tagIsXReverse;
            final float _tagKeyMarginXWhenReverse = (float) (tagKeyMarginXWhenReverse == null ? 0f : tagKeyMarginXWhenReverse);
            if (_isReverse) {
                final float moveX = child.getWidth() * _tagkeyOffsetXFactor * position;
                if (position >= 0 && position <= 1) {
                    //1 <-> 0 过度中
                    float maxMoveX = -(child.getLeft() - _tagKeyMarginXWhenReverse);
                    if (maxMoveX > 0) {
                        maxMoveX = -child.getLeft();
                    }
                    //因为reverse，所以child左移，所以是负数，取最大值，也就是接近0的值
                    child.setTranslationX(Math.max(-moveX, maxMoveX));
                } else if (position <= 0 && position >= -1) {
                    //0 <-> -1 过度中
                    final float howManyleft = parent.getWidth() - _tagKeyMarginXWhenReverse;
                    final int right = child.getRight();
                    float maxMoveX = howManyleft - right;
                    if (maxMoveX < 0) {
                        maxMoveX = parent.getWidth() - child.getRight();
                    }
                    //因为reverse，所以child右移，所以是正数，取最小值
                    child.setTranslationX(Math.min(-moveX, maxMoveX));

                }
            }
        } else {
            child.setTranslationX(child.getWidth() * _tagkeyOffsetXFactor * position);
        }

        final float _tagkeyOffsetYFactor = (float) (tagkeyOffsetYFactor == null ? 0f : tagkeyOffsetYFactor);
        if (tagIsYReverse != null) {
            final boolean _isReverse = (boolean) tagIsYReverse;
            final float _tagKeyMarginYWhenReverse = (float) (tagKeyMarginYWhenReverse == null ? 0f : tagKeyMarginYWhenReverse);
            if (_isReverse) {
                final float moveY = child.getHeight() * _tagkeyOffsetYFactor * position;
                if (position >= 0 && position <= 1) {
                    //1 <-> 0 过度中
                    float maxMoveY = -(child.getTop() - _tagKeyMarginYWhenReverse);
                    if (maxMoveY > 0) {
                        maxMoveY = -child.getTop();
                    }
                    //因为reverse，所以child上移，所以是负数，取最大值，也就是接近0的值
                    child.setTranslationY(Math.max(-moveY, maxMoveY));
                } else if (position <= 0 && position >= -1) {
                    //0 <-> -1 过度中
                    final float howManyleft = parent.getHeight() - _tagKeyMarginYWhenReverse;
                    final int bottom = child.getBottom();
                    float maxMoveY = howManyleft - bottom;
                    if (maxMoveY < 0) {
                        maxMoveY = parent.getHeight() - child.getBottom();
                    }
                    //因为reverse，所以child右移，所以是正数，取最小值
                    child.setTranslationY(Math.min(-moveY, maxMoveY));

                }
            }
        } else {
            child.setTranslationY(child.getHeight() * _tagkeyOffsetYFactor * position);
        }

    }
}

package com.halohoop.halopagertrans;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Pooholah on 2017/6/22.
 */

public class ComplexChildsTransformer extends BaseTransformer {

    private ArrayList<BaseTransformer> mTransformers = null;

    public void addTransformer(BaseTransformer transformer) {
        if (mTransformers == null) {
            mTransformers = new ArrayList<>();
        }
        mTransformers.add(transformer);
    }

    @Override
    protected void transformPage(View page, float position, float fraction) {
        final ArrayList<BaseTransformer> transformers = mTransformers;
        final View _page = page;
        final float _position = position;
        final float _fraction = fraction;
        if (transformers != null) {
            final int size = transformers.size();
            for (int i = 0; i < size; i++) {
                final BaseTransformer baseTransformer = transformers.get(i);
                baseTransformer.transformPage(_page, _position, _fraction);
            }
        }
    }

    @Override
    protected void transformPageChilds(View parent, View child, int childIndex, float position, float fraction) {
        final ArrayList<BaseTransformer> transformers = mTransformers;
        final View _page = parent;
        final View _child = child;
        final int _childIndex = childIndex;
        final float _position = position;
        final float _fraction = fraction;
        if (transformers != null) {
            final int size = transformers.size();
            for (int i = 0; i < size; i++) {
                final BaseTransformer baseTransformer = transformers.get(i);
                baseTransformer.transformPageChilds(_page, _child, _childIndex, _position, _fraction);
            }
        }
    }
}

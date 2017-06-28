package com.halohoop.halopagertrans_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halohoop.halopagertrans.childs.ChildsAlphaTransformer;
import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsScaleTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

import java.util.Random;

public class Translate3Fragment extends Fragment {

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int layoutId = bundle.getInt("layoutId");
        int bgcolor = bundle.getInt("bgcolor");

        View view = inflater.inflate(layoutId, null);
        view.setBackgroundColor(getContext().getColor(bgcolor));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Random random = new Random();
        final ViewGroup vg = (ViewGroup) view;
        final int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = vg.getChildAt(i);
            child.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, (float) random.nextInt(25));
            int nextRand = random.nextInt(10);
            child.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_X, nextRand / 10f);
            child.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_Y, nextRand / 10f);
            child.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, random.nextInt(10) / 10f);
            child.setTag(ChildsRotateTransformer.KEY_ROTATE, (float) random.nextInt(360));
            child.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, random.nextInt(15) / 10f);
            child.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, random.nextInt(15) / 10f);
        }
    }
}

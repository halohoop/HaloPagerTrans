package com.halohoop.halopagertrans_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsScaleTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

import static com.halohoop.halopagertrans_sample.R.id.imageView3;

public class MoonFragment extends Fragment {

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

        View imageView_moon = view.findViewById(R.id.imageView_moon);
        imageView_moon.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        imageView_moon.setTag(ChildsTranslateTransformer.KEY_IS_REVERSE, true);
        imageView_moon.setTag(ChildsRotateTransformer.KEY_ROTATE, 90f);
        imageView_moon.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 1.5f);
//        imageView_moon.setTag(ChildsScaleTransformer.KEY_SCALE_PIVOTX, 0.5f);
//        imageView_moon.setTag(ChildsScaleTransformer.KEY_SCALE_PIVOTY, 0.5f);
        imageView_moon.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_X, .3f);
        imageView_moon.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_Y, .3f);
    }


}

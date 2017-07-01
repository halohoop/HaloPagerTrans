package com.halohoop.halopagertrans_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsScaleTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

import static android.content.ContentValues.TAG;

public class SunFragment extends Fragment {

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
        View imageView3 = view.findViewById(R.id.imageView3);
        imageView3.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        imageView3.setTag(ChildsTranslateTransformer.KEY_IS_X_REVERSE, true);
        imageView3.setTag(ChildsTranslateTransformer.KEY_MARGIN_X_WHEN_REVERSE, -30f);

        View imageView_sun = view.findViewById(R.id.imageView_sun);
        imageView_sun.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        imageView_sun.setTag(ChildsTranslateTransformer.KEY_IS_X_REVERSE, true);
        imageView_sun.setTag(ChildsRotateTransformer.KEY_ROTATE, 90f);
        imageView_sun.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 1.5f);
//        imageView_sun.setTag(ChildsScaleTransformer.KEY_SCALE_PIVOTX, 0.5f);
//        imageView_sun.setTag(ChildsScaleTransformer.KEY_SCALE_PIVOTY, 0.5f);
        imageView_sun.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_X, .3f);
        imageView_sun.setTag(ChildsScaleTransformer.KEY_MIN_SCALE_Y, .3f);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "lifecycle:onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "lifecycle:onPause: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "lifecycle:onDetach: ");
    }
}

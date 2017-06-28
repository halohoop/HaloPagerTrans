package com.halohoop.halopagertrans_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

import static android.content.ContentValues.TAG;

public class Translate1Fragment extends Fragment {

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
        imageView3.setTag(ChildsTranslateTransformer.KEY_IS_REVERSE, true);
        imageView3.setTag(ChildsTranslateTransformer.KEY_MARGIN_WHEN_REVERSE, -30f);
//        imageView3.setTag(ChildsRotateTransformer.KEY_ROTATE,360f);
//		imageView3.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA,0.5f);

        View line = view.findViewById(R.id.line);
        line.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        line.setTag(ChildsTranslateTransformer.KEY_IS_REVERSE, true);
        line.setTag(ChildsTranslateTransformer.KEY_MARGIN_WHEN_REVERSE, -70f);

        View ll_top = view.findViewById(R.id.ll_top);
        ll_top.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE, -90f);
        ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1f);
        ll_top.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 0.5f);

        View textView1 = view.findViewById(R.id.textView1);
        textView1.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 3f);
//        textView1.setTag(ChildsRotateTransformer.KEY_ROTATE, -90f);
//        textView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1f);
//        textView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 0.5f);

        View imageView1 = view.findViewById(R.id.imageView1);
        imageView1.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 2f);
        imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE, 90f);
        imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1f);
        imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, 0.5f);
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

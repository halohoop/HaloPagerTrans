package com.halohoop.halopagertrans_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halohoop.halopagertrans.childs.ChildsAlphaTransformer;
import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

public class Translate2Fragment extends Fragment {

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

        View ll_top = view.findViewById(R.id.ll_top);
        ll_top.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 4f);

        View imageView3 = view.findViewById(R.id.imageView3);
        imageView3.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 5f);
        imageView3.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0.0f);

        View imageView4 = view.findViewById(R.id.imageView4);
        imageView4.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 25f);
        imageView4.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0.0f);

        View imageView7 = view.findViewById(R.id.imageView7);
        imageView7.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 10f);
        imageView7.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0.0f);

        View imageView8 = view.findViewById(R.id.imageView8);
        imageView8.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 10f);
        imageView8.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0.0f);

        View textView1 = view.findViewById(R.id.textView1);
        textView1.setTag(ChildsTranslateTransformer.KEY_OFFSET_X_FACTOR, 3f);

        View imageView1 = view.findViewById(R.id.imageView1);
        imageView1.setTag(ChildsRotateTransformer.KEY_ROTATE, 180f);
        imageView1.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0f);

        View imageView6 = view.findViewById(R.id.imageView6);
        imageView6.setTag(ChildsRotateTransformer.KEY_ROTATE, 720f);
        imageView6.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, -0.5f);

        View imageView5 = view.findViewById(R.id.imageView5);
        imageView5.setTag(ChildsRotateTransformer.KEY_ROTATE, 720f);
        imageView5.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1.5f);
    }


}

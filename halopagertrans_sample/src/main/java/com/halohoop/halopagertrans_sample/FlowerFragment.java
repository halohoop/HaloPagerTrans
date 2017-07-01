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

public class FlowerFragment extends Fragment {

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
//        View imageView_man_give_flower = view.findViewById(R.id.imageView_man_give_flower);
        View imageView_flower = view.findViewById(R.id.imageView_flower);
        imageView_flower.setTag(ChildsRotateTransformer.KEY_ROTATE, -200f);
        imageView_flower.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTX_RATIO, 1.0f);
        imageView_flower.setTag(ChildsRotateTransformer.KEY_ROTATE_PIVOTY_RATIO, .65f);

//        View imageView_girl = view.findViewById(R.id.imageView_girl);
        View imageView_girl_face_red = view.findViewById(R.id.imageView_girl_face_red);
        imageView_girl_face_red.setTag(ChildsAlphaTransformer.KEY_MIN_ALPHA, 0f);

        View imageView_heart = view.findViewById(R.id.imageView_heart);
        imageView_heart.setTag(ChildsTranslateTransformer.KEY_OFFSET_Y_FACTOR, 2.0f);
    }
}

package com.halohoop.halopagertrans_sample;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Pooholah on 2017/6/29.
 */

public class MyVp extends ViewPager {
    public MyVp(Context context) {
        super(context);
    }

    public MyVp(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.i(TAG, "onLayout: "+changed);
    }

    private static final String TAG = "MyVp";
}

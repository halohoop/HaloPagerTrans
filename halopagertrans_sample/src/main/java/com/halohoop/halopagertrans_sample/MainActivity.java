package com.halohoop.halopagertrans_sample;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.halohoop.halopagertrans.ComplexChildsTransformer;
import com.halohoop.halopagertrans.childs.ChildsRotateTransformer;
import com.halohoop.halopagertrans.childs.ChildsTranslateTransformer;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private int[] layouts = {
            R.layout.welcome1,
            R.layout.welcome2,
            R.layout.welcome3,
            R.layout.welcome3,
            R.layout.welcome3,
            R.layout.welcome4,
            R.layout.welcome3,
    };
    private int[] colors = {
            R.color.bg0,
            R.color.bg1,
            R.color.bg2,
            R.color.bg3,
            R.color.bg4,
            R.color.bg0,
            R.color.bg1,
    };
    private ViewPager vp;
    private ColorDrawable colorDrawable;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);

        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager());
        ComplexChildsTransformer complexChildsTransformer = new ComplexChildsTransformer();
        complexChildsTransformer.addTransformer(new ChildsTranslateTransformer());
        complexChildsTransformer.addTransformer(new ChildsRotateTransformer());
//        complexChildsTransformer.addTransformer(new ChildsAlphaTransformer());
//        complexChildsTransformer.addTransformer(new ChildsScaleTransformer());
//        complexChildsTransformer.addTransformer(new PageDefaultTransformer());//普通vp滑动
//        complexChildsTransformer.addTransformer(new PageAlphaTransFormer(false/*可修改*/, true/*可修改*/));//透明度
//        complexChildsTransformer.addTransformer(new PageCubeInnerTransformer(/*可传参数*/));//立方体内部
//        complexChildsTransformer.addTransformer(new PageCubeOuterTransformer());//立方体外部
//        complexChildsTransformer.addTransformer(new PageDepthTransformer(/*可传参数*/));//深度变化
//        complexChildsTransformer.addTransformer(new PageExtrudingTransformer());//挤压
//        complexChildsTransformer.addTransformer(new PageFlipTransformer(/*可传参数*/));//flip
//        complexChildsTransformer.addTransformer(new PageInRightUpTransformer());//右上到左下
//        complexChildsTransformer.addTransformer(new PageInRightDownTransformer());//右下到左上
//        complexChildsTransformer.addTransformer(new PageRotateTransformer(/*可传参数*/));//旋转
//        complexChildsTransformer.addTransformer(new PageZoomOutTransformer(/*可传参数*/));//Zoom out
        vp.setPageTransformer(true, complexChildsTransformer);
//        vp.setPageTransformer(false, complexChildsTransformer);//不建议使用，界面和你锁认为的顺序会乱，除非有需求
//        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(this);


        //
        supportActionBar = getSupportActionBar();
        if (colorDrawable == null) {
            colorDrawable = new ColorDrawable(getColor(colors[0]));
            supportActionBar.setBackgroundDrawable(colorDrawable);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i(TAG, "onPageScrolled: position:" + position);
        Log.i(TAG, "onPageScrolled: positionOffset:" + positionOffset);
        Log.i(TAG, "onPageScrolled: positionOffsetPixels:" + positionOffsetPixels);
    }

    private static final String TAG = "MainActivity";

    @Override
    public void onPageSelected(int position) {
        //actionbar color
        if (colorDrawable == null) {
            colorDrawable = new ColorDrawable(getColor(colors[position]));
            supportActionBar.setBackgroundDrawable(colorDrawable);
        }
        colorDrawable.setColor(getColor(colors[position]));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class WelcomePagerAdapter extends FragmentPagerAdapter {

        public WelcomePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = getFragment(position);
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", layouts[position]);
            bundle.putInt("bgcolor", colors[position]);
            f.setArguments(bundle);
            return f;
        }

        private Fragment getFragment(int pos) {
            switch (pos) {
                case 0:
                    return new Translate1Fragment();
                case 1:
                    return new Translate2Fragment();
                case 2:
                    return new Translate3Fragment();
                case 3:
                    return new Translate3Fragment();
                case 4:
                    return new Translate3Fragment();
                case 5:
                    return new Translate4Fragment();
                case 6:
                    return new Translate3Fragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return layouts.length;
        }

        /**
         * 定义每个Page的宽度，和Vp的宽度的百分比
         * @param position
         * @return
         */
//        public float getPageWidth(int position) {
//            return .3f;
//        }


    }
}

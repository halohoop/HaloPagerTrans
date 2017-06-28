package com.halohoop.halopagertrans.pages;

import android.view.View;

public class PageDepthTransformer extends BasePageTransFormer {
	private static float MIN_SCALE = 0.5f;
	private float mScale = MIN_SCALE;

    public PageDepthTransformer() {
    }

    public PageDepthTransformer(float scale) {
		this.mScale = scale;
    }

	@Override
	protected void transformPage(View view, float position, float fraction) {
		int pageWidth = view.getWidth();
		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setTranslationX(0);
		} else if (position <= 0) { // [-1,0]
			// Use the default slide transition when
			// moving to the left page
			view.setTranslationX(0);
			view.setScaleX(1);
			view.setScaleY(1);
		} else if (position <= 1) { // (0,1]
			// Fade the page out.
			// Counteract the default slide transition
			view.setTranslationX(pageWidth * -position);
			// Scale the page down (between MIN_SCALE and 1)
			float scaleFactor = mScale + (1 - mScale)
					* (1 - Math.abs(position));
			view.setScaleX(scaleFactor);
			view.setScaleY(scaleFactor);
		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setScaleX(1);
			view.setScaleY(1);
		}
	}

}
package com.halohoop.halopagertrans.pages;

import android.view.View;

/**
 * 立方体外部
 */
public class PageCubeOuterTransformer extends BasePageTransFormer {

	@Override
	protected void transformPage(View view, float position, float fraction) {
		if (position <= 0) {
			view.setPivotX(view.getMeasuredWidth());
			view.setPivotY(view.getMeasuredHeight() * 0.5f);
			view.setRotationY(45f * position);
		} else if (position <= 1) {
			view.setPivotX(0);
			view.setPivotY(view.getMeasuredHeight() * 0.5f);
			view.setRotationY(45f * position);
		}
	}

}

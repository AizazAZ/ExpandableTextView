package com.ms.square.android.expandabletextview;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * @author AZ Aizaz
 */
public class ScreenUtils {

	public static void expandViewTouchDelegate(final View view, final int top,
			final int bottom, final int left, final int right) {

		((View) view.getParent()).post(new Runnable() {
			@Override
			public void run() {
				Rect bounds = new Rect();
				view.setEnabled(true);
				view.getHitRect(bounds);

				bounds.top -= top;
				bounds.bottom += bottom;
				bounds.left -= left;
				bounds.right += right;

				TouchDelegate touchDelegate = new TouchDelegate(bounds, view);

				if (View.class.isInstance(view.getParent())) {
					((View) view.getParent()).setTouchDelegate(touchDelegate);
				}
			}
		});
	}

}

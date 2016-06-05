package com.demo.view.business;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * @Description:解决在scrollview中只显示第一行数据的问题
 * @author http://blog.csdn.net/finddreams
 */ 
public class BusinessGridView extends GridView {
	public BusinessGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BusinessGridView(Context context) {
		super(context);
	}

	public BusinessGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
	
}

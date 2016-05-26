package com.demo.fragment;

import com.demo.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BusinessFragment extends BaseFragment {
	private ImageView imageView;

	@Override
	public String initContent() {
		return "商务";
	}

	@SuppressLint("InflateParams")
	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_business, null);

		//设置右上角的图标
		imageView = (ImageView) getActivity().findViewById(R.id.addButton);
		imageView.setImageResource(0);
		// imageView.setOnClickListener(addListener);
		return view;
	}
}

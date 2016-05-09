package com.demo.fragment;

import com.demo.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class BaseFragment extends Fragment {

	private TextView topTextView;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// View view = inflater.inflate(R.layout.fragment, null);
		// TextView textView = (TextView) view.findViewById(R.id.txt_content);
		// textView.setText(initContent());
		topTextView = (TextView) getActivity().findViewById(R.id.topTv);
		topTextView.setText(initContent());

		// 这样来切换布局，而不是局限于一个布局
		View view = inflater.inflate(initLayout(), null);
		return view;
	}

	public abstract String initContent();

	public abstract int initLayout();
	// R.layout.frag_mycomments
}

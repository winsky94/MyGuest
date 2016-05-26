package com.demo.fragment;

import com.demo.R;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;

public class CustomerFragmentAll extends BaseFragment {
	@Override
	public String initContent() {
		return "这是客户界面";
	}

	@SuppressLint("InflateParams")
	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_customer_all, null);
		return view;
	}

}

package com.demo.fragment.customer;

import com.demo.R;
import com.demo.fragment.BaseFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;

public class CustomerFragmentAll extends BaseFragment {
	@Override
	public String initContent() {
		return "客户列表";
	}

	@SuppressLint("InflateParams")
	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_customer_all, null);
		return view;
	}

}

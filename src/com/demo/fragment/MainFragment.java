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
import android.widget.RadioGroup;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainFragment extends Fragment {
	private android.app.FragmentManager fragmentManager;
	private RadioGroup radioGroup;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// View view = inflater.inflate(R.layout.fragment, null);
		// TextView textView = (TextView) view.findViewById(R.id.txt_content);
		// textView.setText(initContent());

		// 这样来切换布局，而不是局限于一个布局
		View view = inflater.inflate(R.layout.activity_main_base, null);

		fragmentManager = getFragmentManager();
		radioGroup = (RadioGroup) view.findViewById(R.id.rg_tab);

		// 进去之后默认是客户列表页
		radioGroup.check(2);
		android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		android.app.Fragment fragment = FragmentFactory.getInstanceByIndex(2);
		transaction.replace(R.id.main_content_frame, fragment);
		transaction.addToBackStack(null);
		transaction.commit();

		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
				android.app.Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
				transaction.replace(R.id.main_content_frame, fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});

		return view;
	}
}

package com.demo.fragment;

import com.demo.R;
import com.demo.utils.LogUtil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomerFragment extends Fragment {

	private Button btn_message, btn_call;

	private CustomerFragmentAll allCustomer;
	private CustomerFragmentMy myCustomer;

	public static final int MESSAGE_FRAGMENT_TYPE = 1;
	public static final int CALL_FRAGMENT_TYPE = 2;
	public int currentFragmentType = -1;
	
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		// 这样来切换布局，而不是局限于一个布局	
		View view = inflater.inflate(R.layout.frag_customer, null);

		btn_message = (Button) view.findViewById(R.id.btn_my);
		btn_call = (Button) view.findViewById(R.id.btn_all);
		btn_message.setOnClickListener(onClicker);
		btn_call.setOnClickListener(onClicker);

		FragmentManager fragmentManager = getFragmentManager();
		if (savedInstanceState != null) {
			int type = savedInstanceState.getInt("currentFragmentType");
			myCustomer = (CustomerFragmentMy) fragmentManager.findFragmentByTag("message");
			allCustomer = (CustomerFragmentAll) fragmentManager.findFragmentByTag("call");
			if (type > 0)
				loadFragment(type);
		} else {
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			Fragment mainFragment = fragmentManager.findFragmentByTag("message");
			if (mainFragment != null) {
				transaction.replace(R.id.fl_content, mainFragment);
				transaction.commit();
			} else {
				loadFragment(MESSAGE_FRAGMENT_TYPE);
			}
		}

		return view;
	}

	private void switchFragment(int type) {
		switch (type) {
		case MESSAGE_FRAGMENT_TYPE:
			loadFragment(MESSAGE_FRAGMENT_TYPE);
			break;
		case CALL_FRAGMENT_TYPE:
			loadFragment(CALL_FRAGMENT_TYPE);
			break;
		}

	}

	private void loadFragment(int type) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (type == CALL_FRAGMENT_TYPE) {
			if (allCustomer == null) {
				allCustomer = new CustomerFragmentAll();

				transaction.add(R.id.fl_content, allCustomer, "zhishi");
			} else {
				transaction.show(allCustomer);
			}
			if (myCustomer != null) {
				transaction.hide(myCustomer);
			}
			currentFragmentType = MESSAGE_FRAGMENT_TYPE;
		} else {
			if (myCustomer == null) {
				myCustomer = new CustomerFragmentMy();
				transaction.add(R.id.fl_content, myCustomer, "wenda");
			} else {
				transaction.show(myCustomer);
			}
			if (allCustomer != null) {
				transaction.hide(allCustomer);
			}
			currentFragmentType = CALL_FRAGMENT_TYPE;
		}
		transaction.commitAllowingStateLoss();
	}

	private OnClickListener onClicker = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_my:
				btn_message.setTextColor(Color.parseColor("#5CACEE"));
				btn_call.setTextColor(Color.parseColor("#5CACEE"));
				btn_message.setBackgroundResource(R.drawable.baike_btn_pink_left_f_96);
				btn_call.setBackgroundResource(R.drawable.baike_btn_trans_right_f_96);
				switchFragment(MESSAGE_FRAGMENT_TYPE);

				break;
			case R.id.btn_all:

				btn_message.setTextColor(Color.parseColor("#5CACEE"));
				btn_call.setTextColor(Color.parseColor("#5CACEE"));
				btn_message.setBackgroundResource(R.drawable.baike_btn_trans_left_f_96);
				btn_call.setBackgroundResource(R.drawable.baike_btn_pink_right_f_96);
				switchFragment(CALL_FRAGMENT_TYPE);

				break;

			}
		}
	};
}

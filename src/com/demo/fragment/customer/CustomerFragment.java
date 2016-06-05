package com.demo.fragment.customer;

import com.demo.R;

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
import android.widget.ImageView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomerFragment extends Fragment {

	private Button btn_message, btn_call;
	private ImageView imageView;

	private CustomerFragmentAll allCustomer;
	private CustomerFragmentMy myCustomer;

	public static final int MY_CUSTOMER_FRAGMENT_TYPE = 1;
	public static final int ALL_CUSTOMER_FRAGMENT_TYPE = 2;
	public int currentFragmentType = -1;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_customer, null);

		btn_message = (Button) view.findViewById(R.id.btn_my);
		btn_call = (Button) view.findViewById(R.id.btn_all);
		imageView = (ImageView) getActivity().findViewById(R.id.addButton);
		btn_message.setOnClickListener(onClicker);
		btn_call.setOnClickListener(onClicker);

		imageView.setImageResource(R.drawable.plus);
		imageView.setOnClickListener(addListener);

		FragmentManager fragmentManager = getFragmentManager();
		if (savedInstanceState != null) {
			int type = savedInstanceState.getInt("currentFragmentType");
			myCustomer = (CustomerFragmentMy) fragmentManager.findFragmentByTag("myCustomer");
			allCustomer = (CustomerFragmentAll) fragmentManager.findFragmentByTag("allCustomer");
			if (type > 0)
				loadFragment(type);
		} else {
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			Fragment mainFragment = new CustomerFragmentMy();
			transaction.replace(R.id.fl_content, mainFragment);
			transaction.commit();
		}

		return view;
	}

	private void switchFragment(int type) {
		switch (type) {
		case MY_CUSTOMER_FRAGMENT_TYPE:
			loadFragment(MY_CUSTOMER_FRAGMENT_TYPE);
			break;
		case ALL_CUSTOMER_FRAGMENT_TYPE:
			loadFragment(ALL_CUSTOMER_FRAGMENT_TYPE);
			break;
		}

	}

	private void loadFragment(int type) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (type == ALL_CUSTOMER_FRAGMENT_TYPE) {
			if (allCustomer == null) {
				allCustomer = new CustomerFragmentAll();

			}
			transaction.replace(R.id.fl_content, allCustomer, "allCustomer");
			currentFragmentType = MY_CUSTOMER_FRAGMENT_TYPE;
		} else {
			if (myCustomer == null) {
				myCustomer = new CustomerFragmentMy();

			}
			transaction.replace(R.id.fl_content, myCustomer, "myCustomer");
			currentFragmentType = ALL_CUSTOMER_FRAGMENT_TYPE;
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
				switchFragment(MY_CUSTOMER_FRAGMENT_TYPE);

				break;
			case R.id.btn_all:
				btn_message.setTextColor(Color.parseColor("#5CACEE"));
				btn_call.setTextColor(Color.parseColor("#5CACEE"));
				btn_message.setBackgroundResource(R.drawable.baike_btn_trans_left_f_96);
				btn_call.setBackgroundResource(R.drawable.baike_btn_pink_right_f_96);
				switchFragment(ALL_CUSTOMER_FRAGMENT_TYPE);

				break;

			}
		}
	};

	private OnClickListener addListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			AddCustomerFragment addCustomerFragment = new AddCustomerFragment();
			transaction.replace(R.id.content_frame, addCustomerFragment, "addCustomerFragment");
			transaction.commit();

		}
	};
}

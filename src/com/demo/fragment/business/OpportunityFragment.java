package com.demo.fragment.business;

import com.demo.R;
import com.demo.fragment.BaseFragment;
import com.demo.fragment.MainFragment;
import com.demo.utils.ToastUtil;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("InflateParams")
public class OpportunityFragment extends BaseFragment {
	private ImageView addButton;

	private Button btn_my, btn_all;
	private ImageView imageView;
	private ImageView backButton;
	// private TextView textView;

	private OpportunityFragmentAll allOpportunity;
	private OpportunityFragmentMy myOpportunity;

	public static final int MY_OPPORTUNITY_FRAGMENT_TYPE = 1;
	public static final int ALL_OPPORTUNITY_FRAGMENT_TYPE = 2;
	public int currentFragmentType = -1;

	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_opportunity, null);

		// 设置右上角的图标
		addButton = (ImageView) getActivity().findViewById(R.id.addButton);
		addButton.setImageResource(R.drawable.plus);
		addButton.setOnClickListener(addListener);

		// textView=(TextView)getActivity().findViewById(R.id.topTv);
		// textView.setText("商机列表");

		imageView = (ImageView) getActivity().findViewById(R.id.topButton);
		imageView.setVisibility(View.GONE);

		backButton = (ImageView) getActivity().findViewById(R.id.backButton);
		backButton.setVisibility(View.VISIBLE);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment newFragment = new MainFragment(R.id.business);
				String title = getString(R.string.business);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, newFragment).commit();
				TextView topTextView = (TextView) getActivity().findViewById(R.id.topTv);
				topTextView.setText(title);
			}
		});

		// 设置我的和全部按钮
		btn_my = (Button) view.findViewById(R.id.btn_my);
		btn_all = (Button) view.findViewById(R.id.btn_all);
		btn_my.setOnClickListener(onClicker);
		btn_all.setOnClickListener(onClicker);

		// 设置选中的标签
		FragmentManager fragmentManager = getFragmentManager();
		Bundle buddle = getArguments();
		int type = -1;
		if (buddle != null) {
			type = buddle.getInt("currentFragmentType");
			System.out.println(type);
			myOpportunity = (OpportunityFragmentMy) fragmentManager.findFragmentByTag("myOpprotunity");
			allOpportunity = (OpportunityFragmentAll) fragmentManager.findFragmentByTag("allOpprotunity");
			if (type > 0)
				loadFragment(type);
		} else {
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			Fragment mainFragment = new OpportunityFragmentMy();
			transaction.replace(R.id.fl_content, mainFragment);
			transaction.commit();
		}

		return view;
	}

	private OnClickListener onClicker = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_my:
				btn_my.setTextColor(Color.parseColor("#5CACEE"));
				btn_all.setTextColor(Color.parseColor("#5CACEE"));
				btn_my.setBackgroundResource(R.drawable.baike_btn_pink_left_f_96);
				btn_all.setBackgroundResource(R.drawable.baike_btn_trans_right_f_96);
				switchFragment(MY_OPPORTUNITY_FRAGMENT_TYPE);

				break;
			case R.id.btn_all:
				btn_my.setTextColor(Color.parseColor("#5CACEE"));
				btn_all.setTextColor(Color.parseColor("#5CACEE"));
				btn_my.setBackgroundResource(R.drawable.baike_btn_trans_left_f_96);
				btn_all.setBackgroundResource(R.drawable.baike_btn_pink_right_f_96);
				switchFragment(ALL_OPPORTUNITY_FRAGMENT_TYPE);

				break;

			}
		}
	};

	private void switchFragment(int type) {
		switch (type) {
		case MY_OPPORTUNITY_FRAGMENT_TYPE:
			loadFragment(MY_OPPORTUNITY_FRAGMENT_TYPE);
			break;
		case ALL_OPPORTUNITY_FRAGMENT_TYPE:
			loadFragment(ALL_OPPORTUNITY_FRAGMENT_TYPE);
			break;
		}

	}

	private void loadFragment(int type) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (type == ALL_OPPORTUNITY_FRAGMENT_TYPE) {
			if (allOpportunity == null) {
				allOpportunity = new OpportunityFragmentAll();

			}
			transaction.replace(R.id.fl_content, allOpportunity, "allOpprotunity");
			currentFragmentType = MY_OPPORTUNITY_FRAGMENT_TYPE;
		} else {
			if (myOpportunity == null) {
				myOpportunity = new OpportunityFragmentMy();

			}
			transaction.replace(R.id.fl_content, myOpportunity, "myOpprotunity");
			currentFragmentType = ALL_OPPORTUNITY_FRAGMENT_TYPE;
		}
		transaction.commitAllowingStateLoss();
	}

	private OnClickListener addListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// FragmentManager fragmentManager = getFragmentManager();
			// FragmentTransaction transaction =
			// fragmentManager.beginTransaction();
			// AddCustomerFragment addCustomerFragment = new
			// AddCustomerFragment();
			// transaction.replace(R.id.content_frame, addCustomerFragment,
			// "addCustomerFragment");
			// transaction.commit();
			ToastUtil.showShort(getActivity(), "in opportunityFragment.java, add");
		}
	};

	@Override
	public String initContent() {
		// TODO Auto-generated method stub
		return "商机管理";
	}
}

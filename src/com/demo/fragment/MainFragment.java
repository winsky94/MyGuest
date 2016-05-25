package com.demo.fragment;

import com.demo.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
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

	private CustomerFragment customerFragment;
	private BusinessFragment businessFragment;
	private WorkFragment workFragment;

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
		radioGroup.check(R.id.customer);
		// android.app.FragmentTransaction transaction =
		// fragmentManager.beginTransaction();
		// android.app.Fragment fragment =
		// FragmentFactory.getInstanceByIndex(2);
		// transaction.replace(R.id.main_content_frame, fragment);
		// transaction.addToBackStack(null);
		// transaction.commit();
		setTabSelection(R.id.customer);

		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// android.app.FragmentTransaction transaction =
				// fragmentManager.beginTransaction();
				// android.app.Fragment fragment =
				// FragmentFactory.getInstanceByIndex(checkedId);
				// transaction.replace(R.id.main_content_frame, fragment);

				// transaction.addToBackStack(null);
				// transaction.commit();
				setTabSelection(checkedId);
			}
		});

		return view;
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。1表示商务，2表示客户，3表示业务。
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		// clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		switch (index) {
		case R.id.business:
			// 当点击了消息tab时，改变控件的图片和文字颜色
			if (businessFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				businessFragment = new BusinessFragment();
			}
			transaction.replace(R.id.main_content_frame, businessFragment);
			break;
		case R.id.customer:
			// 当点击了联系人tab时，改变控件的图片和文字颜色
			if (customerFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				customerFragment = new CustomerFragment();
			}
			transaction.replace(R.id.main_content_frame, customerFragment);
			break;
		case R.id.work:
			// 当点击了动态tab时，改变控件的图片和文字颜色
			if (workFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				workFragment = new WorkFragment();

			}
			transaction.replace(R.id.main_content_frame, workFragment);
			break;
		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	// private void hideFragments(FragmentTransaction transaction) {
	// if (customerFragment != null) {
	// transaction.hide(customerFragment);
	// }
	// if (businessFragment != null) {
	// transaction.hide(businessFragment);
	// }
	// if (workFragment != null) {
	// transaction.hide(workFragment);
	// }
	// }
}

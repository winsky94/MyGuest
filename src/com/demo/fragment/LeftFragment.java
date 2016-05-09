package com.demo.fragment;

import com.demo.MainActivity;
import com.demo.R;
import com.demo.activity.LoginActivity;
import com.demo.utils.LogUtil;
import com.demo.utils.SharedPreferenceUtil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * @date 2014/11/14
 * @author wuwenjie
 * @description 侧边栏菜单
 */
@SuppressLint("InflateParams")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LeftFragment extends Fragment implements OnClickListener {
	private View personInfoView;
	private View logOutView;
	private View settingsView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);
		findViews(view);

		return view;
	}

	public void findViews(View view) {
		personInfoView = view.findViewById(R.id.tvPersonInfo);
		logOutView = view.findViewById(R.id.BtLogOut);
		settingsView = view.findViewById(R.id.tvSettings);

		personInfoView.setOnClickListener(this);
		logOutView.setOnClickListener(this);
		settingsView.setOnClickListener(this);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		String title = null;
		switch (v.getId()) {
		case R.id.tvPersonInfo: // 个人信息
			newContent = new PersonInfoFragment();
			title = getString(R.string.personInfo);
			break;
		case R.id.BtLogOut:// 退出登录
//			newContent = new LogOutFragment();
//			title = getString(R.string.logOut);
			
			//清楚记录的用户名密码
			SharedPreferenceUtil.remove(getActivity(), "user_name");
			SharedPreferenceUtil.remove(getActivity(), "password");
			
			//退出，到登录界面
			Intent intent = new Intent(getActivity(), LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.tvSettings: // 设置
			newContent = new SettingsFragment();
			title = getString(R.string.settings);
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, title);
		}
	}

	/**
	 * 切换fragment
	 * 
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchConent(fragment, title);
		}
	}

}

package com.demo;

import com.demo.fragment.MainFragment;
import com.demo.fragment.customer.CustomerFragmentAll;
import com.demo.fragment.left.LeftFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends SlidingFragmentActivity implements OnClickListener {
	private long exitTime = 0;// 监测再按一次返回键就退出程序
	private android.app.FragmentManager fragmentManager;
	private ImageView topButton;
	private Fragment mContent;
	private TextView topTextView;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initSlidingMenu(savedInstanceState);

		topButton = (ImageView) findViewById(R.id.topButton);
		topButton.setOnClickListener(this);
		topTextView = (TextView) findViewById(R.id.topTv);

		fragmentManager = getFragmentManager();
		android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		android.app.Fragment fragment = new MainFragment();
		transaction.replace(R.id.content_frame, fragment);
		transaction.commit();
	}

	/**
	 * 初始化侧边栏
	 */
	private void initSlidingMenu(Bundle savedInstanceState) {
		// 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
		if (savedInstanceState != null) {
			mContent = getFragmentManager().getFragment(savedInstanceState, "mContent");
		}

		if (mContent == null) {
			mContent = new CustomerFragmentAll();
		}

		// 设置左侧滑动菜单
		setBehindContentView(R.layout.menu_frame_left);
		getFragmentManager().beginTransaction().replace(R.id.menu_frame, new LeftFragment()).commit();

		// 实例化滑动菜单对象
		SlidingMenu sm = getSlidingMenu();
		// 设置可以左右滑动的菜单
		sm.setMode(SlidingMenu.LEFT);
		// 设置滑动阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);
		// 设置滑动菜单阴影的图像资源
		sm.setShadowDrawable(null);
		// 设置滑动菜单视图的宽度
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置渐入渐出效果的值
		sm.setFadeDegree(0.35f);
		// 设置触摸屏幕的模式,这里设置为全屏
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置下方视图的在滚动时的缩放比例
		sm.setBehindScrollScale(0.0f);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 在保存fragment之前，确保该fragment被加入到fragment manager中
		// 不然按home键程序会异常
		if (mContent.isAdded()) {
			getFragmentManager().putFragment(outState, "mContent", mContent);
		}
	}

	/**
	 * 切换Fragment
	 * 
	 * @param fragment
	 */
	public void switchConent(Fragment fragment, String title) {
		mContent = fragment;
		getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
		topTextView.setText(title);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.topButton:
			toggle();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}

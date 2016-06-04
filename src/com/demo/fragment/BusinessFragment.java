package com.demo.fragment;

import com.demo.R;
import com.demo.view.MyGridAdapter;
import com.demo.view.MyGridView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BusinessFragment extends BaseFragment {
	private ImageView imageView;
	private MyGridView gridview;
	private ImageView topButton;
	private ImageView backButton;

	@Override
	public String initContent() {
		return "商务";
	}

	@SuppressLint("InflateParams")
	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_business, null);

		// 设置右上角的图标
		imageView = (ImageView) getActivity().findViewById(R.id.addButton);
		imageView.setImageResource(0);
		// imageView.setOnClickListener(addListener);

		// 设置左上角图标
		topButton = (ImageView) getActivity().findViewById(R.id.topButton);
		// topButton.setOnClickListener(new clicker());
		// topButton.setImageResource(R.drawable.ic_top_bar_category);
		topButton.setVisibility(View.VISIBLE);

		backButton = (ImageView) getActivity().findViewById(R.id.backButton);
		backButton.setVisibility(View.GONE);

		initView(view);
		return view;
	}

	private void initView(View view) {
		gridview = (MyGridView) view.findViewById(R.id.gridview);
		gridview.setAdapter(new MyGridAdapter(getActivity()));
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());
	}

	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
			// 显示所选Item的ItemText
			TextView tv = (TextView) view.findViewById(R.id.tv_item);
			String text = tv.getText().toString();
			if ("商机管理".equals(text)) {
				FragmentTransaction ft2 = getFragmentManager().beginTransaction();
				ft2.replace(R.id.content_frame, new OpportunityFragment());
				ft2.commit();
			} else if ("合同管理".equals(text)) {
				FragmentTransaction ft2 = getFragmentManager().beginTransaction();
				ft2.replace(R.id.content_frame, new ContractFragment());
				ft2.commit();
			}
		}
	}

	class clicker extends SlidingFragmentActivity implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.topButton:
				toggle();
				break;
			default:
				break;
			}
		}
	}
}

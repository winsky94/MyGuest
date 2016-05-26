package com.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.demo.view.Item;
import com.demo.view.ListViewAdapter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

@SuppressLint("InflateParams")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomerFragmentMy extends BaseFragment {
	private ListView mListView = null;
	private List<Item> mData = new ArrayList<Item>();

	private int[] mGroupArrays = new int[] { R.array.tianlongbabu, R.array.shediaoyingxiongzhuan,
			R.array.shendiaoxialv };

	private int[] mDetailIds = new int[] { R.array.tianlongbabu_detail, R.array.shediaoyingxiongzhuan_detail,
			R.array.shendiaoxialv_detail };

	private int[][] mImageIds = new int[][] {
			{ R.drawable.img_00, R.drawable.img_01, R.drawable.img_02 }, { R.drawable.img_10, R.drawable.img_11,
					R.drawable.img_12, R.drawable.img_13, R.drawable.img_14, R.drawable.img_15, R.drawable.img_16 },
			{ R.drawable.img_20, R.drawable.img_21 } };

	@Override
	public String initContent() {
		return "这是客户界面";
	}

	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_customer_my, null);
		initData();
		// mListView = new ExpandableListView(getActivity());
		// mListView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		// LayoutParams.FILL_PARENT));
		// getActivity().setContentView(mListView);
		mListView = (ListView) view.findViewById(R.id.myCustomerList);

		// mListView.setGroupIndicator(getResources().getDrawable(R.drawable.expander_floder));
		// mAdapter = new ExpandAdapter(getActivity(), mData);
		// mListView.setAdapter(mAdapter);
		// mListView.setDescendantFocusability(ExpandableListView.FOCUS_AFTER_DESCENDANTS);
		// mListView.setOnChildClickListener(new childClickListener());
		mListView.setAdapter(new ListViewAdapter(mData, getActivity()));
		return view;
	}

	private void initData() {
		for (int i = 0; i < mGroupArrays.length; i++) {
			String[] childs = getStringArray(mGroupArrays[i]);
			String[] details = getStringArray(mDetailIds[i]);
			for (int j = 0; j < childs.length; j++) {
				Item item = new Item(mImageIds[i][j], childs[j], details[j]);
				mData.add(item);
			}
		}
	}

	private String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}
}

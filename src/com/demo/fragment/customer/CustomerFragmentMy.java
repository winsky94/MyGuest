package com.demo.fragment.customer;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.demo.fragment.BaseFragment;
import com.demo.view.customer.CustomerItem;
import com.demo.view.customer.CustomerViewAdapter;

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
	private List<CustomerItem> mData = new ArrayList<CustomerItem>();

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
		return "客户列表";
	}

	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_customer_my, null);
		initData();
		mListView = (ListView) view.findViewById(R.id.myCustomerList);

		mListView.setAdapter(new CustomerViewAdapter(mData, getActivity()));
		return view;
	}

	private void initData() {
		for (int i = 0; i < mGroupArrays.length; i++) {
			String[] childs = getStringArray(mGroupArrays[i]);
			String[] details = getStringArray(mDetailIds[i]);
			for (int j = 0; j < childs.length; j++) {
				CustomerItem item = new CustomerItem(mImageIds[i][j], childs[j], details[j]);
				mData.add(item);
			}
		}
	}

	private String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}
}

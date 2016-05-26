package com.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.demo.view.ExpandAdapter;
import com.demo.view.Item;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

@SuppressLint("InflateParams")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomerFragmentMy extends BaseFragment {
	private ExpandableListView mListView = null;
	private ExpandAdapter mAdapter = null;
	private List<List<Item>> mData = new ArrayList<List<Item>>();

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
		mListView = (ExpandableListView) view.findViewById(R.id.myCustomerList);

		mListView.setGroupIndicator(getResources().getDrawable(R.drawable.expander_floder));
		mAdapter = new ExpandAdapter(getActivity(), mData);
		mListView.setAdapter(mAdapter);
		mListView.setDescendantFocusability(ExpandableListView.FOCUS_AFTER_DESCENDANTS);
		mListView.setOnChildClickListener(new childClickListener());

		return view;
	}

	private void initData() {
		for (int i = 0; i < mGroupArrays.length; i++) {
			List<Item> list = new ArrayList<Item>();
			String[] childs = getStringArray(mGroupArrays[i]);
			String[] details = getStringArray(mDetailIds[i]);
			for (int j = 0; j < childs.length; j++) {
				Item item = new Item(mImageIds[i][j], childs[j], details[j]);
				list.add(item);
			}
			mData.add(list);
		}
	}

	private String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}

	class childClickListener implements OnChildClickListener {
		/*
		 * ChildView 设置 布局很可能onChildClick进不来，要在 ChildView layout 里加上
		 * android:descendantFocusability="blocksDescendants",
		 * 还有isChildSelectable里返回true
		 */
		@Override
		public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
			// TODO Auto-generated method stub
			Item item = mAdapter.getChild(groupPosition, childPosition);
			new AlertDialog.Builder(getActivity()).setTitle(item.getName()).setMessage(item.getDetail())
					.setIcon(android.R.drawable.ic_menu_more)
					.setNegativeButton(android.R.string.cancel, new OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub

						}

					}).create().show();
			return true;
		}
	}

}

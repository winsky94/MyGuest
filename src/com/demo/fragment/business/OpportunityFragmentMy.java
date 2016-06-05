package com.demo.fragment.business;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.demo.common.OpportunityStatus;
import com.demo.fragment.BaseFragment;
import com.demo.view.business.OpportunityItem;
import com.demo.view.business.OpportunityViewAdapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

@SuppressLint("NewApi")
public class OpportunityFragmentMy extends BaseFragment {
	private ListView mListView = null;
	private List<OpportunityItem> mData = new ArrayList<OpportunityItem>();

	@SuppressLint("InflateParams")
	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_opportunity_my, null);
		initData();
		mListView = (ListView) view.findViewById(R.id.myOpportunityList);

		mListView.setAdapter(new OpportunityViewAdapter(mData, getActivity()));
		return view;
	}

	private void initData() {
		OpportunityStatus status = OpportunityStatus.discussion;
		OpportunityItem item = new OpportunityItem(status, "军火", "南京大学", "普通商机", 5000);
		mData.add(item);
		
		item = new OpportunityItem(status, "军火", "南京大学软件学院", "普通商机", 5000);
		mData.add(item);
		
		item = new OpportunityItem(status, "军火", "南京大学", "普通商机", 5000);
		mData.add(item);
		
		item = new OpportunityItem(status, "军火", "南京大学", "普通商机", 5000);
		mData.add(item);

	}

	@Override
	public String initContent() {
		// TODO Auto-generated method stub
		return "商机列表";
	}

}

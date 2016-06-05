package com.demo.view.business;

import java.util.List;

import com.demo.R;
import com.demo.common.OpportunityStatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class OpportunityViewAdapter extends BaseAdapter {
	private View[] itemViews;
	private Context context;

	public OpportunityViewAdapter(List<OpportunityItem> items, Context context) {
		this.context = context;
		itemViews = new View[items.size()];

		for (int i = 0; i < itemViews.length; ++i) {
			OpportunityItem item = items.get(i);
			itemViews[i] = makeItemView(item);
		}
	}

	public int getCount() {
		return itemViews.length;
	}

	public View getItem(int position) {
		return itemViews[position];
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("ResourceAsColor")
	private View makeItemView(OpportunityItem item) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// 使用View的对象itemView与R.layout.item关联
		View itemView = inflater.inflate(R.layout.opportunity_item_layout, null);

		// 通过findViewById()方法实例R.layout.item内各组件
		TextView status = (TextView) itemView.findViewById(R.id.status);
		status.setText(OpportunityStatus.toString(item.getStatus()));
		TextView title = (TextView) itemView.findViewById(R.id.title);
		title.setText(item.getTitle());
		TextView detail = (TextView) itemView.findViewById(R.id.detail);
		String detailStr = item.getMoney() + "元　|　" + item.getCustomerName();
		detail.setText(detailStr);
		TextView type = (TextView) itemView.findViewById(R.id.type);
		String typeStr = item.getType();
		type.setText(typeStr);
		type.setTextColor(Color.parseColor(getTypeColor(typeStr)));

		return itemView;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			return itemViews[position];
		return convertView;
	}

	private String getTypeColor(String type) {
		switch (type) {
		case "普通商机":
			return "#0000EE";// 蓝色
		case "重要商机":
			return "#ff0000";// 红色
		default:
			return "#eeee00";// 黄色
		}
	}

}

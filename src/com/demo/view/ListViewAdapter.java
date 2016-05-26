package com.demo.view;

import java.util.List;

import com.demo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class ListViewAdapter extends BaseAdapter {
	private View[] itemViews;
	private Context context;

	public ListViewAdapter(List<Item> items, Context context) {
		this.context = context;
		itemViews = new View[items.size()];

		for (int i = 0; i < itemViews.length; ++i) {
			Item item = items.get(i);
			itemViews[i] = makeItemView(item.getName(), item.getDetail(), item.getImageId());
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

	private View makeItemView(String strTitle, String strText, int resId) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// 使用View的对象itemView与R.layout.item关联
		View itemView = inflater.inflate(R.layout.child_item_layout, null);

		// 通过findViewById()方法实例R.layout.item内各组件
		TextView title = (TextView) itemView.findViewById(R.id.item_name);
		title.setText(strTitle);
		TextView text = (TextView) itemView.findViewById(R.id.item_detail);
		text.setText(strText);
		ImageButton image = (ImageButton) itemView.findViewById(R.id.img);
		image.setBackgroundResource(resId);// 这样就避免了图片太大只显示部分的问题

		return itemView;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			return itemViews[position];
		return convertView;
	}
}

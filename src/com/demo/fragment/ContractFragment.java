package com.demo.fragment;

import com.demo.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("InflateParams")
public class ContractFragment extends BaseFragment {
	private ImageView addButton;

	@Override
	public String initContent() {
		// TODO Auto-generated method stub
		return "商机管理";
	}

	@Override
	public View initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.frag_opportunity, null);

		// 设置右上角的图标
		addButton = (ImageView) getActivity().findViewById(R.id.addButton);
		addButton.setImageResource(R.drawable.back);
		addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment newFragment = new MainFragment(R.id.business);
				String title = getString(R.string.business);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, newFragment).commit();
				TextView topTextView = (TextView) getActivity().findViewById(R.id.topTv);
				topTextView.setText(title);
			}
		});

		return view;
	}

}

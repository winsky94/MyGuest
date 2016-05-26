package com.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import com.demo.R;
import com.demo.common.Configure;
import com.demo.common.CustomerStatus;
import com.demo.common.CustomerType;
import com.demo.domain.Customer;
import com.demo.presenter.AddCustomerPresenter;
import com.demo.utils.DateUtil;
import com.demo.utils.SharedPreferenceUtil;
import com.demo.utils.ToastUtil;
import com.demo.view.AddCustomerView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AddCustomerFragment extends Fragment implements AddCustomerView {
	private ImageView imageView;
	private TextView topTextView;

	private AddCustomerPresenter addCustomerPresenter;

	private EditText name_et;
	private EditText profile_et;
	private EditText parent_et;
	private EditText source_et;
	private EditText size_et;
	private EditText telephone_et;
	private EditText email_et;
	private EditText website_et;
	private EditText address_et;
	private EditText zipCode_et;
	private Spinner type_sp;
	private Spinner region_sp;
	private String type_select = null;
	private String region_select = null;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		addCustomerPresenter = new AddCustomerPresenter(this);

		View view = inflater.inflate(R.layout.add_customer, null);

		name_et = (EditText) view.findViewById(R.id.name);
		profile_et = (EditText) view.findViewById(R.id.profile);
		parent_et = (EditText) view.findViewById(R.id.parent);
		source_et = (EditText) view.findViewById(R.id.source);
		size_et = (EditText) view.findViewById(R.id.size);
		telephone_et = (EditText) view.findViewById(R.id.telephone);
		email_et = (EditText) view.findViewById(R.id.email);
		website_et = (EditText) view.findViewById(R.id.website);
		address_et = (EditText) view.findViewById(R.id.address);
		zipCode_et = (EditText) view.findViewById(R.id.zipCode);
		type_sp = (Spinner) view.findViewById(R.id.type);
		region_sp = (Spinner) view.findViewById(R.id.region);

		// 设置下拉框的值
		setType();
		setRegion();

		// 修改右上角图标，将加号改为提交
		imageView = (ImageView) getActivity().findViewById(R.id.addButton);
		imageView.setImageResource(R.drawable.checked);
		imageView.setOnClickListener(submitListener);
		topTextView = (TextView) getActivity().findViewById(R.id.topTv);
		topTextView.setText(getString(R.string.add_customer));

		return view;
	}

	@Override
	public void moveToCustomer() {
		// TODO Auto-generated method stub
		Fragment newFragment = new MainFragment();
		String title = getString(R.string.customers);
		getFragmentManager().beginTransaction().replace(R.id.content_frame, newFragment).commit();
		topTextView.setText(title);
	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		int type = 0;
		if (type_select != null) {
			type = CustomerType.getIndexByContent(type_select);
			if (type == 0) {
				return null;
			}
		} else {
			return null;
		}

		int regionId = -1;
		if (region_select != null) {
			regionId = Integer.parseInt(region_select);// 后面要调后台的数据库取出来Id
			if (regionId == -1)
				return null;
		} else {
			return null;
		}

		String name = name_et.getText().toString().trim();
		String profile = profile_et.getText().toString().trim();

		int status = CustomerStatus.getIndex(CustomerStatus.first_meet);
		int parentCustomerId = getParentId();
		String source = source_et.getText().toString().trim();
		String sizeStr = size_et.getText().toString().trim();
		int size = -1;
		if (sizeStr != null && !sizeStr.equals("")) {
			size = Integer.parseInt(sizeStr);
		}
		String telephone = telephone_et.getText().toString().trim();
		String email = email_et.getText().toString().trim();
		String website = website_et.getText().toString().trim();
		String address = address_et.getText().toString().trim();
		String zipCode = zipCode_et.getText().toString().trim();
		int staffId = -1;
		try {
			staffId = Integer.parseInt(SharedPreferenceUtil.get(getActivity(), Configure.STAFF_ID, "-1").toString());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		String createDate = DateUtil.getToday();// 创建时间
		String mark = "";// 备注

		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setCreateDate(createDate);
		customer.setEmail(email);
		customer.setMark(mark);
		customer.setName(name);
		customer.setParentCustomerId(parentCustomerId);
		customer.setProfile(profile);
		customer.setRegionId(regionId);
		customer.setSize(size);
		customer.setSource(source);
		customer.setStaffId(staffId);
		customer.setStatus(status);
		customer.setTelephone(telephone);
		customer.setType(type);
		customer.setWebsite(website);
		customer.setZipCode(zipCode);
		return customer;
	}

	private int getParentId() {
		String parentName = parent_et.getText().toString().trim();
		// 去数据库查询Id
		parentName = parentName + "";
		return 520;

	}

	@Override
	public void toast(String message) {
		// TODO Auto-generated method stub
		ToastUtil.showLong(getActivity(), message);
	}

	private void setType() {
		// 第一步：建立数据源
		// 数据源可以是数组，也可以是List
		final String[] myItems = getResources().getStringArray(R.array.customer_type);
		// 第二步：建立Adapter,连接数据源
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,
				myItems);
		// 第三步：为适配器设置下拉列表下拉时的菜单样式。 simple_spinner_item
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		// 第四步：将适配器添加到下拉列表上
		type_sp.setAdapter(adapter);
		// 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
		type_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// 如果数据源是List，就使用adapter.getItem(position)来获得选中的值
				// 如果数据源是数组，就使用数组名[position]来取得选中的值
				type_select = myItems[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	private void setRegion() {
		final List<String> list = new ArrayList<>();// 数据可以从后台获取
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
				list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		region_sp.setAdapter(adapter);
		region_sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				// TODO Auto-generated method stub
				region_select = adapter.getItem(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	private OnClickListener submitListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			boolean result = addCustomerPresenter.add(getActivity(), getCustomer());
			ToastUtil.showLong(getActivity(), "AddCustomerFragment 244行强制设置添加结果为true");
			result = true;
			if (result) {
				moveToCustomer();
			}
		}
	};
}

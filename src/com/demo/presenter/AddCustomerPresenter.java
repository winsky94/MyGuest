package com.demo.presenter;

import com.demo.domain.Customer;
import com.demo.listener.OnAddCustomerListener;
import com.demo.model.AddCustomerModel;
import com.demo.model.impl.AddCustomerModelImpl;
import com.demo.view.customer.AddCustomerView;

import android.content.Context;

public class AddCustomerPresenter implements OnAddCustomerListener {
	private AddCustomerModel addCustomerModel;
	private AddCustomerView addCustomerView;

	public AddCustomerPresenter(AddCustomerView addCustomerView) {
		this.addCustomerView = addCustomerView;
		addCustomerModel = new AddCustomerModelImpl();
	}

	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub
		addCustomerView.moveToCustomer();
	}

	@Override
	public void onFailure() {
		// TODO Auto-generated method stub
		String message = "测试错误的消息";
		addCustomerView.toast(message);
	}

	@Override
	public boolean add(Context context,Customer customer) {
		// TODO Auto-generated method stub
		return addCustomerModel.add(context, customer);
	}

}

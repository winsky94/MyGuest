package com.demo.listener;

import com.demo.domain.Customer;

import android.content.Context;

public interface OnAddCustomerListener {

	public boolean add(Context context, Customer customer);

	public void onSuccess();

	public void onFailure();
}

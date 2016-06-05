package com.demo.view.business;

import com.demo.common.OpportunityStatus;

public class OpportunityItem {
	private OpportunityStatus status;// 商机状态
	private String title;// 商机标题
	private String customerName;// 客户姓名
	private String type;// 商机类型
	private int money;// 预计销售金额

	public OpportunityItem(OpportunityStatus status, String title, String customerName, String type, int money) {
		super();
		this.status = status;
		this.title = title;
		this.customerName = customerName;
		this.type = type;
		this.money = money;
	}

	public OpportunityStatus getStatus() {
		return status;
	}

	public void setStatus(OpportunityStatus status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}

package com.demo.common;

public enum CustomerStatus {
	// 1：初访；2：意向；3：报价；4：成交；5：暂时搁置
	error, // 出错了
	first_meet, // 初访
	intention, // 意向
	offer, // 报价
	deal, // 成交
	delay;// 暂时搁置

	/**
	 * 根据下标得到对应的状态
	 * 
	 * @param index
	 * @return
	 */
	public static CustomerStatus getCustomerStatus(int index) {
		switch (index) {
		case 1:
			return first_meet;
		case 2:
			return intention;
		case 3:
			return offer;
		case 4:
			return deal;
		case 5:
			return delay;
		default:
			return error;
		}
	}

	public static int getIndex(CustomerStatus status) {
		return status.ordinal();
	}

	public static int getIndexByContent(String value) {
		switch (value) {
		case "初访":
			return 1;
		case "意向":
			return 2;
		case "报价":
			return 3;
		case "成交":
			return 4;
		case "暂时搁置":
			return 5;
		case "搁置":
			return 5;
		default:
			return 0;
		}
	}
}

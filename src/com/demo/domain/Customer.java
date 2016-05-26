package com.demo.domain;

import cn.bmob.v3.BmobObject;

public class Customer extends BmobObject {
	private static final long serialVersionUID = 1L;
	private int id;// 编号
	private String name;// 姓名
	private String profile;// 简介
	private int type;// 类型
	private int status;// 状态
	private int regionId;// 地区Id
	private int parentCustomerId;// 上级客户Id
	private String source;// 来源
	private int size;// 公司规模
	private String telephone;// 电话
	private String email;// 邮箱
	private String website;// 网址
	private String address;// 地址
	private String zipCode;// 邮编
	private int staffId;// 创建人
	private String createDate;// 创建时间
	private String mark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getParentCustomerId() {
		return parentCustomerId;
	}

	public void setParentCustomerId(int parentCustomerId) {
		this.parentCustomerId = parentCustomerId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}

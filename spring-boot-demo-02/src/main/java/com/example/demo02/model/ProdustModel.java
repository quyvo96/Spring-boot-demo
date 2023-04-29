package com.example.demo02.model;

import lombok.Builder;

@Builder
public class ProdustModel {

	String name;
	String price;
	Integer count;
	String describe01;
	String describe02;
	String describe03;
	String msg;
	
	
	public ProdustModel(String name, String price, Integer count, String describe01, String describe02,
			String describe03, String msg) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.describe01 = describe01;
		this.describe02 = describe02;
		this.describe03 = describe03;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getDescribe01() {
		return describe01;
	}
	public void setDescribe01(String describe01) {
		this.describe01 = describe01;
	}
	public String getDescribe02() {
		return describe02;
	}
	public void setDescribe02(String describe02) {
		this.describe02 = describe02;
	}
	public String getDescribe03() {
		return describe03;
	}
	public void setDescribe03(String describe03) {
		this.describe03 = describe03;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

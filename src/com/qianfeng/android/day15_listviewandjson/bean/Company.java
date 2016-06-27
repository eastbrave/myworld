package com.qianfeng.android.day15_listviewandjson.bean;

import java.io.Serializable;

public class Company implements Serializable{
	private String icon;
	private String name;
	public Company(String icon, String name) {
		super();
		this.icon = icon;
		this.name = name;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Company [icon=" + icon + ", name=" + name + "]";
	}
	
	

}

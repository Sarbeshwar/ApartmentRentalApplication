package com.apartmentrental.dao;

import com.apartmentrental.entity.Properties;

public class Items {
	
	private Properties prop = new Properties();
	
	private int quantity;

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items(Properties prop, int quantity) {
		super();
		this.prop = prop;
		this.quantity = quantity;
	}
	
	public Items() {
		  super();
		 }
	

}

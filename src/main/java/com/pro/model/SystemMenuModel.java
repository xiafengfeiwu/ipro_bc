package com.pro.model;

import java.io.Serializable;
import java.util.List;

import com.pro.entity.SystemMenu;

public class SystemMenuModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private SystemMenu menu;
	private List<SystemMenuModel> childs;
	public SystemMenu getMenu() {
		return menu;
	}
	public void setMenu(SystemMenu menu) {
		this.menu = menu;
	}
	public List<SystemMenuModel> getChilds() {
		return childs;
	}
	public void setChilds(List<SystemMenuModel> childs) {
		this.childs = childs;
	}
	@Override
	public String toString() {
		return "SystemMenuModel [menu=" + menu + ", childs=" + childs + "]";
	}
	
	

}

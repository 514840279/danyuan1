package com.danyuan.menu.service;

import java.util.List;

import com.danyuan.menu.vo.Menu;

public interface MenuServiceI {

	public List<Menu> getTreeNode(String id);

	public List<Menu> getAllTreeNode();

}

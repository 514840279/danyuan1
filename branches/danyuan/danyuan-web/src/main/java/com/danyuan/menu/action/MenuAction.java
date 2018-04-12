package com.danyuan.menu.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.danyuan.common.action.BaseAction;
import com.danyuan.menu.service.MenuServiceI;
import com.danyuan.menu.vo.Menu;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

	private static final Logger logger = Logger.getLogger(MenuAction.class);

	private Menu menu = new Menu();

	private MenuServiceI menuService;

	public MenuServiceI getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	@Override
	public Menu getModel() {
		return menu;
	}

	/**
	 * 异步获取树节点
	 */
	public void getTreeNode() {
		super.writeJson(menuService.getTreeNode(menu.getId()));
	}

	public void getAllTreeNode() {
		super.writeJson(menuService.getAllTreeNode());
	}

}

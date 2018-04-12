package com.danyuan.login.service;

import com.danyuan.login.vo.DataGrid;
import com.danyuan.login.vo.User;

public interface UserServiceI {

	public User save(User user);

	public User login(User user);

	public DataGrid datagrid(User user);

	public void remove(String ids);

}

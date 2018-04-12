package com.danyuan.login.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 字符集编码拦截器
 * 
 * @author 孙宇
 * 
 */
public class EncodingInterceptor extends AbstractInterceptor {

	/**
	 * @Fields serialVersionUID : 生成序列
	 */
	private static final long serialVersionUID = 2251675919669302022L;
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext actionContext = actionInvocation.getInvocationContext();
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		return actionInvocation.invoke();
	}

}

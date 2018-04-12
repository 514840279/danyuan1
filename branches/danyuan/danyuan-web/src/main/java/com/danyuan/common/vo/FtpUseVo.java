package com.danyuan.common.vo;

import java.io.File;

public class FtpUseVo {
	private String host = "192.168.199.232";
	private Integer port = 21;
	private String userName = "wth";
	private String password = "wth";
	private String ftpPath = "";
	private int repeatTime = 3;// 连接ftp服务器的次数
	private File fileter;

	public File getFileter() {
		return fileter;
	}

	public void setFileter(File fileter) {
		this.fileter = fileter;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFtpPath(String ftpPath) {
		if (ftpPath != null)
			this.ftpPath = ftpPath;
	}

	public String getFtpPath() {
		return ftpPath;
	}

	public void setRepeatTime(int repeatTime) {
		if (repeatTime > 0)
			this.repeatTime = repeatTime;
	}

	public int getRepeatTime() {
		return repeatTime;
	}

	/**
	 * take an example:<br>
	 * ftp://userName:password@ip:port/ftpPath/
	 * 
	 * @return
	 */
	public String getFTPURL() {
		StringBuffer buf = new StringBuffer();
		buf.append("ftp://");
		buf.append(getUserName());
		buf.append(":");
		buf.append(getPassword());
		buf.append("@");
		buf.append(getHost());
		buf.append(":");
		buf.append(getPort());
		buf.append("/");
		buf.append(getFtpPath());

		return buf.toString();
	}
}
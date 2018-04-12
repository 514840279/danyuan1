package com.danyuan.common.po;

// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FtpUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ftp_use", catalog = "danyuan")
public class FtpUse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2734452697667739650L;
	private String id;
	private String ftpHost;
	private String ftpPort;
	private String ftpName;
	private String ftpUserName;
	private String ftpUserPassword;
	private Timestamp cjsj;
	private String cjr;
	private Timestamp xgsj;
	private String xgr;

	// Constructors

	/** default constructor */
	public FtpUse() {
	}

	/** minimal constructor */
	public FtpUse(String id, String ftpHost, String ftpPort, String ftpName, String ftpUserName, String ftpUserPassword) {
		this.id = id;
		this.ftpHost = ftpHost;
		this.ftpPort = ftpPort;
		this.ftpName = ftpName;
		this.ftpUserName = ftpUserName;
		this.ftpUserPassword = ftpUserPassword;
	}

	/** full constructor */
	public FtpUse(String id, String ftpHost, String ftpPort, String ftpName, String ftpUserName, String ftpUserPassword, Timestamp cjsj, String cjr, Timestamp xgsj, String xgr) {
		this.id = id;
		this.ftpHost = ftpHost;
		this.ftpPort = ftpPort;
		this.ftpName = ftpName;
		this.ftpUserName = ftpUserName;
		this.ftpUserPassword = ftpUserPassword;
		this.cjsj = cjsj;
		this.cjr = cjr;
		this.xgsj = xgsj;
		this.xgr = xgr;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ftp_host", nullable = false, length = 15)
	public String getFtpHost() {
		return this.ftpHost;
	}

	public void setFtpHost(String ftpHost) {
		this.ftpHost = ftpHost;
	}

	@Column(name = "ftp_port", nullable = false, length = 6)
	public String getFtpPort() {
		return this.ftpPort;
	}

	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}

	@Column(name = "ftp_name", nullable = false, length = 50)
	public String getFtpName() {
		return this.ftpName;
	}

	public void setFtpName(String ftpName) {
		this.ftpName = ftpName;
	}

	@Column(name = "ftp_user_name", nullable = false, length = 50)
	public String getFtpUserName() {
		return this.ftpUserName;
	}

	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}

	@Column(name = "ftp_user_password", nullable = false, length = 50)
	public String getFtpUserPassword() {
		return this.ftpUserPassword;
	}

	public void setFtpUserPassword(String ftpUserPassword) {
		this.ftpUserPassword = ftpUserPassword;
	}

	@Column(name = "cjsj", length = 19)
	public Timestamp getCjsj() {
		return this.cjsj;
	}

	public void setCjsj(Timestamp cjsj) {
		this.cjsj = cjsj;
	}

	@Column(name = "cjr", length = 50)
	public String getCjr() {
		return this.cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	@Column(name = "xgsj", length = 19)
	public Timestamp getXgsj() {
		return this.xgsj;
	}

	public void setXgsj(Timestamp xgsj) {
		this.xgsj = xgsj;
	}

	@Column(name = "xgr", length = 50)
	public String getXgr() {
		return this.xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

}
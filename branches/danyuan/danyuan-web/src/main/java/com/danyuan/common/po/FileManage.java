package com.danyuan.common.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "file_manage", catalog = "danyuan")
public class FileManage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8297817998804386810L;
	// Fields

	private String id;
	private String list;
	private String fileName;
	private String fileType;
	private String fileSize;
	private String ftpHostId;
	private Timestamp cjsj;
	private String cjr;
	private Timestamp xgsj;
	private String xgr;

	// Constructors

	/** default constructor */
	public FileManage() {
	}

	/** minimal constructor */
	public FileManage(String id, String list, String fileName, String ftpHostId) {
		this.id = id;
		this.list = list;
		this.fileName = fileName;
		this.ftpHostId = ftpHostId;
	}

	/** full constructor */
	public FileManage(String id, String list, String fileName, String fileType, String fileSize, String ftpHostId, Timestamp cjsj, String cjr, Timestamp xgsj, String xgr) {
		this.id = id;
		this.list = list;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.ftpHostId = ftpHostId;
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

	@Column(name = "list",  length = 200)
	public String getList() {
		return this.list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Column(name = "file_name", nullable = false, length = 200)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_type", length = 20)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "file_size", length = 50)
	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "ftp_host_id", nullable = false, length = 36)
	public String getFtpHostId() {
		return this.ftpHostId;
	}

	public void setFtpHostId(String ftpHostId) {
		this.ftpHostId = ftpHostId;
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
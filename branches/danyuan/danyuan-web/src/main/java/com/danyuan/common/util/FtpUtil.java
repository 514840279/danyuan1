package com.danyuan.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil extends FTPClient {

	private static Log log = LogFactory.getLog(FtpUtil.class);

	private FtpUseBean ftpUseBean;
	// 获取目标路径下的文件属性信息，主要是获取文件的size
	private FTPFile[] files;

	public FtpUseBean getFtpUseBean() {
		return ftpUseBean;
	}

	public FtpUtil() {
		super();
	}

	public void setFtpUseBean(FtpUseBean usebean) {
		this.ftpUseBean = usebean;
	}

	/**
	 * 登陆ftp用
	 * 
	 * @return
	 */
	public boolean ftpLogin() {
		boolean isLogined = false;
		try {
			log.debug("ftp login start ...");
			int repeatTime = ftpUseBean.getRepeatTime();
			for (int i = 0; i < repeatTime; i++) {
				super.connect(ftpUseBean.getHost(), ftpUseBean.getPort());
				isLogined = super.login(ftpUseBean.getUserName(),
						ftpUseBean.getPassword());
				if (isLogined)
					break;
			}
			if (isLogined)
				log.debug("ftp login successfully ...");
			else
				log.debug("ftp login failed ...");
			return isLogined;
		} catch (Exception e) {
			log.error("登录失败", e);
			return false;
		}
	}

	public void setFtpToUtf8() throws IOException {

		FTPClientConfig conf = new FTPClientConfig();
		super.configure(conf);
		super.setFileType(FTP.BINARY_FILE_TYPE);
		int reply = super.sendCommand("OPTS UTF8 ON");
		if (reply == 200) { // UTF8 Command
			super.setControlEncoding("UTF-8");
		}

	}

	public void close() {
		if (super.isConnected()) {
			try {
				super.logout();
				super.disconnect();
				log.debug("ftp logout ....");
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new RuntimeException(e.toString());
			}
		}
	}

	public void uploadFileToFtpByIS(InputStream inputStream, String fileName)
			throws IOException {
		
		super.storeFile(ftpUseBean.getFtpPath() + fileName, inputStream);
	}

	public File downFtpFile(String fileName, String localFileName)
			throws IOException {
		File outfile = new File(localFileName);
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outfile);
			super.retrieveFile(ftpUseBean.getFtpPath() + fileName, oStream);
			return outfile;
		} finally {
			if (oStream != null)
				oStream.close();
		}
	}

	public FTPFile[] listFtpFiles() throws IOException {
		return super.listFiles(ftpUseBean.getFtpPath());
	}

	public void deleteFtpFiles(FTPFile[] ftpFiles) throws IOException {
		String path = ftpUseBean.getFtpPath();
		for (FTPFile ff : ftpFiles) {
			if (ff.isFile()) {
				if (!super.deleteFile(path + ff.getName()))
					throw new RuntimeException("delete File" + ff.getName()
							+ " is n't seccess");
			}
		}
	}

	public void deleteFtpFile(String fileName) throws IOException {
		if (!super.deleteFile(ftpUseBean.getFtpPath() + fileName))
			throw new RuntimeException("delete File" + ftpUseBean.getFtpPath()
					+ fileName + " is n't seccess");
	}

	public InputStream downFtpFile(String fileName) throws IOException {
		return super.retrieveFileStream(ftpUseBean.getFtpPath() + fileName);
	}

	/**
	 * 下载ftp服务器上的文件,addr为带用户名和密码的URL
	 * 
	 * @return
	 * @return StringBuffer
	 * @description 下载ftp服务器上的文件,addr为带用户名和密码的URL
	 */
	public StringBuffer downloadBufferByURL(String addr) {
		BufferedReader in = null;
		try {
			URL url = new URL(addr);
			URLConnection conn = url.openConnection();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer ret = new StringBuffer();
			while ((line = in.readLine()) != null)
				ret.append(line);

			return ret;
		} catch (Exception e) {
			log.error(e);
			return null;
		} finally {
			try {
				if (null != in)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
	}

	/**
	 * 下载ftp服务器上的文件,addr为带用户名和密码的URL
	 * 
	 * @return
	 * @return byte[]
	 * @description 下载ftp服务器上的文件,addr为带用户名和密码的URL
	 */
	public byte[] downloadByteByURL(String addr) {

		FTPClient ftp = null;

		try {

			URL url = new URL(addr);

			int port = url.getPort() != -1 ? url.getPort() : 21;
			log.info("HOST:" + url.getHost());
			log.info("Port:" + port);
			log.info("USERINFO:" + url.getUserInfo());
			log.info("PATH:" + url.getPath());

			ftp = new FTPClient();

			ftp.setDataTimeout(30000);
			ftp.setDefaultTimeout(30000);
			// ftp.setReaderThread(false);
			ftp.connect(url.getHost(), port);
			ftp.login(url.getUserInfo().split(":")[0],
					url.getUserInfo().split(":")[1]);
			FTPClientConfig conf = new FTPClientConfig("UNIX");
			ftp.configure(conf);
			log.info(ftp.getReplyString());

			ftp.enterLocalPassiveMode(); // ftp.enterRemotePassiveMode()
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);

			int reply = ftp.sendCommand("OPTS UTF8 ON");// try to

			log.debug("alter to utf-8 encoding - reply:" + reply);
			if (reply == 200) { // UTF8 Command
				ftp.setControlEncoding("UTF-8");
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			log.info(ftp.getReplyString());

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream o = new DataOutputStream(out);
			String remotePath = url.getPath();
			/**
			 * Fixed:if doen't remove the first "/" at the head of url, the file
			 * can't be retrieved.
			 */
			if (remotePath.indexOf("/") == 0) {
				remotePath = url.getPath().replaceFirst("/", "");
			}
			ftp.retrieveFile(remotePath, o);
			byte[] ret = out.toByteArray();
			o.close();

			String filepath = url.getPath();
			ftp.changeWorkingDirectory(filepath.substring(0,
					filepath.lastIndexOf("/")));
			files = ftp.listFiles();

			return ret;
		} catch (Exception ex) {
			log.error("Failed to download file from [" + addr + "]!" + ex);
		} finally {
			try {
				if (null != ftp)
					ftp.disconnect();
			} catch (Exception e) {
				//
			}
		}
		return null;
		// StringBuffer buffer = downloadBufferByURL(addr);
		// return null == buffer ? null : buffer.toString().getBytes();
	}

	public FTPFile[] getFiles() {
		return files;
	}

	public void setFiles(FTPFile[] files) {
		this.files = files;
	}

	/**
	 * 获取FTPClient对象
	 * 
	 * @param ftpHost
	 *            FTP主机服务器
	 * @param ftpPassword
	 *            FTP 登录密码
	 * @param ftpUserName
	 *            FTP登录用户名
	 * @param ftpPort
	 *            FTP端口 默认为21
	 * @return
	 */
	public static FTPClient getFTPClient(String ftpHost, String ftpPassword,
			String ftpUserName, int ftpPort) {
		FTPClient ftpClient = null;
		try {
			ftpClient = new FTPClient();
			ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
			ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				log.info("未连接到FTP，用户名或密码错误。");
				ftpClient.disconnect();
			} else {
				log.info("FTP连接成功。");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			log.info("FTP的IP地址可能错误，请正确配置。");
		} catch (IOException e) {
			e.printStackTrace();
			log.info("FTP的端口错误,请正确配置。");
		}
		return ftpClient;
	}

	public static void getftpfilesize(String addr) {

		FTPClient ftp = null;

		try {

			URL url = new URL(addr);

			int port = url.getPort() != -1 ? url.getPort() : 21;
			log.info("HOST:" + url.getHost());
			log.info("Port:" + port);
			log.info("USERINFO:" + url.getUserInfo());
			log.info("PATH:" + url.getPath());

			ftp = new FTPClient();

			ftp.setDataTimeout(30000);
			ftp.setDefaultTimeout(30000);
			// ftp.setReaderThread(false);
			ftp.connect(url.getHost(), port);
			ftp.login(url.getUserInfo().split(":")[0],
					url.getUserInfo().split(":")[1]);
			FTPClientConfig conf = new FTPClientConfig("UNIX");
			ftp.configure(conf);
			log.info(ftp.getReplyString());

			ftp.enterLocalPassiveMode(); // ftp.enterRemotePassiveMode()
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);

			int reply = ftp.sendCommand("OPTS UTF8 ON");// try to

			log.debug("alter to utf-8 encoding - reply:" + reply);
			if (reply == 200) { // UTF8 Command
				ftp.setControlEncoding("UTF-8");
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.changeWorkingDirectory(url.getPath());
			FTPFile[] files = ftp.listFiles();
			for (FTPFile flie : files) {
				System.out.println(new String(flie.getName().getBytes("gbk"),
						"ISO8859-1"));
				System.out.println(flie.getSize());
			}

		} catch (Exception ex) {
			log.error("Failed to download file from [" + addr + "]!" + ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (Exception e) {
			}
		}

	}
}
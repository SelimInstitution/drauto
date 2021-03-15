package egovframework.server.service;

import egovframework.com.cmm.ComDefaultVO;

public class AcntVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	private int rnum;
	private String ipAdres;
	private String acntId;
	private String prtclCode;
	private String prtclNm;
	private String port;
	private String password;;
	private String deleteAt;
	private String prompt;
	private String dc;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}	
	public String getIpAdres() {
		return ipAdres;
	}
	public void setIpAdres(String ipAdres) {
		this.ipAdres = ipAdres;
	}
	public String getAcntId() {
		return acntId;
	}
	public void setAcntId(String acntId) {
		this.acntId = acntId;
	}
	public String getPrtclCode() {
		return prtclCode;
	}
	public void setPrtclCode(String prtclCode) {
		this.prtclCode = prtclCode;
	}
	public String getPrtclNm() {
		return prtclNm;
	}
	public void setPrtclNm(String prtclNm) {
		this.prtclNm = prtclNm;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(String deleteAt) {
		this.deleteAt = deleteAt;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}

}

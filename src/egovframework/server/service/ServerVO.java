package egovframework.server.service;

import egovframework.com.cmm.ComDefaultVO;

public class ServerVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	private int rnum;
	private String ipAdres;
	private String hostNm;
	private String eqpmnNm;
	private String eqpmnDc;
	private String osCode;
	private String osNm;
	private String osVer;
	private String krnlVer;
	private String deleteAt;	
	
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
	public String getHostNm() {
		return hostNm;
	}
	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}
	public String getEqpmnNm() {
		return eqpmnNm;
	}
	public void setEqpmnNm(String eqpmnNm) {
		this.eqpmnNm = eqpmnNm;
	}
	public String getEqpmnDc() {
		return eqpmnDc;
	}
	public void setEqpmnDc(String eqpmnDc) {
		this.eqpmnDc = eqpmnDc;
	}
	public String getOsCode() {
		return osCode;
	}
	public void setOsCode(String osCode) {
		this.osCode = osCode;
	}
	public String getOsNm() {
		return osNm;
	}
	public void setOsNm(String osNm) {
		this.osNm = osNm;
	}
	public String getOsVer() {
		return osVer;
	}
	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}
	public String getKrnlVer() {
		return krnlVer;
	}
	public void setKrnlVer(String krnlVer) {
		this.krnlVer = krnlVer;
	}
	public String getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(String deleteAt) {
		this.deleteAt = deleteAt;
	}

}

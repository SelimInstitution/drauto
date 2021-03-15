package egovframework.dr.service;

import egovframework.com.cmm.ComDefaultVO;

public class DsstrRecovryOpertVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	
	private int opertOdr;
	private int opertDiv;
	private String opertTyCode;
	private int opertGroupId;
	private int unitOpertId;
	private String executDt;
	private String endDt;
	private String errorAt;
	private String errorCn;
	private String creatDt;
	private String crtrId;	
	private String opertSttus;	
	private String hostNm;
	private String ipAdres;
	private String eqpmnNm;
	private String unitOpertNm;
	
	public int getOpertOdr() {
		return opertOdr;
	}
	public void setOpertOdr(int opertOdr) {
		this.opertOdr = opertOdr;
	}
	public int getOpertDiv() {
		return opertDiv;
	}
	public void setOpertDiv(int opertDiv) {
		this.opertDiv = opertDiv;
	}
	public String getOpertTyCode() {
		return opertTyCode;
	}
	public void setOpertTyCode(String opertTyCode) {
		this.opertTyCode = opertTyCode;
	}
	public int getOpertGroupId() {
		return opertGroupId;
	}
	public void setOpertGroupId(int opertGroupId) {
		this.opertGroupId = opertGroupId;
	}
	public int getUnitOpertId() {
		return unitOpertId;
	}
	public void setUnitOpertId(int unitOpertId) {
		this.unitOpertId = unitOpertId;
	}
	public String getExecutDt() {
		return executDt;
	}
	public void setExecutDt(String executDt) {
		this.executDt = executDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getErrorAt() {
		return errorAt;
	}
	public void setErrorAt(String errorAt) {
		this.errorAt = errorAt;
	}
	public String getErrorCn() {
		return errorCn;
	}
	public void setErrorCn(String errorCn) {
		this.errorCn = errorCn;
	}
	public String getCreatDt() {
		return creatDt;
	}
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}
	public String getCrtrId() {
		return crtrId;
	}
	public void setCrtrId(String crtrId) {
		this.crtrId = crtrId;
	}
	public String getOpertSttus() {
		return opertSttus;
	}
	public void setOpertSttus(String opertSttus) {
		this.opertSttus = opertSttus;
	}
	public String getHostNm() {
		return hostNm;
	}
	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}
	public String getIpAdres() {
		return ipAdres;
	}
	public void setIpAdres(String ipAdres) {
		this.ipAdres = ipAdres;
	}
	public String getEqpmnNm() {
		return eqpmnNm;
	}
	public void setEqpmnNm(String eqpmnNm) {
		this.eqpmnNm = eqpmnNm;
	}
	public String getUnitOpertNm() {
		return unitOpertNm;
	}
	public void setUnitOpertNm(String unitOpertNm) {
		this.unitOpertNm = unitOpertNm;
	}
	
}

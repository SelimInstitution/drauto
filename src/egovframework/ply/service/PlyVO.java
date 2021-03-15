package egovframework.ply.service;

import egovframework.com.cmm.ComDefaultVO;

public class PlyVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	private int rn;
	private String opertGrpId;
	private String opertGrpNm;
	private String opertGrpDc;
	private String deleteAt;
	private String crtrId;
	private String creatDt;
	private String updusrId;
	private String updtDt;
	private String opertGrpKindCode;
	private String grpNm;
	private String grpCode;	
	private String gpcode;	
	private String searchL;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getOpertGrpId() {
		return opertGrpId;
	}
	public void setOpertGrpId(String opertGrpId) {
		this.opertGrpId = opertGrpId;
	}
	public String getOpertGrpNm() {
		return opertGrpNm;
	}
	public void setOpertGrpNm(String opertGrpNm) {
		this.opertGrpNm = opertGrpNm;
	}
	
	public String getGrpNm() {
		return grpNm;
	}
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}	
	
	public String getGrpCode() {
		return grpCode;
	}
	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}		
	
	public String getGpcode() {
		return gpcode;
	}
	public void setGpcode(String gpcode) {
		this.gpcode = gpcode;
	}	
	
	public String getOpertGrpKindCode() {
		return opertGrpKindCode;
	}
	public void setOpertGrpKindCode(String opertGrpKindCode) {
		this.opertGrpKindCode = opertGrpKindCode;
	}	
	public String getOpertGrpDc() {
		return opertGrpDc;
	}
	public void setOpertGrpDc(String opertGrpDc) {
		this.opertGrpDc = opertGrpDc;
	}
	public String getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(String deleteAt) {
		this.deleteAt = deleteAt;
	}
	public String getCrtrId() {
		return crtrId;
	}
	public void setCrtrId(String crtrId) {
		this.crtrId = crtrId;
	}
	public String getCreatDt() {
		return creatDt;
	}
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}
	public String getUpdusrId() {
		return updusrId;
	}
	public void setUpdusrId(String updusrId) {
		this.updusrId = updusrId;
	}
	public String getUpdtDt() {
		return updtDt;
	}
	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	public String getSearchL() {
		return searchL;
	}
	public void setSearchL(String searchL) {
		this.searchL = searchL;
	}
}

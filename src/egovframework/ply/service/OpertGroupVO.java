package egovframework.ply.service;

import egovframework.com.cmm.ComDefaultVO;

public class OpertGroupVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	
	private int rnum;
	private int opertGroupId;
	private String opertGroupNm;
	private String opertGroupDc;
	private String deleteAt;
	private String opertGroupKindCode;
	private String crtrId;
	private String creatDt;
	private String updusrId;
	private String updtDt;	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getOpertGroupId() {
		return opertGroupId;
	}
	public void setOpertGroupId(int opertGroupId) {
		this.opertGroupId = opertGroupId;
	}
	public String getOpertGroupNm() {
		return opertGroupNm;
	}
	public void setOpertGroupNm(String opertGroupNm) {
		this.opertGroupNm = opertGroupNm;
	}
	public String getOpertGroupDc() {
		return opertGroupDc;
	}
	public void setOpertGroupDc(String opertGroupDc) {
		this.opertGroupDc = opertGroupDc;
	}
	public String getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(String deleteAt) {
		this.deleteAt = deleteAt;
	}
	public String getOpertGroupKindCode() {
		return opertGroupKindCode;
	}
	public void setOpertGroupKindCode(String opertGroupKindCode) {
		this.opertGroupKindCode = opertGroupKindCode;
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

}

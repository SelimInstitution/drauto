package egovframework.ply.service;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.utl.fcc.service.EgovStringUtil;

public class UnitOpertVO extends ComDefaultVO {

	private static final long serialVersionUID = 1L;
	
	private String ipAdres;
	private String acntId;
	private String prtclCode;
	private String prtclNm;
	private int opertGroupId;
	private int unitOpertId;
	private String opertCn;
	private int opertSn;
	private String unitOpertNm;
	private String unitOpertDc;
	private String executBfeCnfirmAt;
	private String executBfeCnfirmResult;
	private String deleteAt;
	private String crtrId;
	private String creatDt;
	private String updusrId;
	private String updtDt;	

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
	public String getOpertCn() {
		return EgovStringUtil.replace(EgovStringUtil.replace(EgovStringUtil.replace(EgovStringUtil.replace(opertCn, "&gt;", ">"), "&lt;", "<"), "&quot;", "\""),"&apos;", "'");
		//return opertCn;
	}
	public void setOpertCn(String opertCn) {
		this.opertCn = opertCn;
	}
	public int getOpertSn() {
		return opertSn;
	}
	public void setOpertSn(int opertSn) {
		this.opertSn = opertSn;
	}
	public String getUnitOpertNm() {
		return unitOpertNm;
	}
	public void setUnitOpertNm(String unitOpertNm) {
		this.unitOpertNm = unitOpertNm;
	}
	public String getUnitOpertDc() {
		return unitOpertDc;
	}
	public void setUnitOpertDc(String unitOpertDc) {
		this.unitOpertDc = unitOpertDc;
	}
	public String getExecutBfeCnfirmAt() {
		return executBfeCnfirmAt;
	}
	public void setExecutBfeCnfirmAt(String executBfeCnfirmAt) {
		this.executBfeCnfirmAt = executBfeCnfirmAt;
	}
	public String getExecutBfeCnfirmResult() {
		return executBfeCnfirmResult;
	}
	public void setExecutBfeCnfirmResult(String executBfeCnfirmResult) {
		this.executBfeCnfirmResult = executBfeCnfirmResult;
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

}

package egovframework.ply.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * ServerManage를 위한 VO  클래스
 * @author 최장성
 * @since 2012.02.02
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일              수정자              수정내용
 *  ----------  --------    ---------------------------
 *  2012.02.02  최장성              최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class PlyManageVO implements Serializable {


    /** ip 주소 */
    private String opert_group_id = "1";

    /** 장비명 */
    private String unit_opert_id = "";

    /** 장비 설명 */
    private String ip_adres = "";

    /** os code */
    private String acnt_id = "";

    /** os 명 */
    private String prtcl_knd = "";

    /** 삭제여부 */
    private String result = "";

  

    /**
     * opert_group_id를 리턴한다.
     * 
     * @return the rn
     */
    public String getOpert_group_id() {
	return opert_group_id;
    }

    /**
     * rn attribute 값을 설정한다.
     * 
     * @param uniqId
     *            the rn to set
     */
    public void setOpert_group_id(String opert_group_id) {
	this.opert_group_id = opert_group_id;
    }
    
    /**
     * ip_adres attribute를 리턴한다.
     * 
     * @return the ip_adres
     */
    public String getUnit_opert_id() {
	return unit_opert_id;
    }

    /**
     * ip_adres attribute 값을 설정한다.
     * 
     * @param uniqId
     *            the ip_adres to set
     */
    public void setUnit_opert_id(String unit_opert_id) {
	this.unit_opert_id = unit_opert_id;
    }

    /**
     * eqpmn_nm attribute를 리턴한다.
     * 
     * @return the eqpmn_nm
     */
    public String getIp_adres() {
	return ip_adres;
    }

    /**
     * userId attribute 값을 설정한다.
     * 
     * @param eqpmn_nm
     *            the eqpmn_nm to set
     */
    public void setIp_adres(String ip_adres) {
	this.ip_adres = ip_adres;
    }

    /**
     * eqpmn_dc attribute를 리턴한다.
     * 
     * @return the eqpmn_dc
     */
    public String getAcnt_id() {
	return acnt_id;
    }

    /**
     * eqpmn_dc attribute 값을 설정한다.
     * 
     * @param eqpmn_dc
     *            the eqpmn_dc to set
     */
    public void setAcnt_id(String acnt_id) {
	this.acnt_id = acnt_id;
    }

    /**
     * os_code attribute를 리턴한다.
     * 
     * @return the os_code
     */
    public String getPrtcl_knd() {
	return prtcl_knd;
    }

    /**
     * userZip attribute 값을 설정한다.
     * 
     * @param os_code
     *            the os_code to set
     */
    public void setPrtcl_knd(String prtcl_knd) {
	this.prtcl_knd = prtcl_knd;
    }
    
    /**
     * os_nm attribute를 리턴한다.
     * 
     * @return the os_nm
     */
    public String getResult() {
	return result;
    }


    /**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
}

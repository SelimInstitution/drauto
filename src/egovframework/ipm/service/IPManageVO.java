package egovframework.ipm.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.StringUtils;


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
public class IPManageVO implements Serializable {
	
	String searchList[] = new String[]{"&apos;", "&quot;", "&lt;", "&gt;"};
	String replacementList[] = new String[]{"'", "\"", "<", ">"};

    /** ip 주소 */
    private String ipAdres;
    /** 서브넷마스크 */
    private String subnetMask;
    /** 호스트명 */
    private String hostNm;    
    /** 장비종류 */
    private String eqpmnKnd;  
    /** 용도 */
    private String prpos;      
    /** 망구분 */
    private String ntwkDiv;   
    /** 비고 */
    private String rm;
    /** 현재 아이피 */
    private String preIpAdres;
	/** 변경될ip 주소(아이피 입력 후 변경 확인을 위해 추가) */
    private String inputIpAdres; 
    /** 중복여부 */
    private String overlapYn = "";
    /** 등록 모드 구분*/
    private String regMode = "";
    /** 검색 구분*/
    private String searchMode = "";
    /** 검색 값 */
    private String searchValue = "";
    /** 생성자 ID */
    private String crtrId = "";
    /** 생성일 */
    private String creatDt = "";
    /** 수정자 ID */
    private String updusrId = "";
    /** 수정일 */
    private String updtDt = "";
    /** ping 결과 */
    private String alive = "";    
    /** 생성자 */
    private String crtrNm = "";
	/**검색조건  망구분 */
    private String searchNtwkDiv = "";
    /**검색조건  수정일 */
    private String searchEqpmnKnd = "";
    /**검색조건  호스트명 */
    private String searchHostNm = "";
    /**검색조건  ip*/
    private String searchIpAdres = "";
    
	/** 현재페이지 */
    private int pageIndex = 1;

    /** 페이지갯수 */
    private int pageUnit = 10;

    /** 페이지사이즈 */
    private int pageSize = 10;

    /** 첫페이지 인덱스 */
    private int firstIndex = 1;

    /** 마지막페이지 인덱스 */
    private int lastIndex = 1;

    /** 페이지당 레코드 개수 */
    private int recordCountPerPage = 10;

    /** 레코드 번호 */
    private int rowNo = 0;
    
    

    public String getInputIpAdres() {
		return inputIpAdres;
	}
	public void setInputIpAdres(String inputIpAdres) {
		this.inputIpAdres = inputIpAdres;
	}
    public String getSearchNtwkDiv() {
		return searchNtwkDiv;
	}
	public void setSearchNtwkDiv(String searchNtwkDiv) {
		this.searchNtwkDiv = searchNtwkDiv;
	}
	public String getSearchEqpmnKnd() {
		return searchEqpmnKnd;
	}
	public void setSearchEqpmnKnd(String searchEqpmnKnd) {
		this.searchEqpmnKnd = searchEqpmnKnd;
	}
	public String getSearchHostNm() {
		return searchHostNm;
	}
	public void setSearchHostNm(String searchHostNm) {
		this.searchHostNm = searchHostNm;
	}
	public String getSearchIpAdres() {
		return searchIpAdres;
	}
	public void setSearchIpAdres(String searchIpAdres) {
		this.searchIpAdres = searchIpAdres;
	}
    public String getCrtrNm() {
		return crtrNm;
	}
	public void setCrtrNm(String crtrNm) {
		this.crtrNm = crtrNm;
	}
    public String getSearchMode() {
		return searchMode;
	}
	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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
	public String getPreIpAdres() {
		return preIpAdres;
	}
	public void setPreIpAdres(String preIpAdres) {
		this.preIpAdres = preIpAdres;
	}
	
    public String getAlive() {
		return alive;
	}
	public void setAlive(String alive) {
		this.alive = alive;
	}  
    
	public String getRegMode() {
		return regMode;
	}
	public void setRegMode(String regMode) {
		this.regMode = regMode;
	}
	public String getOverlapYn() {
		return overlapYn;
	}
	public void setOverlapYn(String overlapYn) {
		this.overlapYn = overlapYn;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public String getIpAdres() {
		return ipAdres;
	}
	public void setIpAdres(String ipAdres) {
		this.ipAdres = ipAdres;
	}
	public String getSubnetMask() {
		return subnetMask;
	}
	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
	public String getHostNm() {
		return hostNm;
	}
	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}
	public String getEqpmnKnd() {
		//return StringUtils.replaceEach(eqpmnKnd, searchList, replacementList);
		return eqpmnKnd;
	}
	public void setEqpmnKnd(String eqpmnKnd) {
		this.eqpmnKnd = eqpmnKnd;
	}
	public String getPrpos() {
		//return StringUtils.replaceEach(prpos, searchList, replacementList);
		return prpos;
	}
	public void setPrpos(String prpos) {
		this.prpos = prpos;
	}
	public String getNtwkDiv() {
		return ntwkDiv;
	}
	public void setNtwkDiv(String ntwkDiv) {
		this.ntwkDiv = ntwkDiv;
	}
	public String getRm() {
		return StringUtils.replaceEach(rm, searchList, replacementList);
		//return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
}

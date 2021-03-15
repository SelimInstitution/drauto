package egovframework.ply.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ply.service.OpertGroupVO;
import egovframework.ply.service.UnitOpertVO;

@Repository("opertManageDAO")
public class OpertManageDAO extends EgovComAbstractDAO {
	
	/**
	 * 공통코드에서 작업그룹의 종류 정보 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List selectOpertGroupKind() {
//		System.out.println(":::::::serverManageDAO.selectOpertGroupKind::::::::::");
		return list("serverManageDAO.selectOpertGroupKind", null);
	}	

	/**
	 * 작업그룹 목록을 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List selectOpertGroupList(OpertGroupVO opertGroupVO) {
//		System.out.println(":::::::opertManageDAO.selectOpertGroupList::::::::::");
		return list("opertManageDAO.selectOpertGroupList", opertGroupVO);
	}
	
	/**
	 * 작업그룹 개수를 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public int selectOpertGroupListTotCnt(OpertGroupVO opertGroupVO) {
//		System.out.println(":::::::opertManageDAO.selectOpertGroupListTotCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("opertManageDAO.selectOpertGroupListTotCnt", opertGroupVO);
	} 	
	
	/**
	 * 작업그룹을 등록한다.
	 * @param opertGroupVO
	 * @return
	 */
	public Object insertOpertGroup(OpertGroupVO opertGroupVO) {
//		System.out.println(":::::::opertManageDAO.insertOpertGroup::::::::::");
		return insert("opertManageDAO.insertOpertGroup", opertGroupVO);
	}
	
	/**
	 * 작업그룹을 수정한다.
	 * @param opertGroupVO
	 * @return
	 */
	public int updateOpertGroup(OpertGroupVO opertGroupVO) {
//		System.out.println(":::::::opertManageDAO.updateOpertGroup::::::::::");
		return update("opertManageDAO.updateOpertGroup", opertGroupVO);
	}
	
	/**
	 * 작업그룹의 삭제여부를 수정한다.
	 * @param opertGroupVO
	 * @return
	 */
	public int deleteOpertGroup(OpertGroupVO opertGroupVO) {
//		System.out.println(":::::::opertManageDAO.deleteOpertGroup::::::::::");
		return update("opertManageDAO.deleteOpertGroup", opertGroupVO);
	}
	
	/**
	 * 단위작업 목록을 조회한다.
	 * @param unitOpertVO
	 * @return
	 */
	public List selectUnitOpertList(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.selectUnitOpertList::::::::::");
		return list("opertManageDAO.selectUnitOpertList", unitOpertVO);
	}
	
	/**
	 * 단위작업 순번이 존재하는지 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public int selectUnitOpertSnCnt(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.selectUnitOpertSnCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("opertManageDAO.selectUnitOpertSnCnt", unitOpertVO);
	} 	
	
	/**
	 * 단위작업 Max값 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public int selectUnitOpertSnMaxVal(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.selectUnitOpertSnCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("opertManageDAO.selectUnitOpertSnMaxVal", unitOpertVO);
	}	
	
	/**
	 * 단위작업 순번이 존재시 max + 1 값을 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public int selectUnitOpertSnMax(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.selectUnitOpertSnMax::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("opertManageDAO.selectUnitOpertSnMax", unitOpertVO);
	} 
	
	/**
	 * 단위작업을 등록한다.
	 * @param opertGroupVO
	 * @return
	 */
	public Object insertUnitOpert(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.insertUnitOpert::::::::::");
		return insert("opertManageDAO.insertUnitOpert", unitOpertVO);
	}
	
	/**
	 * 단위작업을 수정한다.
	 * @param opertGroupVO
	 * @return
	 */
	public int updateUnitOpert(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.updateUnitOpert::::::::::");
		return update("opertManageDAO.updateUnitOpert", unitOpertVO);
	}
	
	/**
	 * 단위작업의 삭제여부를 수정한다.
	 * @param opertGroupVO
	 * @return
	 */
	public int deleteUnitOpert(UnitOpertVO unitOpertVO) {
//		System.out.println(":::::::opertManageDAO.deleteUnitOpert::::::::::");
		return update("opertManageDAO.deleteUnitOpert", unitOpertVO);
	}
	
	/**
	 * IP 정보를 조회한다.
	 * @return
	 */
	public List selectIpAdresList() {
//		System.out.println(":::::::opertManageDAO.selectIpAdresList::::::::::");
		return list("opertManageDAO.selectIpAdresList", null);
	}
	
	/**
	 * 계정 정보를 조회한다.
	 * @param commandMap
	 * @return
	 */
	public List selectAcntList(Map<String, Object> commandMap) {
//		System.out.println(":::::::opertManageDAO.selectAcntList::::::::::");
		return list("opertManageDAO.selectAcntList", commandMap);
	}
	
	/**
	 * 프로토콜 정보를 조회한다.
	 * @param commandMap
	 * @return
	 */
	public List selectPrtclList(Map<String, Object> commandMap) {
//		System.out.println(":::::::opertManageDAO.selectPrtclList::::::::::");
		return list("opertManageDAO.selectPrtclList", commandMap);
	}	
}

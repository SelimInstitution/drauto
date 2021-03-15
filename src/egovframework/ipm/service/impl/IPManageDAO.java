package egovframework.ipm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ipm.service.IPManageVO;

@Repository("ipManageDAO")
public class IPManageDAO extends EgovComAbstractDAO {

	/**
	 * ip관리 목록을 조회한다.
	 * @param ipManageVO - 
	 */
	@SuppressWarnings("unchecked")
	public List selectIPManageList(IPManageVO ipManageVO) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectPlyManage::::::::::");
		return list("IPManageDAO.selectIPManageList", ipManageVO);
	}
	
	/**
	 * ip관리 목록을 조회한다.
	 * @param ipManageVO - 
	 */
	@SuppressWarnings("unchecked")
	public int selectIPManageListTotCnt(IPManageVO ipManageVO) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectPlyManage::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("IPManageDAO.selectIPManageListTotCnt", ipManageVO);
	}
	
	/**
	 * ip관리 정보를 등록한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public void insertIPManage(IPManageVO ipManageVO) {
		insert("IPManageDAO.insertIPManage", ipManageVO);
	}
	
	/**
	 * ip관리 정보를 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public IPManageVO modifyIPManage(IPManageVO ipManageVO) {
		return (IPManageVO)selectByPk("IPManageDAO.modifyIPManage", ipManageVO);
	}
	
	/**
	 * ip관리 정보를 수정한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public void updateIPManage(IPManageVO ipManageVO) {
		update("IPManageDAO.updateIPManage", ipManageVO);
	}
	
	/**
	 * ip관리 정보를 삭제한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public void deleteIPManage(IPManageVO ipManageVO) {
		update("IPManageDAO.deleteIPManage", ipManageVO);
	}
	
	/**
	 * ip관리 정보를 삭제한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public String overlapIP(IPManageVO ipManageVO) {
		return (String)selectByPk("IPManageDAO.overlapIP", ipManageVO);
	}
	
	
	/**
	 * 서버정보를 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectDivCode() {
		return list("IPManageDAO.selectDivCode", "");
	}
	
	/**
	 * ping test를 위한 ip리스트를 가져온다.
	 * @param ipManageVO - 
	 */
	@SuppressWarnings("unchecked")
	public List selectPingIpAdress() {
		return list("IPManageDAO.selectIpPingList", null);
	}
	
	/**
	 * ping test alive 값 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateAlive(Map<String, Object> commandMap) {
		update("IPManageDAO.updateAlive", commandMap);
	}
	
	/**
	 * ping test alive 값 Clear 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateAliveClear() {
		update("IPManageDAO.updateAliveClear", null);
	}		
}

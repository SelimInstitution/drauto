package egovframework.dr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.dr.service.DsstrRecovryOpertVO;
import egovframework.ply.service.OpertGroupVO;
import egovframework.ply.service.UnitOpertVO;

@Repository("dsstrRecovryManageDAO")
public class DsstrRecovryManageDAO extends EgovComAbstractDAO {
	
	/**
	 * 재해복구 작업의 차수 목록을 조회한다.
	 * @return
	 */
	public List selectOpertOdrList(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.selectOpertOdrList::::::::::");
		return list("dsstrRecovryManageDAO.selectOpertOdrList", dsstrRecovryOpertVO);
	}
	
	/**
	 * 재해복구 작업의 차수를 추가 한다.
	 * @return
	 */
	public Object insertOpertOdr(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.insertOpertOdr::::::::::");
		return insert("dsstrRecovryManageDAO.insertOpertOdr", dsstrRecovryOpertVO);
	}
	
	/**
	 * 재해복구 작업의 마지막 차수를 조회한다.
	 * @return
	 */
	public int selectMaxOpertOdr(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.selectMaxOpertOdr::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("dsstrRecovryManageDAO.selectMaxOpertOdr", dsstrRecovryOpertVO);
	}
	
	/**
	 * 특정 차수의 재해복구 작업 목록을 조회 한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 */
	public List selectDsstrRecovry(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.selectDsstrRecovry::::::::::");
		return list("dsstrRecovryManageDAO.selectDsstrRecovry", dsstrRecovryOpertVO);
	}
	
	/**
	 * 작업그룹의 상태를 조회한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 */
	public List selectOpertGgroupSttus(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.selectOpertGgroupSttus::::::::::");
		return list("dsstrRecovryManageDAO.selectOpertGgroupSttus", dsstrRecovryOpertVO);
	}
	
	/**
	 * 대분류의 작업상태를 조회한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 */
	public List selectLclasSttus(DsstrRecovryOpertVO dsstrRecovryOpertVO) {
//		System.out.println(":::::::dsstrRecovryManageDAO.selectLclasSttus::::::::::");
		return list("dsstrRecovryManageDAO.selectLclasSttus", dsstrRecovryOpertVO);	
	}
}

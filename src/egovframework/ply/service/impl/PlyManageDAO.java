package egovframework.ply.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.ply.service.PlyVO;
import egovframework.server.service.ServerVO;

@Repository("plyManageDAO")
public class PlyManageDAO extends EgovComAbstractDAO {


	/**
	 * 서버정보를 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectPlyManage(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectPlyManage::::::::::");
		return list("plyManageDAO.selectPlyManageList", commandMap);
	}	
	
	/**
	 * 서버정보를 신규로 등록한다.
	 * @param deptManageVO - 부서 model
	 */
	public void insertPlyManage(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.insertPlyManage::::::::::");
		insert("plyManageDAO.insertPlyManage", commandMap);
	}

	/**
	 * 서버 시작시간을 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateExecutTime(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateExecutTime::::::::::");
		update("plyManageDAO.updateExecutTime", commandMap);
	}	
	
	/**
	 * 서버 종료시간을 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateEndTime(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateEndTime::::::::::");
		update("plyManageDAO.updateEndTime", commandMap);
	}	
	
	/**
	 * 서버 결과를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateResult(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateResult::::::::::");
		update("plyManageDAO.updateResult", commandMap);
	}	
	
	/**
	 * 작업그룹 목록을 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List<PlyVO> selectOpertGrpList(PlyVO plyVO) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectOpertGrpList::::::::::");
		return list("plyManageDAO.selectOpertGroupList", plyVO);
	}	
	
	
	/**
	 * 서버 목록 개수를 조회한다.
	 * @param serverVO
	 * @return
	 */
	public int selectOpertGrpListTotCnt(PlyVO plyVO) {
//		System.out.println(":::::::plyManageDAO.selectOpertGroupListTotCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("plyManageDAO.selectOpertGroupListTotCnt", plyVO);
	}	
	
	/**
	 * 단위작업 목록을 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectUnitOpertList(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectUnitOpertList::::::::::");
		return list("plyManageDAO.selectUnitOpertList", commandMap);
	}	
	
	/**
	 * 작업그룹 내의 모든 단위작업 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectGrpByUnitList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectGrpByUnitList::::::::::");
		return list("plyManageDAO.selectGrpByUnitList", commandMap);
	}
	
	/**
	 * 실행시작 시간을 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectSysdate(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectSysdate::::::::::");
		return list("plyManageDAO.selectSysdate", commandMap);
	}	
	
	/**
	 * 작업그룹 내의 모든 단위작업 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectExeResultList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectExeResultList::::::::::");
		return list("plyManageDAO.selectExeResultList", commandMap);
	}	
	
	/**
	 * 실행전 확인 결과를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateExecutCnfirm(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateExecutCnfirm::::::::::");
		update("plyManageDAO.updateExecutCnfirm", commandMap);
	}
	
	/**
	 * next row를 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectNextrowList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectNextList::::::::::");
		return list("plyManageDAO.selectNextrowList", commandMap);
	}	
	
	/**
	 * next 팝업에 대한 정보를 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectNextPopList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectNextList::::::::::");
		return list("plyManageDAO.selectNextPopList", commandMap);
	}
	
	/**
	 * 실행취소 여부 확인 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectCanclAtList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectCanclAtList::::::::::");
		return list("plyManageDAO.selectCanclAt", commandMap);
	}
	
	/**
	 * 실행취소 여부를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateCancl(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateCancl::::::::::");
		update("plyManageDAO.updateCancl", commandMap);
	}	
	
	/**
	 * 결과조회 팝업 정보를 조회
	 * @param opertGroupId
	 * @return
	 */
	public List selectPopList(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectPopList::::::::::");
		return list("plyManageDAO.selectPopList", commandMap);
	}	

	/**
	 * 작업그룹실행일시 max값을 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectMaxExecutDt(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectMaxExecutDt::::::::::");
		return list("plyManageDAO.selectMaxExecutDt", commandMap);
	}

	/**
	 * 실행취소 cancl_At조회  조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectCanclAtCnfrirm(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectCanclAtCnfirm::::::::::");
		return list("plyManageDAO.selectCanclAtCnfirm", commandMap);
	}	
	
	/**
	 * 실행상태를 조회한다.
	 * @param serverVO
	 * @return
	 */
	public int selectExecutCnt(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectExecutCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("plyManageDAO.selectExecutCnt", commandMap);
	}	
	
	/**
	 * 실행취소 후 재실행 상태의 count를 조회한다.
	 * @param serverVO
	 * @return
	 */
	public int selectCanclAtCnt(Map<String, Object> commandMap) {
//		System.out.println(":::::::plyManageDAO.selectCanclAtCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("plyManageDAO.selectCanclAtCnt", commandMap);
	}	
	
	/**
	 * 실행취소의 경우 opert_group_execut_dt  조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectOpertExecutDt(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectOpertExecutDt::::::::::");
		return list("plyManageDAO.selectOpertExecutDt", commandMap);
	}
	
	/**
	 * startofsript를 만났을때 시작시간 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateDsstrRecovOpertExecutTime(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateDsstrRecovOpertExecutTime::::::::::");
		update("plyManageDAO.updateDsstrRecovOpertExecutTime", commandMap);
	}	
	
	/**
	 * endofscript를 만났을때 end_time를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateDsstrRecovOpertEndTime(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateDsstrRecovOpertEndTime::::::::::");
		update("plyManageDAO.updateDsstrRecovOpertEndTime", commandMap);
	}	
	
	
	/**
	 * processcommand를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateRecovOpert(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateDsstrRecovOpert::::::::::");
		update("plyManageDAO.updateDsstrRecovOpert", commandMap);
	}	
	
	/**
	 * processcommand end_time를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateRecovOpertEndTime(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateRecovOpertEndTime::::::::::");
		update("plyManageDAO.updateDsstrRecovOpertEndTime", commandMap);
	}
	
	/**
	 * processcommand.ERROR ERROR_AT 'Y'로 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateRecovOpertErrorAt(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateRecovOpertErrorAt::::::::::");
		update("plyManageDAO.updateDsstrRecovOpertError", commandMap);
	}	
	
	/**
	 * DR TABLE에 ERROR_AT 'Y' 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectErrorAt(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectErrorAt::::::::::");
		return list("plyManageDAO.selectErrorAt", commandMap);
	}	
	
	/**
	 * 작업그룹 그룹핑 코드 조회한다.
	 * @param deptManageVO - 부서 model
	 */
	@SuppressWarnings("unchecked")
	public List selectGrpCode() {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.selectGrCode::::::::::");
		return list("plyManageDAO.selectGrCode", null);
	}	
	
	/**
	 * 실행전 확인여부 플래그 값 원복  업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateUnitOpertCnfirmResult(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateUnitOpertCnfirmResult::::::::::");
		update("plyManageDAO.updateUnitOpertCnfirmResult", commandMap);
	}	
	
	/**
	 * 실행취소여부 플래그 값 원복  업데이트 한다.
	 * @param deptManageVO - 부서 model
	 */
	public void updateCanclRecov(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
//		System.out.println(":::::::plyManageDAO.updateCancelRecov::::::::::");
		update("plyManageDAO.updateCanclRecov", commandMap);
	}	
}

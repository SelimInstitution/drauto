package egovframework.ply.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import egovframework.ply.service.EgovPlyManageService;
import egovframework.ply.service.PlyVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("egovPlyManageService")
public class EgovPlyManageServiceImpl extends AbstractServiceImpl implements EgovPlyManageService {
	
	@Resource(name="plyManageDAO")
    private PlyManageDAO plyManageDAO;

//	@Autowired
//	private OpertGroupService ogs;		
	
	/**
	 * 부서를 관리하기 위해 등록된 부서목록을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectPlyManageList(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectPlyManage(commandMap);
	}
	
	/**
	 * async 테스트
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void asyncTest(String opert_group_id, String userid, String[] chk_val, String executdt) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("egovframework/spring/com/context-*.xml");
		OpertGroupService ogs = (OpertGroupService)context.getBean("OpertGroupService");	
		ogs.opertGroupExecut(opert_group_id, userid, chk_val, executdt);
	}	
	

	/**
	 * 서버정보를 신규로 등록한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void insertPlyManage(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::insertPlyManage:::::::::" + commandMap);
		plyManageDAO.insertPlyManage(commandMap);
	}

	/** 서버 시작시간을 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateExecutTime(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateExecutTime:::::::::" + commandMap);
		plyManageDAO.updateExecutTime(commandMap);
	}		
	
	
	/**
	 * 서버 종료시간을 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateEndTime(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateEndTime:::::::::" + commandMap);
		plyManageDAO.updateEndTime(commandMap);
	}	
	
	/**
	 * 서버 결과를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateResult(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateEndTime:::::::::" + commandMap);
		plyManageDAO.updateResult(commandMap);
	}		
	
	/**
	 * 실행전 확인결과를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateExecutCnfirm(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateExecutCnfirm:::::::::" + commandMap);
		plyManageDAO.updateExecutCnfirm(commandMap);
	}		
	
	/**
	 * 작업그룹 목록을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List<PlyVO> selectOpertGrpList(PlyVO plyVO) throws Exception {
////		System.out.println("::::::::::selectOpertGrpList:::::::::" + plyVO);
		return plyManageDAO.selectOpertGrpList(plyVO);
	}	
	
	
	/**
	 * 서버 목록의 개수를 조회한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectOpertGrpListTotCnt(PlyVO plyVO) throws Exception {
		return plyManageDAO.selectOpertGrpListTotCnt(plyVO);
	}
	/**
	 * 단위작업 목록을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectUnitOpertList(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::selectOpertGrpList:::::::::" + commandMap);
		return plyManageDAO.selectUnitOpertList(commandMap);
	}	
	
	/**
	 * next row를 조회 한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectNextrowList(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectNextrowList(commandMap);
	}	
	
	/**
	 * next 팝업에 대한 정보를 조회 한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectNextPopList(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectNextPopList(commandMap);
	}
	
	/**
	 * 실행취소 여부를 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateCancl(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateCancl:::::::::" + commandMap);
		plyManageDAO.updateCancl(commandMap);
	}	
	
	/**
	 * 결과조회 팝업에 대한 정보를 조회 한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectPopList(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectPopList(commandMap);
	}
	
	/**
	 * 작업그룹실행일시 max값을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectMaxExecutDt(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectMaxExecutDt(commandMap);
	}	
	
	/**
	 * 실행상태를 조회한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectExecutCnt(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectExecutCnt(commandMap);
	}	
	
	
	/**
	 * 실행시작 시간을 조회.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectSysdate(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectSysdate(commandMap);
	}	
	
	/**
	 * startofscrip를 만났을때 시작시간 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateDsstrRecovOpertExecutTime(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateDsstrRecovOpertExecutTime:::::::::" + commandMap);
		plyManageDAO.updateDsstrRecovOpertExecutTime(commandMap);
	}	
	
	/**
	 * endofscript를 만났을때 end_time 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateDsstrRecovOpertEndTime(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateDsstrRecovOpertEndTime:::::::::" + commandMap);
		plyManageDAO.updateDsstrRecovOpertEndTime(commandMap);
	}	
	
	/**
	 * processcommand 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateRecovOpert(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateRecovOpert:::::::::" + commandMap);
		plyManageDAO.updateRecovOpert(commandMap);
	}	
	
	/**
	 * processcommand end_time 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateRecovOpertEndTime(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateRecovOpertEndTime:::::::::" + commandMap);
		plyManageDAO.updateRecovOpertEndTime(commandMap);
	}	
	
	/**
	 * processcommand.ERROR을 만났을때 ERROR_AT 'Y' 업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateRecovOpertErrorAt(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateRecovOpertErrorAt:::::::::" + commandMap);
		plyManageDAO.updateRecovOpertErrorAt(commandMap);
	}	
	
	/**
	 * DR TABLE에 ERROR_AT 'Y' 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectErrorAt(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectErrorAt(commandMap);
	}
	
	/**
	 * 작업그룹 내의 모든 단위작업 조회
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectGrpByUnitList(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectGrpByUnitList(commandMap);
	}	
	
	/**
	 * 작업그룹 내의 모든 단위작업 조회
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public int selectCanclAtCnt(Map<String, Object> commandMap) throws Exception {
		return plyManageDAO.selectCanclAtCnt(commandMap);
	}	
	
	/**
	 * 작업그룹 그룹핑 코드 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectGrpCode() throws Exception {
		return plyManageDAO.selectGrpCode();
	}	
	
	/**
	 * 실행전 확인여부 플래그 값 원복  업데이트 한다.
	 * @param deptManageVO - 부서 model
	 * 
	 * @param deptManageVO
	 */
	public void updateUnitOpertCnfirmResult(Map<String, Object> commandMap) throws Exception {
////		System.out.println("::::::::::updateUnitOpertCnfirmResult:::::::::" + commandMap);
		plyManageDAO.updateUnitOpertCnfirmResult(commandMap);
	}	
	
	
}

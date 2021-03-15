package egovframework.ply.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface EgovPlyManageService {

	/**
	 * 서버정보  목록을 조회한다.
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List selectPlyManageList(Map<String, Object> commandMap) throws Exception;	
//	public List<DeptManageVO> selectDeptManageList(DeptManageVO deptManageVO) throws Exception;
	/**
	 * 서버정보를 신규로 등록한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void insertPlyManage(Map<String, Object> commandMap) throws Exception;

	/**
	 * 서버 시작시간을 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateExecutTime(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 서버 종료시간을 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateEndTime(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * 서버 결과를 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateResult(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 작업그룹  목록을 조회한다.
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List<PlyVO> selectOpertGrpList(PlyVO plyVO) throws Exception;
	
	/**
	 * 작업그룹 개수를 조회한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectOpertGrpListTotCnt(PlyVO plyVO) throws Exception;	
	
	/**
	 * 단위작업  목록을 조회한다.
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List selectUnitOpertList(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * 실행전 확인 confirm 후 결과를 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateExecutCnfirm(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * next row 정보를 조회한다.
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List selectNextrowList(Map<String, Object> commandMap) throws Exception;
	
	/**
	 * next row를 통한 next 팝업을 위한 정보를 조회
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List selectNextPopList(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * 실행취소 여부를 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateCancl(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * 결과조회 팝업을 조회한다.
	 * @param PlyManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param PlyManageVO
	 */
	public List selectPopList(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * 작업실행일시 max 값을 조회한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public List selectMaxExecutDt(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 실행상태를 조회
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectExecutCnt(Map<String, Object> commandMap) throws Exception;
	
	/**
	 * STARTOFSCRIP를 만났을때 시작시간 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateDsstrRecovOpertExecutTime(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * ENDOFSCRIP를 만났을때 종료시간 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateDsstrRecovOpertEndTime(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * processcommand.START 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateRecovOpert(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * processcommand.END end_time 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateRecovOpertEndTime(Map<String, Object> commandMap) throws Exception;	
	
	/**
	 * processcommand.ERROR ERROR_AT를 'Y' 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateRecovOpertErrorAt(Map<String, Object> commandMap) throws Exception;
	
	/**
	 * DR TABLE에 ERROR_AT 'Y' 조회한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public List selectErrorAt(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 작업그룹 그룹핑 코드 조회한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public List selectGrpCode() throws Exception;		
	
	/**
	 * 작업그룹 내의 모든 단위작업 조회
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public List selectGrpByUnitList(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 실행취소 후 재실행 상태의 count를 조회한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public int selectCanclAtCnt(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 실행시작 시간을 조회
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public List selectSysdate(Map<String, Object> commandMap) throws Exception;		
	
	/**
	 * 실행전 확인여부 플래그 값 원복  업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateUnitOpertCnfirmResult(Map<String, Object> commandMap) throws Exception;
	
	
	
	/**
	 * async 테스트.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
//	@Transactional
	public void asyncTest(String opert_group_id, String userid, String[] chk_val, String executdt) throws Exception;	
}

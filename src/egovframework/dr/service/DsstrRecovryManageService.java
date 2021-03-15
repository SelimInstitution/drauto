package egovframework.dr.service;

import java.util.List;
import java.util.Map;

import egovframework.ply.service.UnitOpertVO;

public interface DsstrRecovryManageService {
	
	/**
	 * 재해복구 작업의 차수 목록을 조회한다.
	 * @return
	 * @throws Exception
	 */
	public List selectOpertOdrList(DsstrRecovryOpertVO dsstrRecovryOpertVO)  throws Exception;

	/**
	 * 재해복구 작업의 차수를 추가 한다.
	 * @return
	 * @throws Exception
	 */
	public Object insertOpertOdr(DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception;
	
	/**
	 * 재해복구 작업의 마지막 차수를 조회한다.
	 * @return
	 * @throws Exception
	 */
	public int selectMaxOpertOdr(DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception;
	
	/**
	 * 특정 차수의 재해복구 작업 목록을 조회 한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 * @throws Exception
	 */
	public List selectDsstrRecovry(DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception;
	
	/**
	 * 작업그룹의 상태를 조회한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 * @throws Exception
	 */
	public List selectOpertGgroupSttus(DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception;
	
	/**
	 * 대분류의 작업상태를 조회한다.
	 * @param dsstrRecovryOpertVO
	 * @return
	 * @throws Exception
	 */
	public List selectLclasSttus(DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception;
	
}

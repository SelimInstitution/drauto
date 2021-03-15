package egovframework.ply.service;

import java.util.List;
import java.util.Map;

import egovframework.server.service.AcntVO;
import egovframework.server.service.ServerVO;

public interface OpertManageService {
	
	/**
	 * 공통코드에서 작업그룹의 종류 정보 조회한다.
	 * @return List - 작업그룹 종류 목록
	 */
	public List selectOpertGroupKind() throws Exception;

	/**
	 * 작업그룹 목록을 조회한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public List selectOpertGroupList(OpertGroupVO opertGroupVO) throws Exception;
	
	/**
	 * 작업그룹을 등록한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public Object insertOpertGroup(OpertGroupVO opertGroupVO) throws Exception;
	
	/**
	 * 작업그룹 개수를 조회한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int selectOpertGroupListTotCnt(OpertGroupVO opertGroupVO) throws Exception;
	
	/**
	 * 작업그룹을 수정한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int updateOpertGroup(OpertGroupVO opertGroupVO) throws Exception;
	
	/**
	 * 작업그룹의 삭제여부를 수정한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int deleteOpertGroup(OpertGroupVO opertGroupVO) throws Exception;
	
	/**
	 * 단위작업 목록을 조회한다.
	 * @param unitOpertVO
	 * @return
	 * @throws Exception
	 */
	public List selectUnitOpertList(UnitOpertVO unitOpertVO) throws Exception;
	
	/**
	 * 단위작업을 등록한다.
	 * @param unitOpertVO
	 * @return
	 * @throws Exception
	 */
	public Object insertUnitOpert(UnitOpertVO unitOpertVO) throws Exception;
	
	/**
	 * 작업순번이 존재하는지 조회한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int selectUnitOpertSnCnt(UnitOpertVO unitOpertVO) throws Exception;	
	
	/**
	 * 작업순번 MAX값 조회한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int selectUnitOpertSnMaxVal(UnitOpertVO unitOpertVO) throws Exception;		
	
	/**
	 * 작업순번이 존재시 max + 1 값 조회한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	public int selectUnitOpertSnMax(UnitOpertVO unitOpertVO) throws Exception;		
	
	/**
	 * 단위작업을 수정한다.
	 * @param unitOpertVO
	 * @return
	 * @throws Exception
	 */
	public int updateUnitOpert(UnitOpertVO unitOpertVO) throws Exception;
	
	/**
	 * 단위작업의 삭제여부를 수정한다.
	 * @param unitOpertVO
	 * @return
	 * @throws Exception
	 */
	public int deleteUnitOpert(UnitOpertVO unitOpertVO) throws Exception;
	
	/**
	 * IP 정보를 조회한다.
	 * @return
	 * @throws Exception
	 */
	public List selectIpAdresList() throws Exception;
	
	/**
	 * 계정 정보를 조회한다.
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	public List selectAcntList(Map<String, Object> commandMap) throws Exception;
	
	/**
	 * 프로토콜 정보를 조회한다.
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	public List selectPrtclList(Map<String, Object> commandMap) throws Exception;	
}

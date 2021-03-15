package egovframework.ply.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.ply.service.OpertGroupVO;
import egovframework.ply.service.OpertManageService;
import egovframework.ply.service.UnitOpertVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("opertManageService")
public class OpertManageServiceImpl extends AbstractServiceImpl implements OpertManageService {
	
	@Resource(name="opertManageDAO")
    private OpertManageDAO opertManageDAO;
	
	/**
	 * 공통코드에서 작업그룹의 종류 정보 조회한다.
	 * @return List - 작업그룹 종류 목록
	 */
	public List selectOpertGroupKind() throws Exception {
		return opertManageDAO.selectOpertGroupKind();
	}

	/**
	 * 작업그룹 목록을 조회한다.
	 * @return List - 작업그룹 목록
	 */
	public List selectOpertGroupList(OpertGroupVO opertGroupVO) throws Exception {
		return opertManageDAO.selectOpertGroupList(opertGroupVO);
	}
	
	/**
	 * 작업그룹을 등록한다.
	 */
	public Object insertOpertGroup(OpertGroupVO opertGroupVO) throws Exception {
		return opertManageDAO.insertOpertGroup(opertGroupVO);
	}
	
	/**
	 * 작업그룹 개수를 조회한다.
	 */
	public int selectOpertGroupListTotCnt(OpertGroupVO opertGroupVO) throws Exception {
		return opertManageDAO.selectOpertGroupListTotCnt(opertGroupVO);
	}	
	
	/**
	 * 작업그룹을 수정한다.
	 */
	public int updateOpertGroup(OpertGroupVO opertGroupVO) throws Exception {
		return opertManageDAO.updateOpertGroup(opertGroupVO);
	}

	/**
	 * 작업그룹의 삭제여부를 수정한다.
	 */
	public int deleteOpertGroup(OpertGroupVO opertGroupVO) throws Exception {
		return opertManageDAO.deleteOpertGroup(opertGroupVO);
	}
	
	/**
	 * 단위작업 목록을 조회한다.
	 * @return List - 작업그룹 목록
	 */
	public List selectUnitOpertList(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.selectUnitOpertList(unitOpertVO);
	}
	
	/**
	 * 단위작업 순번이 존재하는지 조회한다.
	 */
	public int selectUnitOpertSnCnt(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.selectUnitOpertSnCnt(unitOpertVO);
	}	
	
	/**
	 * 단위작업 Max 값 조회한다.
	 */
	public int selectUnitOpertSnMaxVal(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.selectUnitOpertSnMaxVal(unitOpertVO);
	}		
	
	/**
	 * 단위작업 순번이 존재시 max + 1 값을 조회한다.
	 */
	public int selectUnitOpertSnMax(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.selectUnitOpertSnMax(unitOpertVO);
	}		
	
	/**
	 * 단위작업을 등록한다.
	 */
	public Object insertUnitOpert(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.insertUnitOpert(unitOpertVO);
	}
	
	/**
	 * 단위작업을 수정한다.
	 */
	public int updateUnitOpert(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.updateUnitOpert(unitOpertVO);
	}

	/**
	 * 단위작업의 삭제여부를 수정한다.
	 */
	public int deleteUnitOpert(UnitOpertVO unitOpertVO) throws Exception {
		return opertManageDAO.deleteUnitOpert(unitOpertVO);
	}
	
	/**
	 * IP 정보를 조회한다.
	 */
	public List selectIpAdresList() throws Exception {
		return opertManageDAO.selectIpAdresList();
	}
	
	/**
	 * 계정 정보를 조회한다.
	 */
	public List selectAcntList(Map<String, Object> commandMap) throws Exception {
		return opertManageDAO.selectAcntList(commandMap);
	}
	
	/**
	 * 프로토콜 정보를 조회한다.
	 */
	public List selectPrtclList(Map<String, Object> commandMap) throws Exception {
		return opertManageDAO.selectPrtclList(commandMap);
	}	
}

package egovframework.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.server.service.AcntVO;
import egovframework.server.service.ServerManageService;
import egovframework.server.service.ServerVO;

@Service("serverManageService")
public class ServerManageServiceImpl extends AbstractServiceImpl implements ServerManageService {
	
	@Resource(name="serverManageDAO")
    private ServerManageDAO serverManageDAO;

	/**
	 * 공통코드에서 OS정보 조회한다.
	 * @return List - OS 목록
	 */
	public List selectOS() throws Exception {
		return serverManageDAO.selectOS();
	}
	
	/**
	 * 공통코드에서 프로토콜 정보 조회한다.
	 * @return List - 프로토콜 목록
	 */
	public List selectPrtcl() throws Exception {
		return serverManageDAO.selectPrtcl();
	}	
	
	/**
	 * 공통코드에서 OS정보 조회한다.
	 * @return List - OS 목록
	 */
	public List selectIP(ServerVO serverVO) throws Exception {
		return serverManageDAO.selectIP(serverVO);
	}	
	
	/**
	 * 서버 목록을 조회한다.
	 * @return List - OS 목록
	 */
	public List<ServerVO> selectServerList(ServerVO serverVO) throws Exception {
		return serverManageDAO.selectServerList(serverVO);
	}		
	
	/**
	 * 서버 목록의 개수를 조회한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectServerListTotCnt(ServerVO serverVO) throws Exception {
		return serverManageDAO.selectServerListTotCnt(serverVO);
	}
	
	/**
	 * 서버정보를 신규로 등록한다.
	 */
	public Object insertServer(ServerVO serverVO) throws Exception {
////		System.out.println("::::::::::insertServer:::::::::" + serverVO);
		return serverManageDAO.insertServer(serverVO);
	}	
	
	/**
	 * 서버정보를 수정 한다.
	 */
	public int updateServer(ServerVO serverVO) throws Exception {
		return serverManageDAO.updateServer(serverVO);
	}
	
	/**
	 * 서버의 삭제여부를 수정 한다.
	 */
	public int updateServerDeleteAt(ServerVO serverVO) throws Exception {
		return serverManageDAO.updateServerDeleteAt(serverVO);
	}	
	
	/**
	 * 계정 정보를 등록한다.
	 */
	public Object insertAcnt(AcntVO acntVO) throws Exception {
		return serverManageDAO.insertAcnt(acntVO);
	}
	
	/**
	 * 계정 정보를 조회한다.
	 */
	public List<AcntVO> selectAcntList(AcntVO acntVO) throws Exception {
		return serverManageDAO.selectAcntList(acntVO);
	}
	
	/**
	 * 계정 목록의 개수를 조회한다.
	 */
	public int selectAcntListTotCnt(AcntVO acntVO) throws Exception {
		return serverManageDAO.selectAcntListTotCnt(acntVO);
	}
	
	/**
	 * 계정 정보를 수정한다.
	 */
	public int updateAcnt(AcntVO acntVO) throws Exception {
		return serverManageDAO.updateAcnt(acntVO);
	}
	
	/**
	 * 계정의 삭제여부를 수정한다.
	 */
	public int updateAcntDeleteAt(AcntVO acntVO) throws Exception {
		return serverManageDAO.updateAcntDeleteAt(acntVO);
	}	
	
}

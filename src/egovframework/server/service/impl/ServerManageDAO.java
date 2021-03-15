package egovframework.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.server.service.AcntVO;
import egovframework.server.service.ServerVO;

@Repository("serverManageDAO")
public class ServerManageDAO extends EgovComAbstractDAO {

	/**
	 * 공통코드에서 OS정보 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List selectOS() {
//		System.out.println(":::::::serverManageDAO.selectOS::::::::::");
		return list("serverManageDAO.selectOS", null);
	}
	
	/**
	 * 공통코드에서 프로토콜 정보 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List selectPrtcl() {
//		System.out.println(":::::::serverManageDAO.selectPrtcl::::::::::");
		return list("serverManageDAO.selectPrtcl", null);
	}		
	
	/**
	 * 서버정보에서 IP의 사용유무 판별을 위해 IP주소를 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List selectIP(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.selectIP::::::::::");
		return list("serverManageDAO.selectIP", serverVO);
	}	
	
	/**
	 * 서버 목록을 조회한다.
	 */
	@SuppressWarnings("unchecked")
	public List<ServerVO> selectServerList(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.selectServerList::::::::::");
		return list("serverManageDAO.selectServerList", serverVO);
	}
	
	/**
	 * 서버 목록 개수를 조회한다.
	 * @param serverVO
	 * @return
	 */
	public int selectServerListTotCnt(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.selectServerListTotCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("serverManageDAO.selectServerListTotCnt", serverVO);
	}
	
	/**
	 * 서버정보를 저장한다.
	 */
	public Object insertServer(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.insertServer::::::::::");
		return insert("serverManageDAO.insertServer", serverVO);
	}		

	/**
	 * 서버 정보를 수정한다.
	 * @param serverVO
	 * @return
	 */
	public int updateServer(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.updateServer::::::::::");
		return update("serverManageDAO.updateServer", serverVO);
	}
	
	/**
	 * 서버의 삭제여부를 수정한다.
	 * @param serverVO
	 * @return
	 */
	public int updateServerDeleteAt(ServerVO serverVO) {
//		System.out.println(":::::::serverManageDAO.updateServerDeleteAt::::::::::");
		return update("serverManageDAO.updateServerDeleteAt", serverVO);
	}
	
	/**
	 * 계정 정보를 등록한다.
	 * @param acntVO
	 * @return
	 */
	public Object insertAcnt(AcntVO acntVO) {
//		System.out.println(":::::::serverManageDAO.insertAcnt::::::::::");
		return insert("serverManageDAO.insertAcnt", acntVO);
	}
	
	/**
	 * 계정 정보를 조회한다.
	 * @param acntVO
	 * @return
	 */
	public List<AcntVO> selectAcntList(AcntVO acntVO) {
//		System.out.println(":::::::serverManageDAO.selectAcntList::::::::::");
		return list("serverManageDAO.selectAcntList", acntVO);
	}
	
	/**
	 * 계정 목록 개수를 조회한다.
	 * @param acntVO
	 * @return
	 */
	public int selectAcntListTotCnt(AcntVO acntVO) {
//		System.out.println(":::::::serverManageDAO.selectAcntListTotCnt::::::::::");
		return (Integer)getSqlMapClientTemplate().queryForObject("serverManageDAO.selectAcntListTotCnt", acntVO);
	}
	
	/**
	 * 계정 정보를 수정한다.
	 * @param acntVO
	 * @return
	 */
	public int updateAcnt(AcntVO acntVO) {
//		System.out.println(":::::::serverManageDAO.updateAcnt::::::::::");
		return update("serverManageDAO.updateAcnt", acntVO);
	}
	
	/**
	 * 계정의 삭제여부를 수정한다.
	 * @param acntVO
	 * @return
	 */
	public int updateAcntDeleteAt(AcntVO acntVO) {
//		System.out.println(":::::::serverManageDAO.updateAcntDeleteAt::::::::::");
		return update("serverManageDAO.updateAcntDeleteAt", acntVO);
	}	
}

package egovframework.server.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

public interface ServerManageService {

	/**
	 * 공통코드에서 OS정보 조회한다.
	 * @return List - OS 목록
	 */
	public List selectOS() throws Exception;	
	
	/**
	 * 공통코드에서 프로토콜 정보 조회한다.
	 * @return List - 프로토콜 목록
	 */
	public List selectPrtcl() throws Exception;	
	
	/**
	 * 서버정보에서 IP의 사용유무 판별을 위해 IP주소를 조회한다.
	 * @return List - 조회된 IP 개수
	 */
	public List selectIP(ServerVO serverVO) throws Exception;	
	
	/**
	 * 서버목록을 조회한다.
	 * @return List - 조회된 IP 개수
	 */
	public List<ServerVO> selectServerList(ServerVO serverVO) throws Exception;	
	
	/**
	 * 서버목록 개수를 조회한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int selectServerListTotCnt(ServerVO serverVO) throws Exception;
	
	/**
	 * 서버정보를 신규로 등록한다.
	 */
	public Object insertServer(ServerVO serverVO) throws Exception;	
	
	/**
	 * 서버 정보를 수정한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int updateServer(ServerVO serverVO) throws Exception;
	
	/**
	 * 서버의 삭제여부를 수정한다.
	 * @param serverVO
	 * @return
	 * @throws Exception
	 */
	public int updateServerDeleteAt(ServerVO serverVO) throws Exception;
		
	/**
	 * 계정 정보를 등록한다.
	 * @param acntVO
	 * @return
	 * @throws Exception
	 */
	public Object insertAcnt(AcntVO acntVO) throws Exception;
	
	/**
	 * 계정 정보를 조회한다.
	 * @param acntVO
	 * @return
	 * @throws Exception
	 */
	public List<AcntVO> selectAcntList(AcntVO acntVO) throws Exception;
	
	/**
	 * 계정 목록의 개수를 조회한다.
	 * @param acntVO
	 * @return
	 * @throws Exception
	 */
	public int selectAcntListTotCnt(AcntVO acntVO) throws Exception;	
	
	/**
	 * 계정 정보를 수정한다.
	 * @param acntVO
	 * @return
	 * @throws Exception
	 */
	public int updateAcnt(AcntVO acntVO) throws Exception;
	
	/**
	 * 계정의 삭제여부를 수정한다.
	 * @param acntVO
	 * @return
	 * @throws Exception
	 */
	public int updateAcntDeleteAt(AcntVO acntVO) throws Exception;
}

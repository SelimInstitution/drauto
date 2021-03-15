package egovframework.ipm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public interface IPManageService {

	/**
	 * ip관리 목록을 조회한다.
	 * @param IPManageVO - ip관리 정보
	 * @return List ip관리 정보
	 * 
	 * @param IPManageVO
	 */
	public List selectIPManageList(IPManageVO ipManageVO) throws Exception;	
	
	/**
	 * ip관리 목록을 조회한다.
	 * @param IPManageVO - ip관리 정보
	 * @return List ip관리 정보
	 * 
	 * @param IPManageVO
	 */
	public int selectIPManageListTotCnt(IPManageVO ipManageVO) throws Exception;	
	
	/**
	 * ip관리 내용을 등록한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void insertIPManage(IPManageVO ipManageVO) throws Exception;
	
	/**
	 * ip관리 상세화면으로 이동한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public IPManageVO modifyIPManage(IPManageVO ipManageVO) throws Exception;	
	/**
	 * ip 중복 확인.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public String overlapIP(IPManageVO ipManageVO) throws Exception;
	
	/**
	 * ip관리 정보를 수정한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void updateIPManage(IPManageVO ipManageVO) throws Exception;	
	
	/**
	 * ip관리 상세화면으로 이동한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void deleteIPManage(IPManageVO ipManageVO) throws Exception;
	
	/**
	 * 코드 가져오기
	 * @param 
	 * @return 
	 * 
	 * @param 
	 */
	public List selectDivCode() throws Exception;	
	
	
	/**
	 * ping test를 위한 IP리스트 가져오기
	 * @param 
	 * @return 
	 * 
	 * @param 
	 */
	public List selectPingIpAdress() throws Exception;	
	
	/**
	 * PING TEST 결과를 업데이트 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateAlive(Map<String, Object> commandMap) throws Exception;
	
	/**
	 * PING TEST 결과를 Clear 한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void updateAliveClear() throws Exception;	
	
	/**
	 * PING TEST 비동기(async) 처리.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void pingAsync() throws Exception;		
}

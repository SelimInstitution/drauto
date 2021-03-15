package egovframework.ipm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import egovframework.ipm.service.IPManageService;
import egovframework.ipm.service.IPManageVO;
import egovframework.ply.service.impl.OpertGroupService;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("ipManageService")
public class IPManageServiceImpl extends AbstractServiceImpl implements IPManageService {
	
	@Resource(name="ipManageDAO")
    private IPManageDAO ipManageDAO;

	/**
	 * 부서를 관리하기 위해 등록된 부서목록을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public List selectIPManageList(IPManageVO ipManageVO) throws Exception {
		return ipManageDAO.selectIPManageList(ipManageVO);
	}
	/**
	 * 부서를 관리하기 위해 등록된 부서목록을 조회한다.
	 * @param deptManageVO - 부서 Vo
	 * @return List - 부서 목록
	 * 
	 * @param deptManageVO
	 */
	public int selectIPManageListTotCnt(IPManageVO ipManageVO) throws Exception {
		return ipManageDAO.selectIPManageListTotCnt(ipManageVO);
	}
	
	
	/**
	 * ip관리 내용을 등록한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void insertIPManage(IPManageVO ipManageVO) throws Exception{
		ipManageDAO.insertIPManage(ipManageVO);
	}
	
	/**
	 * 상세화면으로 이동한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public IPManageVO modifyIPManage(IPManageVO ipManageVO) throws Exception{
		return ipManageDAO.modifyIPManage(ipManageVO);
	}
	
	/**
	 * ip관리 내용을 등록한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void updateIPManage(IPManageVO ipManageVO) throws Exception{
		ipManageDAO.updateIPManage(ipManageVO);
	}
	
	/**
	 * ip관리 내용을 등록한다.
	 * @param IPManageVO - ip관리 정보
	 * @return 
	 * 
	 * @param IPManageVO
	 */
	public void deleteIPManage(IPManageVO ipManageVO) throws Exception{
		ipManageDAO.deleteIPManage(ipManageVO);
	}
	
	public String overlapIP(IPManageVO ipManageVO) throws Exception{
		return ipManageDAO.overlapIP(ipManageVO);
	}
	
	/**
	 * 코드 가져오기
	 * @param 
	 * @return 
	 * 
	 * @param 
	 */
	public List selectDivCode() throws Exception{
		return ipManageDAO.selectDivCode();
	}
	
	/**
	 * ping test를 위한 ip리스트 가져오기
	 * @param 
	 * @return 
	 * 
	 * @param 
	 */
	public List selectPingIpAdress() throws Exception {
		return ipManageDAO.selectPingIpAdress();
	}	
	
	/** ping test alive 값 업데이트 한다.
	 * @param 
	 */
	public void updateAlive(Map<String, Object> commandMap) throws Exception {
		ipManageDAO.updateAlive(commandMap);
	}
	
	/** ping test alive 값 Clear 한다.
	 * @param 
	 */
	public void updateAliveClear() throws Exception {
		ipManageDAO.updateAliveClear();
	}	
	
	/** ping test 비동기(async)처리.
	 * @param 
	 */
	public void pingAsync() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("egovframework/spring/com/context-*.xml");
		PingTestService pts = (PingTestService)context.getBean("PingTestService");
		pts.pingTest();
	}	
}

package egovframework.server.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.server.service.AcntVO;
import egovframework.server.service.ServerManageService;
import egovframework.server.service.ServerVO;
import egovframework.server.service.impl.AsyncTestService;

@Controller
public class ServerManage  {
	

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "serverManageService")
	protected ServerManageService serverManageService;

	/** Message ID Generation */
	@Resource(name = "egovDeptManageIdGnrService")
	private EgovIdGnrService egovPlyManageIdGnrService;

    
	@Autowired
	private DefaultBeanValidator beanValidator;

	
	/**
	 * 실행결과 조회 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/server/serverList.do")
	public String selectServerPrtclListView(@ModelAttribute("serverVO") ServerVO serverVO,
			@ModelAttribute("acntVO") AcntVO acntVO, 
			@RequestParam(value="checkIpAdres", required=false) String checkIpAdres,
			Model model) throws Exception {
		
    	/** 서버 paging */
    	PaginationInfo serverPaginationInfo = new PaginationInfo();
    	serverPaginationInfo.setCurrentPageNo(serverVO.getPageIndex());
    	serverPaginationInfo.setRecordCountPerPage(serverVO.getPageUnit());
    	serverPaginationInfo.setPageSize(serverVO.getPageSize());
		
		serverVO.setFirstIndex(serverPaginationInfo.getFirstRecordIndex());
		serverVO.setLastIndex(serverPaginationInfo.getLastRecordIndex());
		serverVO.setRecordCountPerPage(serverPaginationInfo.getRecordCountPerPage());				
		
		
		List acnt_list = null;
		// 특정 서버를 선택한 경우 해당 서버의 계정을 조회하기 위해 IP주소 set
		if (checkIpAdres != null) {
			acntVO.setIpAdres(checkIpAdres);
			acnt_list = serverManageService.selectAcntList(acntVO);
		}
		
		List os_list = serverManageService.selectOS();
		//List acnt_list = serverManageService.selectAcntList(acntVO);
		List server_list = serverManageService.selectServerList(serverVO);
		int serverTotCnt = serverManageService.selectServerListTotCnt(serverVO);
		
		model.addAttribute("osList", os_list);
		if (checkIpAdres != null) model.addAttribute("acntList", acnt_list);
		model.addAttribute("serverList", server_list);
		model.addAttribute("serverTotCnt", serverTotCnt);
		
		serverPaginationInfo.setTotalRecordCount(serverTotCnt);
        model.addAttribute("serverPaginationInfo", serverPaginationInfo);
        
		return "egovframework/server/ServerManage";
	}	
	
	/**
	 * 서버정보 등록을 위한 새창으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/server/serverPopup.do")
	public String serverPopupView(Model model) throws Exception {
		
		AsyncTestService ats = new AsyncTestService();

		List list = serverManageService.selectOS();
		model.addAttribute("osList", list);
		return "egovframework/server/RegistServer";
	}
	
	
	/**
	 * 서버정보를 수정하기 위한 화면 이동
	 * @param serverVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/serverUpdtView.do")
	public String serverUpdtView(@ModelAttribute("serverVO") ServerVO serverVO, Model model) throws Exception {
		serverVO.setFirstIndex(0);
		List server_list = serverManageService.selectServerList(serverVO);
		List os_list = serverManageService.selectOS();
		
		if (server_list != null) {
			model.addAttribute("serverList", server_list.get(0));
		}
		model.addAttribute("osList", os_list);
		return "egovframework/server/ServerUpdt";
	}		
	
	/**
	 * 서버 정보를 수정
	 * @param serverVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/updateServer.do")
	public String updateServer(@ModelAttribute("serverVO") ServerVO serverVO, Model model) throws Exception {

		int updt_result = serverManageService.updateServer(serverVO);
		serverVO.setFirstIndex(0);
		List server_list = serverManageService.selectServerList(serverVO);
		List os_list = serverManageService.selectOS();
		
		if (server_list != null && server_list.size() > 0) {
			model.addAttribute("serverList", server_list.get(0));
		}
		
		model.addAttribute("updtResult", updt_result);
		model.addAttribute("osList", os_list);
		
		return "egovframework/server/ServerUpdt";
	}	
	
	/**
	 * 서버의 삭제여부를 수정한다.
	 * @param serverVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/updateServerDeleteAt.do")
	public String updateServerDeleteAt(@ModelAttribute("serverVO") ServerVO serverVO,
			@ModelAttribute("acntVO") AcntVO acntVO,
			@RequestParam(value="checkIpAdres", required=false) String checkIpAdres,
			Model model) throws Exception {
		
		String tmpIp = serverVO.getIpAdres();
		
		serverVO.setIpAdres(checkIpAdres);
		
		int delete_result = serverManageService.updateServerDeleteAt(serverVO);
		List os_list = serverManageService.selectOS();
		
		model.addAttribute("deleteResult", delete_result);
		model.addAttribute("osList", os_list);
		
		serverVO.setIpAdres(tmpIp);
		return this.selectServerPrtclListView(serverVO, acntVO, checkIpAdres, model);
		//return "egovframework/server/ServerManage";
	}

	
	/**
	 * 서버정보를 저장한다.
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/server/insertServer.do")
	public String insertServer(@ModelAttribute("serverVO") ServerVO serverVO,
			Model model) throws Exception {
	
		List list = serverManageService.selectOS();
		model.addAttribute("osList", list);
		
		List ip_cnt = serverManageService.selectIP(serverVO);
		
		if (ip_cnt != null && ip_cnt.size() > 0) {
			System.out.println("ipCnt : >>"+ip_cnt.size());
			model.addAttribute("ipCount", ip_cnt.size());	
			return "egovframework/server/RegistServer";
		}

        Object rtn = serverManageService.insertServer(serverVO);

        model.addAttribute("insertAt", "true");
		return "egovframework/server/RegistServer";
	}	

	/**
	 * 계정 정보 등록을 위한 새창
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/server/acntPopup.do")
	public String acntPopupView(Model model) throws Exception {

		List list = serverManageService.selectPrtcl();
		model.addAttribute("prtclList", list);
		
		return "egovframework/server/RegistAcnt";
	}	
	
	/**
	 * 계정 정보를 등록한다.
	 * @param acntVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/insertAcnt.do")
	public String insertAcnt(@ModelAttribute("acntVO") AcntVO acntVO, Model model) throws Exception {
		
		List list = serverManageService.selectPrtcl();
		model.addAttribute("prtclList", list);
		
		List acnt_list = serverManageService.selectAcntList(acntVO);
		
		// 계정 등록 전 중복 확인
		if (acnt_list != null && acnt_list.size() > 0) {
			model.addAttribute("acntDplct", "true");
			return "egovframework/server/RegistAcnt";
		}
		
		Object rnt = serverManageService.insertAcnt(acntVO);
		
		model.addAttribute("insertAt", "true");
		return "egovframework/server/RegistAcnt";
	}
	
	/**
	 * 계정 정보를 수정하기 위한 화면
	 * @param acntVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/acntUpdtView.do")
	public String acntUpdtView(@ModelAttribute() AcntVO acntVO, Model model) throws Exception {
		acntVO.setFirstIndex(0);
		
		List acnt_list = serverManageService.selectAcntList(acntVO);
		List prtcl_list = serverManageService.selectPrtcl();
		
		if (acnt_list != null) {
			model.addAttribute("acntList", acnt_list.get(0));
		}
		
		model.addAttribute("prtclList", prtcl_list);
		
		return "egovframework/server/AcntUpdt";
	}
	
	/**
	 * 계정 정보를 수정한다.
	 * @param acntVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/updateAcnt.do")
	public String updateAcnt(@ModelAttribute("acntVO") AcntVO acntVO, Model model) throws Exception {
		
		int updt_result = serverManageService.updateAcnt(acntVO);
		List prtcl_list = serverManageService.selectPrtcl();
		acntVO.setFirstIndex(0);
		List acnt_list = serverManageService.selectAcntList(acntVO);
		
		if (acnt_list != null && acnt_list.size() > 0) {
			model.addAttribute("acntList", acnt_list.get(0));
		}
		
		model.addAttribute("updtResult", updt_result);
		model.addAttribute("prtclList", prtcl_list);
		
		return "egovframework/server/AcntUpdt";
	}
	
	/**
	 * 계정의 삭제여부를 수정한다.
	 * @param serverVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/server/updateAcntDeleteAt.do")
	public String updateAcntDeleteAt(@ModelAttribute("serverVO") ServerVO serverVO,
			@ModelAttribute("acntVO") AcntVO acntVO,
			@RequestParam(value="checkIpAdres", required=false) String checkIpAdres,
			@RequestParam(value="checkAcntId", required=false) String checkAcntId,
			@RequestParam(value="checkPrtclCode", required=false) String checkPrtclCode,
			Model model) throws Exception {
	
		String tmpIp = serverVO.getIpAdres();
		
		acntVO.setIpAdres(checkIpAdres);
		acntVO.setAcntId(checkAcntId);
		acntVO.setPrtclCode(checkPrtclCode);
		
		int delete_result = serverManageService.updateAcntDeleteAt(acntVO);
		List os_list = serverManageService.selectOS();
		
		model.addAttribute("deleteResult", delete_result);
		model.addAttribute("osList", os_list);
		
		serverVO.setIpAdres(tmpIp);
		acntVO.setAcntId(null);
		acntVO.setPrtclCode(null);
		return this.selectServerPrtclListView(serverVO, acntVO, checkIpAdres, model);
	}	
	
}
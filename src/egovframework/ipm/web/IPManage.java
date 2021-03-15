package egovframework.ipm.web;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.ipm.service.IPManageService;
import egovframework.ipm.service.IPManageVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class IPManage  {
	

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "ipManageService")
	protected IPManageService ipManageService;

	
	/** Message ID Generation */
	@Resource(name = "egovDeptManageIdGnrService")
	private EgovIdGnrService egovPlyManageIdGnrService;
	
	@Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;

    
	@Autowired
	private DefaultBeanValidator beanValidator;

	
	/**
	 * 실행결과 조회 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/selectIPMList.do")
	public String selectIPMList(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		//log.debug(":::::::::테스트::::::::::::::::::");
		//System.out.println(":::::::팝업화면으로 이동::::::::");
		//System.out.println(":::::::pageIndex::::::::"+ipManageVO.getPageIndex());
		//System.out.println(":::::::pageIndex::::::::"+ipManageVO.getPageIndex());
		//System.out.println(":::::::pageIndex::::::::"+ipManageVO.getPageIndex());
		ipManageVO.setPageUnit(propertyService.getInt("pageUnit"));
		ipManageVO.setPageSize(propertyService.getInt("pageSize"));
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(ipManageVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(ipManageVO.getPageUnit());
		paginationInfo.setPageSize(ipManageVO.getPageSize());

		ipManageVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		ipManageVO.setLastIndex(paginationInfo.getLastRecordIndex());
		ipManageVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List map = ipManageService.selectIPManageList(ipManageVO);
		//int totCnt = Integer.parseInt((String)map.("resultCnt"));
		int totCnt = ipManageService.selectIPManageListTotCnt(ipManageVO);
		
		//ipManageVO.setRowNo(((ServerVO) map.get(0)).getRowNo()); //일단주석. 컬럼 순번용 같음.

		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("divCode", ipManageService.selectDivCode()); //망구분 코드
		model.addAttribute("resultList", map);
		model.addAttribute("resultCnt", totCnt);
		model.addAttribute("ipManageVO", ipManageVO);
		model.addAttribute("paginationInfo", paginationInfo);
		//model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
		
		return "egovframework/ipm/IPManageList";
	}	
	
	/**
	 * 등록 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/registIPManage.do")
	public String registIPManage(@ModelAttribute("ipManageVO") IPManageVO ipManageVO,ModelMap model) throws Exception {
		model.addAttribute("divCode", ipManageService.selectDivCode()); //망구분 코드
		return "egovframework/ipm/IPManageRegist";
	}
	
	/**
	 * 저장 후 리스트 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/isnertIPManage.do")
	public String insertIPManage(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		LoginVO loginVO =  
			(LoginVO)request.getSession().getAttribute("loginVO");
		ipManageVO.setCrtrId(loginVO.getId());
		
		ipManageService.insertIPManage(ipManageVO);
		
		//request.getSession().getAttribute("");
		model.addAttribute("ipManageVO", ipManageVO);
		model.addAttribute("message", egovMessageSource.getMessage("success.common.insert"));
		
		return modifyIPManage(ipManageVO, request, model);
	}
	
	/**
	 * 상세 수정 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/modifyIPManage.do")
	public String modifyIPManage(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		IPManageVO ipManVO = ipManageService.modifyIPManage(ipManageVO);
		ipManVO.setPageIndex(ipManageVO.getPageIndex());
		model.addAttribute("divCode", ipManageService.selectDivCode()); //망구분 코드
		model.addAttribute("ipManageVO", ipManVO);
		//model.addAttribute("message", egovMessageSource.getMessage("success.common.select"));
		
		return "egovframework/ipm/IPManageModify";
	}
	
	/**
	 * ip관리정보 수정 
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/updateIPManage.do")
	public String updateIPManage(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		 //log.debug(":::::::::테스트::::::::::::::::::");
		LoginVO loginVO =  
			(LoginVO)request.getSession().getAttribute("loginVO");
		ipManageVO.setUpdusrId(loginVO.getId());
		
		
		ipManageService.updateIPManage(ipManageVO);
		model.addAttribute("message", egovMessageSource.getMessage("success.common.update"));
		
		return modifyIPManage(ipManageVO, request, model);
	}
	
	/**
	 * 상세 수정 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/overlapIP.do")
	public String overlapIP(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		
		model.addAttribute("divCode", ipManageService.selectDivCode()); //망구분 코드
		ipManageVO.setOverlapYn(ipManageService.overlapIP(ipManageVO));
		
		model.addAttribute("ipManageVO", ipManageVO);
		String massegeOverlap="";
		if(ipManageVO.getOverlapYn().equals("N")){
			massegeOverlap = egovMessageSource.getMessage("common.overlapn.msg");
		}else{
			massegeOverlap = egovMessageSource.getMessage("common.overlapy.msg");
		}
		model.addAttribute("messageOverlap", massegeOverlap);
		
		if(ipManageVO.getRegMode().equals("i")){
			return "egovframework/ipm/IPManageRegist";
		}else{
			return "egovframework/ipm/IPManageModify";
		}
	}
	
	/**
	 * ip관리정보 삭제 
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/deleteIPManage.do")
	public String deleteIPManage(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		 //log.debug(":::::::::테스트::::::::::::::::::");
		
		ipManageService.deleteIPManage(ipManageVO);
		model.addAttribute("message", egovMessageSource.getMessage("success.common.delete"));
		
		return selectIPMList(ipManageVO, request, model);
	}
	
	/**
	 * ping check
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/ipm/pingCheck.do")
	public String TelnetCancl(@ModelAttribute("ipManageVO") IPManageVO ipManageVO, HttpServletRequest request, ModelMap model) throws Exception {
		//ping 결과를 clear한다.
		ipManageService.updateAliveClear(); 
		
		//실제 ping처리를 async로 보낸다.
		ipManageService.pingAsync();
		
		return selectIPMList(ipManageVO, request, model);
	}	
}
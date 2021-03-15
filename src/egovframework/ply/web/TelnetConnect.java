package egovframework.ply.web;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.ply.service.EgovPlyManageService;
import egovframework.ply.service.PlyVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @FileName  : TelnetConnect.java
 * @Project     : smbs
 * @Date         : 2012. 2. 28. 
 * @작성자      : cha seung jun
 * @변경이력 :
 * @프로그램 설명 :
 */
@Controller
public class TelnetConnect  {


	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "egovPlyManageService")
	protected EgovPlyManageService egovPlyManageService;

	/** Message ID Generation */
	@Resource(name = "egovDeptManageIdGnrService")
	private EgovIdGnrService egovPlyManageIdGnrService;

    
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private String prompt = "[int.selim.co.kr:/export/home/test01]#";
	
	String user_id = "ADMIN";		
	
	/**
	 * @Method Name  : TelnetConnect
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : telnet 접속 처리
	 * @param server
	 * @param acnt_id
	 * @param password
	 * @param opert_group_id
	 * @param unit_opert_id
	 * @param prtcl
	 * @param opertCn
	 * @param port
	 * @return
	 */
	@RequestMapping("/ply/playSample.do")
	public String TelnetConnect(ModelMap model, @RequestParam("opertGrpId") String opert_group_id,
			                    @RequestParam("userid") String userid, @RequestParam("exe") String exe,
			                    @RequestParam("chk[]") String[] chk_val,
			                    @ModelAttribute("plyVO") PlyVO plyVO) throws Exception {
		try {
			String resultMsg    = "";
			String MsgChk = "";
			int cancl_cnt;
			String opertExecutDt = "";
			String executdt = "";
			String ipAdres = "";
			String acntId = "";
			String password = "";
			String prtclCode = "";
			String port = "";
			String prompt = "";
			String unitOpertId = "";
			String opertCn = "";
			String opertSn = "";
			String executBfeCnfirmAt = "";			
			
			//작업이 실행중인지 여부를 확인 
			Map<String, Object> cntmap = new HashMap<String, Object>();
			cntmap.put("OPERT_GROUP_ID", opert_group_id);
			
			int execut_cnt = egovPlyManageService.selectExecutCnt(cntmap);			
//			System.out.println("execut_cnt :: >>" + execut_cnt);
			if(execut_cnt <= 0) {
				// 해당 작업그룹에 속한 모든 단위 작업 조회(체크박스에 체크된 리스트만 SELECT)
				Map<String, Object> Lmap = new HashMap<String, Object>();
				
				Lmap.put("OPERT_GROUP_ID", opert_group_id);
				Lmap.put("UNIT_OPERT_ID", chk_val);
				Lmap.put("TYPE", "IN");
				
				List list = egovPlyManageService.selectGrpByUnitList(Lmap);
				
				// 해당 작업그룹에 속한 모든 단위 작업 조회(체크박스에 체크안된 리스트만 SELECT)
				Map<String, Object> Nmap = new HashMap<String, Object>();
				
				Nmap.put("OPERT_GROUP_ID", opert_group_id);
				Nmap.put("UNIT_OPERT_ID", chk_val);
				Nmap.put("TYPE", "NOT IN");
				
				List list_not = egovPlyManageService.selectGrpByUnitList(Nmap);		
				
				
				//실행취소 확인을 위해 cancl_cnt 조회
				Map<String, Object> canclmap = new HashMap<String, Object>();
				canclmap.put("OPERT_GROUP_ID", opert_group_id);
				cancl_cnt = egovPlyManageService.selectCanclAtCnt(canclmap);		
				
//				if(cancl_cnt > 0){
//					//실행취소의 경우 opert_group_execut_dt  조회한다.
//					List list_opertExecutDt = egovPlyManageService.selectOpertExecutDt(Nmap);
//					Map optExecDtmap = (Map) list_opertExecutDt.get(0);
//					
//					opertExecutDt = (String) optExecDtmap.get("OPERT_GROUP_EXECUT_DT");			
//				}
				
				// SYSDATE를 조회하기 위한 부분
				Map<String, Object> lMap = new HashMap<String, Object>();
				
				List list_sys = egovPlyManageService.selectSysdate(lMap);
				
				Map executdtmap = (Map) list_sys.get(0);
				executdt = (String) executdtmap.get("EXECUT_DT");
//				System.out.println("executdt ::: >>"+executdt);
				//체크된 리스트 처리
				if (list == null || list.size() == 0)
					return null;
				
					if(cancl_cnt <= 0){
						for (int i = 0; i < list.size(); i++) {

							Map map = (Map) list.get(i);

							ipAdres = (String) map.get("IP_ADRES");
							acntId = (String) map.get("ACNT_ID");
							password = (String) map.get("PASSWORD");
							prtclCode = (String) map.get("PRTCL_CODE");
							port = (String) map.get("PORT");
							prompt = (String) map.get("PROMPT");
							unitOpertId = (String) map.get("UNIT_OPERT_ID");
							opertCn = (String) map.get("OPERT_CN");
							System.out.println("opertCn:::::"+opertCn);
							opertCn = opertCn.replaceAll("<br/>","\n");
							System.out.println("opertCn:::::"+opertCn);
							opertSn = (String) map.get("OPERT_SN");
							executBfeCnfirmAt = (String) map.get("EXECUT_BFE_CNFIRM_AT");
							
							
							
							Map<String, Object> commandMap = new HashMap<String, Object>();

							commandMap.put("OPERT_GROUP_ID", opert_group_id);
							commandMap.put("UNIT_OPERT_ID", unitOpertId);
							commandMap.put("IP_ADRES", ipAdres);
							commandMap.put("ACNT_ID", acntId);
							commandMap.put("PRTCL_CODE", prtclCode);
							commandMap.put("USER_ID", userid);
							commandMap.put("OPERT_GROUP_EXECUT_DT", executdt);
							commandMap.put("EXECUT_DT", "");
							commandMap.put("END_DT", "");
							commandMap.put("RESULT", "");
							
							egovPlyManageService.insertPlyManage(commandMap);
						}
						
						//체크안된 부분 처리 
						//if (list_not == null || list_not.size() == 0)
						//	return;					
						for (int i = 0; i < list_not.size(); i++) {

							Map map = (Map) list_not.get(i);

							ipAdres = (String) map.get("IP_ADRES");
							acntId = (String) map.get("ACNT_ID");
							password = (String) map.get("PASSWORD");
							prtclCode = (String) map.get("PRTCL_CODE");
							port = (String) map.get("PORT");
							prompt = (String) map.get("PROMPT");
							unitOpertId = (String) map.get("UNIT_OPERT_ID");
							opertCn = (String) map.get("OPERT_CN");
							opertSn = (String) map.get("OPERT_SN");
							executBfeCnfirmAt = (String) map.get("EXECUT_BFE_CNFIRM_AT");

							Map<String, Object> commandMap = new HashMap<String, Object>();

							commandMap.put("OPERT_GROUP_ID", opert_group_id);
							commandMap.put("UNIT_OPERT_ID", unitOpertId);
							commandMap.put("IP_ADRES", ipAdres);
							commandMap.put("ACNT_ID", acntId);
							commandMap.put("PRTCL_CODE", prtclCode);
							commandMap.put("USER_ID", userid);
							commandMap.put("OPERT_GROUP_EXECUT_DT", executdt);
							commandMap.put("EXECUT_DT", executdt);
							commandMap.put("END_DT", executdt);
							commandMap.put("RESULT", "사용자에의한 미실행");

							egovPlyManageService.insertPlyManage(commandMap);
							
						}
					}
					
					if(exe.equals("execut")){
						egovPlyManageService.asyncTest(opert_group_id, userid, chk_val, executdt);
					}					
			} else if(execut_cnt > 0){
				resultMsg = egovMessageSource.getMessage("common.execut.msg");
				model.addAttribute("resultMsg", resultMsg);
			}
			

			Map<String, Object> mmap = new HashMap<String, Object>();
			mmap.put("OPERT_GROUP_ID", opert_group_id);
			
			List maxlist = egovPlyManageService.selectMaxExecutDt(mmap); //작업그룹실행일시 max값 조회
			
			Map maxmap = (Map) maxlist.get(0);
			String max_excutdt = (String) maxmap.get("MAX_EXECUT_DT");		
			
			Map<String, Object> Omap = new HashMap<String, Object>();
			Omap.put("OPERT_GROUP_ID", opert_group_id);
			Omap.put("OPERT_GROUP_EXECUT_DT", max_excutdt);
			
			
	    	/** 서버 paging */
	    	PaginationInfo plyPaginationInfo = new PaginationInfo();
	    	plyPaginationInfo.setCurrentPageNo(plyVO.getPageIndex());
	    	plyPaginationInfo.setRecordCountPerPage(plyVO.getPageUnit());
	    	plyPaginationInfo.setPageSize(plyVO.getPageSize());
			
	    	plyVO.setFirstIndex(plyPaginationInfo.getFirstRecordIndex());
	    	plyVO.setLastIndex(plyPaginationInfo.getLastRecordIndex());
	    	plyVO.setRecordCountPerPage(plyPaginationInfo.getRecordCountPerPage());				
			
//			Map<String, Object> tmap = new HashMap<String, Object>();
			
			List grplist = egovPlyManageService.selectOpertGrpList(plyVO);
			List unitlist = egovPlyManageService.selectUnitOpertList(Omap);
			int plyTotCnt = egovPlyManageService.selectOpertGrpListTotCnt(plyVO);
			
			List grpCodelist = egovPlyManageService.selectGrpCode();
			
			String grpId = opert_group_id;
			
			String GrpId = (String) Omap.get("OPERT_GROUP_ID");
			Map map = (Map) unitlist.get(0);			
			
			model.addAttribute("unitlist", unitlist);
			model.addAttribute("grplist", grplist);			
			
			model.addAttribute("grpId", grpId);
			model.addAttribute("unitfirst", map);
			model.addAttribute("grpCodeList", grpCodelist);
			model.addAttribute("plyTotCnt", plyTotCnt);
			model.addAttribute("executCnt", execut_cnt);
			
			plyPaginationInfo.setTotalRecordCount(plyTotCnt);
	        model.addAttribute("plyPaginationInfo", plyPaginationInfo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	   	return "egovframework/ply/EgovPlyManageList";
	}

	
	/**
	 * @Method Name  : TelnetCancl
	 * @작성일   : 2012. 3. 16. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : 실행취소 처리
	 * @param model
	 * @param opert_group_id
	 * @param ip
	 * @param acntId
	 * @param prtcl
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/cancel.do")
	public String TelnetCancl(ModelMap model, @RequestParam("opertGrpId") String opert_group_id,
			@RequestParam("ip") String ip,
			@RequestParam("acntId") String acntId,
			@RequestParam("prtcl") String prtcl,
			@RequestParam("userid") String userid,
            @ModelAttribute("plyVO") PlyVO plyVO) throws Exception {
		try {
			
			Map<String, Object> mmap = new HashMap<String, Object>();
			mmap.put("OPERT_GROUP_ID", opert_group_id);
			
			List maxlist = egovPlyManageService.selectMaxExecutDt(mmap); //작업그룹실행일시 max값 조회
			
			Map maxmap = (Map) maxlist.get(0);
			String max_excutdt = (String) maxmap.get("MAX_EXECUT_DT");			
			
			Map<String, Object> cmap = new HashMap<String, Object>();
			cmap.put("IP_ADRES", ip);
			cmap.put("ACNT_ID", acntId);
			cmap.put("PRTCL_CODE", prtcl);
			cmap.put("OPERT_GROUP_ID", opert_group_id);
			cmap.put("USER_ID", userid);
			cmap.put("OPERT_GROUP_EXECUT_DT", max_excutdt);
			
			egovPlyManageService.updateCancl(cmap);
			
			Map<String, Object> smap = new HashMap<String, Object>();
			smap.put("OPERT_GROUP_ID", opert_group_id);
			smap.put("OPERT_GROUP_EXECUT_DT", max_excutdt);
			
	    	/** 서버 paging */
	    	PaginationInfo plyPaginationInfo = new PaginationInfo();
	    	plyPaginationInfo.setCurrentPageNo(plyVO.getPageIndex());
	    	plyPaginationInfo.setRecordCountPerPage(plyVO.getPageUnit());
	    	plyPaginationInfo.setPageSize(plyVO.getPageSize());
			
	    	plyVO.setFirstIndex(plyPaginationInfo.getFirstRecordIndex());
	    	plyVO.setLastIndex(plyPaginationInfo.getLastRecordIndex());
	    	plyVO.setRecordCountPerPage(plyPaginationInfo.getRecordCountPerPage());	
			
			List grplist = egovPlyManageService.selectOpertGrpList(plyVO);
			List unitlist = egovPlyManageService.selectUnitOpertList(smap);
			int plyTotCnt = egovPlyManageService.selectOpertGrpListTotCnt(plyVO);
			
			String grpId = opert_group_id;
			
			String GrpId = (String) smap.get("OPERT_GROUP_ID");
			Map map = (Map) unitlist.get(0);				
			
			model.addAttribute("unitlist", unitlist);
			model.addAttribute("grplist", grplist);
			model.addAttribute("grpId", grpId);
			model.addAttribute("unitfirst", map);
			
			model.addAttribute("plyTotCnt", plyTotCnt);
			
			plyPaginationInfo.setTotalRecordCount(plyTotCnt);
	        model.addAttribute("plyPaginationInfo", plyPaginationInfo);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	   	return "egovframework/ply/EgovPlyManageList";
	}

	
	/**
	 * @Method Name  : selectDeptManageListView
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : 작업그룹 실행 화면으로 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/selectPlyManageListView.do")
	public String selectDeptManageListView() throws Exception {
		// log.debug(":::::::::테스트::::::::::::::::::");
//		System.out.println(":::::::/ply/selectPlyManageListView.do::::::::");
		return "egovframework/ply/EgovPlyManageList";
	}
	
	
	/**
	 * @Method Name  : opertGrpList
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 :작업 그룹 리스트를 조회
	 * @param model
	 * @return
	 */
	@RequestMapping("/ply/selectOpertGrpList.do")
	public String opertGrpList(ModelMap model, @ModelAttribute("plyVO") PlyVO plyVO) {
		try {
	    	/** 서버 paging */
	    	PaginationInfo plyPaginationInfo = new PaginationInfo();
	    	plyPaginationInfo.setCurrentPageNo(plyVO.getPageIndex());
	    	plyPaginationInfo.setRecordCountPerPage(plyVO.getPageUnit());
	    	plyPaginationInfo.setPageSize(plyVO.getPageSize());
			
	    	plyVO.setFirstIndex(plyPaginationInfo.getFirstRecordIndex());
	    	plyVO.setLastIndex(plyPaginationInfo.getLastRecordIndex());
	    	plyVO.setRecordCountPerPage(plyPaginationInfo.getRecordCountPerPage());	
			
			List<PlyVO> grplist = egovPlyManageService.selectOpertGrpList(plyVO);
			int plyTotCnt = egovPlyManageService.selectOpertGrpListTotCnt(plyVO);
			List grpCodelist = egovPlyManageService.selectGrpCode();
			
			model.addAttribute("grplist", grplist);
			model.addAttribute("plyTotCnt", plyTotCnt);
			model.addAttribute("grpCodeList", grpCodelist);
			plyPaginationInfo.setTotalRecordCount(plyTotCnt);
	        model.addAttribute("plyPaginationInfo", plyPaginationInfo);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "egovframework/ply/EgovPlyManageList";
	}
	
	/**
	 * 단위작업 리스트를 조회
	 * 
	 * @return String
	 * @exception Exception
	 */	
	@RequestMapping("/ply/selectUnitOpertListList.do")
	public String unitOpertList(ModelMap model, @RequestParam("opertGrpId") String opertGrpId, 
            @ModelAttribute("plyVO") PlyVO plyVO) {
		try {
			Map<String, Object> mmap = new HashMap<String, Object>();
			mmap.put("OPERT_GROUP_ID", opertGrpId);
			
			List maxlist = egovPlyManageService.selectMaxExecutDt(mmap); //작업그룹실행일시 max값 조회
			
			Map maxmap = (Map) maxlist.get(0);
			String max_excutdt = (String) maxmap.get("MAX_EXECUT_DT");
			
			Map<String, Object> smap = new HashMap<String, Object>();
			smap.put("OPERT_GROUP_ID", opertGrpId);
			smap.put("OPERT_GROUP_EXECUT_DT", max_excutdt);
			
	    	/** 서버 paging */
	    	PaginationInfo plyPaginationInfo = new PaginationInfo();
	    	plyPaginationInfo.setCurrentPageNo(plyVO.getPageIndex());
	    	plyPaginationInfo.setRecordCountPerPage(plyVO.getPageUnit());
	    	plyPaginationInfo.setPageSize(plyVO.getPageSize());
			
	    	plyVO.setFirstIndex(plyPaginationInfo.getFirstRecordIndex());
	    	plyVO.setLastIndex(plyPaginationInfo.getLastRecordIndex());
	    	plyVO.setRecordCountPerPage(plyPaginationInfo.getRecordCountPerPage());	
			
			List<PlyVO> grplist = egovPlyManageService.selectOpertGrpList(plyVO);
			int plyTotCnt = egovPlyManageService.selectOpertGrpListTotCnt(plyVO);
			List unitlist = egovPlyManageService.selectUnitOpertList(smap);
			List grpCodelist = egovPlyManageService.selectGrpCode();
			
			
			String GrpId = (String) smap.get("OPERT_GROUP_ID");
			
			if(unitlist.size() != 0){
				Map map = (Map) unitlist.get(0);	
				model.addAttribute("unitfirst", map);
			}

			

			model.addAttribute("unitlist", unitlist);
			model.addAttribute("grplist", grplist);
			model.addAttribute("plyTotCnt", plyTotCnt);
			model.addAttribute("grpCodeList", grpCodelist);
			
			plyPaginationInfo.setTotalRecordCount(plyTotCnt);
	        model.addAttribute("plyPaginationInfo", plyPaginationInfo);
			model.addAttribute("grpId", GrpId);
			//model.addAttribute("gpcode", gpcode);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return "egovframework/ply/EgovPlyManageList";
	}	
	
	/**
	 * @Method Name  : selectTelnetPopupView
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 :실행결과 조회 화면으로 이동
	 * @param model
	 * @param opertGrpId
	 * @param unitOpert
	 * @param ip
	 * @param acntId
	 * @param prtcl
	 * @param opertCn
	 * @param unitnm
	 * @param check_time
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/playSamplePopup.do")
	public String selectTelnetPopupView(ModelMap model,@RequestParam(value="opertGrpId", required=false) String opertGrpId,
			@RequestParam(value="unitOpert", required=false) String unitOpert,
			@RequestParam(value="ip", required=false) String ip,
			@RequestParam(value="acntId", required=false) String acntId,
			@RequestParam(value="prtcl", required=false) String prtcl,
			@RequestParam(value="check_time", required=false) String check_time,
			@RequestParam(value="nextrow", required=false) String nextrow,
			@RequestParam(value="ip_n", required=false) String ip_n,
			@RequestParam(value="acntId_n", required=false) String acntId_n,
			@RequestParam(value="prtcl_n", required=false) String prtcl_n,
			@RequestParam(value="userid", required=false) String userid
			) throws Exception {
		
		
		Map<String, Object> amap = new HashMap<String, Object>();
		amap.put("OPERT_GROUP_ID", opertGrpId);
		
		List maxlist = egovPlyManageService.selectMaxExecutDt(amap); //작업그룹실행일시 max값 조회
		
		Map bmap = (Map) maxlist.get(0);
		
		String opert_executdt = (String) bmap.get("MAX_EXECUT_DT");
//		System.out.println("samplepop ::: >>" + opert_executdt);
		Map<String, Object> vMap = new HashMap<String, Object>();
		
		vMap.put("OPERT_GROUP_ID", opertGrpId);
		vMap.put("UNIT_OPERT_ID", unitOpert);	
		vMap.put("IP_ADRES", ip);
		vMap.put("ACNT_ID", acntId);
		vMap.put("PRTCL_CODE", prtcl);
		vMap.put("USER_ID", userid);
		vMap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);
		
		List list_pop = egovPlyManageService.selectPopList(vMap);
		
		Map<String, Object> lMap = new HashMap<String, Object>();
		
		lMap.put("OPERT_GROUP_ID", opertGrpId);
		if(nextrow != null){
			lMap.put("UNIT_OPERT_ID", nextrow);
			lMap.put("IP_ADRES", ip_n);
			lMap.put("ACNT_ID", acntId_n);
			lMap.put("PRTCL_CODE", prtcl_n);	
			lMap.put("USER_ID", userid);
			lMap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);				
		} else {
			lMap.put("UNIT_OPERT_ID", unitOpert);
			lMap.put("IP_ADRES", ip);
			lMap.put("ACNT_ID", acntId);
			lMap.put("PRTCL_CODE", prtcl);	
			lMap.put("USER_ID", userid);
			lMap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);			
		}

		if(check_time == null ||check_time == ""){
			check_time = "3000";
		}
		int time = Integer.parseInt(check_time) / 1000;
		String time_interval = String.valueOf(time); 
		
		List list_Ply = egovPlyManageService.selectPlyManageList(lMap);

		Map map = (Map) list_Ply.get(0);
		String x = (String) map.get("RESULT");
//		System.out.println("RESULT :: >>" + x);
		Map vmap = (Map) list_pop.get(0);
		
//		System.out.println("vmap :: >>>>>" + vmap);
		
		model.addAttribute("list_Ply", map);// 실행결과
		model.addAttribute("check_time", check_time);// reload 시간 	
		model.addAttribute("time_interval", time_interval);// 재조회 value값	
		model.addAttribute("list_pop", vmap);// 팝업 정보를 db에서 select해서 입력
		
		return "egovframework/ply/EgovPlyManagePop";
	}	
	
	/**
	 * @Method Name  : serverManageSearch
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : 결과보기
	 * @param model
	 * @param opertGrpId
	 * @param unitOpert
	 * @param ip
	 * @param acntId
	 * @param prtcl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/playTelnetResult.do")
	public String serverManageSearch(ModelMap model,
			@RequestParam("opertGrpId") String opertGrpId,
			@RequestParam("unitOpert") String unitOpert,
			@RequestParam("ip") String ip,
			@RequestParam("acntId") String acntId,
			@RequestParam("prtcl") String prtcl) throws Exception {
////		System.out.println(":::::실행결과 조회:::::");
		try {
			
			Map<String, Object> lMap = new HashMap<String, Object>();
			
			lMap.put("OPERT_GROUP_ID", opertGrpId);
			lMap.put("UNIT_OPERT_ID", unitOpert);
			lMap.put("IP_ADRES", ip);
			lMap.put("ACNT_ID", acntId);
			lMap.put("PRTCL_CODE", prtcl);
			
			List list_Ply = egovPlyManageService.selectPlyManageList(lMap);
			
			Map map = (Map) list_Ply.get(0);
			String x = (String) map.get("RESULT");
			model.addAttribute("list_Ply", map);// 실행결과 목록

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "egovframework/ply/EgovPlyManagFnlPop";
	}	
	

	/**
	 * @Method Name  : executBfeCnfirm
	 * @작성일   : 2012. 2. 29. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : 실행전 확인 여부 Y로 업데이트 처리 
	 * @param opertGrpId
	 * @param unitOpert
	 * @param ip
	 * @param acntId
	 * @param prtcl
	 * @return
	 */
	@RequestMapping("/ply/executBfeCnfirm.do")	
	public String executBfeCnfirm(ModelMap model, @RequestParam("opertGrpId") String opertGrpId,
			@RequestParam("unitOpert") String unitOpert,
			@RequestParam("ip") String ip,
			@RequestParam("acntId") String acntId,
			@RequestParam("prtcl") String prtcl,
			@RequestParam(value="check_time", required=false) String check_time,
			@RequestParam(value="userid", required=false) String userid) {
		try {
			//작업그룹실행일시 max값 조회
			Map<String, Object> amap = new HashMap<String, Object>();
			amap.put("OPERT_GROUP_ID", opertGrpId);			
			
			List maxlist = egovPlyManageService.selectMaxExecutDt(amap); 
			Map bmap = (Map) maxlist.get(0);
			String opert_executdt = (String) bmap.get("MAX_EXECUT_DT");
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("OPERT_GROUP_ID", opertGrpId);
			map.put("UNIT_OPERT_ID", unitOpert);
			map.put("IP_ADRES", ip);
			map.put("ACNT_ID", acntId);
			map.put("PRTCL_CODE", prtcl);
			
			egovPlyManageService.updateExecutCnfirm(map);
			
			if(check_time == null ||check_time == ""){
				check_time = "3000";
			}
			int time = Integer.parseInt(check_time) / 1000;
			String time_interval = String.valueOf(time); 
			String loading = "unload";
			
			Map<String, Object> Pmap = new HashMap<String, Object>();
			
			Pmap.put("OPERT_GROUP_ID", opertGrpId);
			Pmap.put("UNIT_OPERT_ID", unitOpert);
			Pmap.put("IP_ADRES", ip);
			Pmap.put("ACNT_ID", acntId);
			Pmap.put("PRTCL_CODE", prtcl);
			Pmap.put("USER_ID", userid);
			Pmap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);			
			
			List list_Ply = egovPlyManageService.selectPlyManageList(Pmap);
			
			Map<String, Object> vMap = new HashMap<String, Object>();
			
			vMap.put("OPERT_GROUP_ID", opertGrpId);
			vMap.put("UNIT_OPERT_ID", unitOpert);	
			vMap.put("IP_ADRES", ip);
			vMap.put("ACNT_ID", acntId);
			vMap.put("PRTCL_CODE", prtcl);
			vMap.put("USER_ID", userid);
			vMap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);
			
			List list_pop = egovPlyManageService.selectPopList(vMap);			
			
			Map lmap = (Map) list_Ply.get(0);
			String x = (String) map.get("RESULT");

			Map vmap = (Map) list_pop.get(0);			
			
			model.addAttribute("list_Ply", lmap);// 실행결과
			model.addAttribute("list_pop", vmap);// 팝업 정보를 db에서 select해서 입력
			model.addAttribute("check_time", check_time);// reload 시간 	
			model.addAttribute("time_interval", time_interval);// 재조회 value값	
			model.addAttribute("unload", loading);// confirm 창 한번만 실행 되도록
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return "egovframework/ply/EgovPlyManagePop";
	}		
	
	/**
	 * @Method Name  : selectTextAreaView
	 * @작성일   : 2012. 2. 22. 
	 * @작성자   : cha seung jun
	 * @변경이력  :
	 * @Method 설명 : 실행결과 iframe 호출
	 * @param model
	 * @param opertGrpId
	 * @param unitOpert
	 * @param ip
	 * @param acntId
	 * @param prtcl
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/playTexArea.do")
	public String selectTextAreaView(ModelMap model,@RequestParam("opertGrpId") String opertGrpId,
			@RequestParam("unitOpert") String unitOpert,
			@RequestParam("ip") String ip,
			@RequestParam("acntId") String acntId,
			@RequestParam("prtcl") String prtcl,
			@RequestParam("userid") String userid,
			@RequestParam("opert_executdt") String opert_executdt) throws Exception {
////		System.out.println(":::::::TEXTAREA::::::::");
		
		Map<String, Object> amap = new HashMap<String, Object>();
		amap.put("OPERT_GROUP_ID", opertGrpId);
		
		List maxlist = egovPlyManageService.selectMaxExecutDt(amap); //작업그룹실행일시 max값 조회
		
		Map bmap = (Map) maxlist.get(0);
		
		opert_executdt = (String) bmap.get("MAX_EXECUT_DT");		
		
		Map<String, Object> lMap = new HashMap<String, Object>();
		
		lMap.put("OPERT_GROUP_ID", opertGrpId);
		lMap.put("UNIT_OPERT_ID", unitOpert);
		lMap.put("IP_ADRES", ip);
		lMap.put("ACNT_ID", acntId);
		lMap.put("PRTCL_CODE", prtcl);
		lMap.put("USER_ID", userid);
		lMap.put("OPERT_GROUP_EXECUT_DT", opert_executdt);		
		
		List list_Ply = egovPlyManageService.selectPlyManageList(lMap); //결과값 정보를 가져옴
		List list_next = egovPlyManageService.selectNextrowList(lMap); // 다음 팝업에 대한 next row를 가져옴
		List list_pop = null;
		
		
		Map map = (Map) list_Ply.get(0);
		Map nmap = (Map) list_next.get(0);
		
		String next_row = (String) nmap.get("NEXT_ROW");

		if(next_row != null){

			list_pop = egovPlyManageService.selectNextPopList(nmap); // 다음 팝업에 대한 정보를 가져옴			
			Map pmap = (Map) list_pop.get(0);
			model.addAttribute("list_pop", pmap);// next 팝업에 대한 정보를 JSP로 보냄

		}
		model.addAttribute("list_Ply", map);// 실행결과 목록	jsp로 보냄
		model.addAttribute("list_next", nmap);// next row 정보를 가져옴	

		return "egovframework/ply/PlyResult";
	}	
	
}
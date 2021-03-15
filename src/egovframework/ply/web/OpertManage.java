package egovframework.ply.web;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.ply.service.OpertGroupVO;
import egovframework.ply.service.OpertManageService;
import egovframework.ply.service.UnitOpertVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class OpertManage {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	@Resource(name = "opertManageService")
	protected OpertManageService opertManageService;

	/** Message ID Generation */
	@Resource(name = "egovDeptManageIdGnrService")
	private EgovIdGnrService egovPlyManageIdGnrService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 작업그룹관리 메인 화면
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/opertManage.do")
	public String opertManageMain(
			@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO,
			@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO,
			@RequestParam(value = "checkOpertGroupId", required = false) String checkOpertGroupId,
			Model model) throws Exception {

		/** 작업그룹 paging */
		
		PaginationInfo opertGroupPaginationInfo = new PaginationInfo();
		opertGroupPaginationInfo.setCurrentPageNo(opertGroupVO.getPageIndex());
		opertGroupPaginationInfo.setRecordCountPerPage(opertGroupVO.getPageUnit());
		opertGroupPaginationInfo.setPageSize(opertGroupVO.getPageSize());

		opertGroupVO.setFirstIndex(opertGroupPaginationInfo.getFirstRecordIndex());
		opertGroupVO.setLastIndex(opertGroupPaginationInfo.getLastRecordIndex());
		opertGroupVO.setRecordCountPerPage(opertGroupPaginationInfo.getRecordCountPerPage());
		if(opertGroupVO.getOpertGroupNm()!=null){
		opertGroupVO.setOpertGroupNm(URLDecoder.decode(opertGroupVO.getOpertGroupNm(),"UTF-8"));
		}
		List unitOpertList = null;

		if (checkOpertGroupId != null && !"0".equals(checkOpertGroupId)) {
			unitOpertVO.setOpertGroupId(Integer.parseInt(checkOpertGroupId));
			unitOpertList = opertManageService.selectUnitOpertList(unitOpertVO);
			model.addAttribute("unitOpertListTotCnt", unitOpertList.size());
		}
		
		List opertGroupList = opertManageService.selectOpertGroupList(opertGroupVO);
		//List unitOpertList = opertManageService.selectUnitOpertList(unitOpertVO);
		int opertGroupListTotCnt = opertManageService.selectOpertGroupListTotCnt(opertGroupVO);
		
		model.addAttribute("opertGroupList", opertGroupList);
		model.addAttribute("unitOpertList", unitOpertList);
		model.addAttribute("opertGroupListTotCnt", opertGroupListTotCnt);
		
		opertGroupPaginationInfo.setTotalRecordCount(opertGroupListTotCnt);
		model.addAttribute("opertGroupPaginationInfo", opertGroupPaginationInfo);

		return "egovframework/ply/OpertManage";
	}
	
	/**
	 * 작업그룹 추가 화면
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/opertGroupAditView.do")
	public String opertGroupAditView(Model model) throws Exception {
		
		List opertGroupKindList = opertManageService.selectOpertGroupKind();
		model.addAttribute("opertGroupKindList", opertGroupKindList);
		
		return "egovframework/ply/OpertGroupAdit";
	}
	
	/**
	 * 작업그룹을 등록한다.
	 * @param opertGroupVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/insertOpertGroup.do")
	public String insertOpertGroup(@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO, Model model) throws Exception {
		opertManageService.insertOpertGroup(opertGroupVO);
		
		model.addAttribute("insertAt", "true");
		return "egovframework/ply/OpertGroupAdit";
	}
	
	/**
	 * 작업그룹 수정 화면
	 * @param opertGroupVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/updateOpertGroupView.do")
	public String updateOpertGroupView(@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO, Model model) throws Exception {
		List opertGroupKindList = opertManageService.selectOpertGroupKind();
		model.addAttribute("opertGroupKindList", opertGroupKindList);
		
		opertGroupVO.setFirstIndex(0);
		List opertGroupList = opertManageService.selectOpertGroupList(opertGroupVO);
		
		if (opertGroupList != null && opertGroupList.size() > 0) {
			model.addAttribute("opertGroupList", opertGroupList.get(0));	
		}
		
		return "egovframework/ply/OpertGroupUpdt";
	}
	
	/**
	 * 작업그룹을 수정한다.
	 * @param opertGroupVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/updateOpertGroup.do")
	public String updateOpertGroup(@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO, Model model) throws Exception {
		int updtResult = opertManageService.updateOpertGroup(opertGroupVO);
		
		model.addAttribute("updtResult", updtResult);
		
		opertGroupVO.setFirstIndex(0);
		List opertGroupList = opertManageService.selectOpertGroupList(opertGroupVO);
		
		if (opertGroupList != null && opertGroupList.size() > 0) {
			model.addAttribute("opertGroupList", opertGroupList.get(0));	
		}		
		return "egovframework/ply/OpertGroupUpdt";
	}
	
	/**
	 * 작업그룹의 삭제여부를 수정한다.
	 * @param opertGroupVO
	 * @param checkOpertGroupId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/deleteOpertGroup.do")
	public String deleteOpertGroup(
			@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO,
			@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO,
			@RequestParam(value = "checkOpertGroupId", required = false) String checkOpertGroupId,
			Model model) throws Exception {
		
		int deleteResult = opertManageService.deleteOpertGroup(opertGroupVO);
		opertGroupVO.setOpertGroupId(0);
		model.addAttribute("deleteResult", deleteResult);
		return opertManageMain(opertGroupVO, unitOpertVO, checkOpertGroupId, model);
	}
	
	/**
	 * 단위작업 추가 화면
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/unitOpertAditView.do")
	public String UnitOpertAditView(@RequestParam(value = "ipAdres", required = false) String ipAdres,
			@RequestParam(value = "acntId", required = false) String acntId,
			@RequestParam(value = "prtclCode", required = false) String prtclCode,
			Model model) throws Exception {
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
        
		commandMap.put("ipAdres", ipAdres);
		commandMap.put("acntId", acntId);		
		
		List ipAdresList = opertManageService.selectIpAdresList();
		List acntList = opertManageService.selectAcntList(commandMap);
		List prtclList = opertManageService.selectPrtclList(commandMap);
		
		model.addAttribute("ipAdresList", ipAdresList);
		model.addAttribute("acntList", acntList);
		model.addAttribute("prtclList", prtclList);
		
		return "egovframework/ply/UnitOpertAdit";
	}
	
	/**
	 * 단위작업을 추가한다.
	 * @param unitOpertVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/insertUnitOpert.do")
	public String insertUnitOpert(@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO,
			@RequestParam(value = "ipAdres", required = false) String ipAdres,
			@RequestParam(value = "acntId", required = false) String acntId,
			@RequestParam(value = "prtclCode", required = false) String prtclCode,
			@RequestParam(value = "opertSn", required = false) String opertSn,
			Model model) throws Exception {
		

		int opertSn_cnt = opertManageService.selectUnitOpertSnCnt(unitOpertVO);
		

		if(opertSn_cnt <= 0) {
			opertManageService.insertUnitOpert(unitOpertVO);	
			model.addAttribute("insertAt", "true");
		} else if(opertSn_cnt > 0) {

			int opertSn_max = opertManageService.selectUnitOpertSnMax(unitOpertVO);
			unitOpertVO.setOpertSn(opertSn_max);
//			System.out.println("opertSn :: >>" + unitOpertVO.getOpertSn());
			opertManageService.insertUnitOpert(unitOpertVO);	
			model.addAttribute("resultMsg", "true");
			model.addAttribute("insertAt", "true");
		}

		//return "egovframework/ply/UnitOpertAdit";
		return this.UnitOpertAditView(ipAdres, acntId, prtclCode, model);
	}
	
	/**
	 * 단위작업 수정화면
	 * @param unitOpertVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/updateUnitOpertView.do")
	public String updateUnitOpertView(@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO, Model model) throws Exception {
		List unitOpertList = opertManageService.selectUnitOpertList(unitOpertVO);
		
		
		if (unitOpertList != null && unitOpertList.size() > 0) {
			model.addAttribute("unitOpertList", unitOpertList.get(0));
		}

		return "egovframework/ply/UnitOpertUpdt";
	}
	
	/**
	 * 단위작업을 수정한다.
	 * @param unitOpertVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/updateUnitOpert.do")
	public String updateUnitOpert(@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO, Model model, @RequestParam(value = "opertSn_cp", required = false) int opertSn_cp) throws Exception {
		int opertSn_cnt = opertManageService.selectUnitOpertSnCnt(unitOpertVO);
		int updtResult = 0;
		int opert_sn_c = unitOpertVO.getOpertSn();
		
		if(opertSn_cnt <= 0) {
			updtResult = opertManageService.updateUnitOpert(unitOpertVO);
			model.addAttribute("updtResult", updtResult);
		} else if(opertSn_cnt > 0) {
				int opertSn_max = opertManageService.selectUnitOpertSnMax(unitOpertVO);
			if(opertSn_cp != opert_sn_c) {
				unitOpertVO.setOpertSn(opertSn_max);			
				model.addAttribute("resultMsg", "true");
			}
			
			updtResult = opertManageService.updateUnitOpert(unitOpertVO);
			model.addAttribute("updtResult", updtResult);
		}
		
		List unitOpertList = opertManageService.selectUnitOpertList(unitOpertVO);
		
		
		if (unitOpertList != null && unitOpertList.size() > 0) {
			model.addAttribute("unitOpertList", unitOpertList.get(0));
		}		
		
		
		
		return "egovframework/ply/UnitOpertUpdt";
	}
	
	/**
	 * 단위작업의 사용여부를 수정한다.
	 * @param opertGroupVO
	 * @param unitOpertVO
	 * @param checkOpertGroupId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ply/deleteUnitOpert.do")
	public String deleteUnitOpert(
			@ModelAttribute("opertGroupVO") OpertGroupVO opertGroupVO,
			@ModelAttribute("unitOpertVO") UnitOpertVO unitOpertVO,
			@RequestParam(value = "checkOpertGroupId", required = false) String checkOpertGroupId,
			Model model) throws Exception {
		
		int deleteResult = opertManageService.deleteUnitOpert(unitOpertVO);
		model.addAttribute("deleteResult", deleteResult);
		
		opertGroupVO.setOpertGroupId(0);
		unitOpertVO.setUnitOpertId(0);
		
		return this.opertManageMain(opertGroupVO, unitOpertVO, checkOpertGroupId, model);
	}

}
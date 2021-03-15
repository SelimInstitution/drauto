package egovframework.dr.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import twitter4j.internal.org.json.JSONObject;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.dr.service.DsstrRecovryManageService;
import egovframework.dr.service.DsstrRecovryOpertVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class DsstrRecovryManage {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** Message ID Generation */
	@Resource(name = "egovDeptManageIdGnrService")
	private EgovIdGnrService egovPlyManageIdGnrService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "dsstrRecovryManageService")
	protected DsstrRecovryManageService dsstrRecovryManageService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 현황판 부모화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/dr/selectDrPList.do")
	public String selectDrPList() throws Exception {

		return "egovframework/dr/DrManagePList";
	}

	/**
	 * 현황판 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@Resource MappingJacksonJsonView ajaxMainView;
	@RequestMapping("/dr/selectDrList.do")
	public ModelAndView selectDrList(
			@ModelAttribute("dsstrRecovryOpertVO") DsstrRecovryOpertVO dsstrRecovryOpertVO) throws Exception {
		
		//MappingJacksonJsonView ajaxMainView = new MappingJacksonJsonView();
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		int maxOpertOdr = dsstrRecovryManageService.selectMaxOpertOdr(dsstrRecovryOpertVO);
		model.put("maxOpertOdr", maxOpertOdr);
		
		// 차수가 없을 경우 마지막 차수를 조회한다.
		if (dsstrRecovryOpertVO.getOpertOdr() == 0) {
			dsstrRecovryOpertVO.setOpertOdr(maxOpertOdr);
		}

		// 대분류 상태 조회
		List lclasStttus = dsstrRecovryManageService.selectLclasSttus(dsstrRecovryOpertVO);

		if (lclasStttus != null && lclasStttus.size() > 0) {
			model.put("lclasStttus1", (String) ((Map)lclasStttus.get(0)).get("OPERT_STTUS"));
			model.put("lclasStttus2", (String) ((Map)lclasStttus.get(1)).get("OPERT_STTUS"));
			model.put("lclasStttus3", (String) ((Map)lclasStttus.get(2)).get("OPERT_STTUS"));
			model.put("lclasStttus4", (String) ((Map)lclasStttus.get(3)).get("OPERT_STTUS"));
			model.put("lclasStttus5", (String) ((Map)lclasStttus.get(4)).get("OPERT_STTUS"));
			model.put("lclasStttus6", (String) ((Map)lclasStttus.get(5)).get("OPERT_STTUS"));
			model.put("lclasStttus7", (String) ((Map)lclasStttus.get(6)).get("OPERT_STTUS"));
		} else {
			model.put("lclasStttus1", "fix0");
			model.put("lclasStttus2", "fix0");
			model.put("lclasStttus3", "fix0");
			model.put("lclasStttus4", "fix0");
			model.put("lclasStttus5", "fix0");
			model.put("lclasStttus6", "fix0");
			model.put("lclasStttus7", "fix0");
		}

		// 작업그룹 상태 조회
		List opertGroupSttus = dsstrRecovryManageService.selectOpertGgroupSttus(dsstrRecovryOpertVO);
		
		if (opertGroupSttus != null && opertGroupSttus.size() > 0) {
			Iterator it = opertGroupSttus.iterator();
			Map m = null;
			
			while(it.hasNext()) {
				m = (Map) it.next();
				model.put("LI_"+((java.math.BigDecimal) m.get("OPERT_GROUP_ID")).toString(), (String) m.get("OPERT_STTUS"));
				
				String aClass = null;
				String tmp = (String) m.get("OPERT_STTUS");
				if ("condition_01".equals(tmp)) {
					aClass = "select";
				} else if ("condition_02".equals(tmp)) {
					aClass = "select_02";
				} else if ("condition_03".equals(tmp)) {
					aClass = "select_03";
				}
				model.put("A_"+((java.math.BigDecimal) m.get("OPERT_GROUP_ID")).toString(), aClass);
			}
		}		
		
		ModelAndView mav = new ModelAndView(ajaxMainView, model);
		
		// 단위작업 상태 조회
		if (dsstrRecovryOpertVO.getOpertGroupId() != 0) {
			mav.addObject("dsstrRecovryList", dsstrRecovryManageService.selectDsstrRecovry(dsstrRecovryOpertVO));
		}
		
		// 차수 목록 조회
		mav.addObject("opertOdrList", dsstrRecovryManageService.selectOpertOdrList(dsstrRecovryOpertVO));
		
		return mav;
	}
	
	/**
	 * 차수를 추가한다.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dr/insertOpertOdr.do")
	public ModelAndView insertOpertOdr(@ModelAttribute("dsstrRecovryOpertVO") DsstrRecovryOpertVO dsstrRecovryOpertVO,
			@RequestParam(value = "crtrId", required = false) String crtrId) throws Exception {
		dsstrRecovryOpertVO.setCrtrId(crtrId);
		
		dsstrRecovryManageService.insertOpertOdr(dsstrRecovryOpertVO);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("insertAt", "true");

		return new ModelAndView(ajaxMainView, model);
	}
	
	/**
	 * 현황판 화면으로 이동
	 * 
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping("/dr/selectDrfList.do")
	public String selectDrList(@RequestParam(value = "opertDiv", required = false) String opertDiv,
			@RequestParam(value = "opertTyCode", required = false) String opertTyCode) throws Exception {
		
		System.out.println("opertDiv : >>"+opertDiv);
		System.out.println("opertTyCode : >>"+opertTyCode);
		
		String rtn_jsp = "egovframework/dr/DR";
		if (opertDiv != null) rtn_jsp += "_"+opertDiv;
		if (opertTyCode != null) rtn_jsp += "_"+opertTyCode;
		
		return rtn_jsp;
	}	

}
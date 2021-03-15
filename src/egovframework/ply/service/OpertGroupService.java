package egovframework.ply.service;

import java.util.List;
import java.util.Map;

import egovframework.com.uss.umt.service.DeptManageVO;
import egovframework.server.service.ServerVO;

public interface OpertGroupService {


	/**
	 * 서버정보를 신규로 등록한다.
	 * @param PlyManageVO - 부서 model
	 * 
	 * @param PlyManageVO
	 * @return 
	 */
	public void opertGroupExecut(String opert_group_id, String userid, String[] chk_val) throws Exception;

}

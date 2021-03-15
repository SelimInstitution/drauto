package egovframework.ply.service.impl;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.ply.service.ParameterSubstrUtil;
import egovframework.ply.web.MyUserInfo;

@Component
public class OpertGroupService {

	@Resource(name = "plyManageDAO")
	private PlyManageDAO plyManageDAO;

	// @Resource(name = "egovPlyManageService")
	// protected EgovPlyManageService egovPlyManageService;

	// private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;

	private String opertGroupId; // 작업그룹 ID
	private String loginUserId; // 로그인 사용자 ID
	private String ipAdres; // IP 주소
	private String acntId; // 계정 ID
	private String password; // 비밀번호
	private String prtclCode; // 프로토콜 코드
	private String port; // 포트 번호
	private String prompt; // 프롬프트 경로
	private String unitOpertId; // 단위작
	private String opertCn; // 작업 내용
	private String opertSn; // 작업 순번
	private String executBfeCnfirmAt; // 실행전 확인 여부
	private String executdt; // 작업그룹실행시간
	private String opertExecutDt; // 실행취소의 경우 작업그룹실행시간
	private int cancl_cnt;
	private String cancl; // 실행 취소
	// private String errorAt; // dr 에러

	private String start_time = ""; // 스크립트 실행시간
	private String end_time = ""; // 스크립트 종료시간
	private String opert_div = ""; // 작업구분
	private String opert_ty_code = ""; // 작업유형코드
	private String commands = ""; // ProcessCommand.START 구문내의 명령문
	private String tbl_nm = ""; // 부분 저장 테이블명
	private String col_nm = ""; // 부분 저장 컬럼명
	boolean isCommand = false;
	boolean pcommand_start = false;

	/**
	 * 작업그룹 실행
	 * 
	 * @param opertGroupId
	 */
	@Async
	public void opertGroupExecut(String _opertGroupId, String _loginUserId, String[] chk_val, String _executdt) {
		try {

			opertGroupId = _opertGroupId;
			loginUserId = _loginUserId;
			executdt = _executdt;
			// // 해당 작업그룹에 속한 모든 단위 작업 조회(체크박스에 체크된 리스트만 SELECT)
			Map<String, Object> Lmap = new HashMap<String, Object>();

			Lmap.put("OPERT_GROUP_ID", opertGroupId);
			Lmap.put("UNIT_OPERT_ID", chk_val);
			Lmap.put("TYPE", "IN");

			List list = plyManageDAO.selectGrpByUnitList(Lmap);
			//
			// 해당 작업그룹에 속한 모든 단위 작업 조회(체크박스에 체크안된 리스트만 SELECT)
			Map<String, Object> Nmap = new HashMap<String, Object>();

			Nmap.put("OPERT_GROUP_ID", opertGroupId);
			Nmap.put("UNIT_OPERT_ID", chk_val);
			Nmap.put("TYPE", "NOT IN");
			//
			// List list_not = plyManageDAO.selectGrpByUnitList(Nmap);

			// 실행취소 확인을 위해 cancl_cnt 조회
			Map<String, Object> canclmap = new HashMap<String, Object>();
			canclmap.put("OPERT_GROUP_ID", opertGroupId);
			cancl_cnt = plyManageDAO.selectCanclAtCnt(canclmap);

			if (cancl_cnt > 0) {
				// 실행취소의 경우 opert_group_execut_dt 조회한다.
				List list_opertExecutDt = plyManageDAO.selectOpertExecutDt(Nmap);
				Map optExecDtmap = (Map) list_opertExecutDt.get(0);

				opertExecutDt = (String) optExecDtmap.get("OPERT_GROUP_EXECUT_DT");
			}

			// SYSDATE를 조회하기 위한 부분
			// Map<String, Object> lMap = new HashMap<String, Object>();
			//
			// List list_sys = plyManageDAO.selectSysdate(lMap);
			//
			// Map smap = (Map) list_sys.get(0);
			// executdt = (String) smap.get("EXECUT_DT");

			// 체크된 리스트 처리
			// if (list == null || list.size() == 0)
			// return;
			//
			// if(cancl_cnt <= 0){
			// for (int i = 0; i < list.size(); i++) {
			//
			// Map map = (Map) list.get(i);
			//
			// ipAdres = (String) map.get("IP_ADRES");
			// acntId = (String) map.get("ACNT_ID");
			// password = (String) map.get("PASSWORD");
			// prtclCode = (String) map.get("PRTCL_CODE");
			// port = (String) map.get("PORT");
			// prompt = (String) map.get("PROMPT");
			// unitOpertId = (String) map.get("UNIT_OPERT_ID");
			// opertCn = (String) map.get("OPERT_CN");
			// opertSn = (String) map.get("OPERT_SN");
			// executBfeCnfirmAt = (String) map.get("EXECUT_BFE_CNFIRM_AT");
			//
			//
			//
			// Map<String, Object> commandMap = new HashMap<String, Object>();
			//
			// commandMap.put("OPERT_GROUP_ID", opertGroupId);
			// commandMap.put("UNIT_OPERT_ID", unitOpertId);
			// commandMap.put("IP_ADRES", ipAdres);
			// commandMap.put("ACNT_ID", acntId);
			// commandMap.put("PRTCL_CODE", prtclCode);
			// commandMap.put("USER_ID", loginUserId);
			// commandMap.put("OPERT_GROUP_EXECUT_DT", executdt);
			// commandMap.put("EXECUT_DT", "");
			// commandMap.put("END_DT", "");
			// commandMap.put("RESULT", "");
			//
			// plyManageDAO.insertPlyManage(commandMap);
			// }
			//
			// //체크안된 부분 처리
			// //if (list_not == null || list_not.size() == 0)
			// // return;
			// for (int i = 0; i < list_not.size(); i++) {
			//
			// Map map = (Map) list_not.get(i);
			//
			// ipAdres = (String) map.get("IP_ADRES");
			// acntId = (String) map.get("ACNT_ID");
			// password = (String) map.get("PASSWORD");
			// prtclCode = (String) map.get("PRTCL_CODE");
			// port = (String) map.get("PORT");
			// prompt = (String) map.get("PROMPT");
			// unitOpertId = (String) map.get("UNIT_OPERT_ID");
			// opertCn = (String) map.get("OPERT_CN");
			// opertSn = (String) map.get("OPERT_SN");
			// executBfeCnfirmAt = (String) map.get("EXECUT_BFE_CNFIRM_AT");
			//
			// Map<String, Object> commandMap = new HashMap<String, Object>();
			//
			// commandMap.put("OPERT_GROUP_ID", opertGroupId);
			// commandMap.put("UNIT_OPERT_ID", unitOpertId);
			// commandMap.put("IP_ADRES", ipAdres);
			// commandMap.put("ACNT_ID", acntId);
			// commandMap.put("PRTCL_CODE", prtclCode);
			// commandMap.put("USER_ID", loginUserId);
			// commandMap.put("OPERT_GROUP_EXECUT_DT", executdt);
			// commandMap.put("EXECUT_DT", executdt);
			// commandMap.put("END_DT", executdt);
			// commandMap.put("RESULT", "사용자에의한 미실행");
			//
			// plyManageDAO.insertPlyManage(commandMap);
			//
			// }
			// }

			// 단위작업의 개수 만큼 LOOP
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
				opertCn = opertCn.replaceAll("<br/>","\n");
				opertSn = (String) map.get("OPERT_SN");
				executBfeCnfirmAt = (String) map.get("EXECUT_BFE_CNFIRM_AT");

				// 실행취소 select C 브레이크,
				Map<String, Object> cmap = new HashMap<String, Object>();

				cmap.put("IP_ADRES", ipAdres);
				cmap.put("ACNT_ID", acntId);
				cmap.put("PRTCL_CODE", prtclCode);
				cmap.put("OPERT_GROUP_ID", opertGroupId);
				cmap.put("UNIT_OPERT_ID", unitOpertId);
				cmap.put("USER_ID", loginUserId);
				if (cancl_cnt <= 0) {
					cmap.put("OPERT_GROUP_EXECUT_DT", executdt);
				} else {
					cmap.put("OPERT_GROUP_EXECUT_DT", opertExecutDt);
				}

				plyManageDAO.updateUnitOpertCnfirmResult(cmap);

				// 실행취소여부 조회
				List list_cancl = plyManageDAO.selectCanclAtList(cmap);
				Map amap = (Map) list_cancl.get(0);
				cancl = (String) amap.get("CANCL_AT");

				if (cancl_cnt <= 0 && cancl.equals("C")) {
					break;
				} else {
					// 실행 전 사용자 확인받아야 할 대상
					if ("Y".equals(executBfeCnfirmAt)) {
						// executBfeCnfirm();
						if (!executBfeCnfirm()) {
							// System.out.println("false::::>>>");
							break;
						} else {
							cancelRecovery();
							if ("PRTCL001".equals(prtclCode)) { // 프로토콜이 텔넷인 경우
								telnetExecut();
							} else if ("PRTCL002".equals(prtclCode)) { // 프로토콜이
								sshExecut(); // SSH인
							}
						}
					} else {
						cancelRecovery();
						if ("PRTCL001".equals(prtclCode)) { // 프로토콜이 텔넷인 경우
							telnetExecut();
						} else if ("PRTCL002".equals(prtclCode)) { // 프로토콜이 SSH인
							sshExecut();
						}
					}
				}
			} // for 문 종료 부분
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TELNET 실행
	 */
	private void telnetExecut() {
		try {
			TelnetClient telnet = new TelnetClient();

			String command1 = opertCn;
			telnet.connect(ipAdres, (StringUtils.isNumeric(port)) ? Integer.parseInt(port) : 23);
			telnet.setTcpNoDelay(true);
			// Get input and output stream references
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());
			
			
			readUntil("ogin:");			
			write(acntId);
			readUntil("assword:");
			write(password);

			// prompt 특수문자 치환
			prompt = EgovStringUtil.replace(
					EgovStringUtil.replace(EgovStringUtil.replace(EgovStringUtil.replace(prompt, "&gt;", ">"), "&lt;", "<"), "&quot;", "\""), "&apos;", "'");

			// Advance to a prompt
			readUntil(prompt);
			write(command1);
			// Advance to a prompt
			readUntil(prompt);

			telnet.disconnect();
			// serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * SSH 실행
	 */
	// @Scheduled(fixedDelay=6000)
	private void sshExecut() {
		try {

			JSch jsch = new JSch();

			String host = ipAdres;
			String user = acntId;
			String passwd = password;

			Session session = jsch.getSession(user, host, (StringUtils.isNumeric(port)) ? Integer.parseInt(port) : 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(passwd);
			UserInfo ui = new MyUserInfo(passwd);

			session.setUserInfo(ui);
			session.connect();

			// System.out.println("session connect");
			opertCn = EgovStringUtil.replace(
					EgovStringUtil.replace(EgovStringUtil.replace(EgovStringUtil.replace(opertCn, "&gt;", ">"), "&lt;", "<"), "&quot;", "\""), "&apos;", "'");
			String command = opertCn;

			ChannelExec channel = (ChannelExec) session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);

			channel.setInputStream(null);
			in = channel.getInputStream();

			channel.connect();

			readUntil(null);

			channel.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Method Name : write
	 * @작성일 : 2012. 2. 22.
	 * @작성자 : cha seung jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	private void write(String value) {

		try {
			out.println(value);
			out.flush();
			// System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Method Name : readUntil
	 * @작성일 : 2012. 2. 22.
	 * @작성자 : cha seung jun
	 * @변경이력 :
	 * @Method 설명 : telnet 접속 후 명령어 처리
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	private void readUntil(String pattern) throws Exception {
		if (pattern != null) {
			pattern = EgovStringUtil.replace(
					EgovStringUtil.replace(EgovStringUtil.replace(EgovStringUtil.replace(pattern, "&gt;", ">"), "&lt;", "<"), "&quot;", "\""), "&apos;", "'");
		}

		try {
			int ret_read = 0;
			boolean loop = true;
			StringBuffer sb = new StringBuffer();
			String[] line_a = null;
			String crlf = "";

			StringBuffer line_s = new StringBuffer(); // 실행결과를 한 줄씩 저장
			StringBuffer save_s = new StringBuffer(); // ProcessCommand 내의 실행결과

			// sb.append("\r\n");

			do {
				byte[] buff = new byte[2048];
				
				while (in.available() == 0)
					Thread.sleep(10);

				if (in.available() > 0) {
					ret_read = in.read(buff);
					sb.append(new String(buff, 0, ret_read));
				}
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("IP : " + ipAdres + "          ID : " + acntId);
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.println(sb.toString());
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.println("LF.indexOf : " + sb.indexOf("\n") + "           CR.indexOf : " + sb.indexOf("\r") + "           CRLF.indexOf : "
						+ sb.indexOf("\r\n"));
				System.out.println("----------------------------------------------------------------------------------------------------------------");

				if (sb.indexOf("\n") > 0) {
					line_a = StringUtils.splitPreserveAllTokens(sb.toString(), "\n");
					crlf = "\n";
					System.out.println(pattern + "=======>LF : " + line_a.length);
				} else if (sb.indexOf("\r") > 0) {
					line_a = StringUtils.splitPreserveAllTokens(sb.toString(), "\r");
					crlf = "\r";
					System.out.println(pattern + "=======>CR : " + line_a.length);
				} else if (sb.indexOf("\r\n") > 0) {
					line_a = StringUtils.splitPreserveAllTokens(sb.toString(), "\r\n");
					crlf = "\r\n";
					System.out.println(pattern + "=======>CRLF : " + line_a.length);
				} else {
					line_a = StringUtils.splitPreserveAllTokens(sb.toString(), "\r\n");
					crlf = "\r\n";
					System.out.println(pattern + "=======>None : " + line_a.length);
				}
				//System.out.println("----------------------------------------------------------------------------------------------------------------");
				sb.setLength(0);

				for (int i = 0; i < line_a.length; i++) {
					loop = true;
					line_s.append(line_a[i]);

					if (pattern != null && i>0 && (pattern.equals("ogin:") || pattern.equals("assword:"))) {
						StringBuffer tmp = new StringBuffer();;
						tmp.append(line_a[i-1].replaceAll("\n", "").replaceAll("\r", ""));
						tmp.append(line_a[i].replaceAll("\n", "").replaceAll("\r", ""));

						System.out.println("tmp = " + tmp.toString());
						if (pattern != null && tmp.toString().trim().endsWith(pattern))
							loop = false;						
					} else {
						if (pattern != null && line_s.toString().trim().endsWith(pattern))
							loop = false;
					}
					

					if (loop && i == line_a.length - 1 && !line_s.toString().startsWith("[END OF SCRIPT]")) {
					/*	System.out.println("i = " + i + ", length = " + line_a.length);
						System.out.println("----------------------------------------------------------------------------------------------------------------");
						System.out.println("<<");*/
						if (line_a.length == 1)
							line_s.append(crlf);

						sb.append(line_s);
						line_s.setLength(0);

						break;
					}
					System.out.println("LINE S이다!!!!!!!!!!!!!!!!!!!!!"+(i + 1) + ". " + line_s.toString());

					line_s.append(crlf);
					
				if (line_s.toString().indexOf("[START OF SCRIPT]")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[START OF SCRIPT]")>-1)) {
					startOfScriptProc(line_s);
				}

				if (line_s.toString().indexOf("[ProcessCommand.ERROR]")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[ProcessCommand.ERROR]")>-1)) {						
					commandErrProc(line_s);
				}

				if (line_s.toString().indexOf("[ProcessCommand.START]")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[ProcessCommand.START]")>-1)) {
					save_s = commandStartProc(line_s);
				}

				if (line_s.toString().indexOf("[ProcessCommand.END]")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[ProcessCommand.END]")>-1)) {						
					commandEndProc(line_s, save_s);
				}

				if (isCommand &&!(line_s.toString().indexOf("[ProcessCommand")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[ProcessCommand")>-1))) {
					
					save_s.append(line_s);
				} else {
					save_s.setLength(0);
				}
					
					
/*					if (line_s.toString().startsWith("[START OF SCRIPT]")) {
						startOfScriptProc(line_s);
					}

					if (line_s.toString().startsWith("[ProcessCommand.ERROR]")) {
						commandErrProc(line_s);
					}

					if (line_s.toString().startsWith("[ProcessCommand.START]")) {
						save_s = commandStartProc(line_s);
					}

					if (line_s.toString().startsWith("[ProcessCommand.END]")) {
						commandEndProc(line_s, save_s);
					}

					if (isCommand && !line_s.toString().startsWith("[ProcessCommand")) {
						save_s.append(line_s);
					} else {
						save_s.setLength(0);
					}*/

					// update
					Map<String, Object> rMap = new HashMap<String, Object>();

					rMap.put("RESULT", line_s.toString());
					rMap.put("OPERT_GROUP_ID", opertGroupId);
					rMap.put("UNIT_OPERT_ID", unitOpertId);
					rMap.put("IP_ADRES", ipAdres);
					rMap.put("ACNT_ID", acntId);
					rMap.put("PRTCL_CODE", prtclCode);
					if (cancl_cnt <= 0) {
						rMap.put("OPERT_GROUP_EXECUT_DT", executdt);
					} else {
						rMap.put("OPERT_GROUP_EXECUT_DT", opertExecutDt);
					}
					rMap.put("USER_ID", loginUserId);

					plyManageDAO.updateResult(rMap);

					if (line_s.toString().indexOf("[END OF SCRIPT]")==0||(line_s.toString().indexOf("echo")==-1&&line_s.toString().indexOf("[END OF SCRIPT]")>-1)) {
						loop = false;
						endOfScriptProc(line_s);
					}

					line_s.setLength(0);
				}

			} while (loop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 실행 전 확인
	 */
	private boolean executBfeCnfirm() {

		SimpleDateFormat current = new SimpleDateFormat("yyyyMMddHHmmss");

		// String sttamp = current.format(new java.util.Date()); // 무한루프 탈출용 1시간
		String cktamp = null; // 10초마다 DB 확인용
		long startTime = System.currentTimeMillis(); // 시작시간
		long endTime = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("IP_ADRES", ipAdres);
		map.put("ACNT_ID", acntId);
		map.put("PRTCL_CODE", prtclCode);
		map.put("OPERT_GROUP_ID", opertGroupId);
		map.put("UNIT_OPERT_ID", unitOpertId);

		// double stopper = 0;

		while (true) {
			List list = null;

			if (cktamp == null) {
				cktamp = current.format(new java.util.Date());
				list = plyManageDAO.selectExeResultList(map);
				// System.out.println("cktamp1111::>>>>"+cktamp);
			} else if ((endTime - startTime) / 1000 == 600) {
				// //
				// System.out.println("::::::::::::::::::10분 됐다 멈춰라::::::::::::");
				break;
			} else {
				try {
					Thread.sleep(10000);

				} catch (Exception e) {
					e.printStackTrace();
				}
				cktamp = current.format(new java.util.Date());
				list = plyManageDAO.selectExeResultList(map);
				// System.out.println("cktamp222::>>>>"+cktamp);
				endTime = System.currentTimeMillis(); // 종료시간
			}

			if (list != null) {
				Map result_map = (Map) list.get(0);
				String ebcr = (String) result_map.get("EXECUT_BFE_CNFIRM_RESULT");
				// System.out.println("ebcr::>>>>>>>>" + ebcr);
				if ("Y".equals(ebcr)) {
					return true;
				}
			}

			// System.out.println("##  시작시간 : " + new
			// OpertGroupService().formatTime(startTime));
			// System.out.println("##  종료시간 : " + new
			// OpertGroupService().formatTime(endTime));
			// System.out.println("##  소요시간(초.0f) : " + (endTime - startTime) /
			// 1000 + "초");
		}

		return false;
	}

	// private int formatTime(long lTime) {
	// Calendar c = Calendar.getInstance();
	// c.setTimeInMillis(lTime);
	// return (c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.MINUTE) +
	// c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND));
	// }

	/**
	 * @Method Name : cancelRecovery
	 * @작성일 : 2012. 6. 1.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 : 실행취소 여부 재실행 시 플래그 값 원복 업데이트
	 * @param line_s
	 * @return
	 * @throws Exception
	 */
	private void cancelRecovery() throws Exception {
		Map<String, Object> mmap = new HashMap<String, Object>();
		mmap.put("OPERT_GROUP_ID", opertGroupId);

		List maxlist = plyManageDAO.selectMaxExecutDt(mmap); // 작업그룹실행일시 max값 조회

		Map maxmap = (Map) maxlist.get(0);
		String max_excutdt = (String) maxmap.get("MAX_EXECUT_DT");

		Map<String, Object> recovmap = new HashMap<String, Object>();
		recovmap.put("IP_ADRES", ipAdres);
		recovmap.put("ACNT_ID", acntId);
		recovmap.put("PRTCL_CODE", prtclCode);
		recovmap.put("OPERT_GROUP_ID", opertGroupId);
		recovmap.put("USER_ID", loginUserId);
		recovmap.put("OPERT_GROUP_EXECUT_DT", max_excutdt);

		plyManageDAO.updateCanclRecov(recovmap);
	}

	/**
	 * @Method Name : startOfScriptProc
	 * @작성일 : 2012. 5 17.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param line_s
	 * @return
	 * @throws Exception
	 */
	private void startOfScriptProc(StringBuffer line_s) throws Exception {
		ParameterSubstrUtil param = new ParameterSubstrUtil(line_s, "[START OF SCRIPT]"); 
		start_time = param.substrResult();
		start_time = StringUtils.remove(start_time, "[START OF SCRIPT]");
		opert_div = StringUtils.substringBetween(start_time, "][", ",");
		opert_ty_code = StringUtils.substringBetween(start_time, ",", "]");
		start_time = StringUtils.substringBetween(start_time, "[", "]");
		start_time = StringUtils.remove(StringUtils.remove(start_time, "-"), ":");

		 System.out.println("::::::::::start_time::::::::>>>" + start_time);

		Map<String, Object> eMap = new HashMap<String, Object>();

		if (cancl_cnt <= 0) {
			eMap.put("OPERT_GROUP_EXECUT_DT", executdt);
		} else {
			eMap.put("OPERT_GROUP_EXECUT_DT", opertExecutDt);
		}
		eMap.put("START_DT", start_time);
		eMap.put("OPERT_GROUP_ID", opertGroupId);
		eMap.put("UNIT_OPERT_ID", unitOpertId);
		eMap.put("IP_ADRES", ipAdres);
		eMap.put("ACNT_ID", acntId);
		eMap.put("USER_ID", loginUserId);
		eMap.put("PRTCL_CODE", prtclCode);

		plyManageDAO.updateExecutTime(eMap);

		Map<String, Object> drMap = new HashMap<String, Object>();

		drMap.put("EXECUT_DT", start_time);
		drMap.put("OPERT_DIV", opert_div);
		drMap.put("OPERT_TY_CODE", opert_ty_code);
		drMap.put("OPERT_GROUP_ID", opertGroupId);
		drMap.put("UNIT_OPERT_ID", unitOpertId);

		plyManageDAO.updateDsstrRecovOpertExecutTime(drMap);
	}

	/**
	 * @Method Name : endOfScriptProc
	 * @작성일 : 2012. 5 17.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param line_s
	 * @return
	 * @throws Exception
	 */
	private void endOfScriptProc(StringBuffer line_s) throws Exception {
		ParameterSubstrUtil param = new ParameterSubstrUtil(line_s, "[END OF SCRIPT]"); 
		end_time = param.substrResult();
		end_time = StringUtils.remove(end_time, "[END OF SCRIPT]");
		end_time = StringUtils.substringBetween(end_time, "[", "]");
		end_time = StringUtils.remove(StringUtils.remove(end_time, "-"), ":");

		Map<String, Object> tMap = new HashMap<String, Object>();

		if (cancl_cnt <= 0) {
			tMap.put("OPERT_GROUP_EXECUT_DT", executdt);
		} else {
			tMap.put("OPERT_GROUP_EXECUT_DT", opertExecutDt);
		}
		tMap.put("ENDTIME", end_time);
		tMap.put("OPERT_GROUP_ID", opertGroupId);
		tMap.put("UNIT_OPERT_ID", unitOpertId);
		tMap.put("IP_ADRES", ipAdres);
		tMap.put("ACNT_ID", acntId);
		tMap.put("USER_ID", loginUserId);
		tMap.put("PRTCL_CODE", prtclCode);

		plyManageDAO.updateEndTime(tMap);

		// System.out.println("pcommand::::: >>" + pcommand_start);

		if (opert_div != null && opert_ty_code != null) {
			Map<String, Object> RMap = new HashMap<String, Object>();

			RMap.put("END_DT", end_time);
			RMap.put("OPERT_DIV", opert_div);
			RMap.put("OPERT_TY_CODE", opert_ty_code);
			RMap.put("OPERT_GROUP_ID", opertGroupId);
			RMap.put("UNIT_OPERT_ID", unitOpertId);
			RMap.put("TBL_NM", tbl_nm);
			RMap.put("COL_NM", col_nm);
			// System.out.println("::::::DR::::::::::>>");
			plyManageDAO.updateDsstrRecovOpertEndTime(RMap);
		}

		if (pcommand_start == true) {
			Map<String, Object> RMap = new HashMap<String, Object>();

			RMap.put("END_DT", end_time);
			RMap.put("OPERT_DIV", opert_div);
			RMap.put("OPERT_TY_CODE", opert_ty_code);
			RMap.put("OPERT_GROUP_ID", opertGroupId);
			RMap.put("UNIT_OPERT_ID", unitOpertId);
			RMap.put("TBL_NM", tbl_nm);
			RMap.put("COL_NM", col_nm);

			plyManageDAO.updateRecovOpertEndTime(RMap);
		}
	}

	/**
	 * @Method Name : commandErrProc
	 * @작성일 : 2012. 5 17.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param line_s
	 * @return
	 * @throws Exception
	 */
	private void commandErrProc(StringBuffer line_s) throws Exception {
		ParameterSubstrUtil param = new ParameterSubstrUtil(line_s, "[ProcessCommand.ERROR]"); 
		commands = param.substrResult();
		commands = StringUtils.remove(commands, "[ProcessCommand.ERROR]");
		tbl_nm = StringUtils.substringBetween(commands, "[", ",");
		col_nm = StringUtils.substringBetween(commands, ",", "]");
		commands = null;

		Map<String, Object> drMap = new HashMap<String, Object>();

		drMap.put("TBL_NM", tbl_nm);
		drMap.put("COL_NM", col_nm);
		drMap.put("OPERT_DIV", opert_div);
		drMap.put("OPERT_TY_CODE", opert_ty_code);
		drMap.put("OPERT_GROUP_ID", opertGroupId);
		drMap.put("UNIT_OPERT_ID", unitOpertId);

		plyManageDAO.updateRecovOpertErrorAt(drMap);
	}

	/**
	 * @Method Name : commandStartProc
	 * @작성일 : 2012. 5 17.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param line_s
	 * @return save_s
	 * @throws Exception
	 */
	private StringBuffer commandStartProc(StringBuffer line_s) throws Exception {

		StringBuffer save_s = new StringBuffer(); // ProcessCommand 내의 실행결과

		isCommand = true;
		save_s.append(line_s);
		
		pcommand_start = save_s.toString().startsWith("[ProcessCommand.START]");
		ParameterSubstrUtil param = new ParameterSubstrUtil(line_s, "[ProcessCommand.START]"); 
		commands = param.substrResult();
		commands = StringUtils.remove(commands, "[ProcessCommand.START]");
		tbl_nm = StringUtils.substringBetween(commands, "[", ",");
		col_nm = StringUtils.substringBetween(commands, ",", "]");
		commands = StringUtils.substringAfter(commands, "]");
		// String[] tmp = StringUtils.split(commands, ",");

		return save_s;
	}

	/**
	 * @Method Name : commandEndProc
	 * @작성일 : 2012. 5 17.
	 * @작성자 : kim kwang jun
	 * @변경이력 :
	 * @Method 설명 :
	 * @param line_s
	 * @param line_s
	 * @return
	 * @throws Exception
	 */
	private void commandEndProc(StringBuffer line_s, StringBuffer save_s) throws Exception {
		isCommand = false;
		ParameterSubstrUtil param = new ParameterSubstrUtil(line_s, "[ProcessCommand.END]"); 
		commands = param.substrResult();
		commands = StringUtils.remove(commands, "[ProcessCommand.END]");
		// p_end_time = StringUtils.substringBetween(commands, "[", "]");

		// System.out.println("save_s::>>>>"+save_s.toString()+"<<<<:::");

		Map<String, Object> commandMap = new HashMap<String, Object>();

		commandMap.put("EXECUT_DT", start_time);
		commandMap.put("ERROR_CN", save_s.toString());
		commandMap.put("OPERT_DIV", opert_div);
		commandMap.put("OPERT_TY_CODE", opert_ty_code);
		commandMap.put("OPERT_GROUP_ID", opertGroupId);
		commandMap.put("UNIT_OPERT_ID", unitOpertId);
		commandMap.put("TBL_NM", tbl_nm);
		commandMap.put("COL_NM", col_nm);

		// System.out.println("EXECUT_DT check::::::::::::::" +
		// commandMap.get("EXECUT_DT"));
		// System.out.println("ERROR_CN check::::::::::::::" +
		// commandMap.get("ERROR_CN"));
		// System.out.println("OPERT_DIV check::::::::::::::" +
		// commandMap.get("OPERT_DIV"));
		// System.out.println("OPERT_TY_CODE check::::::::::::::" +
		// commandMap.get("OPERT_TY_CODE"));
		// System.out.println("OPERT_GROUP_ID check::::::::::::::" +
		// commandMap.get("OPERT_GROUP_ID"));
		// System.out.println("UNIT_OPERT_ID check::::::::::::::" +
		// commandMap.get("UNIT_OPERT_ID"));

		plyManageDAO.updateRecovOpert(commandMap);
	}

}

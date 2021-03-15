package egovframework.ply.web;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.ply.service.EgovPlyManageService;


@Controller
public class TelnetSample {
	
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private String prompt = "[int.selim.co.kr:/export/home/test01]#";	
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
  
//	/** EgovLoginService */
//	@Resource(name = "TelnetConnect")
//    private TelnetConnect telnetconnect;
	@Resource(name = "egovPlyManageService")
	private EgovPlyManageService egovPlyManageService;

//	/** Message ID Generation */
//	@Resource(name = "egovDeptManageIdGnrService")
//	private EgovIdGnrService egovPlyManageIdGnrService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	Logger log = Logger.getLogger(this.getClass());	
	
//	@RequestMapping("/ply/playSample.do")
	public String TelnetTest()throws Exception{
	
	String opert_group_id = "01";
	String unit_opert_id = "01";
	String ip_adres = "211.234.68.2";
	String acnt_id = "000001";
	String prtcl_knd = "000001";
	String user_id = "login_user";			
	
	//insert
	Map<String, Object> commandMap = new HashMap<String, Object>();
    
	commandMap.put("OPERT_GROUP_ID", opert_group_id);
	commandMap.put("UNIT_OPERT_ID", unit_opert_id);
	commandMap.put("IP_ADRES", ip_adres);
	commandMap.put("ACNT_ID", acnt_id);
	commandMap.put("PRTCL_KND", prtcl_knd);
	commandMap.put("USER_ID", user_id);		
	
	egovPlyManageService.insertPlyManage(commandMap);
	
	return null;
}
//	public static void main(String[] args) {
//		System.out.println("Telnet connect======>ok");
//		try {
//			TelnetConnect telnet = new TelnetConnect("211.234.68.2", "test01",
//					"test01");
//			telnet.sendCommand("ls");
//			// telnet.su( "root-password" );
//			telnet.sendCommand("./test_shell1.sh");
//			telnet.disconnect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}	

	
	

//	public  TelnetSample(String server, String user, String password) {
//		try {
//			
//			// Connect to the specified server
//			telnet.connect(server, 23);
//			
//			// Get input and output stream references
//			in = telnet.getInputStream();
//			out = new PrintStream(telnet.getOutputStream());
//
//			// Log the user on
//			readUntil("login: ");
//			write(user);
//			readUntil("Password: ");
//			write(password);
//
//			// Advance to a prompt
//			readUntil(prompt + " ");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	   	
//	}
//
//	public void su(String password) {
//		try {
//			write("su");
//			readUntil("Password: ");
//			write(password);
////			prompt = '#';
//			readUntil(prompt + " ");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String readUntil(String pattern) throws Exception {
//		try {
//			char lastChar = pattern.charAt(pattern.length() - 1);
//			StringBuffer sb = new StringBuffer();
//			boolean found = false;
//			System.out.println("commnd readUntil===>");
//			char ch = (char) in.read();
//			
//			StringBuffer line_s = new StringBuffer(); // 실행결과를 한 줄씩 저장
//			StringBuffer save_s = new StringBuffer(); // ProcessCommand 내의 실행결과
//			String command = ""; // ProcessCommand.START 구문내의 명령문
//			String timestamp = "";
//			String end_time = "";
//			boolean isCommand = false;
//			
//			String opert_group_id = "01";
//			String unit_opert_id = "01";
//			String ip_adres = "211.234.68.2";
//			String acnt_id = "000001";
//			String prtcl_knd = "000001";
//			String user_id = "login_user";			
//			
//			//insert
//	        Map<String, Object> map = new HashMap<String, Object>();
//	        
//	        map.put("OPERT_GROUP_ID", opert_group_id);
//	        map.put("UNIT_OPERT_ID", unit_opert_id);
//	        map.put("IP_ADRES", ip_adres);
//	        map.put("ACNT_ID", acnt_id);
//	        map.put("PRTCL_KND", prtcl_knd);
//	        map.put("USER_ID", user_id);
//	        
////	        System.out.println("map check::::::::::::::"+map.get("OPERT_GROUP_ID"));
////	        System.out.println("map check::::::::::::::"+map.get("UNIT_OPERT_ID"));
////	        System.out.println("map check::::::::::::::"+map.get("IP_ADRES"));
////	        System.out.println("map check::::::::::::::"+map.get("ACNT_ID"));
////	        System.out.println("map check::::::::::::::"+map.get("PRTCL_KND"));
////	        System.out.println("map check::::::::::::::"+map.get("USER_ID"));
//	        if(egovPlyManageService == null){
//	        	System.out.println("map is null");
//	        }
//	        
//			egovPlyManageService.insertPlyManage(map);
////	        egovPlyManageServiceImpl.insertPlyManage(map);
//	        
//			
//			while (true) {
//				System.out.print(ch);
//				sb.append(ch);
//				
//				line_s.append(String.valueOf(ch));	
//								
//				if (isCommand) {
//					save_s.append(String.valueOf(ch)); 
//				}
//
//				if (String.valueOf(ch).indexOf("\n") >= 0) {
//					
//					if (isCommand) {
//						if (!save_s.toString().startsWith("[ProcessCommand.")) {
//							System.out.println("save_s : >>"+save_s+"<<");
//						}
//					} else {
//						System.out.println(">"+line_s+"<");
//					}
//					
//					if (line_s.toString().startsWith("[ProcessCommand.START]")) {
//						isCommand = true;
//						
//						command = StringUtils.remove(line_s.toString(), "[ProcessCommand.START]");
//						timestamp = StringUtils.substringBetween(command, "[", "]");
//						command = StringUtils.substringAfter(command, "]");
//						String[] tmp = StringUtils.split(command, "&");
//						
//						System.out.println("timestamp : >>"+timestamp);
//						for (int i=0; i < tmp.length; i++) {
//							System.out.println("tmp["+i+"] : >>"+tmp[i]);
//						}
//					}
//					
//					if (line_s.toString().startsWith("[ProcessCommand.END]")) {
//						isCommand = false;
//					}
//					
//					if (line_s.toString().startsWith("[END OF SCRIPT]")) {
//						end_time = StringUtils.remove(line_s.toString(), "[END OF SCRIPT]");
//						end_time = StringUtils.substringBefore("[", "]");
//						//endtime update
//					}
//					//update
//					//System.out.println("line_s : >>"+line_s);
//					line_s.setLength(0); // 한 줄씩 저장하기위한 초기화
//					save_s.setLength(0);
//				}
//
//					
//				if (ch == lastChar) {
//					if (sb.toString().endsWith(pattern)) {
//						return sb.toString();
//					}
//				}
//				ch = (char) in.read();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//
//	public String telnetSmp(String cha) throws Exception {
////		String rtnVal = "EgovPlyManageList";
//		ModelMap model = new ModelMap();
//		model.addAttribute("chaList", cha);
//		System.out.println("11sb======>"+cha+"<========end11");
//		
//		return "redirect:/ply/telnetResult.do";
//	}
//	
//
//	
//	public void write(String value) {
//
//		try {
//			out.println(value);
//			out.flush();
//			System.out.println(value);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String sendCommand(String command) {
//		try {
//			write(command);
//			System.out.println("command==>"+command);
//			return readUntil(prompt + " ");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public void disconnect() {
//		try {
//			telnet.disconnect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
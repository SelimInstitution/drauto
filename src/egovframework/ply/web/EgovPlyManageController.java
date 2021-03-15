package egovframework.ply.web;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.ply.service.EgovPlyManageService;
import egovframework.ply.service.impl.EgovPlyManageServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Controller
public class EgovPlyManageController {

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

//	@Resource(name = "egovPlyManageService")
//	public EgovPlyManageService egovPlyManageService;
//
//	/** Message ID Generation */
//	@Resource(name = "egovDeptManageIdGnrService")
//	private EgovIdGnrService egovPlyManageIdGnrService;
//
//	@Autowired
//	private DefaultBeanValidator beanValidator;

	Logger log = Logger.getLogger(this.getClass());
//	private static char prompt = '$';
//	TelnetClient client = null;
	
	private static TelnetClient telnet = new TelnetClient();
	private static InputStream in;
	private static PrintStream out;
	private static String prompt = "[int.selim.co.kr:/export/home/test01]#";	
	


	/**
	 * 텔넷을 통한 서버 접속
	 * 
	 * @return String
	 * @exception Exception
	 */
//	@RequestMapping("/ply/playSample.do")
//		public static void main(String[] args) {
//		System.out.println("Telnet connect======>ok");
//		try {
//			TelnetConnect telnet = new TelnetConnect("211.234.68.2", "test01",
//					"test01");
////			telnet.TelnetConnect("211.234.68.2", "test01", "test01");
//			telnet.sendCommand("ls");
//			// telnet.su( "root-password" );
//			telnet.sendCommand("./test_shell1.sh");
//			telnet.disconnect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public String TelnetTest()throws Exception{
//		
//		String opert_group_id = "01";
//		String unit_opert_id = "01";
//		String ip_adres = "211.234.68.2";
//		String acnt_id = "000001";
//		String prtcl_knd = "000001";
//		String user_id = "login_user";			
//		
//		//insert
//		Map<String, Object> commandMap = new HashMap<String, Object>();
//        
//		commandMap.put("OPERT_GROUP_ID", opert_group_id);
//		commandMap.put("UNIT_OPERT_ID", unit_opert_id);
//		commandMap.put("IP_ADRES", ip_adres);
//		commandMap.put("ACNT_ID", acnt_id);
//		commandMap.put("PRTCL_KND", prtcl_knd);
//		commandMap.put("USER_ID", user_id);		
//		
//		egovPlyManageService.insertPlyManage(commandMap);
//		
//		return null;
//	}
	
//	public static void TelnetConnect(String server, String user, String password) {
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
//
//	public static String readUntil(String pattern)throws Exception {
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
//			Map<String, Object> commandMap = new HashMap<String, Object>();
//	        
//			commandMap.put("OPERT_GROUP_ID", opert_group_id);
//			commandMap.put("UNIT_OPERT_ID", unit_opert_id);
//			commandMap.put("IP_ADRES", ip_adres);
//			commandMap.put("ACNT_ID", acnt_id);
//			commandMap.put("PRTCL_KND", prtcl_knd);
//			commandMap.put("USER_ID", user_id);
//	        
//	        System.out.println("map check::::::::::::::"+commandMap.get("OPERT_GROUP_ID"));
//	        System.out.println("map check::::::::::::::"+commandMap.get("UNIT_OPERT_ID"));
//	        System.out.println("map check::::::::::::::"+commandMap.get("IP_ADRES"));
//	        System.out.println("map check::::::::::::::"+commandMap.get("ACNT_ID"));
//	        System.out.println("map check::::::::::::::"+commandMap.get("PRTCL_KND"));
//	        System.out.println("map check::::::::::::::"+commandMap.get("USER_ID"));
////	        if(egovPlyManageService == null){
////	        	System.out.println("map is null==>");
////	        }
//	        
////	        egovPlyManageService.insertPlyManage(commandMap);
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
//	
//	public static void write(String value) {
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
//	public static String sendCommand(String command) {
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
//	public static void disconnect() {
//		try {
//			telnet.disconnect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}	
	
//	public static void main(String[] args) throws Exception {
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
	
////	@RequestMapping("/ply/playSample.do")
//	public static void Telnetmain(String[] args) {
////		System.out.println(":::::::playSample.do::::::::");
//
//		String SERVER_IP = "211.234.68.2"; // 텔넷 접속 서버 ip
//		int SERVER_PORT = 23; // 텔넷 접속 서버 포트
//		String ID = "test01"; // 아이디
//		String PASSWORD = "test01"; // 패스워드
//		String CMD_CD = "cd /export/home/test01/"; // 디렉토리 변경
//		String CMD_FIND = "./testshll.sh"; // FIND로 파일 찾기
//
//		String SUFFIX_LOGIN = "login:"; // 아이디 입력 표시
//		String SUFFIX_PASSWORD = "Password:"; // 패스워드 입력 표시
//		String SUFFIX_OK = prompt + " "; // 정상 로그인 후
//		String SUFFIX_CD = prompt + " "; // 디렉토리
//																			// 변경
//																			// 명령
//																			// 후
//		String SUFFIX_FIND = prompt + " "; // FIND로
//																			// 파일
//																			// 찾기
//																			// 명령
//																			// 후
//
////		 String SUFFIX_OK = ""; // 정상 로그인 후
////		 String SUFFIX_CD = ""; // 디렉토리 변경 명령 후
////		 String SUFFIX_FIND = ""; // FIND로 파일 찾기 명령 후
//
//		TelnetClient client = null;
//		PrintStream out = null;
//		InputStream in = null;
//		String result = null;
//		String[] list = null;
//		
//
//		try {
//			client = new TelnetClient();
//
//			client.connect(SERVER_IP, SERVER_PORT);
//
//			// 타임아웃 설정 : 1000초
//			client.setSoTimeout(1000000);
//
//			in = client.getInputStream();
//			out = new PrintStream(client.getOutputStream());
//
//			// 아이디 입력 대기
//			result = cmd(in, out, null, SUFFIX_LOGIN);
//
//			// 아이디 입력
//			result = cmd(in, out, ID, SUFFIX_PASSWORD);
//
//			// 패스워드 입력
//			result = cmd(in, out, PASSWORD, SUFFIX_OK);
//
//			// 디렉토리 변경 명령
//			result = cmd(in, out, CMD_CD, SUFFIX_CD);
//
//			// 파일 찾기 명령
//			result = cmd(in, out, CMD_FIND, SUFFIX_FIND);
//
//			list = result.split("\n");
//			
//			for (int i = 0; i < list.length; i++) {
//				list[i] = list[i].trim();
//				System.out.println("[" + i + "]=[" + list[i] + "]");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			if (out != null) {
//				try {
//					out.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			if (client != null) {
//				try {
//					// client.disconnect();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public static String cmd(InputStream in, PrintStream out, String msg,
//			String suffix) throws IOException {
//		byte[] b = new byte[5000];
//		int cnt = 0;
//		int off = 0;
//		int len = b.length;
//		String line = null;
//
////		TelnetOptionHandler to = null;
////		ProtocolCommandEvent pc = null;
//
//		
//		PrintCommandListener PrintCommandListener;
//		
//		
//		int d = TelnetCommand.DO;
//////		System.out.println(":::::상태값 확인1:::>>>" + PrintCommandListener.protocolReplyReceived(""));
//
//////		System.out.println(":::in:::" + in);
//////		System.out.println(":::out:::" + out);
//////		System.out.println(":::suffix:::" + suffix);
//
//		if (msg != null) {
//			out.println(msg);
//			out.flush();
////	//		System.out.println(":::message:::" + msg);
//		}
//
//		while ((cnt = in.read(b, off, len)) != -1) {
//			line = new String(b, 0, off + cnt);
////			 System.out.println("[" + line + "]");
//
//			if (line.trim().endsWith(suffix)) {
//		//		System.out.println(":::::결과값 확인:::>>>" + line);
//				Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());		
//		//		System.out.println(":::::시간::>>>"+currentTimestamp);	
//				break;
//			}
//
//			off = off + cnt;
//			len = len - cnt;
//		}
//
//		if (line != null) {
//			line = line.substring(0, line.length() - suffix.length() - 1)
//					.trim();
//		}
//
//		return line;
//	}	
	
//	  public static void main(String[] args){
//		System.out.println("telnet test::::::::::::::::::::::::::::");
//	    TelnetWrapper telnet = new TelnetWrapper();
//	    try {
//	      /**
//	       * connect(IP, port)
//	       */
//	      telnet.connect("211.234.68.2", 23);
//	      
//	      /**
//	       * login 메소드 확인사항
//	       * Telnet 로그인 커멘드 확인 필요 (crt 등 telnet 툴 확인)
//	       * 예) 로그인 커멘드   - login:
//	       *     패스워드 커멘드 - Password:
//	       * 경우에 따라 패스워드 커멘드 다를 수 있음 (예:Jeus's Password:)
//	       * 
//	       * 로그인, 패스워드 커맨드 설정. 
//	       * 120~123 라인 확인 후 수정
//	       * 
//	       * login(telnet_user, telnet_password)
//	       */
//	      telnet.login("test01", "test01");
//	      
//	      /**
//	       * waitfor 내의 String 문자열은 Telnet 접속 성공시의 커멘드 상태이다.
//	       */
//	      telnet.waitfor("[int.selim.co.kr:/export/home/test01]#");
//	      
//	      /**
//	       * send 함수는 접속한 Telnet 서버에 전송할 명령어이다. 
//	       * 여기서는 데몬 프로세스 갯수를 얻기 위한 커멘드를 사용하였다.
//	       */
//	      telnet.send("mv test1 test1");
//	      telnet.waitfor("[int.selim.co.kr:/export/home/test01]#");
//	      
//	      /**
//	       * 조회한 데몬 프로세스의 갯수는 process_cnt의 getter를 통해 
//	       * 얻을 수있다.
//	       * 실제 프로세스 갯수는 process_cnt - 1 을 하면 얻을 수 있다.
//	       */
//	      
//     
//	      
//		System.out.println("조회 테스트 : " +telnet.getPrompt());
//	      
//	      
//	      //telnet.disconnect();
//	    } catch (java.io.IOException e) {
//	      e.printStackTrace();
//	    } finally{
//	      try {
//	        telnet.disconnect();
//	      } catch (IOException e) {
//	        e.printStackTrace();
//	      }
//	    }
//	  }	


	
//	/**
//	 * SSH를 통한 서버 접속
//	 * 
//	 * @return String
//	 * @exception Exception
//	 */
//	@RequestMapping("/ply/playSshSample.do")
//	public static void sshmain(String args[]) {
//		System.out
//				.println(":::::::::::::/ply/playSshSample.do:::::::::::::::::");
//		try {
//			ConfigurationLoader.initialize(false);
//			String hostname = "211.234.68.2";
//			String cmd = "rm -rf test4\n";
//			SshClient ssh = new SshClient();
//			ssh.setSocketTimeout(30000);
//			SshConnectionProperties properties = new SshConnectionProperties();
//			properties.setHost(hostname);
//			properties.setPort(22);
//			properties.setPrefPublicKey("ssh-dss");
//			// Connect to the host
//			ssh.connect(properties,
//					new AlwaysAllowingConsoleKnownHostsKeyVerification());
//			// Create a password authentication instance
//			PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
//			// Get the users name
//			// System.out.print("Username? ");
//			// Read the password
//			String username = "test01";
//			pwd.setUsername(username);
//			// Get the password
//			// System.out.print("Password? ");
//			String password = "test01";
//			pwd.setPassword(password);
//
//			// Try the authentication
//			int result = ssh.authenticate(pwd);
//
//			if (result == AuthenticationProtocolState.FAILED)
//				System.out.println("The authentication failed");
//
//			if (result == AuthenticationProtocolState.PARTIAL)
//				System.out.println("The authentication succeeded but another"
//						+ "authentication is required");
//			EgovPlyManageController pc = new EgovPlyManageController();
//			// Evaluate the result
//			if (result == AuthenticationProtocolState.COMPLETE) {
//
//				// The connection is authenticated we can now do some real work!
//				SessionChannelClient session = ssh.openSessionChannel();
//
//				if (session.startShell()) {
//					// System.out.println("Executing session.executeCommand(cd /etc/):"+session.executeCommand("cd /etc/"+"\n"));
//					String str = pc.execute_command(cmd, session);
//					System.out.println("Executed !!!!!!!!!!!!!!!!" + str);
//					// session.getState().waitForState(ChannelState.CHANNEL_CLOSED);
//					System.out.println("Waiting !!!!!!!!!!!!!!!!");
//				} else
//					System.out.println("Failed to start the users shell");
//				ssh.disconnect();
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static InputStream fromString(String str) {
//		byte[] bytes = str.getBytes();
//		return new ByteArrayInputStream(bytes);
//	}
//
//	public String execute_command(String command, SessionChannelClient session) {
//
//		String return_value = "";
//		boolean prompt_returned = false;
//
//		try {
//
//			String response = "";
//			return_value = "Executing command : " + command;
//			System.out.println(return_value);
//			/** Writing to the session OutputStream */
//			OutputStream out = session.getOutputStream();
//			// System.out.println("Executing session.executeCommand(cd /etc/):"+session.executeCommand("cd /etc/"));
//			out.write(command.getBytes());
//
//			/**
//			 * Reading from the session InputStream
//			 */
//			InputStream in = session.getInputStream();
//			byte buffer[] = new byte[1040];
//			String temp = null;
//			int read;
//			int i = 0;
//			return_value += " : Response=";
//			while (prompt_returned == false && (read = in.read(buffer)) > 0) {
//				System.out.println("prompt_returned=" + prompt_returned
//						+ " / read=" + read);
//
//				prompt_returned = false;
//				response = new String(buffer, 0, read);
//				return_value += response.toString();
//				temp = temp + response;
//				// System.out.println("temp"+temp);
//				++i;
//				if ((response.indexOf("[root@adaranet ~]#") >= 0) || i >= 2)
//					prompt_returned = true;
//
//			}
//			return return_value;
//
//		} catch (Exception e) {
//			return_value = return_value + "   " + e.getStackTrace();
//			return return_value;
//
//		}
//	}

	// public String gethostprompt() {
	// return this.hostprompt;
	// }
	//
	// public void sethostprompt(String input_value) {
	// this.hostprompt = input_value;
	// }

}

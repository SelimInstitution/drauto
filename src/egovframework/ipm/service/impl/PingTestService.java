package egovframework.ipm.service.impl;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PingTestService {
	@Resource(name="ipManageDAO")
    private IPManageDAO ipManageDAO;
	
	@Async
	public void pingTest() {
		Boolean pingChk;
		String alive = "";
		String ipAdres = "";
		List ip_list = ipManageDAO.selectPingIpAdress();
		
		try {
			for (int i = 0; i < ip_list.size(); i++) {
				Map map = (Map) ip_list.get(i);

				ipAdres = (String) map.get("IP_ADRES");

				InetAddress pingcheck = InetAddress.getByName(ipAdres);
				pingChk = pingcheck.isReachable(3000);

				if (pingChk.equals(true)) {
					alive = "Y";
				} else {
					alive = "N";
				}

				Map<String, Object> mmap = new HashMap<String, Object>();

				mmap.put("ALIVE", alive);
				mmap.put("IP_ADRES", ipAdres);

				ipManageDAO.updateAlive(mmap);
//				System.out.println("pingCheck :: >>" + "ipAdress :: >>" + ipAdres
//						+ "check ::>" + pingChk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
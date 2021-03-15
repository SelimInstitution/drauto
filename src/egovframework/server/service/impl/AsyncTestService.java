package egovframework.server.service.impl;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTestService {

	@Resource(name="serverManageDAO")
    private ServerManageDAO serverManageDAO;

	@Async
	public void asyncTest() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("1111111111111111111111111111111111111111111111111");
		System.out.println("2222222222222222222222222222222222222222222222222");
		System.out.println("3333333333333333333333333333333333333333333333333");
		System.out.println("4444444444444444444444444444444444444444444444444");
		System.out.println("5555555555555555555555555555555555555555555555555");
		System.out.println("6666666666666666666666666666666666666666666666666");
		System.out.println("7777777777777777777777777777777777777777777777777");
		System.out.println("8888888888888888888888888888888888888888888888888");
		System.out.println("9999999999999999999999999999999999999999999999999");
		System.out.println("0000000000000000000000000000000000000000000000000");
		

	}
	


}

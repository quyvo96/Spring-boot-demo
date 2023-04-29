package com.example.demo02.service.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SleepServiceTest extends Thread{
	@Autowired
	SleepService someClass;

	@Test
	public void testRun() throws Exception {
//		SleepService a = new SleepService();
//		//
//		a.run();
//		a.interrupt();
		someClass.start();
		someClass.interrupt();
		someClass.delete();
		//someClass.name();
	}

}

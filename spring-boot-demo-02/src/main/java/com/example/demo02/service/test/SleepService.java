package com.example.demo02.service.test;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SleepService  extends Thread{
	
	public void run() {
		sleep();
	}
	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			new RuntimeException("12312");
		}
	}
	
	public void delete() {
		System.out.println("123");
	}

}

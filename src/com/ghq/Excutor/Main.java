package com.ghq.Excutor;
/**
 * CountDownLatch
 * http://www.importnew.com/15731.html
 * @author Lenovo
 *
 */
public class Main {
	public static void main(String[] args) {
		boolean result = false;
		try {
			result = ApplicationStartupUtil.checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: " + result);
	}
}

package test;

import java.util.HashMap;
import java.util.Map;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("runnable-run");
//		throw new RuntimeException("run~~~~~~~~~");
	}
}

public class Demo {
	public static void main(String[] args) {
		new Thread(new MyRunnable()).start();
		System.out.println("main");
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "hello");
		map.put(2, "world");
		for (Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		System.out.println("-------------------");
		System.out.println(map);
	}
}

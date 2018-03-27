package test;

class MyThread implements Runnable {
	private int count = 5;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + count--);
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		new Thread(myThread, "test").start();
		new Thread(myThread, "or").start();
	}
}

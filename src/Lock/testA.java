package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 要注意顺序 await和signal，先唤醒在等待，否则会打印一次即完成
 * 原因为执行到await线程即停止
 * @author Lenovo
 *
 */
public class testA {
	ReentrantLock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();

	class A extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("A");
					b.signal();
					a.await();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	class B extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("B");
					a.signal();
					b.await();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		testA test = new testA();
		test.new A().start();
		test.new B().start();
		
	}
	
}
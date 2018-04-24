package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ABAB {
	static ReentrantLock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();

	class A implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("A");
					condition2.signalAll();
					condition1.await();
				} catch (Exception e) {

				} finally {
					lock.unlock();
				}
			}
		}
	}

	class B implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("B");
					condition1.signalAll();
					condition2.await();
				} catch (Exception e) {

				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		ABAB test = new ABAB();
		new Thread(test.new A()).start();
		new Thread(test.new B()).start();
	}
}

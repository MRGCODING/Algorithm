package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Synchronized与ReentrantLock

ReentrantLock与synchronized关键字一样，属于互斥锁，synchronized中的锁是非公平的
（公平锁是指多个线程等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁），
ReentrantLock默认情况下也是非公平的，但可以通过带布尔值的构造函数要求使用公平锁。线程通过ReentrantLock的lock()方法获得锁，用unlock()方法释放锁。

ReentrantLock和synchronized关键字的区别

    ReentrantLock在等待锁时可以使用lockInterruptibly()方法选择中断， 改为处理其他事情，而synchronized关键字，线程需要一直等待下去。
            同样的，tryLock()方法可以设置超时时间，用于在超时时间内一直获取不到锁时进行中断。
    ReentrantLock可以实现公平锁，而synchronized的锁是非公平的。
    ReentrantLock拥有方便的方法用于获取正在等待锁的线程。
    ReentrantLock可以同时绑定多个Condition对象，而synchronized中，
            锁对象的wait()和notify()或notifyAll()方法可以实现一个隐含的条件，如果要和多于一个条件关联时，只能再加一个额外的锁，
            而ReentrantLock只需要多次调用newCondition方法即可。

性能比较
在JDK1.6之前，ReentrantLock的性能要明显优于synchronized，但是JDK1.6中加入了很多针对锁的优化措施，synchronized和ReentrantLock的性能基本完全持平了。

ReentrantLock缺点
ReentrantLock的主要缺点是方法需要置于try-finally块中，另外，开发人员需要负责获取和释放锁，而开发人员常常忘记在finally中释放锁。
 * @author Lenovo
 *
 */
public class ABABReentrantLock {
	private ReentrantLock lock = new ReentrantLock();
	Condition aCondition = lock.newCondition();
	Condition bCondition = lock.newCondition();

	public static void main(String[] args) {
		ABABReentrantLock test = new ABABReentrantLock();

		test.new AOutput().start();
		test.new BOutput().start();
	}

	class AOutput extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("A");

					bCondition.signal();
					aCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	class BOutput extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					System.out.println("B");
					aCondition.signal();
					bCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}
}

package Pattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

class Producer implements Runnable {
	private BlockingQueue que;

	public Producer(BlockingQueue que) {
		this.que = que;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "get " + que.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue que;

	public Consumer(BlockingQueue que) {
		this.que = que;
	}

	private static AtomicLong id = new AtomicLong(0);

	@Override
	public void run() {
		try {
			while (true) {
				que.put(id.getAndIncrement());
				System.out.println(Thread.currentThread().getName() + "put " + id);
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Producer_Consumer {

}

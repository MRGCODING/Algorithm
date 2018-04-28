package concurrent.model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random r = new Random();
		try {
			PCData data = queue.take();
			if (null != data) {
				int res = data.getIntData() * data.getIntData();
				System.err.println(res + "," + data.getIntData());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();

		}
	}

}

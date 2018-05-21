package Lock;

public class ABABSynchronized {
	public static void main(String[] args) {
		ABABSynchronized test = new ABABSynchronized();

		Object lock = new Object();

		test.new Output(lock, "A").start();
		test.new Output(lock, "B").start();
		test.new Output(lock, "C").start();
	}

	class Output extends Thread {
		private Object lock;
		private String value;

		public Output(Object lock, String value) {
			this.lock = lock;
			this.value = value;
		}

		@Override
		public void run() {
			synchronized (lock) {
				while (true) {
					try {
						System.out.println(value);
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

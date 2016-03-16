package demo.java.util.BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tester {

	public static void main(String[] args) {

		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
		for (int i = 0; i < 1; i++) {
			new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(2000);
							System.out.println(Thread.currentThread().getName()
									+ "׼��������!");
							queue.put(1);
							Thread.sleep(1000);
							System.out.println(Thread.currentThread().getName()
									+ "�Ѿ��������ݣ�" + "����Ŀǰ��" + queue.size()
									+ "������");
							System.out.println("++++++++++++");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}

			}.start();
		}

		new Thread() {
			public void run() {
				while (true) {
					try {
						// ���˴���˯��ʱ��ֱ��Ϊ100��1000���۲����н��
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName()
								+ "׼��ȡ����!");
						System.out.println(".............");
						queue.take();
						System.out.println(Thread.currentThread().getName()
								+ "�Ѿ�ȡ�����ݣ�" + "����Ŀǰ��" + queue.size() + "������");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();

	}
}

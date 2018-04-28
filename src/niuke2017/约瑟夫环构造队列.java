package niuke2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * https://blog.csdn.net/tingyun_say/article/details/52344785
 * 
 * https://blog.csdn.net/yanweibujian/article/details/50876631
 * @author Lenovo
 *
 */
public class 约瑟夫环构造队列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num != 0) {
			int n = sc.nextInt();
			Queue<Integer> ori = new LinkedList<Integer>();
			Queue<Integer> temp = new LinkedList<Integer>();
			int[] tempArray = new int[n];
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				ori.add(i + 1);
			}
			while (!ori.isEmpty()) {
				int x = ori.poll();
				ori.add(x);
				temp.add(ori.poll());
			}
			for (int i = 0; i < n; i++) {
				tempArray[i] = temp.poll();
			}
			for (int i = 0; i < n; i++) {
				res[tempArray[i] - 1] = i + 1;
			}
			for (int i = 0; i < n; i++) {
				System.out.print(res[i]);
				if (i < n - 1)
					System.out.print(" ");
			}
			System.out.println();
			num--;
		}
	}
}

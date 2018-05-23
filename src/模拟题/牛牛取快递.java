package 模拟题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 牛牛取快递
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();
		int[] u = new int[m];
		int[] v = new int[m];
		int[] d = new int[m];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
		for (int i = 0; i < m; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			d[i] = sc.nextInt();
			temp.put(u[i], v[i]);
			if(temp.get(u[i]) == v[i]){
			if(map.containsKey(u[i])){
				if(map.get(u[i]) > d[i]){
					map.put(u[i], d[i]);
				}					
				else{
					continue;
				}
			}else{
				map.put(u[i], d[i]);
			}
		}
			}
		int res = 0;
		for (int i = 0; i < m; i++) {
			res += d[i];
		}
		System.out.println(res);
	}
}
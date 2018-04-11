package niuke2017;

import java.math.BigDecimal;
import java.util.Scanner;

public class moweilingdegeshu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			BigDecimal res = new BigDecimal(1);
			BigDecimal temp;
			int count = 0;
			for(int i = num;i > 0;i--){
				temp = new BigDecimal(i);
				res = res.multiply(temp);
			}
			String str = String.valueOf(res);
			for(int i = str.length() - 1;i>=0;i--){
				if(str.charAt(i)=='0'){
					count++;
				}else{
					break;
				}
			}
			System.out.println(count);
		}
	}
}

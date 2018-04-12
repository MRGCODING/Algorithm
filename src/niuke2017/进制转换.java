package niuke2017;

import java.util.Scanner;

public class 进制转换 {
	static String getNum(int num, int systemCheck) {
		String res = "";
		char[] sixten = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
		boolean flag = false;
		if(num < 0){
			num = - num;
			flag = true;
		}
		while (num % systemCheck != 0) {
			if (systemCheck > 9 && num % systemCheck >=10) {
				res = sixten[num % systemCheck - 10] + res;
			} else {
				res = num % systemCheck + res;
			}
			num /= systemCheck;
		}
		if(flag){
			return "-" + res;
		}else{
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			int systemCheck = sc.nextInt();
			String res = getNum(num, systemCheck);
			System.out.println(res);
		}

	}
}

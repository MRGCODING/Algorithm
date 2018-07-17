package 牛客网考试;

public class 快乐数字数学方法 {
	public boolean isHappy(int number) {
		if(number < 1 || number == 89)
			return false;
		while (number != 1) {
			int res = helper(number);
			if (res == 1)
				return true;
			if (res == 89)
				return false;
			number = res;
		}
		return true;
	}

	private int helper(int number) {
		int res = 0;
		while (number > 0) {
			res += (number % 10) * (number % 10);
			number /= 10;
		}
		return res;
	}
}

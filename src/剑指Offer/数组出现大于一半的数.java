package 剑指Offer;

public class 数组出现大于一半的数 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array.length <= 0)
			return 0;
		int res = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				res = array[i];
				times = 1;
			} else if (array[i] == res)
				times++;
			else
				times--;
		}
		times = 0;
		for (int i = 0; i < array.length; i++)
			if (res == array[i])
				times++;
		if (times * 2 > array.length)
			return res;
		else
			return 0;
	}
}

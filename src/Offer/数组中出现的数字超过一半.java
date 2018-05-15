package Offer;

public class 数组中出现的数字超过一半 {
	public static int MoreThanHalfNum_Solution(int[] array) {
		int res = 0;
		int k = array[0];
		for (int i = 0; i < array.length; i++) {
			if (res == 0) {
				k = array[i];
				res = 1;
			}
			if (array[i] == k)
				res++;
			else
				res--;
		}
		res = 0;
		for (int i = 0; i < array.length; i++) {
			if(k == array[i])
				res++;
			if(res * 2 > array.length)
				return res;
			else
				return 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		int moreThanHalfNum_Solution = MoreThanHalfNum_Solution(array);
		System.out.println(moreThanHalfNum_Solution);
	}
}

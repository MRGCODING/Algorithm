package Offer;

public class 累乘 {
	// 直接来
	public double Power(double base, int exponent) {
		double res = 1.0;
		for (int i = 0; i < Math.abs(exponent); i++) {
			res *= base;
		}
		if (exponent < 0)
			return 1 / res;
		else
			return res;
	}

	// 递归
	public double Power1(double base, int exponent) {
		double res = 1.0;
		int n = Math.abs(exponent);
		if (n == 1.0)
			return base;
		if (n == 0)
			return 1.0;
		res = Power(base, n >> 1);
		res *= res;
		if ((n & 1) == 1)
			res *= base;
		if (exponent < 0)
			return 1 / res;
		else
			return res;
	}
}

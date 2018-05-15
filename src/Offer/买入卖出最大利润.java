package Offer;

public class 买入卖出最大利润 {
	/**
	 * 计算你能获得的最大收益
	 * 
	 * @param prices
	 *            Prices[i]即第i天的股价
	 * @return 整型
	 */
	public int calculateMax(int[] prices) {
		int res = 0;
		int min = prices[0];
		int max = prices[1] - min;
		for (int i = 2; i < prices.length; i++) {
			if (min > prices[i - 1])
				min = prices[i - 1];
			if (prices[i] - min > max)
				max = prices[i] - min;
		}
		return max;
	}
}

package 剑指Offer;

public class 数组最大和之升级版 {
	// 股市买入卖出
	public int calculateMax(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			int temp = helper(prices, 0, i) + helper(prices, i + 1, prices.length - 1);
			res = Math.max(res, temp);
		}
		return res;
	}

	private int helper(int[] prices, int left, int right) {
		if (left >= prices.length)
			return 0;
		int res = 0, min = prices[left];
		for (int i = left + 1; i <= right; i++) {
			min = Math.min(prices[i], min);
			res = Math.max(res, prices[i] - min);
		}
		return res;
	}
}

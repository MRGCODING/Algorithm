package com.ghq.core;

import java.util.ArrayList;
import java.util.List;

public class MarkovTest {
	private static List<List<Integer>> rawData;
	public static List<Object> markovChain(List<List<Integer>> rawData) {
		// 存放统计数据
		List<Object> theStatisticsArray = new ArrayList<Object>();
		// 存放概率P
		List<Object> theProbabilityArray = new ArrayList<Object>();

		int len = rawData.size() - 1;
		int times = 1;
		double sum = 0;
		double p = 0;
		if (len == 0 || len == -1) {
			theStatisticsArray.add("数据量不够，请导入足够数据！");
			return theStatisticsArray;
		} else {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < rawData.get(i).size(); j++) {
					boolean status = true;
					if (theStatisticsArray.size() == 0) {
						theStatisticsArray.add(rawData.get(i).get(j));
						theStatisticsArray.add(rawData.get(i + 1).get(j));
						theStatisticsArray.add(times);
					} else {
						for (int k = 0; k < theStatisticsArray.size(); k += 3) {
							if (rawData.get(i).get(j).equals(theStatisticsArray.get(k))) {
								if (rawData.get(i + 1).get(j).equals(theStatisticsArray.get(k + 1))) {
									theStatisticsArray.set(k + 2, (Integer) theStatisticsArray.get(k + 2) + 1);
									status = false;
								}
							}
						}
						if (status) {
							theStatisticsArray.add(rawData.get(i).get(j));
							theStatisticsArray.add(rawData.get(i + 1).get(j));
							theStatisticsArray.add(times);
						}
					}
				}
			}
		}

		for (int i = 0; i < theStatisticsArray.size(); i += 3) {
			sum = sum + (Integer) theStatisticsArray.get(i + 2);
		}
		for (int i = 0; i < theStatisticsArray.size(); i += 3) {
			p = (Integer) theStatisticsArray.get(i + 2) / sum;
			for (int j = i; j < i + 3; j++) {
				if (j == i + 2)
					continue;
				theProbabilityArray.add(theStatisticsArray.get(j));
			}
			theProbabilityArray.add(p);
		}
		return theProbabilityArray;
	}
	public static void main(String[] args) {
		rawData = new ArrayList<List<Integer>>();
		ArrayList<Integer> test1 = new ArrayList<>();
		ArrayList<Integer> test2 = new ArrayList<>();
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(1);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);
		test1.add(0);

		test2.add(0);
		test2.add(1);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(1);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		test2.add(0);
		System.out.println(test1);
		rawData.add(test1);
		rawData.add(test2);
		List<Object> res = markovChain(rawData);
		System.out.println(res);
	}
}

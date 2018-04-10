package com.ghq.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import com.ghq.pojo.Machine;

public class IO {
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			Machine machine = new Machine();
			HashMap<String, Integer> hm = new HashMap();
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				String[] split = s.split("\\s{1,}");

				// containsKey(c),当c不存在于hm中
				if (!hm.containsKey(split[1])) {
					hm.put(split[1], 1);
				} else {
					// 否则获得c的值并且加1
					hm.put(split[1], hm.get(split[1]) + 1);
				}

				result.append(System.lineSeparator() + split[1] + split[2]);
			}

			// 从map中取出封装到数据结构
			for (String in : hm.keySet()) {
				// map.keySet()返回的是所有key的值
				int str = hm.get(in);// 得到每个key多对用value的值
				System.out.println(in + "     " + str);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void main(String[] args) {
		File file = new File("config/data_2015_1.txt");
		System.out.print(txt2String(file));
	}
}

package concurrent.model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) {
		try {
			// 创建输出流
			FileOutputStream fos = new FileOutputStream("D:/test.txt");
			OutputStreamWriter os = new OutputStreamWriter(fos);
			BufferedWriter bos = new BufferedWriter(os);

			// 写入数组数据
			char[] buf = new char[3];
			buf[0] = 'a';
			buf[1] = 'b';
			buf[2] = '中';
			bos.write(buf);

			// 关闭输出流
			bos.close();
			os.close();
			fos.close();
		} catch (IOException e) {
		}
	}
}
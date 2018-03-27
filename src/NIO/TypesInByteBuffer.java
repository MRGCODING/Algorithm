package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TypesInByteBuffer {

	private static FileInputStream fin;
	private static FileOutputStream fout;

	public static void main(String[] args) throws Exception {
		String infile = "c://test/nio_copy.txt";
		String outfile = "c://test/result.txt";

		fin = new FileInputStream(infile);
		fout = new FileOutputStream(outfile);
		// 获取读的通道
		FileChannel fcin = fin.getChannel();
		// 获取写的通道
		FileChannel fcout = fout.getChannel();
		// 定义缓冲区，并指定大小
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 利用缓冲区进行NIO，替代之前的IO
		while (true) {
			// 清空缓冲区，即初始化为缓冲区未使用的状态，由于之前缓冲区数据写入通道后未清空，现在准备读操作，此时limit = capacity,position = 0
			buffer.clear();
			// 从通道读取一个数据到缓冲区
			int r = fcin.read(buffer);
			// 判断是否有从通道读到数据
			if (r == -1) {
				break;
			}
			// 缓冲区读取完成，清空缓冲区进行写入
			// 将buffer指针指向头部，此时limit = position,position = 0
			buffer.flip();
			// 把缓冲区数据写入通道
			fcout.write(buffer);
		}
		System.out.println("Done");
	}

}

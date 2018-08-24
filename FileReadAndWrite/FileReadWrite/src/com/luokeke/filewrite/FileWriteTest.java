package com.luokeke.filewrite;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriteTest {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("E:/cc.log", true);//true表示追加
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("我不知道你是谁4");
		bw.newLine();//换行
		bw.flush();
		bw.close();
		fw.close();
	}
}

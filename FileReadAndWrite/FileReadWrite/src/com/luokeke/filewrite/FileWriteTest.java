package com.luokeke.filewrite;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriteTest {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("E:/cc.log", true);//true��ʾ׷��
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("�Ҳ�֪������˭4");
		bw.newLine();//����
		bw.flush();
		bw.close();
		fw.close();
	}
}

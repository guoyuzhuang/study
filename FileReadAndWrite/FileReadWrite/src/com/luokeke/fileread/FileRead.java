package com.luokeke.fileread;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileRead {

	public static void main(String[] args) throws Exception {
		//����һ���ļ�Ŀ¼
		FileInputStream fi = new FileInputStream("track.log");
		InputStreamReader is = new InputStreamReader(fi, "UTF-8");
		BufferedReader br = new BufferedReader(is);
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("�ļ���ȡ����");
	}
}

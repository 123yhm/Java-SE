package com.hp.MyFile;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
	public static void main(String[] args) {
		String str01="F:\\c1604";
		File file=new File(str01);
		String str02="\\������.txt";
		File file1=new File(file,str02);
		String str="������_01.txt";
		try {
			boolean bn=file.mkdirs();
			System.out.println(bn);
			
			boolean b= file1.createNewFile();
			System.out.println(b);
		
			String str1=file1.getAbsolutePath();
			String str2=file1.getName();
			String str3=str1.substring(0,str1.indexOf(str2));
			File file4=new File(str3+str);
			file1.renameTo(file4);
			System.out.println(file1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

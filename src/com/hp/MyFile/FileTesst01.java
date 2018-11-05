package com.hp.MyFile;

import java.io.File;
import java.io.IOException;

public class FileTesst01 {
	public static void main(String[] args) {
			File file1=new File("C:\\1604yhm.txt");
			File file2=new File("C:\\1604c\\�ڶ���\\������");
			File file3=new File(file2,"\\Test.java");
			String file4=("Test_01.java");
			try {
				
			boolean bn=	 file1.createNewFile();//�����ļ�
			System.out.println(bn);
			boolean bn1=file2.mkdirs();//����Ŀ¼
			System.out.println(bn1);
			
			boolean bn2=file3.createNewFile();//���ı��´����ı�
			System.out.println(bn2);
			
			String str=file3.getAbsolutePath();//���ؾ���·��
			String str1=file3.getName();
			String str2=str.substring(0,str.indexOf(str1));
			File file5=new File(str2+file4);
			file3.renameTo(file5);
			System.out.println(file5);
			System.out.println(str);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}

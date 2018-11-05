package com.hp.MyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest01 {
			public static void main(String[] args) {
				FileInputStream fm=null;
				//����StringBuffer�������
				StringBuffer sb=new StringBuffer();
					try {
					//����һ���ֽ���ʽ��������
					 fm=new FileInputStream("C:\\1604c\\�ڶ���\\������\\Test_01.java");
					 //���ֽ�������װÿһ�ζ�ȡ������
					 byte [] b=new byte[100];
					 
					 int read=0;
					 try {
						while((read=fm.read(b))>0){
							 sb.append(new String(b,0,read));
						 }
						System.out.println(sb);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						if(fm!=null){
						try {
							fm.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						
						}
					}
			}
	}

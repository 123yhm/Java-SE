package com.hp.Dome22;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * 设置访问次数
 * 应用使用次数超过限制，不准使用，提示用户注册
 */
public class SystemDome {
    public static void main(String[] args)throws NumberFormatException  {
        File file = new File("D:\\reg.properties");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            String useCount = (String) properties.get("useCount");
            if (useCount == null) {
                properties.setProperty("useCount", "1");
            } else {
                int k =Integer.valueOf(useCount+1);
                if (k < 5) {
                    System.out.println("使用次数以到达期限，请立即注册");
                    return;
                }
                properties.setProperty("useCount", String.valueOf(k));
            }
            System.out.println("软件正常使用");
            FileOutputStream fos = new FileOutputStream("D:\\reg.properties");
            properties.store(fos, "授权信息");
            fos.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void Test() {

        try {
            File file = new File("D:\\reg.properties");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();
            //
            String useCount = (String) properties.get("useCount");
            if (useCount == null) {
                properties.setProperty("useCount", "1");
            } else {
                int value = Integer.valueOf(useCount) + 1;
                if (value > 5) {
                    System.out.println("使用超过限制，请授权");
                    return;
                }
                properties.setProperty("useCount", String.valueOf(value));
            }

            System.out.println("软件正常使用");

            FileOutputStream fos = new FileOutputStream("D:\\reg.properties");
            properties.store(fos, "授权信息");
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

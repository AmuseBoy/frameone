package com.amuse.frameone.test.io;

import java.io.*;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/8/24 19:51
 * @Version 1.0
 */
public class FileTest {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            File file = new File("E:\\a\\b\\c\\abc.txt");
            File fileParent = file.getParentFile();
            fileParent.mkdirs();
            boolean flag = file.createNewFile();
            System.out.println(flag);
            if(!flag){
//                FileOutputStream fos = new FileOutputStream(file);
//                File fileIn = new File("E:\\a\\b\\c\\def.txt");
//                FileInputStream fis = new FileInputStream(fileIn);
//                int i = 0;
//                while ((i = fis.read())!= -1){
//                    fos.write(i);
//                }
//                fos.flush();
//                fis.close();
//                fos.close();


//                FileOutputStream fos = new FileOutputStream(file);
//                fos.write("我是刘培振".getBytes());
//                fos.flush();
//                fos.close();

//                FileOutputStream fos = new FileOutputStream(file);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
//                File fileIn = new File("E:\\a\\b\\c\\def.txt");
//                FileInputStream fis = new FileInputStream(fileIn);
//                BufferedInputStream bis = new BufferedInputStream(fis);
//                int i = 0;
//                while ((i = bis.read())!= -1){
//                    bos.write(i);
//                }
//                bos.flush();
//                bos.close();
//                bis.close();
//                fos.close();
//                fis.close();


//                FileOutputStream fos = new FileOutputStream(file);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
//                bos.write("我是个帅哥".getBytes());
//                bos.flush();
//                bos.close();
//                fos.close();

                FileWriter fw = new FileWriter(file);
                File fileIn = new File("E:\\a\\b\\c\\def.txt");
                FileReader fr = new FileReader(fileIn);
                char[] ch = new char[1024];
                while (fr.read(ch)!=-1){
                    fw.write(ch);
                }
                fw.flush();
                fw.close();
                fr.close();

//                FileWriter fw = new FileWriter(file);
//                fw.write("我是个混蛋");
//                fw.flush();
//                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

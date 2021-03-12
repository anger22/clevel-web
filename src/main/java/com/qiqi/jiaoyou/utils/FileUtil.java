package com.qiqi.jiaoyou.utils;

import com.qiqi.jiaoyou.constants.PathParam;

import java.io.File;
import java.util.LinkedList;

public class FileUtil {

    public static void main(String[] args) {
        delApk(1,"");
    }

    /**
     * type 1:apk  2:img/video
     * @param type
     * @param filePath
     */
    public static void delApk(Integer type,String filePath) {
        File file = new File(PathParam.uploadpath);
        //File file = new File("D:/upload");
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                } else {
                    if (type == 1){
                        if (file2.getAbsolutePath().indexOf("apk") >= 0){
                            file2.delete();
                        }
                    }else{
                        if (file2.getAbsolutePath().indexOf(filePath) >= 0){
                            file2.delete();
                        }
                    }
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    } else {
                        if (type == 1){
                            if (file2.getAbsolutePath().indexOf("apk") >= 0){
                                file2.delete();
                            }
                        }else{
                            if (file2.getAbsolutePath().indexOf(filePath) >= 0){
                                file2.delete();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}

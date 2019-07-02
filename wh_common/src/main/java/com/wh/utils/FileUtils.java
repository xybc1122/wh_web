package com.wh.utils;

import java.io.*;;
import java.util.Scanner;

public class FileUtils {

    /**
     * 上传文件
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
        BufferedOutputStream out = null;
        File targetFile = new File(filePath);
        try {
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            out = new BufferedOutputStream(new FileOutputStream(filePath + fileName));
            out.write(file);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 创建文件
     *
     * @param path
     */
    public static void mkdirFile(String path) {
        File pathFile = new File(path); // 相对路径，如果没有则要建立一个新的output.txt文件
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
    }

    /**
     * 读取文件总行数
     *
     * @param filePath
     * @return
     */
    public static Double readFile(String filePath) {
        Double count = 0.0;
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            return count;
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}

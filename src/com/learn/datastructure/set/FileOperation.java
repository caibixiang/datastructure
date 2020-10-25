package com.learn.datastructure.set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-07 18:00 caibixiang Exp $
 */
public class FileOperation {

    public static boolean readFile(String fileName, ArrayList<String> words) {
        if (fileName == null || words == null) {
            System.out.println("filename is null or words is null");
        }
        //文件读取
        Scanner scanner;
        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fls = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fls), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else
                return false;

        } catch (IOException e) {
            System.out.println("Cannot open " + fileName);
            return false;
        }
        // 简单分词
        // 这个分词方式相对简陋 没有考虑很多
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
            }

        }
        return true;

    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                return i;
        }
        return s.length();
    }

}

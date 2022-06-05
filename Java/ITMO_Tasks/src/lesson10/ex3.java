package lesson10;

import java.io.*;
import java.util.*;

public class ex3 {
    public static void twoFilesToOne(String pthIn1,String pthIn2,String pthOut3){
        List<String> lst = new ArrayList<>();
        lst.addAll(ex1.fileToList(pthIn1));
        lst.addAll(ex1.fileToList(pthIn2));
        for (String s:lst){
            ex2.stringToFile(s,pthOut3);
        }
    }
    public static void main(String[] args) {
        String pthIn1 = "files/txt1.txt";
        String pthIn2 = "files/txt2.txt";
        String pthOut3 = "files/output.txt";
        twoFilesToOne(pthIn1,pthIn2,pthOut3);
    }
}

package lesson5;

import java.util.Arrays;

public class ex5 {
    public static String invertstr(String str) {
        String[] splited = str.split(" ");
        StringBuilder sb = new StringBuilder();
        str = "";
        for (int i=0; i < splited.length; i++) {
            sb.append(splited[i]);
            str = str+" "+sb.reverse();
            sb.delete(0,sb.length());
        }
        return str.trim();
    }

    public static void main(String[] args) {
        String str = "This is a test string";
        System.out.println(str);
        System.out.println(invertstr(str));
    }

}

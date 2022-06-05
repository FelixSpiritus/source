package lesson10;

import java.io.*;
import java.util.*;


public class ex1 {

    public static List<String> fileToList(String pth){
        File file = new File(pth);
        List<String> listStr = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String input;
            while ((input = reader.readLine()) != null) {
                listStr.add(input);
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
        return listStr;
    }

    public static void main(String[] args) {

    }
}

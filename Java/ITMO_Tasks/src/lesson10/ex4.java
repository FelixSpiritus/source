package lesson10;

import java.io.*;
import java.util.*;

public class ex4 {
    public static void replaceAll(String pth){
        List<String> lst = new ArrayList<>(ex1.fileToList(pth));
        File file = new File(pth);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("");
        } catch (IOException e){
            System.err.println("Error " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
            for (String str:lst){
                writer.write(str.replaceAll("[^A-Za-zА-Яа-я0-9\\d]", "\\$") + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String pth = "files/output.txt";
        replaceAll(pth);
    }
}

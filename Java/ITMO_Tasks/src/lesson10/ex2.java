package lesson10;

import java.io.*;

public class ex2 {
    public static void stringToFile(String str, String pth) {
        File file = new File(pth);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
            writer.write(str + "\n");
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public static void main(String[] args) {

    }

}

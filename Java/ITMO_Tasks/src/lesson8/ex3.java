package lesson8;

import java.util.*;

public class ex3 {
    public static void addElementsToList(List<String> lst){
        for (int i = 1; i<=1000000; i++){
            lst.add(Integer.toString(i));
        }
    }

   public static long rndSelectTime(List<String> string){
        Random random = new Random();
        String[] str = new String[100000];
        long t = System.currentTimeMillis();
        for (int i = 0; i<100000; i++){
            str[i] = string.get(random.nextInt(100000));
        }
        return System.currentTimeMillis() - t;

    }

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        addElementsToList(arrayList);
        addElementsToList(linkedList);
        System.out.println("Arraylist time(ms): "+rndSelectTime(arrayList));
        System.out.println("linkedList time(ms): "+rndSelectTime(linkedList));
    }
}

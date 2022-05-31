package lesson9;

import java.util.*;

public class ex2 {

    public static Set<String> noDouble(List<String> string){
        Set<String> set = new HashSet<>();
        for (String str: string){
            set.add(str);
        }
        return set;
    }

    public static void main(String[] args) {

    }
}

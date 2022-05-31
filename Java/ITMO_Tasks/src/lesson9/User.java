package lesson9;

import java.util.*;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void fillMap(Map<User, Integer> map){
        Random random = new Random();
        map.put(new User("Alice"), random.nextInt(100));
        map.put(new User("Katie"), random.nextInt(100));
        map.put(new User("Mike"), random.nextInt(100));
        map.put(new User("Bill"), random.nextInt(100));
        map.put(new User("Maria"), random.nextInt(100));
        map.put(new User("Ivan"), random.nextInt(100));
        map.put(new User("Petr"), random.nextInt(100));
    }

    public static void showUsePoints(Map<User, Integer> map) {
        boolean notFound = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input user name: ");
        String str = scanner.next();
        for (Map.Entry<User, Integer> m : map.entrySet()) {
            if (m.getKey().getName().equalsIgnoreCase(str)) {
                System.out.println(m.getKey().getName()+" points: "+m.getValue());
                notFound = false;
            }
        }
        if (notFound) {
            System.out.println("User not found");
        }


    }

    public static void main(String[] args) {
        Map<User, Integer> map = new HashMap<>();
        fillMap(map);
        showUsePoints(map);
    }



}

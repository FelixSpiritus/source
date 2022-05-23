package lesson5;

public class ex2 {
    public static boolean palindrom(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return str.equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(palindrom("Ротатор"));
    }
}

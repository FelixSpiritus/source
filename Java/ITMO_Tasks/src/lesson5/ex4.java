package lesson5;

public class ex4 {
    public static int substrcouter(String str, String substr) {
        return (str.length() - str.replace(substr, "").length()) / substr.length();
    }

    public static void main(String[] args) {
        String str = "Имеются две строки. Найти количество вхождений одной строки в другую.";
        String substr = "строки";
        System.out.println(substrcouter(str, substr));
    }

}

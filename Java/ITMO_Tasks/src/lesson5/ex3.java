package lesson5;

public class ex3 {
    public static String replb(String str) {
        str = str.replace("бяка", "[вырезано цензурой]");
        return str;
    }

    public static void main(String[] args) {
        String str = "Для работы с текстовыми данными в Java есть бяка три класса: String, StringBuffer и StringBuilder. С первым каждый разработчик бяка сталкивается еще в самом начале изучения языка.";
        System.out.println(str);
        System.out.println(replb(str));
    }
}

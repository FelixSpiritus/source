package lesson5;

public class ex1 {
    public static void longestWord(String str) {
        String st;
        st = str.replaceAll("[^a-zA-Zа-яА-Я\\s]+", "");
        String[] splited = st.split("\\s+");
        st = "";
        for(String s : splited) {
            if (s.length()>st.length()) {
                st = s;
            }

        }
        for(String s : splited) {
            if (s.length()==st.length()) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        longestWord("Для работы с текстовыми данными в Java есть три класса: String, StringBuffer и StringBuilder. С первым каждый разработчик сталкивается еще в самом начале изучения языка. А что насчет оставшихся двух? Какие у них есть различия, и когда лучше использовать тот или иной класс? В общем-то, разница между ними небольшая, но лучше во всем разобраться на практике :)");
    }
}

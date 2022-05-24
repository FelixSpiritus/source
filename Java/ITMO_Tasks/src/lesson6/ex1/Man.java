package lesson6.ex1;

public abstract class Man {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    abstract void getManinfo();

    public Man(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

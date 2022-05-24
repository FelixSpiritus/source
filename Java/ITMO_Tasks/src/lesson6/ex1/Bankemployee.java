package lesson6.ex1;

public class Bankemployee extends Man{
    String bankName;

    public Bankemployee(String name, String surname) {
        super(name, surname);
    }

    @Override
    void getManinfo() {
        System.out.println("Name: "+getName()+" "+"Surname: "+getSurname());
    }

    public Bankemployee(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }
}

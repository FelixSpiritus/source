package lesson6.ex1;

public class Client extends Man{
    String bankName;

    public Client(String name, String surname) {
        super(name, surname);
    }

    @Override
    void getManinfo() {
        System.out.println("Name: "+getName()+" "+"Surname: "+getSurname());
    }

    public Client(String name, String surname, String bankName) {
        super(name, surname);
        this.bankName = bankName;
    }
}

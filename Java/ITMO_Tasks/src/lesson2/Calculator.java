package lesson2;

public class Calculator {
    public long sum(int a, int b){
        return ((long)a+b);
    }
    public long sum(long a, long b){
        return (a+b);
    }
    public double sum(double a, double b){
        return (a+b);
    }
    public double dev(int a, int b){
        return (1.0*a/b);
    }
    public  double dev(long a, long b){
        return (1.0*a/b);
    }
    public double dev(double a, double b){
        return (a/b);
    }
    public long mul(int a, int b){
        return ((long) a *b);
    }
    public  long mul(long a, long b){
        return (a*b);
    }
    public double mul(double a, double b){
        return (a*b);
    }
    public long sub(int a, int b){
        return ((long)a-b);
    }
    public  long sub(long a, long b){
        return (a-b);
    }
    public double sub(double a, double b){
        return (a-b);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sub(241.2,4534.3));
    }
}

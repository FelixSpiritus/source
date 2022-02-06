using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


class Program
{

    static void Main(string[] args)
    {
        Console.WriteLine("Enter triangle side A");
        double a = double.Parse(Console.ReadLine());
        Console.WriteLine("Enter triangle side B");
        double b = double.Parse(Console.ReadLine());
        Console.WriteLine("Enter triangle side C");
        double c = double.Parse(Console.ReadLine());
        Triangle MyTriangle = Triangle.NewTriangle(a,b,c);
        Console.WriteLine("The triangle square is: " + MyTriangle.Square() + "\n"
                            + "The triangle perimetr is: " + MyTriangle.Perimetr() + "\n"
                            + "The triangle side A is: " + MyTriangle.Aside() + "\n"
                            + "The triangle side B is: " + MyTriangle.Bside() + "\n"
                            + "The triangle side C is: " + MyTriangle.Cside());
    }
     
    
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex84
{
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
            Triangle MyTriangle = new Triangle(a, b, c);
            MyTriangle.Show();
            Console.WriteLine();
            Console.WriteLine("For equilateral triangle with side А={0}",a);
            Triangle EqTriangle = new Triangle(a);
            EqTriangle.Show();

        }
        
    }
}

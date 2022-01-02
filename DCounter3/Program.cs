using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DCounter3
{
    class Geron
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please enter perimeter");
            Double p;
            while (!Double.TryParse(Console.ReadLine(), out p) || p <= 0)
                   Console.WriteLine("Invalid input. Try again!");

            Double s = Math.Sqrt(0.5*p * Math.Pow((0.5 * p - 0.5 * p / 3), 3));
            Console.WriteLine("\tSide\t\tSquare");
            Console.WriteLine($"{p,12:F}{s,18:F}");
                                           
        }
    }
}
   
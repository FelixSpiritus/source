using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DCounter1
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack double fz;

            Console.WriteLine("Input a");
            Double a = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Input b");
            Double b = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Input c");
            Double c = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Input x1");
            Double x1 = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Input x2");
            Double x2 = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Input dx");
            Double dx = Convert.ToDouble(Console.ReadLine());

            var x = x1;
            var ulong i = 1;

            while (x<=x2)
                   {
                var temp = (b * c) - (c * x * x);
                var z = a * Math.Exp(temp);
                fz.push(z);
                Console.WriteLine($"v={x}",$"z={z}");
                x = x + dx;
                
            }
            Console.WriteLine($"quantity={i}");
            Console.ReadLine();

        }
    }
}

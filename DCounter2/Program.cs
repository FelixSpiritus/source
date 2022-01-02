using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DCounter2
{
    class Program
    {
        static void Main(string[] args)
        {
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
            var zstack = new Stack<double>();
            var xstack = new Stack<double>();

            while (x <= x2)
            {
                var z = a * Math.Exp(b * c - c * x * x);
                zstack.Push(z);
                xstack.Push(x);
                x += dx;
            }

            Console.WriteLine($"Quantity of elements={zstack.Count}");

            while (zstack.Count != 0)
            {
                var zs = zstack.Pop();
                var xs = xstack.Pop();
                Console.WriteLine($"Element number {zstack.Count+1}  z={zs} x={xs}");
            }

            Console.ReadKey();
        }
    }
}

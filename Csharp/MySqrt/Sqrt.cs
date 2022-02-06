using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MySqrt
{
    class Sqrt
    {
        static double MySqrt(double target)
        {
            double x = 1;
            double oldx;
            do
            {
                oldx = x;
                x = (x + target / x) / 2;
            }
            while (oldx != x);
            return (x);

        }

        static void Main(string[] args)
        {
            double target = 2023;
            double x = MySqrt(target);
            Console.WriteLine(x);
            Console.WriteLine(x * x);
        }
    }
}

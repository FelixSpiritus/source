using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuadraticEquation45
{
    class QuadraticEquation
    {
        public static int QEquation(double a, double b, double c, ref double x1, ref double x2)
        {
            int f = 0;
            double d = b * b - 4 * a * c;
            if (d == 0)
            {
                f = 0;
                x1 = x2 = -b/(2 * a);
            }
            if (d > 0)
            {
                f = 1;
                x1 = (-b + Math.Sqrt(d)) / (2 * a);
                x2 = (-b - Math.Sqrt(d)) / (2 * a);
            }
            if (d < 0) f = -1;
            return f;
        }
    
    }



    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Введите коэффициент a: ");
            double a = double.Parse(Console.ReadLine());
            Console.Write("Введите коэффициент b: ");
            double b = double.Parse(Console.ReadLine());
            Console.Write("Введите коэффициент c: ");
            double c = double.Parse(Console.ReadLine());
            double x1 = 0;
            double x2 = 0;
            int f = QuadraticEquation.QEquation(a, b, c, ref x1, ref x2);
            if (f == -1) Console.WriteLine($"Корней уравнения с коэффициентами a={a}, b={b}, c={c} нет");
            if (f == 0) Console.WriteLine($"Корень уравнения с коэффициентами a={a}, b={b}, c={c} один x1=x2={x1}");
            if (f == 1) Console.WriteLine($"Корни уравнения с коэффициентами a={a}, b={b}, c={c} равны x1={x1}, x2={x2}");
        }
    }
}

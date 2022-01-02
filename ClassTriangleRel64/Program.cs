using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassTriangleRel64
{

    class Triangle
    {
        private double a;
        private double b;
        private double c;

        public double Aside()
        {
            return a;
        }
        public double Bside()
        {
            return b;
        }
        public double Cside()
        {
            return c;
        }
        public void Populate(double Aside, double Bside, double Cside)
        {
            a = Aside;
            b = Bside;
            c = Cside;
        }


        public bool Perimetr(double a, double b, double c, out double p)
        {
            bool ok = TriangleExist(a, b, c);
            p = 0;
            if (ok)
            {
                p = a + b + c;
            }
            return ok;
        }

        private bool TriangleExist(double a, double b, double c)
        {
            bool ok;
            if (a + b > c && a + c > b && b + c > a) ok = true;
            else ok = false;
            return ok;
        }

        public bool STriangle(double a, out double s)
        {
            bool ok = TriangleExist(a, a, a);
            s = 0;
            if (ok)
            {
                double p = 0.5 * 3 * a;
                s = Math.Sqrt(p * Math.Pow((p - a), 3));
            }
            else ok = false;
            return ok;
        }

        public bool STriangle(double a, double b, double c, out double s)
        {
            bool ok = TriangleExist(a, b, c);
            s = 0;
            if (ok)
            {
                double p = 0.5 * (a + b + c);
                s = Math.Sqrt(p * (p - a) * (p - b) * (p - c));
            }
            return ok;
        }


    }

    class Program
    {
        static Triangle NewTriangle();
        {
            Triangle created = new Triangle();
        double Aside = double.Parse(Console.ReadLine());
        double Bside = double.Parse(Console.ReadLine());
        double Cside = double.Parse(Console.ReadLine());
        created.Populate(Aside,Bside,Cside);
            return created;
        }
    static void Main(string[] args)
        {
            Console.Write("Enter triangle type, 1 for equilateral, 2 for any other: ");
            int type = int.Parse(Console.ReadLine());
            if (type == 1)
            {
                Console.Write("Enter size of equilateral triangle side: ");
                double a = double.Parse(Console.ReadLine());
                bool ok = STriangle(a, out double s);
                if (ok) Console.WriteLine("The triangle square is: " + s);
                else Console.WriteLine("The triangle doesn't exist");
            }
            if (type == 2)
            {
                Console.Write("Enter size of side a: ");
                double a = double.Parse(Console.ReadLine());
                Console.Write("Enter size of side b: ");
                double b = double.Parse(Console.ReadLine());
                Console.Write("Enter size of side c: ");
                double c = double.Parse(Console.ReadLine());
                bool ok = Operation.STriangle(a, b, c, out double s);
                if (ok) Console.WriteLine("The triangle square is: " + s);
                else Console.WriteLine("This triangle doesn't exist.");

            }
            if (type != 1 && type != 2) Console.WriteLine("The triangle type incorrect.");
        }
    }
}

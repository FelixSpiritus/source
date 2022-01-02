using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex84
{
    class Triangle
    {
        private double a;
        private double b;
        private double c;
        private bool e;

        private bool Exist()
        {
            if (a + b > c && a + c > b && b + c > a) e = true;
            else e = false;
            
            return e;
        }
        public double Perimetr()
        {
            double p = a + b + c;
            return p;
        }
        public double Square()
        {
            double p = 0.5 * Perimetr();
            double s = Math.Sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        public Triangle(double Aside)
        {
            a = Aside;
            b = Aside;
            c = Aside;
            e = Exist();
        }
        public Triangle(double Aside, double Bside, double Cside)
        {
            a = Aside;
            b = Bside;
            c = Cside;
            e = Exist();
        }
        public void Show()
        {
            if (Exist())
            {
                Console.WriteLine("The triangle square is: " + Square() + "\n"
                                + "The triangle perimetr is: " + Perimetr() + "\n"
                                + "The triangle side A is: " + a + "\n"
                                + "The triangle side B is: " + b + "\n"
                                + "The triangle side C is: " + c);
            }
            else Console.WriteLine("This triangle doesn`t exist.");
        }

    } 
}


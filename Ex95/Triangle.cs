using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex95
{
    class Triangle :Shape, IRotate
    {
        private double a;
        private double b;
        private double c;
        private bool e;

        
        public override bool Exist()
        {
            if (a + b > c && a + c > b && b + c > a) e = true;
            else e = false;

            return e;
        }
        public override double Perimetr()
        {
            double p = a + b + c;
            return p;
        }
        public override double Area()
        {
            double p = 0.5 * Perimetr();
            double s = Math.Sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        public void Rot()
        {
            Console.WriteLine("Triangle turned");
        }


        public Triangle()
        {
            SetShapeName("triangle");
            SetSizeName("side");
            a = InputSize();
            b = InputSize();
            c = InputSize();
            e = Exist();
            SetShapeExist(e);
        }
      
    }
}

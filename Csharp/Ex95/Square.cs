using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex95
{
    class Square: Shape, IRotate
    {
        private double a;
        private bool e;


        public override bool Exist()
        {
            if (a > 0) e = true;
            else e = false;

            return e;
        }
        public override double Perimetr()
        {
            double p = 4 * a;
            return p;
        }
        public override double Area()
        {
            double s = Math.Pow(a, 2);
            return s;
        }

        public void Rot()
        {
            Console.WriteLine("Square turned");
        }

        public Square()
        {
            SetShapeName("square");
            SetSizeName("side");
            a = InputSize();
            SetSize(a);
            e = Exist();
            SetShapeExist(e);
        }
    }
}


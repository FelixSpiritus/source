using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex95
{
    class Circle: Shape
    {
        private double r;
        private bool e;


        public override bool Exist()
        {
            if (r>0) e = true;
            else e = false;

            return e;
        }
        public override double Perimetr()
        {
            double p = 2*Math.PI*r;
            return p;
        }
        public override double Area()
        {
            double s = Math.PI * Math.Pow(r,2);
            return s;
        }
        
        public Circle()
        {
            SetShapeName("circle");
            SetSizeName("radius");
            r = InputSize();
            SetSize(r);
            e = Exist();
            SetShapeExist(e);
        }
    }
}

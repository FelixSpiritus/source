using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex95
{
    abstract class Shape
    {
        protected string ShapeName;
        protected string SizeName;
        protected double size;
        protected bool ShapeExist;

        abstract public bool Exist();



        public void SetShapeName(string sn)
        {
            ShapeName = sn;
        }
        public void SetSizeName(string sn)
        {
            SizeName = sn;

        }
        public void SetShapeExist(bool ex)
        {
            ShapeExist = ex;
        }

        public void SetSize(double s)
        {
            size = s;
        }
        public double Size()
        {
            return size;
        }

        abstract public double Perimetr();

        abstract public double Area();

        public virtual double InputSize()
        {
            Console.Write($"Enter {SizeName} length of {ShapeName} ");
            size = double.Parse(Console.ReadLine());
            return size;
        }

        public virtual void Show(string ParamName, double ParamValue)
        {
            if (ShapeExist) Console.WriteLine($"The {ShapeName} {ParamName} is {ParamValue}");
                else Console.WriteLine($"The {ShapeName} doesn`t exist");
        }
       
    }
}

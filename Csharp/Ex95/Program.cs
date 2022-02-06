using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex95
{
    class Program
    {
        static void Main(string[] args)
        {
            Triangle MyTriangle = new Triangle();
            MyTriangle.Show("аrea", MyTriangle.Area());
            MyTriangle.Show("perimeter", MyTriangle.Perimetr());
            MyTriangle.Rot();

            Circle MyCircle = new Circle();
            MyCircle.Show("radius", MyCircle.Size());
            MyCircle.Show("аrea", MyCircle.Area());
            MyCircle.Show("perimeter", MyCircle.Perimetr());
            
            Square MySquare = new Square();
            MySquare.Show("side", MySquare.Size());
            MySquare.Show("аrea", MySquare.Area());
            MySquare.Show("perimeter", MySquare.Perimetr());
            MySquare.Rot();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Distance

{public struct Distance
    {
        public int foot;
        public int inch;
    }
    class FootInch
    {
        static void Main(string[] args)
        {
            Distance a;
            Distance b;
            Distance z;

            Console.WriteLine("Input the first distance ft");
            a.foot = int.Parse(Console.ReadLine());
            Console.WriteLine("Input the first distance in");
            a.inch = int.Parse(Console.ReadLine());

            Console.WriteLine("Input the second distance ft");
            b.foot = int.Parse(Console.ReadLine());
            Console.WriteLine("Input the second distance in");
            b.inch = int.Parse(Console.ReadLine());

            z.foot = a.foot + b.foot + (int)((a.inch + b.inch) / 12);
            z.inch = (a.inch + b.inch) % 12;
            Console.WriteLine("Total distance is {0}'-{1}\"",z.foot, z.inch);
        }
    }
}

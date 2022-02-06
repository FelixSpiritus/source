using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Array53
{
    public class MethArray
    {
        public struct Dnum
        {
            public int s1;
            public int s2;
        }

        public static int[] MyArray(int r)
        {
            Random rnd = new Random();
            int[] Arr = new int[r];
            for (int i = 0; i < Arr.Length; i++)
            {
                Arr[i] = rnd.Next(-20, 20);
                Console.WriteLine($"Arr[{i}]={Arr[i]}");
            }
            return Arr;
        }

        public static int SumArray(int [] Arr)
        {
            int sum=0;
            for (int i = 0; i < Arr.Length; i++)
                sum += Arr[i];
            return sum;
        }
        
        public static Dnum PosNeg(int[] Arr)
        {
            MethArray.Dnum sum;
            sum.s1 = 0;
            sum.s2 = 0;
            for (int i = 0; i < Arr.Length; i++)
            {
                if (Arr[i] > 0) sum.s1 += Arr[i];
                if (Arr[i] < 0) sum.s2 += Arr[i];
            }
            return sum;
        }

        public static Dnum EvenOdd(int[] Arr)
        {
            MethArray.Dnum sum;
            sum.s1 = 0;
            sum.s2 = 0;
            for (int i = 0; i < Arr.Length; i++)
            {
                if (Arr[i] % 2 == 0) sum.s1 += Arr[i];
                    else sum.s2 += Arr[i];
            }
            return sum;
        }
        
        public static Dnum MinMax(int[] Arr)
        {
            MethArray.Dnum elm;
            elm.s1 = 0;
            elm.s2 = 0;
            for (int i = 0; i < Arr.Length; i++)
            {
                if (Arr[i] > Arr[elm.s1]) elm.s1 = i;
                if (Arr[i] < Arr[elm.s2]) elm.s2 = i;
            }
            return elm;
        }
        public static int MMProduct(int[] Arr)
        {
            MethArray.Dnum elm = MethArray.MinMax(Arr);
            int prod = Arr[Math.Min(elm.s1, elm.s2)];
            for (int i = Math.Min(elm.s1, elm.s2)+1; i <= Math.Max(elm.s1, elm.s2); i++)
            {
                prod *= Arr[i];
            }
            return prod;
        }
        public static int AverArray(int[] Arr)
        {
            int avr = MethArray.SumArray(Arr) / Arr.Length;
            return avr;
        }
    }
    class ArrayOperatios
    {
        static void Main(string[] args)
        {
            Console.Write("Enter quantity of array elemets: ");
            int r = int.Parse(Console.ReadLine());
            int[] Arr = new int[r];
            Console.Write("Do you want to fill array automatic, yes[y], no[any other simbols] :  ");
            string auto = Console.ReadLine().ToLower();
            if (auto == "y")
            {
                Arr = MethArray.MyArray(r);
            }
                else
                {
                    for (int i = 0; i < Arr.Length; i++)
                    {
                        Console.Write($"Enter array element Arr[{i}]= ");
                        Arr[i] = int.Parse(Console.ReadLine());
                    }
                                   
                }
            Console.WriteLine($"Elements Sum={MethArray.SumArray(Arr)}, Elements quantity={Arr.Length}");
            Console.WriteLine($"The average of the array={MethArray.AverArray(Arr)}");
            MethArray.Dnum num = MethArray.PosNeg(Arr);
            Console.WriteLine($"Positiv elements sum is: {num.s1}, Negativ elements sum is {num.s2}");
            num = MethArray.EvenOdd(Arr);
            Console.WriteLine($"Even elements sum is: {num.s1}, Odd elements sum is {num.s2}");
            num = MethArray.MinMax(Arr);
            Console.WriteLine($"Max element is: Arr[{num.s1}]={Arr[num.s1]}, Min element is: Arr[{num.s2}]={Arr[num.s2]}");
            Console.WriteLine($"Poduct of elements between Min and Max is: {MethArray.MMProduct(Arr)}");
        }
    }
}

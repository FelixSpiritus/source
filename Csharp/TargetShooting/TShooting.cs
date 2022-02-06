using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace TargetShooting
{
    public struct Coord
    {
        public int x;
        public int y;
    }

    public struct Target
    {
        public Coord CenterTarget;
        public int r10;
        public int r5;
        public int r1;
    }

    

    class TShooting
    {
        static Coord Interference(Coord p)
        {
            Random rnd = new Random();
            p.x += rnd.Next(-10, 10);
            p.y += rnd.Next(-10, 10);
            return (p);
        }

        
        static byte ShotResult(Coord p1, Target t1)
        {
            byte res = 0;
            double dev = Math.Sqrt(Math.Pow((p1.x - t1.CenterTarget.x), 2) + Math.Pow((p1.y - t1.CenterTarget.y), 2));
            if (dev <= t1.r10) res = 10;
                else if (dev <= t1.r5) res = 5;
                         else if (dev <= t1.r1) res = 1;
            return (res);
        }

        static void Main(string[] args)
        {
            Random rnd = new Random();
            Target target1;
            target1.CenterTarget.x = rnd.Next(-400, 400);
            target1.CenterTarget.y = rnd.Next(-400, 400);
            target1.r10 = 200;
            target1.r5 = 400;
            target1.r1 = 600;
            
            Coord[] shot = new Coord[5];
            byte TotalResult = 0;
            for (int i = 0; i < shot.Length; i ++)
            {
                Console.Write($"Input x coordinate of {i+1} shot between -1000 and 1000: ");
                shot[i].x = int.Parse(Console.ReadLine());
                Console.Write($"Input y coordinate of {i+1} shot between -1000 and 1000: ");
                shot[i].y = int.Parse(Console.ReadLine());
                shot[i] = Interference(shot[i]);
                Console.WriteLine($"Shot with interference: x={shot[i].x}, y={ shot[i].y} result: {ShotResult(shot[i], target1)} points");
                TotalResult += ShotResult(shot[i], target1);

            }
            Console.WriteLine($"Total result: {TotalResult} points");
            Console.ReadKey();
        }
    }
}

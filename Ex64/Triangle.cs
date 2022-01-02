using System;

    class Triangle
        {
            private double a;
            private double b;
            private double c;
            private bool e;

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
                e = Exist(); 
            }
            private bool Exist()
            {
                if (a+b > c && a + c > b && b + c > a) e = true;
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
            public static Triangle NewTriangle(double Aside, double Bside, double Cside)
            {
                 Triangle created = new Triangle();
                 created.Populate(Aside, Bside, Cside);
                 if (!created.e)
                 {
                    Console.WriteLine("This triangle doesn`t exist.");
                    Environment.Exit(0);
                 }
                 return created;
            }
}


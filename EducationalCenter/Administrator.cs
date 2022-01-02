using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    class Administrator: Person, IEmployee
    {
        private string Lab;
        private int EmpYear;
        private bool WorkNow;


        public void Dismiss()
        {
            WorkNow = false;
            Console.WriteLine($"{Surname} from Laboratory {Lab} currently working {WorkNow}");
        }
        public Administrator(string Lab, string Surname, int BirthYear) : base(Surname, BirthYear)
        {
            this.Lab = Lab;
            this.EmpYear = DateTime.Now.Year;
        }

        public double Salary(int workdays, double daysal, double k)
        {
            double salary = workdays * daysal + workdays * daysal * k ;
            return salary;
        }
        public override void Show()
        {
            base.Show();
            Console.WriteLine($"Laboratory {Lab}");
        }

    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    class Teacher : Person, IEmployee
    {
        private string Faculty;
        private string Position;
        private int Expirience;
        private bool WorkNow;
        private int EmpYear;


        public void Dismiss()
        {
            WorkNow = false;
            Console.WriteLine($"{Position} {Surname} currently working {WorkNow}");
        }
        public Teacher(string Faculty, string Position, int Expirience, string Surname, int BirthYear) : base(Surname, BirthYear)
        {
            this.Faculty = Faculty;
            this.Position = Position;
            this.WorkNow = true;
            this.EmpYear = DateTime.Now.Year;
            this.Expirience = Expirience;
        }

        public int GetActualExp()
        {
            int Exp = Expirience + DateTime.Now.Year - EmpYear;
            return Exp;
        }
        public double Salary(int workdays, double daysal)
        {
            double salary = workdays * daysal;
            return salary;
        }
        public override void Show()
        {
            base.Show();
            Console.WriteLine($"Faculty {Faculty}, Position {Position}, Expirience {GetActualExp()} years");
        }
    }
}

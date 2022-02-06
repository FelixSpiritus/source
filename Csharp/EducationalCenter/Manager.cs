using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    class Manager : Person, IEmployee
    {

        private string Faculty;
        private string Position;
        private int EmpYear;
        private bool WorkNow;

        public void Dismiss()
        {
            WorkNow = false;
            Console.WriteLine($"{Position} {Surname} currently working {WorkNow}");
        }


        public Manager(string Faculty, string Position, string Surname, int BirthYear): base(Surname, BirthYear)
        {
            this.Faculty = Faculty;
            this.Position = Position;
            this.WorkNow = true;
            this.EmpYear = DateTime.Now.Year;
        }
       
        public double Salary(int workdays, double daysal, double inc)
        {
            double salary = workdays * daysal * inc;
            return salary;
        }
        
        public override void Show()
        {
            base.Show();
            Console.WriteLine($"Faculty {Faculty}, Position {Position}");
        }
    }    
}

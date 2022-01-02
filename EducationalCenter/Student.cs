using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    class Student: Person
    {
        private string Faculty;
        private string Group;
        


        public Student(string Faculty, string Group, string Surname, int BirthYear) : base(Surname, BirthYear)
        {
            this.Faculty = Faculty;
            this.Group = Group;
                      
        }
        public override void Show()
        {
            base.Show();
            Console.WriteLine($"Faculty {Faculty}, Group {Group}");
        }
    }
}

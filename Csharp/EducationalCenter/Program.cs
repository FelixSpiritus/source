using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    class Program
    {
        static void Main(string[] args)
        {
            var Persons = new List<Person>
            {
                new Manager("Economic","Assistant","Ivanov",1990),
                new Student("Economic","A325","Petrov",2002),
                new Teacher("Historical", "Professor", 25, "Popov", 1965),
                new Administrator("chemical", "Fridman", 1976)

            };

            foreach (Person human in Persons)
            {
                human.Show();
                Console.WriteLine();
            }


        }
    }
}

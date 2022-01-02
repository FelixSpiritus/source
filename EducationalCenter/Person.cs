using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EducationalCenter
{
    abstract class Person
    {
        protected readonly int PersId;
        protected string Surname;
        protected int BirthYear;
        private static int nnum=1;

        private static int NextNumber()
        {
            return nnum++;
        }

        public Person(String Surname, int BirthYear)
        {
            this.PersId = NextNumber();
            this.Surname = Surname;
            this.BirthYear = BirthYear;
        }
        public int GetPersId()
            {
                return PersId;
            }
        public int GetAge()
        {
            int age = DateTime.Now.Year - BirthYear;
            return age;
        }
        virtual public void Show()
        {
            Console.WriteLine($"id {PersId}, Surname {Surname}, Year of birth {BirthYear}, Age {GetAge()}");
        }
        
    }
    
}

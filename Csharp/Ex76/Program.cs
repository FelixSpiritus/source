using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ex76
{
    class Program
    {
        static void Main(string[] args)
        {
            Book b1 = NewBook("Will Smith", "Apple", 233, 1850);
            Book b2 = NewBook("Bill Brown", "Tree", 433, 1958);
            Book b3 = NewBook("John Dow", "Invisible Man", 221, 1920);
            Book b4 = NewBook("Andy Fast", "Black Snow", 68, 1910);
            Book b5 = NewBook("Ann White", "Small Dog", 411, 1901);
            Book[] AllBooks = new Book[] { b1, b2, b3, b4, b5 };
            Array.Sort(AllBooks);
            foreach (Book b in AllBooks)
            {
                b.Show();
            }
        }
        public static Book NewBook(String author, String title, int pages, int year)
        {
            Book set = new Book();
            set.SetBook(author, title, pages, year);
            return set;
        }
    }
}
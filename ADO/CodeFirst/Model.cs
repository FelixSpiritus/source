using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


namespace CodeFirst
{
    public class SampleContext : DbContext
    {
        public SampleContext() : base("MyShop")
        { }

        public DbSet<Customer> Customers { get; set; }
        public DbSet<Order> Orders { get; set; }
    }

    public class Model
    {

    }
    public class Customer
    {
        [Required]
        [MaxLength(30)]
        public string Name { get; set; }

        [MaxLength(100)]
        public string Email { get; set; }

        [Range(8, 100)]
        public int Age { get; set; }

        [Column(TypeName = "image")]
        public byte[] Photo { get; set; }


        public override string ToString()
        {
            string s = Name + ", электронный адрес: " + Email;
            return s;
        }
        // Ссылка на заказы
        public virtual List<Order> Orders { get; set; }
        public Customer()
        {
            Orders = new List<Order>();
        }
    }

    public class Order
    {
        public int OrderId { get; set; }
        public string ProductName { get; set; }
        public string Description { get; set; }
        public int Quantity { get; set; }
        public DateTime PurchaseDate { get; set; }

        // Ссылка на покупателя
        public Customer Customer { get; set; }

        public override string ToString()
        {
            string s = ProductName + " " + Quantity + "шт., дата: " + PurchaseDate;
            return s;
        }

    }

}

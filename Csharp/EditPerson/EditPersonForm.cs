using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EditPerson
{
    public partial class EditPersonForm : Form
    {
        Person p;

        public EditPersonForm()
        {
            InitializeComponent();
        }
        public EditPersonForm(Person p)
        {
            InitializeComponent();
            this.p = p;
            firstNameTextBox.Text = p.FirstName;
            lastNameTextBox.Text = p.LastName;
            ageNumericUpDown.Value = p.Age;
            
        }
       
        //public string FirstName
        //{
        //    get { return firstNameTextBox.Text; }
        //    set { firstNameTextBox.Text = value; }
        //}
        //public string LastName
        //{
        //    get { return lastNameTextBox.Text; }
        //    set { lastNameTextBox.Text = value; }
        //}
        //public int Age
        //{
        //    get { return (int)ageNumericUpDown.Value; }
        //    set { ageNumericUpDown.Value = value; }
        //}

        private void button1_Click(object sender, EventArgs e)
        {
            p.FirstName = firstNameTextBox.Text;
            p.LastName = lastNameTextBox.Text;
            p.Age = Convert.ToInt32(ageNumericUpDown.Value);
            MessageBox.Show("Сотрудник: " + p.ToString());
        }
    }
}

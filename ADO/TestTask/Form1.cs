using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TestTask
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dataGridView1.DataSource = afDataSet1.Customers;
        }

        private void FillCustomers_Click(object sender, EventArgs e)
        {
            sqlDataAdapter1.Fill(afDataSet1.Customers);
            BindingSource CustomersBindingSource = new BindingSource(afDataSet1, "Customers");
            dataGridView1.DataSource = CustomersBindingSource;
            bindingNavigator1.BindingSource = CustomersBindingSource;

        }

        private void SaveData_Click(object sender, EventArgs e)
        {
            sqlDataAdapter1.Update(afDataSet1);
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsAppEx1._5._2
{
    public partial class Form2 : Form
    {
        Form1 myF2;
        public Form2()
        {
            InitializeComponent();
            myF2 = new Form1();
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                myF2.Show();
                myF2.Activate();
            }
            catch (ObjectDisposedException ex) { myF2 = new Form1();
            myF2.Text = "Повторное создание формы";
            myF2.Show(); myF2.Activate(); }
        }
    }
}

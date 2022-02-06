using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FuncCalcEx45
{
   
    public partial class FormRange : Form
    {
        //public double x1
        //{
        //    get { return (double)numericUpDown1.Value; }
        //    set { numericUpDown1.Value = value; }
        //}
        public string x1
        {
            get { return textBox1.Text; }
            set { textBox1.Text = value; }
        }
        public string x2
        {
            get { return textBox2.Text; }
            set { textBox2.Text = value; }
        }


        public FormRange()
        {
            InitializeComponent();
        }
    }
}

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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormRange editForm = new FormRange();
            if (editForm.ShowDialog() != DialogResult.OK)
                return;
            label2.Text = "Левая граница: "+editForm.x1 + ", Правая граница: "+editForm.x2;
            StringBuilder sb = new StringBuilder();
            double y1 = double.Parse(editForm.x1);
            double y2 = double.Parse(editForm.x2);
            while (y1 <= y2)
            {
                
                sb.Append(String.Format($"{y1}:   " + "{0:0.00}", Math.Sin(y1))+ "\n");
                y1 += 0.1;

            }
            richTextBox1.Text = sb.ToString();
            
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ex75Eratosfen
{
    public partial class Form1 : Form
    {
        public async Task<string> GoButt()
        {
            return await Task.Run(() =>
            {
                int maxValue = 0;
                System.Text.StringBuilder resultText = new System.Text.StringBuilder();
                if (int.TryParse(MaxValue.Text, out maxValue))
                {
                    for (int trial = 2; trial <= maxValue; trial++)
                    {
                        bool isPrime = true;
                        for (int divisor = 2; divisor <= Math.Sqrt(trial); divisor++)
                        {
                            if (trial % divisor == 0)
                            {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime)
                        {
                            resultText.AppendFormat("{0} ", trial);
                        }
                    }
                }
                else { resultText.Append("Unable to parse maximum value."); }
                return resultText.ToString();
            }
            );
        }


        public Form1()
        {
            InitializeComponent();
        }

        private void MaxValue_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
                MessageBox.Show("Поле должно содержать цифры");
            }
            button1.Enabled = true;
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            rTB.Text = await GoButt();
        }
    }
}

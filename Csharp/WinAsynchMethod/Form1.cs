using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinAsynchMethod
{
    public partial class Form1 : Form
    {
        private delegate int AsyncSumm(int a, int b);
        private int Summ(int a, int b)
        {
            System.Threading.Thread.Sleep(9000);
            return a + b;
        }
        private void CallBackMethod(IAsyncResult ar)
        {
            string str;
            AsyncSumm summdelegate = (AsyncSumm)ar.AsyncState;
            str = String.Format("Сумма введенных чисел равна {0}", summdelegate.EndInvoke(ar));
            MessageBox.Show(str, "Результат операции");
            lblResult.Invoke(PrintDlegateFunc, new object[] { str });
        }
        void PrintFunc(string str)
        {
            lblResult.Text = str;
        }
        delegate void PrintLabel(string str);
        private PrintLabel PrintDlegateFunc;
        private async Task<int> Subb(int a, int b)
        {
            return await Task.Run(() =>
            {
                System.Threading.Thread.Sleep(5000);
                return a - b;
            }
            );
        }
        public Form1()
        {
            InitializeComponent();
            PrintDlegateFunc = new PrintLabel(PrintFunc);
           
        }

        private void btnRun_Click(object sender, EventArgs e)
        {
            int a, b;
            try
            {
                // Преобразование типов данных.
                a = Int32.Parse(txbA.Text);
                b = Int32.Parse(txbB.Text);
            }
            catch (Exception)
            {
                MessageBox.Show("При выполнении преобразования типов возникла ошибка");
                txbA.Text = txbB.Text = "";
                return;
            }
            AsyncSumm summdelegate = new AsyncSumm(Summ);
            AsyncCallback cb = new AsyncCallback(CallBackMethod);
            summdelegate.BeginInvoke(a, b, cb, summdelegate);
        }

        private void btnWork_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Работа кипит!!!");
        }

        private async void button2_Click(object sender, EventArgs e)
        {
            int a, b;
            try
            {
                a = Int32.Parse(txbA.Text);
                b = Int32.Parse(txbB.Text);
                int res = await Subb(a, b);
                lblResult.Text = res.ToString();
            }
            catch (Exception)
            {
                MessageBox.Show("При выполнении преобразования типов возникла ошибка");
                txbA.Text = txbB.Text = "";

            }
            return;
            

        }
    }
}

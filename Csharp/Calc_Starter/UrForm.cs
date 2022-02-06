using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Calculator;

namespace SimpleCalculator
{
    public partial class UrForm : Form
    {
        CalcEngine.Ecoef ec;

        public UrForm()
        {
            InitializeComponent();
                                    
        }
        public UrForm(CalcEngine.Ecoef ec)
        {
            InitializeComponent();
            this.ec = ec;
            numericA.Value = (decimal)ec.Acoef;
            numericB.Value = (decimal)ec.Bcoef;
            numericC.Value = (decimal)ec.Ccoef;

        }

        private void Save_Click(object sender, EventArgs e)
        {
            ec.Acoef = (double)numericA.Value;
            ec.Bcoef = (double)numericB.Value;
            ec.Ccoef = (double)numericC.Value;
            

        }
    }
}


namespace WinAsynchMethod
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnRun = new System.Windows.Forms.Button();
            this.btnWork = new System.Windows.Forms.Button();
            this.lblA = new System.Windows.Forms.Label();
            this.lblB = new System.Windows.Forms.Label();
            this.txbA = new System.Windows.Forms.TextBox();
            this.txbB = new System.Windows.Forms.TextBox();
            this.lblResult = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnRun
            // 
            this.btnRun.Location = new System.Drawing.Point(8, 75);
            this.btnRun.Name = "btnRun";
            this.btnRun.Size = new System.Drawing.Size(75, 23);
            this.btnRun.TabIndex = 0;
            this.btnRun.Text = "Сумма";
            this.btnRun.UseVisualStyleBackColor = true;
            this.btnRun.Click += new System.EventHandler(this.btnRun_Click);
            // 
            // btnWork
            // 
            this.btnWork.Location = new System.Drawing.Point(65, 126);
            this.btnWork.Name = "btnWork";
            this.btnWork.Size = new System.Drawing.Size(75, 23);
            this.btnWork.TabIndex = 1;
            this.btnWork.Text = "Работа";
            this.btnWork.UseVisualStyleBackColor = true;
            this.btnWork.Click += new System.EventHandler(this.btnWork_Click);
            // 
            // lblA
            // 
            this.lblA.AutoSize = true;
            this.lblA.Location = new System.Drawing.Point(5, 35);
            this.lblA.Name = "lblA";
            this.lblA.Size = new System.Drawing.Size(65, 13);
            this.lblA.TabIndex = 2;
            this.lblA.Text = "Значение A";
            // 
            // lblB
            // 
            this.lblB.AutoSize = true;
            this.lblB.Location = new System.Drawing.Point(214, 35);
            this.lblB.Name = "lblB";
            this.lblB.Size = new System.Drawing.Size(65, 13);
            this.lblB.TabIndex = 3;
            this.lblB.Text = "Значение B";
            // 
            // txbA
            // 
            this.txbA.Location = new System.Drawing.Point(76, 32);
            this.txbA.Name = "txbA";
            this.txbA.Size = new System.Drawing.Size(100, 20);
            this.txbA.TabIndex = 4;
            // 
            // txbB
            // 
            this.txbB.Location = new System.Drawing.Point(285, 32);
            this.txbB.Name = "txbB";
            this.txbB.Size = new System.Drawing.Size(100, 20);
            this.txbB.TabIndex = 5;
            // 
            // lblResult
            // 
            this.lblResult.AutoSize = true;
            this.lblResult.Location = new System.Drawing.Point(12, 101);
            this.lblResult.Name = "lblResult";
            this.lblResult.Size = new System.Drawing.Size(35, 13);
            this.lblResult.TabIndex = 6;
            this.lblResult.Text = "label1";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(65, 181);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 7;
            this.button2.Text = "Разность";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(409, 226);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.lblResult);
            this.Controls.Add(this.txbB);
            this.Controls.Add(this.txbA);
            this.Controls.Add(this.lblB);
            this.Controls.Add(this.lblA);
            this.Controls.Add(this.btnWork);
            this.Controls.Add(this.btnRun);
            this.Name = "Form1";
            this.Text = "Асинхронный запуск";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnRun;
        private System.Windows.Forms.Button btnWork;
        private System.Windows.Forms.Label lblA;
        private System.Windows.Forms.Label lblB;
        private System.Windows.Forms.TextBox txbA;
        private System.Windows.Forms.TextBox txbB;
        private System.Windows.Forms.Label lblResult;
        private System.Windows.Forms.Button button2;
    }
}


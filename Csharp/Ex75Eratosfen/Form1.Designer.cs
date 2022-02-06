
namespace Ex75Eratosfen
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
            this.MaxValue = new System.Windows.Forms.TextBox();
            this.rTB = new System.Windows.Forms.RichTextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // MaxValue
            // 
            this.MaxValue.Location = new System.Drawing.Point(60, 41);
            this.MaxValue.Name = "MaxValue";
            this.MaxValue.Size = new System.Drawing.Size(100, 20);
            this.MaxValue.TabIndex = 0;
            this.MaxValue.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.MaxValue_KeyPress);
            // 
            // rTB
            // 
            this.rTB.Location = new System.Drawing.Point(48, 105);
            this.rTB.Name = "rTB";
            this.rTB.Size = new System.Drawing.Size(294, 293);
            this.rTB.TabIndex = 1;
            this.rTB.Text = "";
            // 
            // button1
            // 
            this.button1.Enabled = false;
            this.button1.Location = new System.Drawing.Point(459, 39);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "Run";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.rTB);
            this.Controls.Add(this.MaxValue);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox MaxValue;
        private System.Windows.Forms.RichTextBox rTB;
        private System.Windows.Forms.Button button1;
    }
}


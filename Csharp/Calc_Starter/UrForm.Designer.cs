
namespace SimpleCalculator
{
    partial class UrForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.numericA = new System.Windows.Forms.NumericUpDown();
            this.numericB = new System.Windows.Forms.NumericUpDown();
            this.numericC = new System.Windows.Forms.NumericUpDown();
            this.Save = new System.Windows.Forms.Button();
            this.Cancel = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.numericA)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericB)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericC)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(73, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(135, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Ввведите коэффициенты";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(21, 63);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(95, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "коэффициент \"a\"";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(21, 100);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(95, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "коэффициент \"b\"";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(21, 136);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(95, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "коэффициент \"c\"";
            // 
            // numericA
            // 
            this.numericA.Location = new System.Drawing.Point(136, 61);
            this.numericA.Minimum = new decimal(new int[] {
            100,
            0,
            0,
            -2147483648});
            this.numericA.Name = "numericA";
            this.numericA.Size = new System.Drawing.Size(120, 20);
            this.numericA.TabIndex = 4;
            // 
            // numericB
            // 
            this.numericB.Location = new System.Drawing.Point(136, 98);
            this.numericB.Minimum = new decimal(new int[] {
            100,
            0,
            0,
            -2147483648});
            this.numericB.Name = "numericB";
            this.numericB.Size = new System.Drawing.Size(120, 20);
            this.numericB.TabIndex = 5;
            // 
            // numericC
            // 
            this.numericC.Location = new System.Drawing.Point(136, 134);
            this.numericC.Minimum = new decimal(new int[] {
            100,
            0,
            0,
            -2147483648});
            this.numericC.Name = "numericC";
            this.numericC.Size = new System.Drawing.Size(120, 20);
            this.numericC.TabIndex = 6;
            // 
            // Save
            // 
            this.Save.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.Save.Location = new System.Drawing.Point(57, 213);
            this.Save.Name = "Save";
            this.Save.Size = new System.Drawing.Size(75, 23);
            this.Save.TabIndex = 7;
            this.Save.Text = "Сохранить";
            this.Save.UseVisualStyleBackColor = true;
            this.Save.Click += new System.EventHandler(this.Save_Click);
            // 
            // Cancel
            // 
            this.Cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.Cancel.Location = new System.Drawing.Point(181, 213);
            this.Cancel.Name = "Cancel";
            this.Cancel.Size = new System.Drawing.Size(75, 23);
            this.Cancel.TabIndex = 8;
            this.Cancel.Text = "Отмена";
            this.Cancel.UseVisualStyleBackColor = true;
            // 
            // UrForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(293, 271);
            this.Controls.Add(this.Cancel);
            this.Controls.Add(this.Save);
            this.Controls.Add(this.numericC);
            this.Controls.Add(this.numericB);
            this.Controls.Add(this.numericA);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "UrForm";
            this.Text = "UrForm";
            ((System.ComponentModel.ISupportInitialize)(this.numericA)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericB)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericC)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown numericA;
        private System.Windows.Forms.NumericUpDown numericB;
        private System.Windows.Forms.NumericUpDown numericC;
        private System.Windows.Forms.Button Save;
        private System.Windows.Forms.Button Cancel;
    }
}
namespace mtis_p3_cliente_net
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.buttonComprar = new System.Windows.Forms.Button();
            this.labelReferencia = new System.Windows.Forms.Label();
            this.labelUnidades = new System.Windows.Forms.Label();
            this.textBoxUnidades = new System.Windows.Forms.TextBox();
            this.labelOutput = new System.Windows.Forms.Label();
            this.comboBoxReferencia = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // buttonComprar
            // 
            this.buttonComprar.BackColor = System.Drawing.Color.OrangeRed;
            this.buttonComprar.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.buttonComprar.Location = new System.Drawing.Point(274, 199);
            this.buttonComprar.Name = "buttonComprar";
            this.buttonComprar.Size = new System.Drawing.Size(163, 44);
            this.buttonComprar.TabIndex = 0;
            this.buttonComprar.Text = "Comprar";
            this.buttonComprar.UseVisualStyleBackColor = false;
            this.buttonComprar.Click += new System.EventHandler(this.buttonComprar_Click);
            // 
            // labelReferencia
            // 
            this.labelReferencia.AutoSize = true;
            this.labelReferencia.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelReferencia.Location = new System.Drawing.Point(194, 74);
            this.labelReferencia.Name = "labelReferencia";
            this.labelReferencia.Size = new System.Drawing.Size(98, 25);
            this.labelReferencia.TabIndex = 1;
            this.labelReferencia.Text = "Producto";
            // 
            // labelUnidades
            // 
            this.labelUnidades.AutoSize = true;
            this.labelUnidades.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelUnidades.Location = new System.Drawing.Point(194, 134);
            this.labelUnidades.Name = "labelUnidades";
            this.labelUnidades.Size = new System.Drawing.Size(103, 25);
            this.labelUnidades.TabIndex = 2;
            this.labelUnidades.Text = "Unidades";
            // 
            // textBoxUnidades
            // 
            this.textBoxUnidades.BackColor = System.Drawing.SystemColors.MenuBar;
            this.textBoxUnidades.Location = new System.Drawing.Point(347, 134);
            this.textBoxUnidades.Name = "textBoxUnidades";
            this.textBoxUnidades.Size = new System.Drawing.Size(164, 22);
            this.textBoxUnidades.TabIndex = 4;
            // 
            // labelOutput
            // 
            this.labelOutput.AutoSize = true;
            this.labelOutput.Location = new System.Drawing.Point(248, 258);
            this.labelOutput.Name = "labelOutput";
            this.labelOutput.Size = new System.Drawing.Size(12, 17);
            this.labelOutput.TabIndex = 5;
            this.labelOutput.Text = " ";
            // 
            // comboBoxReferencia
            // 
            this.comboBoxReferencia.BackColor = System.Drawing.SystemColors.Menu;
            this.comboBoxReferencia.FormattingEnabled = true;
            this.comboBoxReferencia.Location = new System.Drawing.Point(347, 74);
            this.comboBoxReferencia.Name = "comboBoxReferencia";
            this.comboBoxReferencia.Size = new System.Drawing.Size(164, 24);
            this.comboBoxReferencia.TabIndex = 6;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(708, 314);
            this.Controls.Add(this.comboBoxReferencia);
            this.Controls.Add(this.labelOutput);
            this.Controls.Add(this.textBoxUnidades);
            this.Controls.Add(this.labelUnidades);
            this.Controls.Add(this.labelReferencia);
            this.Controls.Add(this.buttonComprar);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "MTIS - Práctica 3 - Proceso de Compra";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonComprar;
        private System.Windows.Forms.Label labelReferencia;
        private System.Windows.Forms.Label labelUnidades;
        private System.Windows.Forms.TextBox textBoxUnidades;
        private System.Windows.Forms.Label labelOutput;
        private System.Windows.Forms.ComboBox comboBoxReferencia;
    }
}


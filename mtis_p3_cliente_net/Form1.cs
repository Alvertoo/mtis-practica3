using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace mtis_p3_cliente_net
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonComprar_Click(object sender, EventArgs e)
        {
            String referencia = comboBoxReferencia.Text;
            String unidades = textBoxUnidades.Text;

            int unidadesProducto = 0;
            var isNumber = Int32.TryParse(unidades, out unidadesProducto);

            if(referencia.Equals("") || unidades.Equals(""))
            {
                MessageBox.Show("ERROR: Es obligatorio rellenar todos los campos");
            } else if (!isNumber)
            {
                MessageBox.Show("ERROR: El campo unidades es solo numérico");
            }  else
            {
                ServiceCompra.procesoCompraRequest request = new ServiceCompra.procesoCompraRequest();
                request.referenciaProducto = referencia;
                request.numeroUnidades = unidadesProducto;

                ServiceCompra.procesoCompraClient cliente = new ServiceCompra.procesoCompraClient();

                ServiceCompra.procesoCompraResponse response = cliente.process(request);

                if(response.compraRealizadaCorrectamente) { 
                    MessageBox.Show("Compra realizada correctamente");
                } else {
                    MessageBox.Show("Se ha producido un error durante el proceso de compra");
                }

            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            comboBoxReferencia.Items.Add("cama");
            comboBoxReferencia.Items.Add("carro");
            comboBoxReferencia.Items.Add("pizza");
            comboBoxReferencia.Items.Add("mesa");
            comboBoxReferencia.Items.Add("colacao");

            comboBoxReferencia.SelectedIndex = 0;
        }
    }
}

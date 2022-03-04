
package optiuam.vista;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import optiuam.controlador.Controlador;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 *
 */
public class VentanaPulso extends javax.swing.JFrame {
    private VentanaFuente ventanaFuente;//id de la ventana de la fuente !!
    String tipo="Gaussiano";
    /** Creates new form VentanaPulso */

    private Controlador controlador;
    public VentanaPulso() {
        initComponents();
        lbl_formula.setIcon(new ImageIcon("iconos/pulsoGaussiano.png"));
        btn_cancelar.setIcon(new ImageIcon("iconos/ico_cancelar.png"));
        btn_aplicar.setIcon(new ImageIcon("iconos/ico_aplicar.png"));
        
    }
    
    public void setVentanaFuente(VentanaFuente ventanaFuente){
        this.ventanaFuente= ventanaFuente;
    }
    
    public void setValores(float C,float A0,float W0,float T0,float M){
        txtf_chirp.setText(String.valueOf(C)); //chirp
        txtf_amplitud.setText(String.valueOf(A0));
        txtf_frecuencia.setText(String.valueOf(W0));
        txtf_anchura.setText(String.valueOf(T0));
        txtf_m.setText(String.valueOf(M));
        if(M>1){
            tipo="Supergaussiano";
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_aplicar = new javax.swing.JButton();
        lbl_formula = new javax.swing.JLabel();
        txtf_amplitud = new javax.swing.JTextField();
        txtf_anchura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtf_chirp = new javax.swing.JTextField();
        txtf_frecuencia = new javax.swing.JTextField();
        btn_graficar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtf_m = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración del Pulso");

        jLabel1.setText("Configuración del Pulso");

        jLabel3.setText("A0:");

        jLabel4.setText("T0:");

        jLabel5.setText("W0:");

        btn_cancelar.setText("Salir");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aplicar.setText("Aplicar");
        btn_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplicarActionPerformed(evt);
            }
        });

        lbl_formula.setText("jLabel6");

        jLabel6.setText("C:");

        btn_graficar.setText("Graficar Pulso");
        btn_graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_graficarActionPerformed(evt);
            }
        });

        jLabel7.setText("M:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_graficar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf_amplitud, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf_chirp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf_anchura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf_m, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_formula, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btn_aplicar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl_formula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtf_amplitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtf_chirp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtf_anchura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtf_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtf_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btn_aplicar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_graficar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicarActionPerformed
        if(validarValores()){
            float A0=Float.parseFloat(txtf_amplitud.getText());
            float T0=Float.parseFloat(txtf_anchura.getText());
            float W0=Float.parseFloat(txtf_frecuencia.getText());
            float C=Float.parseFloat(txtf_chirp.getText());
            float M=Float.parseFloat(txtf_m.getText());
            controlador.guardarPulso(A0,T0,W0,C,M,ventanaFuente.getId());
            ventanaFuente.setPulso(A0, T0, W0, C,M);
            if(M>1){
            tipo="Supergaussiano";
        }
            //System.out.println("C:"+C+" A0:"+A0+" W0:"+W0+ " T0:"+T0);
            JOptionPane.showMessageDialog(null,"Pulso modificado","éxito",JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_btn_aplicarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_graficarActionPerformed
        float [] valores = controlador.calcularPulso(ventanaFuente.getId());
        int n =valores.length;
        
        
        
        XYSeries series = new XYSeries("xy");
        
         //Introduccion de datos
                for(int i = -(n/2); i <(n/2) ; i++){
                        series.add(i,valores[(n/2)+i]);
                        //System.out.println(i+1+256+",,"+Ej[256+i].getRealPart());
                }
               

        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Pulso "+ tipo, // Título
                "Tiempo (x)", // Etiqueta Coordenada X
                "U(0,t)", // Etiqueta Coordenada Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Muestra la leyenda de los productos (Producto A)
                false,
                false
        );

         //Mostramos la grafica en pantalla
        ChartFrame frame = new ChartFrame("Pulso "+tipo, chart);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btn_graficarActionPerformed
    
    private boolean validarValores(){
        if (txtf_amplitud.getText().compareTo("")==0 || !txtf_amplitud.getText().matches("[+-]?\\d*(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Valor de la amplitud invalido","error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtf_anchura.getText().compareTo("")==0 || !txtf_anchura.getText().matches("[+-]?\\d*(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Valor de la anchura invalido","error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtf_chirp.getText().compareTo("")==0 || !txtf_chirp.getText().matches("[+-]?\\d*(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Valor del chirp invalido","error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtf_frecuencia.getText().compareTo("")==0 || !txtf_frecuencia.getText().matches("[+-]?\\d*(\\.\\d+)?")){
            JOptionPane.showMessageDialog(null,"Valor de la frecuencia invalido","error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
         if (txtf_m.getText().compareTo("")==0 || !txtf_m.getText().matches("[+-]?\\d*(\\.\\d+)?") || Float.parseFloat(txtf_m.getText() ) <1){
            JOptionPane.showMessageDialog(null,"Valor de M invalido","error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPulso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aplicar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_graficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_formula;
    private javax.swing.JTextField txtf_amplitud;
    private javax.swing.JTextField txtf_anchura;
    private javax.swing.JTextField txtf_chirp;
    private javax.swing.JTextField txtf_frecuencia;
    private javax.swing.JTextField txtf_m;
    // End of variables declaration//GEN-END:variables

}
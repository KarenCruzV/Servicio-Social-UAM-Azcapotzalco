
package optiuam.vista;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import optiuam.controlador.Controlador;

/**
 *
 *
 */
public class VentanaEmpalme extends javax.swing.JFrame {
    private final double perdidaMax = 0.5;
    private Controlador controlador;
    private String id ; //id del componente
    /** Creates new form VistaCople */
    public VentanaEmpalme() {
        initComponents();
        btn_eliminar.setIcon(new ImageIcon("iconos/ico_eliminar.png"));
        btn_cancelar.setIcon(new ImageIcon("iconos/ico_cancelar.png"));
        btn_aplicar.setIcon(new ImageIcon("iconos/ico_aplicar.png"));
        btn_desconectar.setIcon(new ImageIcon("iconos/ico_desconectar.png"));
        bgroup_window.add(rbutton_1310);
        bgroup_window.add(rbutton_1550);
        bgroup_tipo.add(rbutton_fusion);
        bgroup_tipo.add(rbutton_mecanico);
        rbutton_fusion.setSelected(true);
        rbutton_1310.setSelected(true);
        btn_eliminar.setVisible(false);
        lbl_conectarA.setVisible(false);
        cbox_conexion.setVisible(false);
        //separador.setVisible(false);
        btn_desconectar.setVisible(false);
    }
    
    //metodo para mostrar los elementos disponibles para conectar con el conector
    public void setElementos(ArrayList<String> elementos,String elemento_selecionado){
        cbox_conexion.removeAllItems();
        cbox_conexion.addItem(elemento_selecionado);
        for (int i = 0 ; i < elementos.size(); i++)
            cbox_conexion.addItem(elementos.get(i));
        if(elemento_selecionado.compareTo("")!=0)// si no esta conectado , no se muestra el boton desconectar
            btn_desconectar.setVisible(true);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void setValores(int window, int tipo,double perdida,String id){
        if(window == 1550)
            rbutton_1550.setSelected(true);
        if(tipo ==1)
            rbutton_mecanico.setSelected(true);
        
        txtf_perdida.setText(String.valueOf(perdida));
        btn_eliminar.setVisible(true);
        btn_aplicar.setText("Aplicar");
        this.id=id;
        lbl_conectarA.setVisible(true);
        cbox_conexion.setVisible(true);
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroup_window = new javax.swing.ButtonGroup();
        bgroup_tipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_aplicar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtf_perdida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbutton_1310 = new javax.swing.JRadioButton();
        rbutton_1550 = new javax.swing.JRadioButton();
        rbutton_fusion = new javax.swing.JRadioButton();
        rbutton_mecanico = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_conectarA = new javax.swing.JLabel();
        cbox_conexion = new javax.swing.JComboBox<>();
        btn_desconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Configuración del empalme óptico");

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aplicar.setText("Crear");
        btn_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplicarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        jLabel3.setText("Pérdida por inserción");

        jLabel4.setText("Longitud de onda");

        rbutton_1310.setText("1310 nm");

        rbutton_1550.setText("1550 nm");

        rbutton_fusion.setText("fusión");

        rbutton_mecanico.setText("mecánico");

        jLabel5.setText("dB");

        lbl_conectarA.setText("Conectar a:");

        cbox_conexion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_desconectar.setText("Desconectar");
        btn_desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_eliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_aplicar)))
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbutton_1310)
                                    .addComponent(rbutton_fusion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbutton_mecanico)
                                    .addComponent(rbutton_1550)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtf_perdida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_conectarA)
                                .addGap(18, 18, 18)
                                .addComponent(cbox_conexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_desconectar)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbutton_1310)
                    .addComponent(rbutton_1550))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbutton_fusion)
                    .addComponent(rbutton_mecanico)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtf_perdida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_conectarA)
                    .addComponent(cbox_conexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_desconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_aplicar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicarActionPerformed
        int tipo = 0; // 1 mecanico | 0 fusion
        int window = 1310;
        if(!rbutton_1310.isSelected())
            window=1550; 
        if(!rbutton_fusion.isSelected())
            tipo=1;

        if (txtf_perdida.getText().compareTo("")==0 || !txtf_perdida.getText().matches("[+-]?\\d*(\\.\\d+)?"))
            JOptionPane.showMessageDialog(null,"Valor de la pérdida invalido","error",JOptionPane.ERROR_MESSAGE);
        else if(Double.parseDouble(txtf_perdida.getText()) > perdidaMax || Double.parseDouble(txtf_perdida.getText()) < 0)
             JOptionPane.showMessageDialog(null,"La pérdida debe ser" + " min: 0" + " max: " + perdidaMax,"error",JOptionPane.ERROR_MESSAGE);
        else{
            if(btn_aplicar.getText().compareTo("Crear")==0){
            controlador.crearEmpalme(tipo,window,Double.parseDouble(txtf_perdida.getText()));
            JOptionPane.showMessageDialog(null,"Empalme creado","éxito",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            }
            else{
                controlador.modificarEmpalme(tipo,window,Double.parseDouble(txtf_perdida.getText()),
                                             id,cbox_conexion.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Empalme modificado","éxito",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        
        }
        
        
    }//GEN-LAST:event_btn_aplicarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        JOptionPane.showMessageDialog(null,"Empalme eliminado","éxito",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        controlador.eliminarElemento(id);
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desconectarActionPerformed
        if(cbox_conexion.getSelectedItem().toString().compareTo("")!=0){
            controlador.desconectarElemento(id);
            setElementos(controlador.elementosDisponibles("empalme", id), "");
            JOptionPane.showMessageDialog(null,"componente desconectado","éxito",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_desconectarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEmpalme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpalme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpalme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmpalme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmpalme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroup_tipo;
    private javax.swing.ButtonGroup bgroup_window;
    private javax.swing.JButton btn_aplicar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_desconectar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JComboBox<String> cbox_conexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_conectarA;
    private javax.swing.JRadioButton rbutton_1310;
    private javax.swing.JRadioButton rbutton_1550;
    private javax.swing.JRadioButton rbutton_fusion;
    private javax.swing.JRadioButton rbutton_mecanico;
    private javax.swing.JTextField txtf_perdida;
    // End of variables declaration//GEN-END:variables

}
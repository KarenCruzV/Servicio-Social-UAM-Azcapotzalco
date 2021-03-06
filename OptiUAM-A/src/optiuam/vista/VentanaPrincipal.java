
package optiuam.vista;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;



import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableModel;

import optiuam.controlador.Controlador;


/**
 *
 * 
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private Controlador controlador; // objeto de la clase controlador


    
    private DefaultTableModel tablaAuxiliar;

    /** Creates new form GeneralGUI */
    public VentanaPrincipal() {
        initComponents();
        this.setLocation(-10, 0);
        //this.setLocationRelativeTo(null);
        pnl_trabajo.setFondo("iconos/fondo.png");
        pnl_trabajo.updateUI();
        /*JLabel fondo_aux = new JLabel(new ImageIcon("iconos/fondo.png"));
        fondo_aux.setBounds(4, 13,1024,572);
        pnl_trabajo.add(fondo_aux);
        fondo_aux.setOpaque(false);
        fondo_aux.setVisible(true);
        
        pnl_trabajo.updateUI();
        */
       // Graphics grphcs = pnl_trabajo.getGraphics();
        //grphcs.drawImage(new ImageIcon("iconos/fondo.png").getImage(), 0, 0, getWidth(), getHeight(),pnl_trabajo);
        pnl_trabajo.repaint();
        
        btn_fibra.setIcon(new ImageIcon("iconos/ico_fibra.png"));
        btn_fuente.setIcon(new ImageIcon("iconos/ico_fuente.png"));
        btn_potencia.setIcon(new ImageIcon("iconos/ico_potencia.png"));
        btn_espectro.setIcon(new ImageIcon("iconos/ico_espectro.png"));
        btn_splitter.setIcon(new ImageIcon("iconos/ico_splitter.png"));
        btn_empalme.setIcon(new ImageIcon("iconos/ico_empalme.png"));
        btn_conector.setIcon(new ImageIcon("iconos/ico_conector.png"));
        //tablaElementos.setRowHeight(22);
        //tablaElementos.repaint();
        //tablaAuxiliar=(DefaultTableModel) tablaElementos.getModel();

        
        
        
    }
    
    
    //metodo para asignar un objeto de tipo controlador
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;

    }
    //metodo para actualizar a tabla de elementos cuando se agregue 
    //o se elimine un elementno
    public void actualizarTabla(ArrayList lista){
        
    }

    public JPanel getPnl_trabajo() {
        return pnl_trabajo;
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_componentes = new javax.swing.JPanel();
        btn_fibra = new javax.swing.JButton();
        btn_splitter = new javax.swing.JButton();
        btn_conector = new javax.swing.JButton();
        btn_empalme = new javax.swing.JButton();
        btn_potencia = new javax.swing.JButton();
        btn_espectro = new javax.swing.JButton();
        btn_fuente = new javax.swing.JButton();
        pnl_trabajo = new optiuam.vista.CustomJPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_guardar = new javax.swing.JMenuItem();
        menu_cargar = new javax.swing.JMenuItem();
        menu_ayuda = new javax.swing.JMenu();
        menu_acerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OptiUAM");
        setBackground(new java.awt.Color(153, 255, 255));
        setExtendedState(6);
        setForeground(new java.awt.Color(0, 153, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_componentes.setBackground(new java.awt.Color(255, 255, 255));
        pnl_componentes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Componentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 51))); // NOI18N

        btn_fibra.setToolTipText("Optical Fiber");
        btn_fibra.setBorder(null);
        btn_fibra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_fibraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_fibraMouseExited(evt);
            }
        });
        btn_fibra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fibraActionPerformed(evt);
            }
        });

        btn_splitter.setToolTipText("Splitter");
        btn_splitter.setBorder(null);
        btn_splitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_splitterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_splitterMouseExited(evt);
            }
        });
        btn_splitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_splitterActionPerformed(evt);
            }
        });

        btn_conector.setToolTipText("Connector");
        btn_conector.setBorder(null);
        btn_conector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_conectorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_conectorMouseExited(evt);
            }
        });
        btn_conector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectorActionPerformed(evt);
            }
        });

        btn_empalme.setToolTipText("Splice");
        btn_empalme.setBorder(null);
        btn_empalme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_empalmeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_empalmeMouseExited(evt);
            }
        });
        btn_empalme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_empalmeActionPerformed(evt);
            }
        });

        btn_potencia.setToolTipText("OPM");
        btn_potencia.setBorder(null);
        btn_potencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_potenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_potenciaMouseExited(evt);
            }
        });
        btn_potencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_potenciaActionPerformed(evt);
            }
        });

        btn_espectro.setToolTipText("OSM");
        btn_espectro.setBorder(null);
        btn_espectro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_espectroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_espectroMouseExited(evt);
            }
        });
        btn_espectro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_espectroActionPerformed(evt);
            }
        });

        btn_fuente.setToolTipText("OLS");
        btn_fuente.setBorder(null);
        btn_fuente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_fuenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_fuenteMouseExited(evt);
            }
        });
        btn_fuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fuenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_componentesLayout = new javax.swing.GroupLayout(pnl_componentes);
        pnl_componentes.setLayout(pnl_componentesLayout);
        pnl_componentesLayout.setHorizontalGroup(
            pnl_componentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_componentesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_fibra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_fuente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_splitter, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_conector, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_empalme, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_potencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_espectro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_componentesLayout.setVerticalGroup(
            pnl_componentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_fibra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_potencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_espectro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_splitter, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_empalme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_conector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_fuente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnl_trabajo.setBackground(new java.awt.Color(255, 255, 255));
        pnl_trabajo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Area de trabajo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 51))); // NOI18N
        pnl_trabajo.setOpaque(false);

        javax.swing.GroupLayout pnl_trabajoLayout = new javax.swing.GroupLayout(pnl_trabajo);
        pnl_trabajo.setLayout(pnl_trabajoLayout);
        pnl_trabajoLayout.setHorizontalGroup(
            pnl_trabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_trabajoLayout.setVerticalGroup(
            pnl_trabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 255), null, null));
        jMenuBar1.setForeground(new java.awt.Color(255, 0, 0));

        menu_archivo.setText("Archivo");

        menu_nuevo.setText("Nuevo");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_nuevo);

        menu_guardar.setText("Guardar");
        menu_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_guardarActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_guardar);

        menu_cargar.setText("Cargar");
        menu_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cargarActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_cargar);

        jMenuBar1.add(menu_archivo);

        menu_ayuda.setText("Ayuda");
        menu_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_ayudaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_ayuda);

        menu_acerca.setText("Acerca de ");
        menu_acerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_acercaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_acerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_componentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_trabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_componentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_trabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_fibraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fibraActionPerformed
        VentanaFibra fibra = new  VentanaFibra();
        fibra.setControlador(controlador);
        fibra.setVisible(true);//hacer la ventana visible
        fibra.setLocationRelativeTo(null); //mostrar la ventana en el centro de la pantalla
        
        
    
        
        //intentando hacer la tabla de botones 
        /*Vector<JButton> fila = new Vector();
        VentanaFibra ventana1 = new VentanaFibra();
        VentanaFibra ventana2 = new VentanaFibra();
        Object elemento []= {"HOLA"};
        BotonModificar boton_aux = new BotonModificar(ventana1, tablaElementos);
        TableColumn agregarColumn =tablaElementos.getColumnModel().getColumn(1);
        agregarColumn.setCellEditor(new myeditor(tablaElementos, ventana2));
        agregarColumn.setCellRenderer(new myrenderer(true));
       //tablaElementos.setColumnModel((TableColumnModel) agregarColumn);
        tablaAuxiliar.addRow(elemento);
        tablaElementos.setModel(tablaAuxiliar);
        tablaElementos.repaint();
        JButton boton = new JButton(new ImageIcon("iconos/ico_mod.png"));
        boton.setSize(22, 22);
        
        jPanel1.add(boton);
        jPanel1.updateUI();
        */
    }//GEN-LAST:event_btn_fibraActionPerformed

    private void btn_splitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_splitterActionPerformed
        VentanaSplitter splitter = new VentanaSplitter();
        splitter.setControlador(controlador);
        splitter.setLocationRelativeTo(null); //mostrar la ventana en el centro de la pantalla
        splitter.setVisible(true);
    }//GEN-LAST:event_btn_splitterActionPerformed

    private void btn_conectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectorActionPerformed
        VentanaConector conector = new VentanaConector();//ventana auxiliar para crear el conector
        conector.setControlador(controlador);
        conector.setLocationRelativeTo(null); //mostrar la ventana en el centro de la pantalla
        conector.setVisible(true);
    }//GEN-LAST:event_btn_conectorActionPerformed

    private void btn_empalmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_empalmeActionPerformed
        VentanaEmpalme empalme = new VentanaEmpalme();
        empalme.setControlador(controlador);
        empalme.setLocationRelativeTo(null); //mostrar la ventana en el centro de la pantalla
        empalme.setVisible(true);
    }//GEN-LAST:event_btn_empalmeActionPerformed

    private void btn_espectroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_espectroActionPerformed
        controlador.crearEspectro();
        JOptionPane.showMessageDialog(null,"Medidor de Espectro creado","??xito",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_espectroActionPerformed

    private void btn_fibraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fibraMouseEntered
        btn_fibra.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_fibraMouseEntered

    private void btn_fibraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fibraMouseExited
        btn_fibra.setBorder(null);
    }//GEN-LAST:event_btn_fibraMouseExited

    private void btn_fuenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fuenteMouseEntered
        btn_fuente.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_fuenteMouseEntered

    private void btn_fuenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fuenteMouseExited
        btn_fuente.setBorder(null);
    }//GEN-LAST:event_btn_fuenteMouseExited

    private void btn_splitterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_splitterMouseEntered
        btn_splitter.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_splitterMouseEntered

    private void btn_splitterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_splitterMouseExited
        btn_splitter.setBorder(null);
    }//GEN-LAST:event_btn_splitterMouseExited

    private void btn_conectorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conectorMouseEntered
        btn_conector.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_conectorMouseEntered

    private void btn_conectorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conectorMouseExited
        btn_conector.setBorder(null);
    }//GEN-LAST:event_btn_conectorMouseExited

    private void btn_empalmeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empalmeMouseEntered
        btn_empalme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_empalmeMouseEntered

    private void btn_empalmeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empalmeMouseExited
        btn_empalme.setBorder(null);
    }//GEN-LAST:event_btn_empalmeMouseExited

    private void btn_potenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_potenciaMouseEntered
        btn_potencia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_potenciaMouseEntered

    private void btn_potenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_potenciaMouseExited
        btn_potencia.setBorder(null);
    }//GEN-LAST:event_btn_potenciaMouseExited

    private void btn_espectroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_espectroMouseEntered
        btn_espectro.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }//GEN-LAST:event_btn_espectroMouseEntered

    private void btn_espectroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_espectroMouseExited
        btn_espectro.setBorder(null);
    }//GEN-LAST:event_btn_espectroMouseExited

    private void btn_fuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fuenteActionPerformed
        VentanaFuente fuente = new VentanaFuente();
        fuente.setControlador(controlador);
        fuente.setLocationRelativeTo(null); //mostrar la ventana en el centro de la pantalla
        fuente.setVisible(true);
    }//GEN-LAST:event_btn_fuenteActionPerformed

    private void btn_potenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_potenciaActionPerformed
        controlador.crearPotencia();
        JOptionPane.showMessageDialog(null,"Medidor de potencia creado","??xito",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_potenciaActionPerformed

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"??Desea crear un nuevo trabajo?","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
            controlador.nuevoTrabajo(); // empezar un nuevo trabajo
        }
        else{}
    }//GEN-LAST:event_menu_nuevoActionPerformed

    private void menu_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_guardarActionPerformed
        JFileChooser manejador = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("guardalo sin extension", "opt");
        manejador.setFileFilter(filtro);
        manejador.showSaveDialog(this);
        
        String ruta_archivo="";
        try {
        ruta_archivo = manejador.getSelectedFile().getPath();
        //System.out.println(ruta_archivo);
        controlador.guardarTrabajo(ruta_archivo);
        
            
        } catch (Exception e) {
            //no se hyace nada ya que esta excepcion se activa cuando se da click 
            //en cancelar o se cierra la ventana para cargar/guardad trabajo
        }
        
    }//GEN-LAST:event_menu_guardarActionPerformed

    private void menu_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cargarActionPerformed
        JFileChooser manejador = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("opt files", "opt");
        manejador.setFileFilter(filtro);
        manejador.showOpenDialog(this);
        String ruta_archivo="";
        try {
            ruta_archivo = manejador.getSelectedFile().getPath();
            System.out.println(ruta_archivo);
            controlador.abrirTrabajo(ruta_archivo);
         
            
        } catch (Exception e) {
            //no se hyace nada ya que esta excepcion se activa cuando se da click 
            //en cancelar o se cierra la ventana para cargar/guardad trabajo
        }
        
    }//GEN-LAST:event_menu_cargarActionPerformed

    private void menu_acercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_acercaMouseClicked
        VentanaAcercaDe acercaDe = new VentanaAcercaDe();
        acercaDe.setLocationRelativeTo(null);
        acercaDe.setVisible(true);
        System.out.println("dslkjhsa");
    }//GEN-LAST:event_menu_acercaMouseClicked

    private void menu_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_ayudaMouseClicked
        try {

            File objetofile = new File ("ayuda.pdf");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }
    }//GEN-LAST:event_menu_ayudaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"??Desea cerrar el simulador?","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION){
        System.exit(0); // terminar ejecucion del programa
        }
        else{}
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_conector;
    private javax.swing.JButton btn_empalme;
    private javax.swing.JButton btn_espectro;
    private javax.swing.JButton btn_fibra;
    private javax.swing.JButton btn_fuente;
    private javax.swing.JButton btn_potencia;
    private javax.swing.JButton btn_splitter;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_acerca;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JMenuItem menu_cargar;
    private javax.swing.JMenuItem menu_guardar;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JPanel pnl_componentes;
    private optiuam.vista.CustomJPanel pnl_trabajo;
    // End of variables declaration//GEN-END:variables

}

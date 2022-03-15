

package optiuam.vista;

import java.awt.Color;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import optiuam.controlador.Controlador;

/**
 *
 *
 */

public class ElementoGrafico{
    private Controlador controlador; 
    private JLabel dibujo; //etiqueta para colocar el elemento
    
                                    private JLabel title; //etiqueta del elemento.
                                    private JPopupMenu upMenu; //Menu desplegable
                                    
    private JPanel panel; // panel para dibujar el conector
    private String id; // identificador del dibujo, el mismo que el de el componente
    private String componente; // identificador del componente
    
    public ElementoGrafico(JPanel panel, String id, String componente,Controlador controlador,String title) {
        this.controlador= controlador;
        this.componente=componente;
        this.panel = panel;
        this.id = id;
        this.dibujo = new JLabel();
        this.title= new JLabel();
    }
    
    public void dibujarComponente(){
        
        if (componente.compareTo("splitter64")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter64.png"));
            dibujo.setBounds(10,20,100,75);
            title.setText(id);
            title.setBounds(15,45,200,48);
            
        }
        else if(componente.compareTo("splitter128")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter128.png"));
            dibujo.setBounds(10,20,150,113);
            title.setText(id);
            title.setBounds(15,45,200,48);
        }
        else if(componente.compareTo("splitter32")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter32.png"));
            dibujo.setBounds(10,20,75,56);
            title.setText(id);
            title.setBounds(15,45,200,48);
        }
        else if(componente.compareTo("splitter16")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter16.png"));
            dibujo.setBounds(10,20,51,38);
            title.setText(id);
            title.setBounds(15,45,200,48);
        }
        else if(componente.compareTo("fibra")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_fibra.png"));
            dibujo.setBounds(10,20,128,11);
            title.setText(id);
            title.setBounds(20,20,200,48);
        }
        else if(componente.compareTo("conector")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_conectorR.png"));
            dibujo.setBounds(10,20,55,13);
            title.setText(id);
            title.setBounds(20,20,200,48);
        }
        else if(componente.compareTo("empalme")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_empalmeR.png"));
            dibujo.setBounds(10,20,48,15);
            title.setText(id);
            title.setBounds(20,20,200,48);
        }
        
        else{
            dibujo.setIcon(new ImageIcon("iconos/dibujo_"+componente+"R.png"));
            dibujo.setBounds(15,15,43,48);
            title.setText(id);
            title.setBounds(15,45,200,48);
            
        }
        //dibujo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.add(dibujo);
        dibujo.setVisible(true);
        panel.add(title);
        title.setVisible(true);
        
        MouseAdapter ml =new MouseAdapter() {
            int x_pressed = 0;
            int y_pressed = 0;
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dibujarContorno(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                borrarContorno(evt);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                x_pressed = me.getX();
                y_pressed = me.getY();
            }
            
            //Localización de elementos
            @Override
            public void mouseDragged(MouseEvent me) {
                dibujo.setLocation(me.getXOnScreen()-x_pressed, me.getYOnScreen()- y_pressed-150);
                if(componente.compareTo("fibra")==0){
                    title.setLocation(me.getXOnScreen()-x_pressed+20, me.getYOnScreen()- y_pressed-150);
                }else if(componente.compareTo("conector")==0){
                    title.setLocation(me.getXOnScreen()-x_pressed+10, me.getYOnScreen()- y_pressed-150);
                }else if(componente.compareTo("empalme")==0){
                    title.setLocation(me.getXOnScreen()-x_pressed+10, me.getYOnScreen()- y_pressed-150);
                }else{
                    title.setLocation(me.getXOnScreen()-x_pressed, me.getYOnScreen()- y_pressed-120);
                }
                
                //dibujo.repaint();
                //panel.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                
                if(me.getButton()==1){//click izquierdo
                        controlador.mostrarVentanaElemento(id);
                        dibujarContorno(me);
                }
                if(me.getButton()==3){//click derecho
                        /*upMenu= new JPopupMenu("Opciones.");
                        JMenuItem duplicar =new JMenuItem("Duplicar");
                        upMenu.add(duplicar);
                        upMenu.addSeparator();
                        upMenu.add(new JMenuItem(" Girar. "));
                        upMenu.show(me.getComponent(), me.getX(), me.getY());
                        dibujarContorno(me);*/
                        ElementoGrafico ele= new ElementoGrafico(panel,id,componente,controlador,title.toString());
                        MenuEmergente menu = new MenuEmergente();
                        menu.setControlador(ele);
                        menu.setVisible(true);
                        menu.setLocation(me.getXOnScreen()-x_pressed+20, me.getYOnScreen()- y_pressed-50);
                        menu.setOpacity(0.8f);
                       
                }
            }
           
        };
        
        dibujo.addMouseListener(ml);
        dibujo.addMouseMotionListener(ml);
        dibujo.setToolTipText(id);
        panel.updateUI();
    }
    
    //acciones cuando el mouse esta sobre el elemento
    public void dibujarContorno(MouseEvent evt){
        dibujo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));   
    }
    public void borrarContorno(MouseEvent evt){
        dibujo.setBorder(null);
    }
    ///---------------------------------//
    public void eliminarEle(){
        borrarDibujo();
        controlador.eliminarElemento(id);
        panel.updateUI();
    }
    public void girarXd(){
        if(componente.compareTo("conector")==0){
            controlador.girarConector(id);
        }
        if(componente.compareTo("espectro")==0){
            controlador.girarEspectro(id);
        }
        if(componente.compareTo("fuente")==0){
            controlador.girarFuente(id);
        }
        if(componente.compareTo("potencia")==0){
            controlador.girarPotencia(id);
        }
        
        
        panel.updateUI();
    }
    public void borrarDibujo(){
        dibujo.setVisible(false);
        title.setVisible(false);
        panel.remove(dibujo);
        panel.remove(title);
    }

    public String getId() {
        return id;
    }
    
    public int getX(){
        return dibujo.getX();
    }
    
    public int getY(){
        return dibujo.getY();
    }
    
    public void setX(int x){
        dibujo.setLocation(x, dibujo.getY());
        title.setLocation(x, title.getY()-10);
    }
    
    public void setY(int y){
        dibujo.setLocation(dibujo.getX(),y);
        title.setLocation(title.getX(),y);
    }
    
    public void girarConector(char orientaion){
        Point aux = dibujo.getLocation();
        dibujo.setIcon(new ImageIcon("iconos/dibujo_conector"+orientaion+".png"));
            dibujo.setBounds(aux.x,aux.y,55,13);
           //dibujo.updateUI();
           //panel.updateUI();
    }
    
    public void girarEspectro(char orientaion){
        Point aux = dibujo.getLocation();
        dibujo.setIcon(new ImageIcon("iconos/dibujo_espectro"+orientaion+".png"));
            dibujo.setBounds(aux.x,aux.y,43,48);
           //dibujo.updateUI();15,15,43,48
           //panel.updateUI();
    }
    public void girarPotencia(char orientaion){
        Point aux = dibujo.getLocation();
        dibujo.setIcon(new ImageIcon("iconos/dibujo_potencia"+orientaion+".png"));
            dibujo.setBounds(aux.x,aux.y,43,48);
           //dibujo.updateUI();
           //panel.updateUI();
    }
    public void girarFuente(char orientaion){
        Point aux = dibujo.getLocation();
        dibujo.setIcon(new ImageIcon("iconos/dibujo_fuente"+orientaion+".png"));
            dibujo.setBounds(aux.x,aux.y,43,48);
           //dibujo.updateUI();
           //panel.updateUI();
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public JLabel getDibujo() {
        return dibujo;
    }

    public void setDibujo(JLabel dibujo) {
        this.dibujo = dibujo;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JPopupMenu getUpMenu() {
        return upMenu;
    }

    public void setUpMenu(JPopupMenu upMenu) {
        this.upMenu = upMenu;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }
    
}

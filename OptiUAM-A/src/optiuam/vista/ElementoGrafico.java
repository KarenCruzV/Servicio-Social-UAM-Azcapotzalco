

package optiuam.vista;

import java.awt.Color;
import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;
import optiuam.controlador.Controlador;

/**
 *
 *
 */

public class ElementoGrafico{
    private Controlador controlador; 
    private JLabel dibujo; //etiqueta para colocar el elemento
    private JPanel panel; // panel para dibujar el conector
    private String id; // identificador del dibujo, el mismo que el de el componente
    private String componente; // identificador del componente
    
    public ElementoGrafico(JPanel panel, String id, String componente,Controlador controlador) {
        this.controlador= controlador;
        this.componente=componente;
        this.panel = panel;
        this.id = id;
        this.dibujo = new JLabel();
    }
    
    public void dibujarComponente(){
        
        if (componente.compareTo("splitter64")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter64.png"));
            dibujo.setBounds(10,20,100,75);
        }
        else if(componente.compareTo("splitter128")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter128.png"));
            dibujo.setBounds(10,20,150,113);
        }
        else if(componente.compareTo("splitter32")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter32.png"));
            dibujo.setBounds(10,20,75,56);
        }
        else if(componente.compareTo("splitter16")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_splitter16.png"));
            dibujo.setBounds(10,20,51,38);
        }
        else if(componente.compareTo("fibra")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_fibra.png"));
            dibujo.setBounds(10,20,128,11);
        }
        else if(componente.compareTo("conector")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_conectorR.png"));
            dibujo.setBounds(10,20,55,13);
        }
        else if(componente.compareTo("empalme")==0){
            dibujo.setIcon(new ImageIcon("iconos/dibujo_empalme.png"));
            dibujo.setBounds(10,20,48,15);
        }
        
        else{
            dibujo.setIcon(new ImageIcon("iconos/dibujo_"+componente+".png"));
            dibujo.setBounds(15,15,43,48);
        }
        //dibujo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        panel.add(dibujo);
        dibujo.setVisible(true);
        
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
            
            @Override
            public void mouseDragged(MouseEvent me) {
       
                    dibujo.setLocation(me.getXOnScreen()-x_pressed, me.getYOnScreen()- y_pressed-150);
                //dibujo.repaint();
                //panel.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getButton()==3){//click derecho
                        controlador.mostrarVentanaElemento(id);
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

    public void borrarDibujo(){
        dibujo.setVisible(false);
        panel.remove(dibujo);
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
    }
    
    public void setY(int y){
        dibujo.setLocation(dibujo.getX(),y);
    }
    
    public void girarConector(char orientaion){
        Point aux = dibujo.getLocation();
        dibujo.setIcon(new ImageIcon("iconos/dibujo_conector"+orientaion+".png"));
            dibujo.setBounds(aux.x,aux.y,55,13);
           //dibujo.updateUI();
           //panel.updateUI();
    }
}

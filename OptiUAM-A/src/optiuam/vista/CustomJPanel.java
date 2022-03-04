/*
 * Desarrollado por Daniel Hernandez
 */

package optiuam.vista;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 *
 */
public class CustomJPanel extends JPanel {
    String fondo="iconos/fondo.png";
    

    @Override
    public void paint(Graphics grphcs) {
        
        //grphcs.drawImage(new ImageIcon("iconos/fondo.png").getImage(), 4, 13, getWidth()-30, getHeight()-30,this);
        if(fondo.compareTo("iconos/fondo.png")==0)
            grphcs.drawImage(new ImageIcon(fondo).getImage(), 2, 7, this);
        else
            grphcs.drawImage(new ImageIcon(fondo).getImage(),0, 0, this);
        
        setOpaque(false);
        super.paint(grphcs);
        
    }
    
    public void setFondo(String fondo){
        this.fondo = fondo;
    }
    
}

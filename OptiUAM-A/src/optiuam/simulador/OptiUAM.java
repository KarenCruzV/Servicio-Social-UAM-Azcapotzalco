
package optiuam.simulador;



import optiuam.controlador.Controlador;
import optiuam.vista.VentanaPrincipal;

public class OptiUAM {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        VentanaPrincipal ventana_principal = new VentanaPrincipal();
        
        controlador.setVentana_principal(ventana_principal);
        ventana_principal.setControlador(controlador);
        
        /*double B=2.5;
        double Dt=43.2;
        double Pd = -10 * Math.log10(1-((0.5)*Math.pow((Math.PI*(B*Math.pow(10, 9))),2)* Math.pow((Dt*Math.pow(10, -12)),2)));
        System.out.println(Pd);*/
        ventana_principal.setVisible(true);
    }
  
}
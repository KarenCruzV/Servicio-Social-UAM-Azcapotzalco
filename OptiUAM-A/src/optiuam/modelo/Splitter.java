
package optiuam.modelo;

import java.util.ArrayList;


public class Splitter extends Componente{
                          
    private int salidas;// numero de salidas del splitter optico
                        //0=2;1=4;2=8;3=16;4=32;5=64
    private double perdida_insercion;
    private int longitud_onda;
    private ArrayList<String> conexiones;
    
    public Splitter(int salidas,double perdida_insercion,int longitud_onda,String id){
        this.salidas=salidas;
        this.perdida_insercion = perdida_insercion;
        this.longitud_onda = longitud_onda;
        this.id_nombre=id;
        modificarSalidas(salidas);   
    }

    public Splitter() {
    }



    public int getSalidas() {
        return salidas;
    }

    public double getPerdida_insercion() {
        return perdida_insercion;
    }

    public int getLongitud_onda() {
        return longitud_onda;
    }

    public void setSalidas(int salidas) {
        if(this.salidas!=salidas)
            modificarSalidas(salidas);
        this.salidas = salidas;
    }

    public void setPerdida_insercion(double perdida_insercion) {
        this.perdida_insercion = perdida_insercion;
    }

    public void setLongitud_onda(int longitud_onda) {
        this.longitud_onda = longitud_onda;
    }
    
    public String getConexion(int salida){
        return conexiones.get(salida);
    }
    //asigna el elemento conectado en la salida indicada 
    public void setConexion(int salida,String componente){
        conexiones.remove(salida);
        conexiones.add(salida, componente);
    }
    //este metodo es exclusivo para cuando se carga un trabajo y contiene un splitter
    //asigna el elemento conectado en la salida indicada
    // es necesario ya que por alguna razon no inicializa el arreglo de conexiones
    public void cargarConexion(int salida,String componente){
       if(conexiones == null){
           modificarSalidas(salidas);
       }
        conexiones.remove(salida);
        conexiones.add(salida, componente);
       
    }
    
    private void modificarSalidas(int salidas){
        this.conexiones = new ArrayList();
        for(int i=0;i<((int) Math.pow(2,(salidas+1))); i++)
            conexiones.add("");
    }

    public ArrayList<String> getConexiones() {
        return conexiones;
    }
    //este metodo encuentra la salida a la que esta conectada el componente   
    public int buscarSalida(String idComponente){
        for(int i = 0;i<conexiones.size();i++)
            if(conexiones.get(i).compareTo(idComponente)==0)
                return i;
            
        return -1;    
    }
    @Override
    public String toString() {
        
        
        return super.toString()+","+salidas+","+perdida_insercion+","+longitud_onda;
    }
    
    public String Conexiones(){
        String aux="";// variable para guardar las conexiones creadas separadas con una coma;
        for(int i =0;i < conexiones.size();i++){
            if(i+1 == conexiones.size()){
                if(conexiones.get(i).compareTo("")==0)
                  aux=aux+" ";  
                else
                aux=aux + conexiones.get(i);
            }
            else{
                if(conexiones.get(i).compareTo("")==0)
                    aux=aux+" "+",";  
                else
                    aux=aux + conexiones.get(i)+",";
            }
        }
        
        return aux;
    } 
}

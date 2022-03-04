
package optiuam.modelo;


public class Conector extends Componente{
    private double perdida_insercion;// 0.5 max na min single fiber| 1.0 max na min multi fiber
    //private float reflectancia;// -35 max na min 
    private int longitud_onda; // 1360 max 1260 min 1310 nm window | 1580 max 1480 min 1550 nm window
    private int modo;
    private char orientacion ='R';
    
    public Conector(){
        
    }
    
    public Conector(int longitud_onda,int modo,double perdida_insercion,String id){
        this.perdida_insercion = perdida_insercion;
      //  this.reflectancia = reflectancia;
        this.longitud_onda = longitud_onda;
        this.modo=modo;
        this.id_nombre=id;
    }
    //--- metodos para asignar y obtener valores de los atributos

    public double getPerdida_insercion() {
        return perdida_insercion;
    }

    public void setPerdida_insercion(double perdida_insercion) {
        this.perdida_insercion = perdida_insercion;
    }

    public int getLongitud_onda() {
        return longitud_onda;
    }

    public void setLongitud_onda(int longitud_onda) {
        this.longitud_onda = longitud_onda;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public char getOrientacion() {
        return orientacion;
    }
    
    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }
    
    //--------------

    @Override
    public String toString() {
        return super.toString() +","+ perdida_insercion+","+longitud_onda+","+modo+","+orientacion;
    }
    
}
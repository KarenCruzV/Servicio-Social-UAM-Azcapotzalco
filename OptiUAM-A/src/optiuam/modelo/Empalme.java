
package optiuam.modelo;


public class Empalme extends Componente{
    private final double perdidaMax = .5;
    private int tipo; // 0 mecanico | 1 fusion
    private double perdida_insercion;// 50 max na min mecanico | 50 max na min fusion
    private int longitud_onda; // 1360 max 1260 min 1310 nm window | 1580 max 1480 min 1550 nm window

    public Empalme() {
    }
    
    public Empalme(int tipo, double perdida_insercion, int longitud_onda, String id){
        this.tipo = tipo;
        this.perdida_insercion = perdida_insercion;
        this.longitud_onda = longitud_onda;
        this.id_nombre = id;
    }

    public double getPerdidaMax() {
        return perdidaMax;
    }

    public String getId_nombre() {
        return id_nombre;
    }




    public int getTipo() {
        return tipo;
    }

    public double getPerdida_insercion() {
        return perdida_insercion;
    }

    public int getLongitud_onda() {
        return longitud_onda;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setPerdida_insercion(double perdida_insercion) {
        this.perdida_insercion = perdida_insercion;
    }

    public void setLongitud_onda(int longitud_onda) {
        this.longitud_onda = longitud_onda;
    }

    public void setId_nombre(String id_nombre) {
        this.id_nombre = id_nombre;
    }

    @Override
    public String toString() {
        return super.toString()+","+tipo+","+perdida_insercion+","+longitud_onda;
    }
    
    
}

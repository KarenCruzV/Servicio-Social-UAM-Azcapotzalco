
package optiuam.modelo;


public class Fibra extends Componente{
    private int longitud_onda; // 1360 max 1260 min 1310 nm window | 1580 max 1480 min 1550 nm window
    private int modo; // 0 monomodo | 1 multimodo
    private int tipo; // 0 smf28 | 1 mm50 | 2 otro
    private double longitud_km;// longitud del cable de fibra optica 
    private double dispersion;// smf28 1310 = 0 1550 = 18
                              // mm50 1310 = 3.5
                              // otra  cualquier valor para ambas waves
    
    private double atenuacion; // para smf28 0.32 1310 nm window | 0.18 1550 nm window db/km
                               //para mm50 // 1550 <=.36 dB/KM
    // 

    public Fibra(int longitud_onda, int modo, int tipo, double longitud_km,double atenuacion,double dispersion,String id) {
        this.longitud_onda = longitud_onda;
        this.modo = modo;
        this.tipo = tipo;
        this.longitud_km = longitud_km;
        this.dispersion = dispersion;
        this.id_nombre=id;
        this.atenuacion=atenuacion;
        
    }

    public Fibra() {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getLongitud_km() {
        return longitud_km;
    }

    public void setLongitud_km(double longitud_km) {
        this.longitud_km = longitud_km;
    }

    public double getDispersion() {
        return dispersion;
    }

    public void setDispersion(double dispersion) {
        this.dispersion = dispersion;
    }

    public double getAtenuacion() {
        return atenuacion;
    }

    public void setAtenuacion(double atenuacion) {
        this.atenuacion=atenuacion;
        
    }

    @Override
    public String toString() {
        return super.toString()+","+longitud_onda +","+modo +","+tipo +","+longitud_km +","+dispersion +","+atenuacion ;
    }
    
    
    
}


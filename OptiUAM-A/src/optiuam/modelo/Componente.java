

package optiuam.modelo;


public class Componente {
    //nombre para identificar el componente
    protected String id_nombre;
    //atributo para saber si esta conectado y a que esta conectado
    protected String elementoConectado="";
    protected boolean conectado;

    public String getElementoConectado() {
        return elementoConectado;
    }

    public void setElementoConectado(String elementoConectado) {
        this.elementoConectado = elementoConectado;
    }
    
    public String getId_nombre() {
        return id_nombre;
    }

    public void setId_nombre(String id_nombre) {
        this.id_nombre = id_nombre;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String toString() {
        return id_nombre + "," + conectado +","+ elementoConectado;
    }
}

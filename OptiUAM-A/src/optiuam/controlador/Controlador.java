
package optiuam.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import optiuam.modelo.Componente;
import optiuam.modelo.Conector;
import optiuam.modelo.Empalme;
import optiuam.modelo.Fibra;
import optiuam.modelo.Fuente;
import optiuam.modelo.MedidorEspectro;
import optiuam.modelo.MedidorPotencia;
import optiuam.modelo.Splitter;
import optiuam.vista.ElementoGrafico;

import optiuam.vista.VentanaConector;
import optiuam.vista.VentanaEmpalme;
import optiuam.vista.VentanaEspectro;
import optiuam.vista.VentanaFibra;
import optiuam.vista.VentanaFuente;
import optiuam.vista.VentanaPotencia;
import optiuam.vista.VentanaPrincipal;
import optiuam.vista.VentanaSplitter;

/**
 *
 *
 */
public class Controlador {

    private ArrayList<Componente> elementos; // contiene los elementos creados en la simulacion
    private ArrayList<ElementoGrafico> dibujos; //Contiene los elementos mostrados en el panel
    private int contadorElemento; // contador para asignar id a un elemento
    private VentanaPrincipal ventana_principal;//para tener la comunicacion vista-controlador
    private ElementoGrafico manejadorElementos; // para crear los elementos graficos

    public Controlador() {
        contadorElemento = 0;
        elementos = new ArrayList();
        dibujos = new ArrayList();

    }

    public void crearFibra(int window, int modo, int tipo, double longitud_km, double atenuacion, double dispersion) {
        Fibra fibra_aux = new Fibra(window, modo, tipo, longitud_km, atenuacion, dispersion, "fibra" + String.valueOf(contadorElemento));
        elementos.add(fibra_aux);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), "fibra" + String.valueOf(contadorElemento), "fibra", this,"fibra");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
        //System.out.println(fibra_aux.toString());
    }

    public void modificarFibra(int window, int modo, int tipo, double longitud_km,
                               double atenuacion, double dispersion, String id,String componente) {
        Fibra fibra = (Fibra) obtenerElemento(id);
        fibra.setLongitud_onda(window);
        fibra.setModo(modo);
        fibra.setTipo(tipo);
        fibra.setLongitud_km(longitud_km);
        fibra.setDispersion(dispersion);
        fibra.setAtenuacion(atenuacion);
        if (componente.compareTo(fibra.getElementoConectado()) != 0) { //es otro componente a conectar
            if (fibra.getElementoConectado().compareTo("") != 0) { // para desconectar el que tenia antes
                obtenerElemento(fibra.getElementoConectado()).setConectado(false);
            }
            fibra.setElementoConectado(componente);
            obtenerElemento(componente).setConectado(true);
        }
       // System.out.println(fibra.toString());
    }

    public void crearConector(int window, int modo, double perdida) {
        Conector conector = new Conector(window, modo, perdida, "conector" + String.valueOf(contadorElemento));
        elementos.add(conector);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), "conector" + 
                String.valueOf(contadorElemento), "conector", this,"conector");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
    }

    public void modificarConector(int window, int modo, double perdida, String id, String componente) {
        Conector conector = (Conector) obtenerElemento(id);
        conector.setLongitud_onda(window);
        conector.setModo(modo);
        conector.setPerdida_insercion(perdida);
        if (componente.compareTo(conector.getElementoConectado()) != 0) { //es otro componente a conectar
            if (conector.getElementoConectado().compareTo("") != 0) { // para desconectar el que tenia antes
                obtenerElemento(conector.getElementoConectado()).setConectado(false);
            }
            conector.setElementoConectado(componente);
            obtenerElemento(componente).setConectado(true);
        }
    }

    public void crearEmpalme(int tipo, int window, double perdida) {
        Empalme empalme = new Empalme(tipo, perdida, window, "empalme" + String.valueOf(contadorElemento));
        elementos.add(empalme);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), "empalme" + 
                String.valueOf(contadorElemento), "empalme", this,"empalme");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
    }

    public void modificarEmpalme(int tipo, int window, double perdida, String id,String componente) {
        Empalme aux = (Empalme) obtenerElemento(id);
        aux.setLongitud_onda(window);
        aux.setPerdida_insercion(perdida);
        aux.setTipo(tipo);
        if (componente.compareTo(aux.getElementoConectado()) != 0) {
            if (aux.getElementoConectado().compareTo("") != 0) {
                obtenerElemento(aux.getElementoConectado()).setConectado(false);
            }
            aux.setElementoConectado(componente);
            obtenerElemento(componente).setConectado(true);
        }
    }

    public void crearFuente(int window, int tipo, double potencia, double anchura, double velocidad) {
        Fuente fuente = new Fuente(tipo, potencia, anchura, velocidad, window, "fuente" + String.valueOf(contadorElemento));
        
        elementos.add(fuente);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), "fuente" + 
                String.valueOf(contadorElemento), "fuente", this,"fuente");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
    }

    public void modificarFuente(int window, int tipo, double potencia, double anchura, double velocidad, String id, String componente) {
        Fuente fuente = (Fuente) obtenerElemento(id);
        fuente.setLongitud_onda(window);
        fuente.setTipo(tipo);
        fuente.setPotencia(potencia);
        fuente.setAnchura(anchura);
        fuente.setVelocidad(velocidad);
        if (componente.compareTo(fuente.getElementoConectado()) != 0) {
            if (fuente.getElementoConectado().compareTo("") != 0) {
                obtenerElemento(fuente.getElementoConectado()).setConectado(false);
            }
            fuente.setElementoConectado(componente);
            obtenerElemento(componente).setConectado(true);
        }
    }
    public void guardarPulso(float A0,float T0,float W0,float C,float M,String id){
        Fuente fuente = (Fuente) obtenerElemento(id);
        //System.out.println("C:"+C+" A0:"+A0+" W0:"+W0+ " T0:"+T0);
        fuente.setPulso(A0, T0, W0, C,M);
    }

    public void crearSplitter(int window, int salidas, double perdida) {
        Splitter splitter = new Splitter(salidas, perdida, window, "splitter" + String.valueOf(contadorElemento));
        elementos.add(splitter);
        String aux = "splitter16"; //guarda el tipo de splitter //< 16 salidas
        //saber que tipo de splitter
        if (salidas == 3) {//32 salidas
            aux = "splitter32";
        }
        if (salidas == 4) {//64 salidas
            aux = "splitter64";
        }
        if (salidas == 5) {//128 salidas
            aux = "splitter128";
        }

        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(),
                "splitter" + String.valueOf(contadorElemento), aux, this,"splitter");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
        //System.out.println(splitter.toString());
    }
    
    //este metodo conecta la salida n del splitter a un componente
    public boolean conectarSplitter(String id,int salida,String componente){
        Splitter splitter = (Splitter) obtenerElemento(id);
        if (componente.compareTo(splitter.getConexion(salida)) != 0) { 
            if (splitter.getConexion(salida).compareTo("") != 0) {
                obtenerElemento(splitter.getConexion(salida)).setConectado(false);
            }
            splitter.setConexion(salida, componente);
            obtenerElemento(componente).setConectado(true);
            return true;
        }
        return false;
        //for(int i =0;i < splitter.getConexiones().size(); i++){
            //System.out.println(" salida : " +i+" conexion >"+splitter.getConexion(i) );
        //}
        
    }
    
    public void modificarSplitter(int window, int salidas, double perdida, String id) {
        Splitter aux = (Splitter) obtenerElemento(id);
        if(aux.getSalidas()!=salidas){
            
            for(int i = 0; i < aux.getConexiones().size(); i++){ //se desconecta de los elementos a los que se conecto ->
                if(obtenerElemento(aux.getConexion(i))!= null)
                    obtenerElemento(aux.getConexion(i)).setConectado(false);
            }
            aux.setSalidas(salidas);
        }
        aux.setLongitud_onda(window);
        aux.setPerdida_insercion(perdida);
    }
    
    public void crearEspectro(){
        MedidorEspectro espectro = new MedidorEspectro("espectro" + String.valueOf(contadorElemento));
        elementos.add(espectro);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(),
                "espectro" + String.valueOf(contadorElemento), "espectro", this,"espectro");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
    }
    
    public float[] calcularPulsoEntrada(String id){
        MedidorEspectro espectro = (MedidorEspectro) obtenerElemento(id);
        ArrayList<Componente> lista = conexionesElemento(id);
        if(lista == null)
            return null;
        else{
            //se obtiene la fuente para saber la configuracion del pulso
            Fuente fuente = (Fuente) lista.get(lista.size()-1); 
            //se le pasa la configuracion del pulso al medidor de espectro
            return espectro.pulsoEntrada(fuente.getA0(), fuente.getT0(),fuente.getW0(), fuente.getC(),fuente.getM());
        }
    }
    
    //Al igual que en el metodo a anterior se vuelve a buscar todos los elementos del enlace
    //para comprobar que el enlace es correcto
    //tambien se vuelve a evaluar el puslo por si se cambio algun valor
    public float[] calcularPulsoSalidaB2(String id){
        MedidorEspectro espectro = (MedidorEspectro) obtenerElemento(id);
        ArrayList<Componente> lista = conexionesElemento(id);
        if(lista == null)
            return null;
        else{
            //se obtiene la fuente para saber la configuracion del pulso
            Fuente fuente = (Fuente) lista.get(lista.size()-1); 
            //se le pasa la configuracion del pulso al medidor de espectro
            return espectro.pulsoSalidaB2(fuente.getA0(), fuente.getT0(),fuente.getW0(), fuente.getC(),fuente.getM(),lista);
        }
    }
    
    
    public float [] calcularPulso(String id){
        Fuente fuente = (Fuente) obtenerElemento(id);
        return fuente.calcularPulso();
    }

    public void crearPotencia() {
        MedidorPotencia potencia = new MedidorPotencia("potencia" + String.valueOf(contadorElemento));
        elementos.add(potencia);
        manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(),
                "potencia" + String.valueOf(contadorElemento), "potencia", this,"potencia");
        dibujos.add(manejadorElementos);
        manejadorElementos.dibujarComponente();
        contadorElemento++;
    }

    public double calcularPotencia(String id,Double sensibilidad) {
        MedidorPotencia aux = (MedidorPotencia) obtenerElemento(id);
        if(sensibilidad!=aux.getSensibilidad())//si aun un cambio en el valor de la sensibilidad
            aux.setSensibilidad(sensibilidad);//lo guarda
        ArrayList<Componente> lista = conexionesElemento(id);
        if(lista == null)
            return -1;
        else{
            //for(int i = lista.size() -1;i >=0; i--)
                //System.out.println(lista.get(i).getId_nombre());
            return aux.calcularPotencia(lista);
        }
    }
    
    //este metodo busca la serie de elementos que estan conectados y terminan en
    //algun elemento especificado por un id
    public ArrayList<Componente> conexionesElemento(String id){
        String componente;
        ArrayList<Componente> aux = new ArrayList();
        //primero busca si esta conectado a un splitter
        componente= conexiones_Splitter(id);
        if(componente.compareTo("")==0)
            componente = buscarConexion(id);
        while(componente.compareTo("")!=0){
            aux.add(obtenerElemento(componente));
            if(componente.contains("conector")){
                for(int i =0;i<elementos.size();i++){
                    if(elementos.get(i).getId_nombre().contains("splitter")){
                        Splitter splitter = (Splitter) elementos.get(i);
                        for(int j=0; j< splitter.getConexiones().size();j++){
                            if(splitter.getConexion(j).compareTo(componente)==0){
                                aux.add(splitter);
                                componente=splitter.getId_nombre();
                            }   
                        }
                    }
                }
                
            }
            if(componente.contains("fuente")){
                return aux;
            }
            componente = buscarConexion(componente);
        }
        return null;
    }
    
    //este metodo busca un elemento en alguna salida de todos los splitters creados
    public String conexiones_Splitter(String id){
        for(int i =0;i < elementos.size();i++){
            if(elementos.get(i).getId_nombre().contains("splitter")){
                if(elementoSplitter(elementos.get(i).getId_nombre(), id)){
                    return elementos.get(i).getId_nombre();
                }
            }
        }
        return "";
    }
    
    //este metodo crea un array de los elementos disponibles para cada tipo de elemento
    public ArrayList<String> elementosDisponibles(String tipoComponente,String id) {
        //Componente aux = 
        ArrayList<String> aux = new ArrayList();
        for (int i = 0; i < elementos.size(); i++) {
            if (tipoComponente.compareTo("fuente") == 0) {
                if (!elementos.get(i).isConectado() && elementos.get(i).getId_nombre().contains("conector")//si encuentra un conector
                    && (elementos.get(i).getElementoConectado().compareTo("")==0 || //el conector no se ha conectado a nada
                        elementos.get(i).getElementoConectado().contains("fibra"))) { //el conector puede estar conectado a una fibra
                    aux.add(elementos.get(i).getId_nombre());
                }
            }
            else if(tipoComponente.compareTo("conector") == 0){
                if (!elementos.get(i).isConectado() &&((elementos.get(i).getId_nombre().contains("fibra")&& // si encuentra una fibra
                                                        !buscarConexion(id).contains("fibra") && // no debe venir conectado de otra fibra
                                                       (buscarConexion(id).contains("fuente") || //puede  venir conectado de fuente
                                                        buscarConexion(id).contains("") || //puede no venir estar conectado
                                                        buscarConexion(id).contains("splitter")))||//puede venir conectado de un splitter
                                                        ((elementos.get(i).getId_nombre().contains("potencia")||//si encuentra un medidor de potencia
                                                          elementos.get(i).getId_nombre().contains("espectro"))&& // o espectro
                                                         (!buscarConexion(id).contains("fuente")&&//no debe venir conectado de una fuente
                                                         !buscarConexion(id).contains("splitter") &&//no debe venir conectado de un splitter
                                                         !obtenerElemento(id).getElementoConectado().contains("fibra"))&& //no debe estar conectado a una fibra
                                                        (buscarConexion(id).contains("fibra") || // puede venir conectado conectado de una fibra
                                                         buscarConexion(id).contains(""))) || // puede no estar conectado 
                                                        (elementos.get(i).getId_nombre().contains("splitter")&& // si encuentra un splitter
                                                        (!buscarConexion(id).contains("fuente")&& // no debe estar conectado a una fuente
                                                        !elementoSplitter(elementos.get(i).getId_nombre(), id))&& // no debe estar conectado a un splitter
                                                        (buscarConexion(id).contains("fibra") || //puede estar conectado a una fibra
                                                         buscarConexion(id).contains(""))))){  // puede no estar conectado
                                                          
                                                    
                    aux.add(elementos.get(i).getId_nombre());
                }
            }
            else if(tipoComponente.compareTo("fibra") ==0){
                if (!elementos.get(i).isConectado()&&(((elementos.get(i).getId_nombre().contains("conector")&& //si encuentra un cobnector
                                                        !buscarConexion(id).contains("fuente") && //no debe venir conectado de fuente
                                                        !buscarConexion(id).contains("splitter")&&//no debe venir conectado de un splitter
                                                        !elementos.get(i).getElementoConectado().contains("fibra")))|| // no debe estar conectado a una fibra
                                                       (elementos.get(i).getId_nombre().contains("empalme")/*&&//si encuentra un empalme
                                                        !elementos.get(i).getElementoConectado().contains("fibra")*/))){//no debe estar conectado a una fibra
                    aux.add(elementos.get(i).getId_nombre());
                }
            }
            else if(tipoComponente.compareTo("empalme") ==0){
                if (!elementos.get(i).isConectado()&&(elementos.get(i).getId_nombre().contains("fibra")&& //si encuentra una fibra)
                                                      elementos.get(i).getElementoConectado().compareTo(id)!=0)){ // no debe venir conetado de la misma fibra
                    aux.add(elementos.get(i).getId_nombre());
                }
            }
            
            else{}
        }
        return aux;
    }
    //este metodo retorna true o false si un elemento ya esta conectadoa una salida de un splitter
    public boolean elementoSplitter(String id_splitter,String id_elemento){
        Splitter splitter = (Splitter) obtenerElemento(id_splitter);
        for(int i = 0;i < splitter.getConexiones().size();i++)
            if(splitter.getConexion(i).compareTo(id_elemento)==0)
                return true; 
        return false;
    }
    
    //este metodo crea un array de los elementos disponibles para las salidas del splitter
    public ArrayList<String> elementosDisponibles(String id) {
        ArrayList<String> aux = new ArrayList();
        for (int i = 0; i < elementos.size(); i++) {
            if (!elementos.get(i).isConectado() && elementos.get(i).getId_nombre().contains("conector")//si encuentra un conector
                    && (elementos.get(i).getElementoConectado().compareTo("")==0 || //el conector no se ha conectado a nada
                        elementos.get(i).getElementoConectado().contains("fibra"))) { //el conector puede estar conectado a una fibra
                    aux.add(elementos.get(i).getId_nombre());
                }
            if (!elementos.get(i).isConectado() && (elementos.get(i).getId_nombre().contains("potencia")
                                                    ||elementos.get(i).getId_nombre().contains("splitter")//si encuentra un medidor de potencia
                                                    &&elementos.get(i).getId_nombre().compareTo(id)!=0)//no se puede conectar a el mismo
                    /* && (elementos.get(i).getElementoConectado().compareTo("")==0 || //el conector no se ha conectado a nada
                        elementos.get(i).getElementoConectado().contains("fibra"))*/) { //el conector puede estar conectado a una fibra
                    aux.add(elementos.get(i).getId_nombre());
                }
        }
        return aux;
    }
    
    //este metodo encuentra el id del elemento que se conecto al componente 
    // aux -> id_componente
    public String buscarConexion(String id_componente){
        String aux =""; //almacena el id del componente  
        for(int i = 0; i< elementos.size();i++){
            if(elementos.get(i).getId_nombre().contains("splitter")){
                if(elementoSplitter(elementos.get(i).getId_nombre(), id_componente))
                    return elementos.get(i).getId_nombre();
            }
            if (elementos.get(i).getElementoConectado().compareTo(id_componente)==0)
                aux=elementos.get(i).getId_nombre();
        }
        return aux;
    }
    

    //este metodo elimina la conexion de un elemento
    public void desconectarElemento(String id){
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId_nombre().compareTo(id) == 0) {
                for(int j = 0; j < elementos.size(); j++){
                    
                    if (elementos.get(j).getId_nombre().compareTo(elementos.get(i).getElementoConectado()) == 0 &&
                        elementos.get(i).getElementoConectado().compareTo("")!=0){ //se desconecta el elemento al que se conecto
                        elementos.get(j).setConectado(false);
                        elementos.get(i).setElementoConectado("");
                    }
                }
            }
        }
    }
    //este metodo elimina la conexion de la salida de un splitter
    public void desconectarElemento(String id,int salida){
        Splitter splitter = (Splitter) obtenerElemento(id);
        for(int i =0;i < elementos.size(); i++){
            if (elementos.get(i).getId_nombre().compareTo(splitter.getConexion(salida)) == 0 &&
                        splitter.getConexion(salida).compareTo("")!=0){ //se desconecta el elemento al que se conecto
                elementos.get(i).setConectado(false);
                splitter.setConexion(salida, "");
            }
            
            //desconectar de un elemento que ya se ha eliminado y solo queda su id
            //comprueba que ya se haya buscado en todos los elementos disponibles
            else if(i+1 ==elementos.size())
                splitter.setConexion(salida, "");
                
        }
        
        //for(int i =0;i < splitter.getConexiones().size(); i++){
          //  System.out.println(" salida : " +i+" conexion >"+splitter.getConexion(i) );
        //}
      
    }
    
    //este metodo valida la seleccion de elemento a conectar
   /* public boolean validarConexion(String componente, String id){
        if (componente.compareTo("") != 0) {
            if()
            obtenerElemento(id).setElementoConectado(componente);
            obtenerElemento(componente).setConectado(true);
        }
      return true;
    }
*/
    //este metodo elimina un elemento junto a su dibujo en base a su id
    public void eliminarElemento(String id) {
        
        if(!id.contains("splitter")){ // otros que no sean  splitter
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId_nombre().compareTo(id) == 0) {
                for(int j = 0; j < elementos.size(); j++){
                    if(elementos.get(j).getElementoConectado().compareTo(elementos.get(i).getId_nombre())==0){//se desconecta del elemento conectado a el  
                       elementos.get(j).setElementoConectado("");
                    }
                    if (elementos.get(j).getId_nombre().compareTo(elementos.get(i).getElementoConectado()) == 0 &&
                        elementos.get(i).getElementoConectado().compareTo("")!=0) //se desconecta el elemento al que se conecto
                        elementos.get(j).setConectado(false);
                    
                }
                String idSplitter;
                if((idSplitter=conexiones_Splitter(id)).compareTo("")!=0){//comprueba si esta conectado a un splitter
                    Splitter splitter = (Splitter)obtenerElemento(idSplitter);
                    splitter.setConexion(splitter.buscarSalida(id),"");
                }
                
                elementos.remove(i); // se elimina el elemento
           
            }
        }
        }
        else{//para eliminar el splitter
            Splitter splitter = (Splitter) obtenerElemento(id);
            
            for(int i = 0; i < splitter.getConexiones().size(); i++){ //se desconecta los elementos a los que se conecto ->
                if(obtenerElemento(splitter.getConexion(i))!= null)
                    obtenerElemento(splitter.getConexion(i)).setConectado(false);
            }
            for (int i = 0; i < elementos.size(); i++) { // se desconecta del elemento conectado a el <-
            if (elementos.get(i).getId_nombre().compareTo(id) == 0) {
                    if(buscarConexion(id).compareTo("")!=0)// si un elemento se conecto al splitter
                        obtenerElemento(buscarConexion(id)).setElementoConectado("");
                    elementos.remove(i); // se elimina el splitter
                }
            }
        }
        
        
        for (int i = 0; i < dibujos.size(); i++) {
            if (dibujos.get(i).getId().compareTo(id) == 0) {
                dibujos.get(i).borrarDibujo();
                dibujos.remove(i);
            }
        }

    }

    //este metodo es para mostrar la ventana de algun elemento a modificar en base al id
    public void mostrarVentanaElemento(String id) {
        String id_aux = separarId(id);
        switch (id_aux) {
            case "conector":
                VentanaConector ventanaConector = new VentanaConector();
                ventanaConector.setControlador(this);
                Conector conector = (Conector) obtenerElemento(id);
                ventanaConector.setValores(conector.getLongitud_onda(), conector.getModo(), conector.getPerdida_insercion(), id);
                ventanaConector.setElementos(elementosDisponibles(id_aux,id),conector.getElementoConectado());
                ventanaConector.setLocationRelativeTo(null);
                ventanaConector.setTitle(id);
                ventanaConector.setVisible(true);
                break;
            case "empalme":
                VentanaEmpalme ventanaEmpalme = new VentanaEmpalme();
                ventanaEmpalme.setControlador(this);
                Empalme aux = (Empalme) obtenerElemento(id);
                ventanaEmpalme.setValores(aux.getLongitud_onda(), aux.getTipo(), aux.getPerdida_insercion(), id);
                ventanaEmpalme.setElementos(elementosDisponibles(id_aux,id),aux.getElementoConectado());
                ventanaEmpalme.setLocationRelativeTo(null);
                ventanaEmpalme.setTitle(id);
                ventanaEmpalme.setVisible(true);
                break;
            case "splitter":
                VentanaSplitter ventanaSplitter = new VentanaSplitter();
                ventanaSplitter.setControlador(this);
                Splitter splitter = (Splitter) obtenerElemento(id);
                ventanaSplitter.setValores(splitter.getSalidas(),
                        splitter.getLongitud_onda(), splitter.getPerdida_insercion(), id);
                ventanaSplitter.setElementos(elementosDisponibles(splitter.getId_nombre()),splitter.getConexion(0));
                ventanaSplitter.setLocationRelativeTo(null);
                ventanaSplitter.setTitle(id);
                ventanaSplitter.setVisible(true);
                break;
            case "fibra":
                VentanaFibra ventanaFibra = new VentanaFibra();
                ventanaFibra.setControlador(this);
                Fibra fibra = (Fibra) obtenerElemento(id);
                ventanaFibra.setValores(fibra.getLongitud_onda(), fibra.getModo(), fibra.getTipo(), fibra.getLongitud_km(), fibra.getAtenuacion(), fibra.getDispersion(), id);
                ventanaFibra.setElementos(elementosDisponibles(id_aux,id),fibra.getElementoConectado());
                ventanaFibra.setLocationRelativeTo(null);
                ventanaFibra.setTitle(id);
                ventanaFibra.setVisible(true);
                break;
            case "fuente":
                VentanaFuente ventanaFuente = new VentanaFuente();
                ventanaFuente.setControlador(this);
                Fuente fuente = (Fuente) obtenerElemento(id);
                ventanaFuente.setValores(fuente.getLongitud_onda(), fuente.getTipo(), fuente.getPotencia(),
                        fuente.getAnchura(), fuente.getVelocidad(), id);
                ventanaFuente.setPulso(fuente.getA0(), fuente.getT0(), fuente.getW0(), fuente.getC(),fuente.getM());
                //System.out.println("C:"+fuente.getC()+" A0:"+fuente.getA0()+" W0:"+fuente.getW0()+ " T0:"+fuente.getT0() + " M:"+fuente.getM());
                ventanaFuente.setElementos(elementosDisponibles(id_aux,id), fuente.getElementoConectado());
                ventanaFuente.setLocationRelativeTo(null);
                ventanaFuente.setTitle(id);
                ventanaFuente.setVisible(true);
                break;
            case "potencia":
                VentanaPotencia ventanaPotencia = new VentanaPotencia();
                ventanaPotencia.setControlador(this);
                MedidorPotencia potencia = (MedidorPotencia)obtenerElemento(id);
                ventanaPotencia.setValores(potencia.getSensibilidad(),id);
                ventanaPotencia.setLocationRelativeTo(null);
                ventanaPotencia.setTitle(id);
                ventanaPotencia.setVisible(true);
                break;

            case "espectro":
                VentanaEspectro ventanaEspectro = new VentanaEspectro();
                ventanaEspectro.setControlador(this);
                ventanaEspectro.setValores(id);
                ventanaEspectro.setLocationRelativeTo(null);
                ventanaEspectro.setTitle(id);
                ventanaEspectro.setVisible(true);
                break;
            default:
        }
    }

    //este metodo devuelve el nombre del componente sin el numero
    public String separarId(String id) {
        String aux = "";
        int i = 0;
        while (!Character.isDigit(id.charAt(i))) {
            aux = aux + id.charAt(i);
            i++;
        }
        return aux;
    }

    //este metodo regresa el elemento de la lista en base a su id 
    public Componente obtenerElemento(String id) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId_nombre().compareTo(id) == 0) {
                return elementos.get(i);
            }
        }
        return null;
    }
    
    //este metodo devuelve el id del elemento al que esta conectado
    //solo para splitter
    //id -> elemento  
    public String elementoConectado(String id,int salida){
        Splitter splitter = (Splitter) obtenerElemento(id);
        return splitter.getConexion(salida);
    }
        
    //este metodo es para girar 180º el icono del conector
    public void girarConector(String id){
        Conector aux = (Conector) obtenerElemento(id);
        char orientacion= aux.getOrientacion();
        if(orientacion=='R')
            orientacion='L';
        else
            orientacion='R';
        for(int i=0;i < dibujos.size();i++){
            if(dibujos.get(i).getId().compareTo(id)==0){
                dibujos.get(i).girarConector(orientacion);
            }
        }
        aux.setOrientacion(orientacion);
    }
    
    public void girarEspectro(String id){
        MedidorEspectro aux = (MedidorEspectro) obtenerElemento(id);
        char orientacion= aux.getOrientacion();
        if(orientacion=='R')
            orientacion='L';
        else
            orientacion='R';
        for(int i=0;i < dibujos.size();i++){
            if(dibujos.get(i).getId().compareTo(id)==0){
                dibujos.get(i).girarEspectro(orientacion);
            }
        }
        aux.setOrientacion(orientacion);
    }
    
    //Metodo para crear un archivo con los elementos creados en la maqueta.
    //crea un archivo de texto plano con extension .opt
    
    public void guardarTrabajo(String ruta_archivo){
          //se comprueba que el usuario no le ponga extension al archivo
          if(ruta_archivo.contains(".opt")){
             ruta_archivo= ruta_archivo.split(".opt")[0];//se le quita el .opt
              //System.out.println(ruta_archivo);
          }
             
        
        try {
            File archivo = new File(ruta_archivo+".opt");
            if(!archivo.exists())
                archivo.createNewFile();
            FileWriter fichero = null;
            PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println(contadorElemento);
            for(int i =0;i < elementos.size();i++){
                String aux = elementos.get(i).getId_nombre();
                
                if(aux.contains("conector")){
                    Conector conector = (Conector) elementos.get(i);
                    
                    pw.println(conector.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
                else if(aux.contains("empalme")){
                    Empalme empalme= (Empalme) elementos.get(i);
                    pw.println(empalme.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
                else if(aux.contains("fibra")){
                    Fibra fibra = (Fibra) elementos.get(i);
                    pw.println(fibra.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
                else if(aux.contains("splitter")){
                    Splitter splitter = (Splitter) elementos.get(i);
                    pw.println(splitter.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                    pw.println(splitter.Conexiones());
                }
                else if(aux.contains("fuente")){
                    Fuente fuente = (Fuente) elementos.get(i);
                    pw.println(fuente.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
                else if(aux.contains("potencia")){
                    MedidorPotencia potencia= (MedidorPotencia) elementos.get(i);
                    pw.println(potencia.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
                else{
                    MedidorEspectro espectro = (MedidorEspectro)elementos.get(i);
                    pw.println(espectro.toString()+","+obtenerDibujo(aux).getX()+","+obtenerDibujo(aux).getY());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo para abrir un trabajo guardado
    
    public void abrirTrabajo(String ruta){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
      

        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            
         //se vacian los arrays de elementos
            elementos = new ArrayList();
            dibujos = new ArrayList();
            
         //se limpia el panel de trabajo
         ventana_principal.getPnl_trabajo().removeAll();

         // Lectura del fichero
            String linea="";
            
            while((linea=br.readLine())!=null){
                //System.out.println(linea);
                String [] partes = linea.split(",");
                    String id = partes[0];
                    String id_aux = separarId(id);
                    switch (id_aux) {
                        case "conector":
                            
                            //for(int i = 0 ; i < partes.length;i++)
                                //System.out.println(partes[i]);
                            Conector conector = new Conector();
                            conector.setId_nombre(id);
                            conector.setConectado(Boolean.valueOf(partes[1]));
                            conector.setElementoConectado(partes[2]);
                            conector.setPerdida_insercion(Double.valueOf(partes[3]));
                            conector.setLongitud_onda(Integer.valueOf(partes[4]));
                            conector.setModo(Integer.valueOf(partes[5]));
                            conector.setOrientacion(partes[6].charAt(0));
                            elementos.add(conector);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "conector", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[7]));
                            manejadorElementos.setY(Integer.valueOf(partes[8]));
                            manejadorElementos.girarConector(conector.getOrientacion());
                            dibujos.add(manejadorElementos);
                            
                            break;
                        case "empalme":
                            Empalme empalme = new Empalme();
                            empalme.setId_nombre(id);
                            empalme.setConectado(Boolean.valueOf(partes[1]));
                            empalme.setElementoConectado(partes[2]);
                            empalme.setTipo(Integer.valueOf(partes[3]));
                            empalme.setPerdida_insercion(Double.valueOf(partes[4]));
                            empalme.setLongitud_onda(Integer.valueOf(partes[5]));
                            elementos.add(empalme);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "empalme", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[6]));
                            manejadorElementos.setY(Integer.valueOf(partes[7]));
                            dibujos.add(manejadorElementos);

                            break;
                        case "splitter":
                            Splitter splitter = new Splitter();
                            splitter.setId_nombre(id);// id del splitter
                            splitter.setConectado(Boolean.valueOf(partes[1]));
                            splitter.setElementoConectado(partes[2]);
                            splitter.setSalidas(Integer.valueOf(partes[3]));
                            splitter.setPerdida_insercion(Double.valueOf(partes[4]));
                            splitter.setLongitud_onda(Integer.valueOf(partes[5]));
                            
                            //ArrayList<String> aux2 = splitter.getConexiones();
                            //System.out.println("----------");
                            //for(String i : aux2){
                              //  System.out.println(aux2);
                            //}
                            //System.out.println("---"+splitter.getSalidas());
                            String aux = "splitter16"; //guarda el tipo de splitter //< 16 salidas
                                    //saber que tipo de splitter
                            if (splitter.getSalidas()== 3) {//32 salidas
                                     aux = "splitter32";
                            }
                            if (splitter.getSalidas() == 4) {//64 salidas
                            aux = "splitter64";
                            }
                            if (splitter.getSalidas()== 5) {//128 salidas
                            aux = "splitter128";
                            }
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id,aux, this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[6]));
                            manejadorElementos.setY(Integer.valueOf(partes[7]));
                            dibujos.add(manejadorElementos);
                            linea=br.readLine();
                            
                            String [] conexiones = linea.split(",");
                           // for(String o:conexiones){
                             //   System.out.println("--------"+o);
                           // }
                            for(int i=0;i<((int) Math.pow(2,(splitter.getSalidas()+1))); i++){
                                if(conexiones[i].compareTo(" ")==0)
                                    splitter.cargarConexion(i,"");
                                else    
                                    splitter.cargarConexion(i,conexiones[i]);
                            }
                            elementos.add(splitter);

                            break;
                        case "fibra":
                            Fibra fibra = new Fibra();
                            fibra.setId_nombre(id);// id del splitter
                            fibra.setConectado(Boolean.valueOf(partes[1]));
                            fibra.setElementoConectado(partes[2]);
                            fibra.setLongitud_onda(Integer.valueOf(partes[3]));
                            fibra.setModo(Integer.valueOf(partes[4]));
                            fibra.setTipo(Integer.valueOf(partes[5]));
                            fibra.setLongitud_km(Double.valueOf(partes[6]));
                            fibra.setDispersion(Double.valueOf(partes[7]));
                            fibra.setAtenuacion(Double.valueOf(partes[8]));
                            
                            elementos.add(fibra);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "fibra", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[9]));
                            manejadorElementos.setY(Integer.valueOf(partes[10]));
                            dibujos.add(manejadorElementos);
                            break;
                        case "fuente":
                            Fuente fuente = new Fuente();
                            fuente.setId_nombre(id);// id del splitter
                            fuente.setConectado(Boolean.valueOf(partes[1]));
                            fuente.setElementoConectado(partes[2]);
                            fuente.setTipo(Integer.valueOf(partes[3]));
                            fuente.setPotencia(Double.valueOf(partes[4]));
                            fuente.setAnchura(Double.valueOf(partes[5]));
                            fuente.setVelocidad(Double.valueOf(partes[6]));
                            fuente.setLongitud_onda(Integer.valueOf(partes[7]));
                            fuente.setPulso(Float.parseFloat(partes[8]),Float.parseFloat(partes[9]),Float.parseFloat(partes[10]),Float.parseFloat(partes[11]),Float.parseFloat(partes[12]));
                            elementos.add(fuente);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "fuente", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[13]));
                            manejadorElementos.setY(Integer.valueOf(partes[14]));
                            dibujos.add(manejadorElementos);
                            break;
                        case "potencia":
                            MedidorPotencia potencia= new MedidorPotencia();
                            potencia.setId_nombre(id);// id del splitter
                            potencia.setConectado(Boolean.valueOf(partes[1]));
                            potencia.setElementoConectado(partes[2]);
                            potencia.setSensibilidad(Double.valueOf(partes[3]));
                            elementos.add(potencia);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "potencia", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[4]));
                            manejadorElementos.setY(Integer.valueOf(partes[5]));
                            dibujos.add(manejadorElementos);
                            break;

                        case "espectro":
                            MedidorEspectro espectro = new MedidorEspectro();
                            espectro.setId_nombre(id);// id del splitter
                            espectro.setConectado(Boolean.valueOf(partes[1]));
                            espectro.setElementoConectado(partes[2]);
                            elementos.add(espectro);
                            manejadorElementos = new ElementoGrafico(ventana_principal.getPnl_trabajo(), 
                                                    id, "espectro", this,id);
                            manejadorElementos.dibujarComponente();
                            manejadorElementos.setX(Integer.valueOf(partes[3]));
                            manejadorElementos.setY(Integer.valueOf(partes[4]));
                            dibujos.add(manejadorElementos);
                            break;
                        default:
                            contadorElemento=Integer.valueOf(id);
                            //System.out.println(id);
                    }
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
            try{                    
                if( null != fr ){   
                fr.close();     
            }                  
            }catch (Exception e2){ 
            e2.printStackTrace();
            }
        }
    }
    
    //metodo para crear un nuevo trabajo
    public void nuevoTrabajo(){
        ventana_principal.dispose(); //se oculta y elimina la ventana principal
        Controlador controlador = new Controlador();
        ventana_principal= new VentanaPrincipal();
        
        controlador.setVentana_principal(ventana_principal);
        ventana_principal.setControlador(controlador);
        
        ventana_principal.setVisible(true);
    }
    
    public ElementoGrafico obtenerDibujo(String id){
        
        for(int i = 0 ; i < dibujos.size();i++)
            if(dibujos.get(i).getId().compareTo(id)==0)
                return dibujos.get(i);
            
        return null;
        
    }
    
    
    //------- metodos para inicializar y obtener los atributos del controlador--///
    public void setVentana_principal(VentanaPrincipal ventana_principal) {
        this.ventana_principal = ventana_principal;

    }

    public ArrayList<Componente> getElementos() {
        return elementos;
    }

    //--------------------------------------------/ 
}

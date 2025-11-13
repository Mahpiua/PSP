package controlador;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Cliente;

/**
 *
 * @author Mª Del Pilar Parra Vergara 1º DAM
 */
public class MiLista {

    //Declaramos una variable que guardara la posicion en la que empieza la lista
    private int actual;
    
    //Se instancia un ArrayList de Cliente para introducir los clientes
    private ArrayList<Cliente> listaClientes;

    public MiLista() {
        actual=0;
        listaClientes = new ArrayList<>();
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    public void setClientes(ArrayList<Cliente> miLista) {
        this.listaClientes = miLista;
    }

    @Override
    public String toString() {
        return "MiLista{" + "actual=" + actual + ", miLista=" + listaClientes + '}';
    }
    
    public Cliente irAlPrincipio() {
        actual = 0;
        return listaClientes.get(actual);
    }
    
    public Cliente irAlFinal() {
        actual = listaClientes.size()-1;
        return listaClientes.get(actual);
    }
    
    public Cliente anterior() {
        actual--;
        return listaClientes.get(actual);
    }
    
    public Cliente siguiente() {
        actual++;
        return listaClientes.get(actual);
    }
    
    public boolean esVacia() {
        return listaClientes.isEmpty();
    }
    
    public void insertarCliente(Cliente cli){
        if (!esVacia()) {
            actual++;
        }
        listaClientes.add(cli);
        
    }
    
    public void modificarCliente(Cliente cli){
        listaClientes.remove(actual);
        listaClientes.add(actual, cli);
    }
    
    public void borrarCliente(Cliente cli){
        listaClientes.remove(cli);
        if (actual > 0) {
            actual--;
        }
    }
    
    public void ordenarPorNumeroDeCliente (){
        Collections.sort(listaClientes);
    }  
    
    public Cliente obtenerClienteActual () {
        if(!esVacia()) {
            return this.getClientes().get(actual);
        }
        return null;
    }
           
}

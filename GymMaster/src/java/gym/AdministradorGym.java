package gym;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa el sitema del Gimnasio
 * @author Michael
 */
public class AdministradorGym {
    /**
     * Lista de clientes
     */
    private List<Cliente> clientes;
    /**
     * Crea una nueva instancia del administrador con la lista 
     * de clientes vacía
     */
    public AdministradorGym(){
        clientes = new ArrayList<Cliente>();
    }
    /**
     * Agrega un nuevo cliente a la lista
     * @param nuevoCliente 
     */
    public void agregarCliente(Cliente nuevoCliente){
        clientes.add(nuevoCliente);
    }
    
    /**
     * Obtiene la lista de clientes
     * @return Clientes
     */
    public List<Cliente> getClientes(){
        return clientes;
    }
    
}

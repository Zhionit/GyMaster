package beans;
 
import gym.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import persistencia.ConexionBaseDatos;

/**
 *
 * @author Zhionit
 */
@Named(value = "clienteBean")
@Dependent
public class ClienteBean 
{
    
    private List<Cliente> listaClientes;
    
    private Cliente cliente;
    
    private ConexionBaseDatos conexionBD;
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() 
    {
        cliente = new Cliente();
        listaClientes = new ArrayList<Cliente>();
        cargarClientes();
        
    }
    
    
    

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private void cargarClientes(){
        if(conexionBD == null){
            conexionBD = new ConexionBaseDatos();
            System.out.println("Se creo nueva conexion a BD");
        }
        conexionBD.cargarClientes(this.listaClientes);
    }
    
    public void registrarCliente(){
        listaClientes.add(this.cliente);
        if(conexionBD == null){
            conexionBD = new ConexionBaseDatos();
            System.out.println("Se creo nueva conexion a BD");
        }
        conexionBD.registrarCliente(this.cliente);
    }
    
    public void eliminarCliente(){
          System.out.println("llamado metodo borrar");
        if (conexionBD == null) {
            conexionBD = new ConexionBaseDatos();
            System.out.println("Created new connection");
        }
        conexionBD.eliminarCliente(this.cliente.getId());
        System.out.println("Cliente " + this.cliente.getId() + " eliminado");
        listaClientes.clear();
        cargarClientes();
    }
    
}

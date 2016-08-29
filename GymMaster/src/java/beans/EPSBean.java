package beans;

import gym.EPS;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import persistencia.ConexionBaseDatos;

/**
 *
 * @author Zhionit
 */
@Named(value = "ePSBean")
@ApplicationScoped
public class EPSBean {

    // Atributos
    private ConexionBaseDatos conexionBD;

    /**
     * Instancia que representa un objeto de la clase EPS
     */
    private EPS eps;

    /**
     * Lista de EPS's
     */
    private List<EPS> listaEPS;

    /**
     * Crea una nueva instancia de EPSBean
     */
    public EPSBean() {
        eps = new EPS();
        listaEPS = new ArrayList<EPS>();
        cargarListaEPS();
    }

    /**
     * Obtiene la EPS de EPSBean
     *
     * @return EPS -
     */
    public EPS getEps() {
        return eps;
    }

    /**
     * Modifica la EPS del EPSBEan
     *
     * @param eps nueva EPS
     */
    public void setEps(EPS eps) {
        this.eps = eps;
    }

    /**
     * Obtiene la lista de las EPS's del EPSBean
     *
     * @return List<EPS> La lista de EPS de EPSBean
     */
    public List<EPS> getListaEPS() {
        return listaEPS;
    }

    /**
     * Modifica la lista de EPS's que tiene el Bean
     *
     * @param listaEPS La nueva lista de EPS's Para el Bean
     */
    public void setListaEPS(List<EPS> listaEPS) {
        this.listaEPS = listaEPS;
    }

    public ConexionBaseDatos getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(ConexionBaseDatos conexionBD) {
        this.conexionBD = conexionBD;
    }

    private void cargarListaEPS() {

        if (conexionBD == null) {
            conexionBD = new ConexionBaseDatos();
            System.out.println("Created new connection");
        }
        conexionBD.cargarListaEPS(this.listaEPS);
        System.out.println("Lista de EPS's cargada");
    }

    public void registrarEPS() {

        listaEPS.add(this.eps);
        if (conexionBD == null) {
            conexionBD = new ConexionBaseDatos();
            System.out.println("Created new connection");
        }
        
        int id = conexionBD.registrarEPS(this.eps.getNombre());
//        this.eps.setId(id);
        listaEPS.get(listaEPS.size() - 1).setId(id);
        System.out.println("EPS Registrada con ID: " + id);
    }
    
    public void eliminarEPS(){
        System.out.println("llamado metodo borrar");
        if (conexionBD == null) {
            conexionBD = new ConexionBaseDatos();
            System.out.println("Created new connection");
        }
        conexionBD.eliminarEPS(this.eps.getId());
        System.out.println("EPS con ID: " + this.eps.getId() + " eliminada");
        listaEPS.clear();
        cargarListaEPS();
    }
    
}

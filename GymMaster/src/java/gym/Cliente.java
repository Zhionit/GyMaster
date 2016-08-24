package gym;

import java.util.Date;
import java.util.List;

/**
 * Esta clase representa a un cliente del gimnasio
 *
 * @author Michael
 */
public class Cliente {

    /**
     * Identificación del cliente
     */
    private String id;
    /**
     * Nombre del cliente
     */
    private String nombre;
    /**
     * Apellido del cliente
     */
    private String apellido;
    /**
     * Género sexual del cliente, verdadero si es masculino
     */
    private boolean genero;
    /**
     * Tipo de sangre del cliente
     */
    private TipoSangre tipoSangre;
    /**
     * Fecha de nacimiento del Cliente
     */
    private Date fechaNacimiento;
    /**
     * Dirección del cliente
     */
    private String direccion;
    /**
     * Lista de telefonos de contacto del cliente
     */
    private List<String> telefonos;
    /**
     * Empresa Prestadora de Salud a la cual esta afiliado el cliente
     */
    private EPS eps;
    /**
     * Medidas corporales del cliente
     */
    private MedidasCorporales medidasCorporales;
    /**
     * Servicios a los que esta suscrito el cliente en el gimnasio
     */
    private List<Servicio> servicios;
    /**
     * Rutina programada del cliente en el gimnasio
     */
    private Rutina[] rutinas;

    public Cliente(String id, String nombre, String apellido, boolean genero, TipoSangre tipoSangre, Date fechaNacimiento, String direccion, List<String> telefonos, EPS eps) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.tipoSangre = tipoSangre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.eps = eps;
    }

    /**
     * Obtiene la identificación del cliente
     * @return Identificación del cliente
     */
    public String getId() {
        return id;
    }
    /**
     * Modifica la identificación del cliente
     * @param id Nueva identificación del cliente
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre del cliente
     * @param nombre Nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el apellido del cliente
     * @return Apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Modifica el apellido del cliente
     * @param apellido Nuevo apellido del cliente
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Obtiene el género del cliente
     * @return Positivo si el género es masculino, falso de lo contrario
     */
    public boolean getGenero() {
        return genero;
    }
    /**
     * Modifica el género sexual del cliente
     * @param genero Nuevo género sexual del cliente
     */
    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    /**
     * Obtiene el tipo de sangre del cliente
     * @return Tipo de sangre
     */
    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }
    /**
     * Modifica el tipo de sangre del cliente
     * @param tipoSangre Nuevo tipo de sangre del cliente
     */
    public void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    /**
     * Obtiene la fecha de nacimiento del cliente
     * @return Fecha de nacimiento del cliente
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Modifica la fecha de nacimiento del cliente
     * @param fechaNacimiento Nueva fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Obtiene la dirección del cliente
     * @return Dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Modifica la dirección del cliente
     * @param direccion Nueva dirección del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Obtiene la lista de telefonos de contacto del cliente
     * @return Lista de telefonos de contacto del cliente
     */
    public List<String> getTelefonos() {
        return telefonos;
    }
    /**
     * Modifica la lista de telefonos de contacto del cliente
     * @param telefonos Nueva lista de telefonos de contacto del cliente
     */
    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }
    /**
     * Obtiene la Empresa Prestadora de Salud a la cual esta afiliado el cliente
     * @return Empresa Prestadora de Salud a la cual esta afiliado el cliente
     */
    public EPS getEPS() {
        return eps;
    }
    /**
     * Modifica la Empresa Prestadora de Salud a la cual esta afiliado el cliente
     * @param eps Nueva Empresa Prestadora de Salud a la cual esta afiliado el cliente
     */
    public void setEPS(EPS eps) {
        this.eps = eps;
    }
    /**
     * Obtiene las medidas corporales del cliente
     * @return Medidas corporales del cliente
     */
    public MedidasCorporales getMedidasCorporales() {
        return medidasCorporales;
    }
    /**
     * Modifica las medidas corporales del cliente
     * @param medidasCorporales Nuevas medidas corporales del cliente
     */
    public void setMedidasCorporales(MedidasCorporales medidasCorporales) {
        this.medidasCorporales = medidasCorporales;
    }
    /**
     * Obtiene la lista de servicios a los cuales esta inscrito el cliente
     * @return Lista de servicios a los cuales esta inscrito el cliente
     */
    public List<Servicio> getServicios() {
        return servicios;
    }
    /**
     * Modifica la lista de servicios a los cuales esta inscrito el cliente
     * @param servicios Nueva lista de servicios a los cuales esta inscrito el cliente
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    /**
     * Obtiene la rutina que debe seguir el cliente
     * @return Rutina a seguir
     */
    public Rutina[] getRutina() {
        return rutinas;
    }
    /**
     * Modifica la rutina que debe seguir el cliente
     * @param rutina Nueva rutina
     */
    public void setRutina(Rutina[] rutina) {
        this.rutinas = rutina;
    }

    
}

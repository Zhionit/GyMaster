package gym;

/**
 * Esta clase representa una Empresa Prestadora de Salud a la cual estaría
 * afiliado un cliente
 *
 * @author Michael
 */
public class EPS {

    /**
     * Identificador de la EPS
     */
    private int id;

    /**
     * Nombre de la EPS
     */
    private String nombre;

    /**
     * Crea una nueva instancia de EPS
     *
     * @param id Identificador de la EPS
     * @param nombre Nombre de la EPS
     */
    public EPS(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Crea una instancia con valores por defecto Para su uso y manipulación con
     * el bean
     */
    public EPS() {

    }

    /**
     * Obtiene el identificador de la EPS
     *
     * @return Identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el identificador de la EPS
     *
     * @param id Nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la EPS
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la EPS
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

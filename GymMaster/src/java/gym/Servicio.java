package gym;

/**
 * Esta clase describe un servicio solicitado por un cliente como el programa
 * específico por el cual ha acudido al gimnasio
 *
 * @author Michael
 */
public class Servicio {

    /**
     * Identificador unívoco del servicio
     */
    private int id;
    /**
     * Descripción del servicio
     */
    private String descripcion;

    /**
     * Crea una instancia del servicio
     *
     * @param id Identificador unívoco del servicio
     * @param descripcion Descripción del servicio
     */
    public Servicio(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    /**
     * Crea una instancia con valores por defecto Para su uso y manipulación con
     * el bean
     */
    public Servicio() {

    }

    /**
     * Obtiene el identificador unívoco del servicio
     *
     * @return Identificador unívoco
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el identificador unívoco del servicio
     *
     * @param id Nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la descripción del servicio
     *
     * @return Descripción del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción del servicio
     *
     * @param descripcion Nueva descripción del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

package gym;

/**
 * Esta clase describe un servicio solicitado por un cliente
 * como el programa específico por el cual ha acudido al gimnasio
 * @author Michael
 */
public class Servicio {
    /**
     * Identificador unívoco del servicio
     */
    private String id;
    /**
     * Descripción del servicio
     */
    private String descripcion;
    
    /**
     * Crea una instancia del servicio
     * @param id Identificador unívoco del servicio
     * @param descripcion Descripción del servicio
     */
    public Servicio(String id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene el identificador unívoco del servicio
     * @return Identificador unívoco
     */
    public String getId() {
        return id;
    }
    /**
     * Modifica el identificador unívoco del servicio
     * @param id Nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene la descripción del servicio
     * @return Descripción del servicio
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Modifica la descripción del servicio
     * @param descripcion Nueva descripción del servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

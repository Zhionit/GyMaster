package gym;

/**
 * Esta clase representa el tipo de sangre de un Cliente
 *
 * @author Michael
 */
public class TipoSangre {

    /**
     * Tipo de sangre
     */
    private short tipo;

    /**
     * Presencia de RH
     */
    private boolean rh;

    /**
     * Crea una nueva instancia de tipo de sangre
     *
     * @param tipo
     * @param rh
     */
    public TipoSangre(short tipo, boolean rh) {
        this.tipo = tipo;
        this.rh = rh;
    }

    /**
     * Crea una instancia con valores por defecto Para su uso y manipulación con
     * el bean
     */
    public TipoSangre() {

    }

    /**
     * Obtiene el tipo de sangre
     *
     * @return Tipo
     */
    public short getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de sangre
     *
     * @param tipo Nuevo tipo
     */
    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la presencia de RH
     *
     * @return Presencia RH
     */
    public boolean getRh() {
        return rh;
    }

    /**
     * Modifica la presencia de RH
     *
     * @param rh Presencia RH
     */
    public void setRh(boolean rh) {
        this.rh = rh;
    }

}

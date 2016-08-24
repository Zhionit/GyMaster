package gym;

/**
 * Esta clase representa el tipo de sangre de un Cliente
 * @author Michael
 */
public class TipoSangre {
    
    /**
     * Constante que representa el tipo de sangre A
     */
    public static final byte TIPO_A = 0;
    /**
     * Constante que representa el tipo de sangre B
     */
    public static final byte TIPO_B = 1;
    /**
     * Constante que representa el tipo de sangre AB
     */
    public static final byte TIPO_AB = 2;
    /**
     * Constante que representa el tipo de sangre O
     */
    public static final byte TIPO_O = 3;
    
    /**
     * Tipo de sangre
     */
    private byte tipo;
    
    /**
     * Presencia de RH
     */
    private boolean rh;
    
    /**
     * Crea una nueva instancia de tipo de sangre
     * @param tipo
     * @param rh 
     */
    public TipoSangre(byte tipo, boolean rh){
        this.tipo = tipo;
        this.rh = rh;
    }

    /**
     * Obtiene el tipo de sangre
     * @return Tipo
     */
    public byte getTipo() {
        return tipo;
    }
    /**
     * Modifica el tipo de sangre
     * @param tipo Nuevo tipo
     */
    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }
    /**
     * Obtiene la presencia de RH
     * @return Presencia RH
     */
    public boolean getRh() {
        return rh;
    }
    /**
     * Modifica la presencia de RH
     * @param rh Presencia RH
     */
    public void setRh(boolean rh) {
        this.rh = rh;
    }
    
    
    
}

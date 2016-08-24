package gym;

/**
 * Esta clase representa un ejercicio a realizar en una rutina determinada
 *
 * @author Michael
 */
public class Ejercicio {

    /**
     * Descripción del ejercicio
     */
    private String descripcion;
    /**
     * Orden secuencial del ejercicio en la rutina
     */
    private int ordenSecuencial;
    /**
     * Número de series a realizar
     */
    private int series;
    /**
     * Número de repeticiones por cada serie
     */
    private int repeticiones;
    /**
     * Peso en Kg a usar durante el ejercicio
     */
    private int peso;

    /**
     * Crea una nueva instancia de Ejercicio
     * @param descripcion Nombre del ejercicio
     * @param ordenSecuencial Orden secuencial del ejercicio en la rutina
     * @param series Número de series a realizar
     * @param repeticiones Número de repeticiones por serie
     * @param peso Peso en KG a usar en el ejercicio
     */
    public Ejercicio(String descripcion, int ordenSecuencial, int series, int repeticiones, int peso) {
        this.descripcion = descripcion;
        this.ordenSecuencial = ordenSecuencial;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
    }

    /**
     * Obtiene la descripcion del ejercicio
     *
     * @return Descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripcion del ejercicio
     *
     * @param descripcion Nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene el orden secuencial del ejercicio en la rutina
     * @return Orden Secuencial
     */
    public int getOrdenSecuencial(){
        return ordenSecuencial;
    }
    
    /**
     * Modifica el orden secuencial del ejercicio
     * @param ordenSecuencial Nuevo orden
     */
    public void setOrdenSecuencial(int ordenSecuencial){
        this.ordenSecuencial = ordenSecuencial;
    }

    /**
     * Obtiene el número de series
     *
     * @return Número de series
     */
    public int getSeries() {
        return series;
    }

    /**
     * Modifica el número de series
     *
     * @param series Nuevo número de series
     */
    public void setSeries(int series) {
        this.series = series;
    }

    /**
     * Obtiene el número de repeticiones por serie
     *
     * @return Número de repeticiones por serie
     */
    public int getRepeticiones() {
        return repeticiones;
    }

    /**
     * Modifica el número de repeticiones por serie
     *
     * @param repeticiones Nuevo número de repeticiones por serie
     */
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    /**
     * Obtiene el peso en KG a usar durante el ejercicio
     *
     * @return Peso en KG
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Modifica el peso en KG a usar durante el ejercicio
     *
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

}

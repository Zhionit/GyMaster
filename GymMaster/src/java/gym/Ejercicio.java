package gym;

/**
 * Esta clase representa un ejercicio a realizar en una rutina determinada
 *
 * @author Michael
 */
public class Ejercicio {

    /**
     * Nombre del ejercicio
     */
    private String nombre;
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
     * @param nombre Nombre del ejercicio
     * @param series Número de series a realizar
     * @param repeticiones Número de repeticiones por serie
     * @param peso Peso en KG a usar en el ejercicio
     */
    public Ejercicio(String nombre, int series, int repeticiones, int peso) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
    }

    /**
     * Obtiene el nombre del ejercicio
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del ejercicio
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

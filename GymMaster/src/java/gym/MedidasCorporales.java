package gym;

/**
 * Esta clase representa las medidas corporales de un cliente
 *
 * @author Michael
 */
public class MedidasCorporales {

    /**
     * Peso en Kg de un cliente
     */
    private double peso;
    
    /**
     * Medida en cm con punto flotante de cada uno de las partes del cuerpo medidas
     */
    private double estatura, cintura, cadera, piernaI, piernaD, brazoI, brazoD, 
            gluteoI, gluteoD, gemeloI, gemeloD, cuello, hombroI, hombroD, espalda;

    /**
     * Crea una nueva instancia de las medidas corporales con todas las medidas
     * en valor -1 para indicar que no han sido registradas
     */
    public MedidasCorporales(){
        peso = estatura = cintura = cadera = piernaI = piernaD = brazoI = brazoD = 
            gluteoI = gluteoD = gemeloI = gemeloD = cuello = hombroI = hombroD = espalda = -1;
    }

    /**
     * Obtiene el peso en Kg
     * @return Peso en Kg
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Modifica el peso
     * @param peso Nuevo peso en Kg
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    /**
     * Obtiene la estatura en cm
     * @return Estatura en cm
     */
    public double getEstatura() {
        return estatura;
    }
    /**
     * Modifica la estatura
     * @param estatura Nueva estatura en cm
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
    /**
     * Obtiene la medida de la cintura en cm
     * @return Medida de la cintura en cm
     */
    public double getCintura() {
        return cintura;
    }
    /**
     * Modifica la medida de la cintura
     * @param cintura Nueva medida de la cintura en cm
     */
    public void setCintura(double cintura) {
        this.cintura = cintura;
    }
    /**
     * Obtiene la medida de la cadera en cm
     * @return medida de la cadera en cm
     */
    public double getCadera() {
        return cadera;
    }
    /**
     * Modifica la medida de la cadera
     * @param cadera Nueva medida de la cadera en cm
     */
    public void setCadera(double cadera) {
        this.cadera = cadera;
    }
    /**
     * Obtiene la medida de la pierna izquierda en cm
     * @return medida de la pierna izquierda en cm
     */
    public double getPiernaI() {
        return piernaI;
    }
    /**
     * Modifica medida de la pierna izquierda
     * @param piernaI Nueva medida de la pierna izquierda en cm
     */
    public void setPiernaI(double piernaI) {
        this.piernaI = piernaI;
    }
    /**
     * Obtiene la medida de la pierna derecha en cm
     * @return medida de la pierna derecha en cm
     */
    public double getPiernaD() {
        return piernaD;
    }
    /**
     * Modifica la medida de la pierna derecha
     * @param piernaD Nueva medida de la pierna derecha en cm
     */
    public void setPiernaD(double piernaD) {
        this.piernaD = piernaD;
    }
    /**
     * Obtiene la medida del brazo izquierdo en cm
     * @return medida del brazo izquierdo en cm
     */
    public double getBrazoI() {
        return brazoI;
    }
    /**
     * Modifica la medida del brazo izquierdo
     * @param brazoI Nueva medida del brazo izquierdo en cm
     */
    public void setBrazoI(double brazoI) {
        this.brazoI = brazoI;
    }
    /**
     * Obtiene la medida del brazo derecho en cm
     * @return medida del brazo derecho en cm
     */
    public double getBrazoD() {
        return brazoD;
    }
    /**
     * Modifica la medida del brazo derecho
     * @param brazoD Nueva medida del brazo derecho en cm
     */
    public void setBrazoD(double brazoD) {
        this.brazoD = brazoD;
    }
    /**
     * Obtiene la medida del gluteo izquierdo en cm
     * @return medida del gluteo izquierdo en cm
     */
    public double getGluteoI() {
        return gluteoI;
    }
    /**
     * Modifica la medida del gluteo izquierdo
     * @param gluteoI Nueva medida del gluteo izquierdo en cm
     */
    public void setGluteoI(double gluteoI) {
        this.gluteoI = gluteoI;
    }
    /**
     * Obtiene la medida del gluteo derecho en cm
     * @return medida del gluteo derecho en cm
     */
    public double getGluteoD() {
        return gluteoD;
    }
    /**
     * Modifica la medida del gluteo derecho
     * @param gluteoD Nueva medida del gluteo derecho en cm
     */
    public void setGluteoD(double gluteoD) {
        this.gluteoD = gluteoD;
    }
    /**
     * Obtiene la medida del gemelo izquierdo en cm
     * @return medida del gemelo izquierdo en cm
     */
    public double getGemeloI() {
        return gemeloI;
    }
    /**
     * Modifica la medida del gemelo izquierdo
     * @param gemeloI Nueva medida del gemelo izquierdo en cm
     */
    public void setGemeloI(double gemeloI) {
        this.gemeloI = gemeloI;
    }
    /**
     * Obtiene la medida del gemelo derecho en cm
     * @return medida del gemelo derecho en cm
     */
    public double getGemeloD() {
        return gemeloD;
    }
    /**
     * Modifica la medida del gemelo derecho
     * @param gemeloD Nueva medida del gemelo derecho en cm
     */
    public void setGemeloD(double gemeloD) {
        this.gemeloD = gemeloD;
    }
    /**
     * Obtiene la medida del cuello en cm
     * @return medida del cuello en cm
     */
    public double getCuello() {
        return cuello;
    }
    /**
     * Modifica la medida del cuello
     * @param cuello Nueva medida del cuello en cm
     */
    public void setCuello(double cuello) {
        this.cuello = cuello;
    }
    /**
     * Obtiene la medida del hombro izquierdo en cm
     * @return medida del hombro izquierdo en cm
     */
    public double getHombroI() {
        return hombroI;
    }
    /**
     * Modifica la medida del hombro izquierdo
     * @param hombroI Nueva medida del hombro izquierdo en cm
     */
    public void setHombroI(double hombroI) {
        this.hombroI = hombroI;
    }
    /**
     * Obtiene la medida del hombro derecho en cm
     * @return medida del hombro derecho en cm
     */
    public double getHombroD() {
        return hombroD;
    }
    /**
     * Modifica la medida del hombro derecho
     * @param hombroD Nueva medida del hombro derecho en cm
     */
    public void setHombroD(double hombroD) {
        this.hombroD = hombroD;
    }
    /**
     * Obtiene la medida de la espalda en cm
     * @return medida de la espalda en cm
     */
    public double getEspalda() {
        return espalda;
    }
    /**
     * Modifica la medida de la espalda
     * @param espalda Nueva medida de la espalda en cm
     */
    public void setEspalda(double espalda) {
        this.espalda = espalda;
    }

    
}

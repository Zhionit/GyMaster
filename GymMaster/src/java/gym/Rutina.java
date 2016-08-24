package gym;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una rutina asignada a un cliente
 * @author Michael
 */
public class Rutina {
    /**
     * Identificador unívoco de la rutina
     */
    private String id;
    
    /**
     * Lista de ejercicios asociados a la rutina
     */
    private List<Ejercicio> ejercicios;
    
    /**
     * Crea una instancia de una rutina sin ejercicios
     * @param id Identificador unívoco de la rutina
     */
    public Rutina(String id){
        this.id = id;
        this.ejercicios = new ArrayList<Ejercicio>();
    }
    
    /**
     * Crea una instancia de una rutina con la lista de ejercicios cargada
     * @param id Identificador unívoco de la rutina
     * @param ejercicios Ejercicios previamente cargados
     */
    public Rutina(String id, List<Ejercicio> ejercicios){
        this.id = id;
        this.ejercicios = ejercicios;
    }

    /**
     * Obtiene el identificador unívoco de la rutina
     * @return Identificador unívoco
     */
    public String getId() {
        return id;
    }
    /**
     * Modifica el identificador unívoco de la rutina
     * @param id Nuevo identificador unívoco
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene la lista de ejercicios
     * @return Lista de ejercicios
     */
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    /**
     * Modifica la lista de ejercicios
     * @param ejercicios Nueva lista de ejercicios
     */
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/**
 *
 * @author Michael
 */
public class EPS {
    
    /**
     * Identificador de la EPS
     */
    private String id;
    
    /**
     * Nombre de la EPS
     */
    private String nombre;

    
    /**
     * Crea una nueva instancia de EPS
     * @param id Identificador de la EPS
     * @param nombre Nombre de la EPS
     */
    public EPS(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el identificador de la EPS
     * @return Identificador
     */
    public String getId() {
        return id;
    }
    /**
     * Modifica el identificador de la EPS
     * @param id Nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre de la EPS
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre de la EPS
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

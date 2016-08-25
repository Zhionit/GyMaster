/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import gym.EPS;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Zhionit
 */
@Named(value = "ePSBean")
@Dependent
public class EPSBean 
{
    // Atributos
    
    /**
     * Instancia que representa un objeto de la clase EPS
     */
    private EPS eps;
    
    /**
     * Lista de EPS's 
     */
    private List <EPS> lstEPSs = new ArrayList<EPS>( );
    
    /**
     * Crea una nueva instancia de EPSBean
     */
    public EPSBean() 
    {
        eps = new EPS();
    }
    
    /**
     * Crea una nueva instancia de una EPSBEan
     * @param id identificador de la EPS
     * @param nombre nombre de la EPS
     */
    public EPSBean(int id, String nombre)
    {
        eps = new EPS(id, nombre);
    }

    /**
     * Obtiene la EPS de EPSBean
     * 
     * @return EPS - 
     */
    public EPS getEps() 
    {
        return eps;
    }

    /**
     * Modifica la EPS del EPSBEan
     * @param eps nueva EPS
     */
    public void setEps(EPS eps) 
    {
        this.eps = eps;
    }

    /**
     * Obtiene la lista de las EPS's del EPSBean
     * @return List<EPS> La lista de EPS de EPSBean
     */
    public List<EPS> getLstEPSs() 
    {
        return lstEPSs;
    }

    /**
     * Modifica la lista de EPS's que tiene el Bean
     * @param List<EPS> lstEPSs La nueva lista de EPS's Para el Bean
     */
    public void setLstEPSs(List<EPS> lstEPSs) 
    {
        this.lstEPSs = lstEPSs;
    }
    
    public void registrarEPS()
    {
        lstEPSs.add(this.eps);
    }
    
    
    
}

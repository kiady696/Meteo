/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KIADY
 */
public class Region {
    
    String idRegion;
    private String nomRegion;
    double tempMoyenRegion;
    
    public Region(String nomRegion){
        this.nomRegion = nomRegion;
    }
    
    public Region(){
        
    }

    /**
     * @return the nomRegion
     */
    public String getNomRegion() {
        return nomRegion;
    }

    /**
     * @param nomRegion the nomRegion to set
     */
    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }
    
    
    
    
    
}

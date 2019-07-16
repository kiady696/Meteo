/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author KIADY
 */
public class Prevision {
    public String idPrevision;
    public Timestamp datePrevision;
    public String descPrevision;
    public double tempMax;
    public double tempMin;
    public String idRegion;
    
    public Prevision(String idPrevision,Timestamp datePrevision,Date dateAjd,String descPrev,
            double tempMax, double tempMin , String idRegion ) throws Exception{
        //mapiasa setXXXX
        setIdPrevision(idPrevision);
        setDatePrevision(datePrevision,dateAjd);
        setDescPrevision(descPrev);
        setTempMax(tempMax);
        setTempMin(tempMin);
        setIdRegion(idRegion);
        
        
    }

    /**
     * @return the idPrevision
     */
    public String getIdPrevision() {
        return idPrevision;
    }

    /**
     * @param idPrevision the idPrevision to set
     */
    private void setIdPrevision(String idPrevision) {
        this.idPrevision = idPrevision;
    }

    /**
     * @return the datePrevision
     */
    public Date getDatePrevision() {
        return datePrevision;
    }

    /**
     * @param datePrevision the datePrevision to set
     */
    private void setDatePrevision(Timestamp datePrevision,Date dateAjd) throws Exception {        
        
            //ra tsy ao arinan androany ny date avany amny base (de mila manipy exception)
            if(!datePrevision.after(dateAjd)){
                throw new Exception("Date passée");
            }
            this.datePrevision = datePrevision;
            
        
    }
        

    /**
     * @return the descPrevision
     */
    public String getDescPrevision() {
        return descPrevision;
    }

    /**
     * @param descPrevision the descPrevision to set
     */
    private void setDescPrevision(String descPrevision) {
        this.descPrevision = descPrevision;
    }

    /**
     * @return the tempMax
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * @param tempMax the tempMax to set
     */
    private void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * @return the tempMin
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * @param tempMin the tempMin to set
     */
    private void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * @return the idregion
     */
    public String getIdregion() {
        return idRegion;
    }

    /**
     * @param idregion the idregion to set
     */
    private void setIdRegion(String idregion) {
        this.idRegion = idregion;
    }
    
    
    
    
      
            
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.DBConnect;
import DAO.PrevisionDAO;
import java.sql.Timestamp;
import model.Prevision;
import model.Region;

/**
 *
 * @author KIADY
 */
public class PrevisionService {
    
    private Prevision[] previsions;
    private DBConnect dbc;
    private Region[] regions;

    /**
     * @return the previsions
     */
    public Prevision[] getPrevisions() {
        return previsions;
    }

    /**
     * @param previsions the previsions to set
     */
    public void setPrevisions(Prevision[] previsions) {
        this.previsions = previsions;
    }
    
    public void Meteo(Timestamp datePosterieure) throws Exception{
        this.dbc = new DBConnect();
      
        try{
            dbc.connect();
            PrevisionDAO pdao = new PrevisionDAO();
            Prevision[] tomorrows = pdao.getPrevisions(dbc, datePosterieure);
            setPrevisions(tomorrows);
            Region[] regs = new Region[this.getPrevisions().length]; //le tableau ho fenoina amle resultats ana region selon id region
            for(int i = 0;i<this.getPrevisions().length;i++){
                regs[i] = pdao.getRegion(dbc,this.getPrevisions()[i].getIdregion());
            }
           setRegions(regs);
           
            
        }
        catch(Exception e){
            throw e;
        }
        finally{
            dbc.disconnect();
        }
       
    }
    

    /**
     * @return the dbc
     */
    public DBConnect getDbc() {
        return dbc;
    }

    /**
     * @param dbc the dbc to set
     */
    public void setDbc(DBConnect dbc) {
        this.dbc = dbc;
    }

    /**
     * @return the regions
     */
    public Region[] getRegions() {
        return regions;
    }

    /**
     * @param regions the regions to set
     */
    public void setRegions(Region[] regions) {
        this.regions = regions;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspnaina;

import DAO.PrevisionDAO;
import java.sql.Timestamp;
import DAO.DBConnect;
import model.Prevision;
import DAO.LoginDAO;
import model.Region;
import model.User;
import service.PrevisionService;


/**
 *
 * @author KIADY
 */
public class JSPNaina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        // TODO code application logic here
        //TEST RETRARETRA AMLE APPLICATION METEO
        DBConnect dbc = new DBConnect();
        try{ 
                dbc.connect();
                
                
                //PrevisionDAO pdao = new PrevisionDAO();
                //Timestamp tmp = new Timestamp(119,04,30,0,0,0,0);
                //System.out.println(tmp);
                //Prevision[] previsions = pdao.getPrevisions(dbc,tmp);

                /*for (int i = 0 ; i< previsions.length ; i++) {
                    System.out.println(previsions[i].getDescPrevision() + " " + previsions[i].getDatePrevision().toString());
                }*/
                
                
                /*LoginDAO ldao = new LoginDAO();
                User[] users = ldao.getUsers(dbc);
                for (int i = 0;i<users.length;i++){
                    System.out.println(""+users[i].getNom()+" et "+users[i].getPassword());
                }*/
                
                /*Region reg = new Region();
                reg = pdao.getRegion(dbc,"1");
                System.out.println(reg.getNomRegion());*/
                
                User nouvo = new User("rthe","5252");
                LoginDAO ldao = new LoginDAO();
                ldao.insertInto(dbc, nouvo, "Us");
                 
                 System.out.println("aff below");
                   
               
               
        
        }
        finally{
            if(dbc!=null){
               dbc.disconnect();
            }
            
        }
    }
}

    
    

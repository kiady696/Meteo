/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import model.Prevision;
import model.Region;

/**
 *
 * @author KIADY
 */
public class PrevisionDAO {
    
    public PrevisionDAO(){
        
    }
    
    public Prevision[] getPrevisions(DBConnect dbc,Timestamp date) throws Exception{
       
            String queryString = "SELECT * FROM PREVISIONS WHERE dateprevision = ?";
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<Prevision> resultTemp = new Vector();
            PreparedStatement prepSt = null;
             ResultSet rs = null;
        try{    
            prepSt = dbc.getConnection().prepareStatement(queryString);
            prepSt.setTimestamp(1, date); //date = date selectionnee dans le formulaire
            
            rs = prepSt.executeQuery();
            Date dateAjd = new Date();
                  
            while(rs.next()){
                resultTemp.add(new Prevision(rs.getString(1),rs.getTimestamp(2),dateAjd,rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6)));
                /*ra inferieur am date androany de manipy exception
                  ra tsisy zavatra set-ena de manipy exception*/
            }
        }
        catch(Exception e){
            throw e;
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(prepSt!=null){
                prepSt.close();
            }
        }
            Prevision[] prevs = new Prevision[resultTemp.size()];
            for(int i=0;i<resultTemp.size();i++){
                prevs[i]=resultTemp.get(i);
            }
            return prevs;
        
    }
    
    public Region getRegion(DBConnect dbc,String idRegion)throws Exception{
         
        String queryString = "SELECT r.nomregion FROM region r JOIN previsions p ON r.idregion=p.idregion WHERE p.idregion Like ?";
            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector<Region> resultTemp = new Vector();
            PreparedStatement prepSt = null;
             ResultSet rs = null;
        try{    
            prepSt = dbc.getConnection().prepareStatement(queryString);
            prepSt.setString(1, idRegion); //region = region dans les resultats des previsions
            
            rs = prepSt.executeQuery();
           
                  
            while(rs.next()){
                resultTemp.add(new Region(rs.getString("nomregion")));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(prepSt!=null){
                prepSt.close();
            }
        }
        //mbola misy blem tsy mamerina region
        Region reg=resultTemp.get(0);           
        return reg;
    }
    
    
    
    public void insertInto(DBConnect dbc,Object ob,String table) throws Exception {
		Statement req;
		@SuppressWarnings("unused")
		int nb = 0;
		String nomTable=table;
		
		Field[] m=ob.getClass().getDeclaredFields();
		String sql="";
		if(m[0].get(ob) instanceof String) {
                    sql=sql+"'"+m[0].get(ob)+"',";
                        
		}
		for(int i=1;i<m.length;i++){
			
			if(m[i].get(ob) instanceof Integer) {
				sql=sql+(Integer)m[i].get(ob);
			}
                        if(m[i].get(ob) instanceof Date) {
                            
                            //sql=sql+"'"+(Date)m[i].get(ob)+"'"; taloha 
                            String[] sqlarr = split(m[i].get(ob)+"'"," ");
                            sql=sql+"'"+sqlarr[0]+"'";
                            
                        }
			if(m[i].get(ob) instanceof String) {
				if(m[i].get(ob)!="") {
					if(m[i].get(ob).equals("SYSDATE")) {
						sql=sql+m[i].get(ob);
					}else {
						sql=sql+" '"+m[i].get(ob)+"' ";
					}
				}
				
			}if(m[i].get(ob) instanceof Double) {
				sql=sql+(double)m[i].get(ob);
			}
			if(i<m.length-1) {
				sql=sql+" , ";
			}
		}
		req = dbc.getConnection().createStatement();
                System.out.println(sql);
		nb=req.executeUpdate("INSERT INTO "+nomTable+" values("+sql+")");			
		req.execute("COMMIT");	
		req.close(); 
	}
    
    public String[]split(String c,String separate){
                @SuppressWarnings("Convert2Diamond")
		Vector<Integer>indices=new Vector<Integer>();
                @SuppressWarnings("UnusedAssignment")
		int i=0,j=0;
		char[]sep=separate.toCharArray();
		char separateur=sep[0];
		char[]tc=c.toCharArray();
		for(i=0;i<tc.length;i++)
		{
			if(tc[i]==separateur){
				indices.add(i);
				j++;
			}
		}
		String[]rep=new String[j+1];
		int a=0;
		for(i=0;i<j;i++)
		{
			Integer k=indices.get(i);
			int b=k.intValue();
			rep[i]=c.substring(a,b);
			a=b+1;
		}
		rep[j]=c.substring(a,tc.length);
		return rep;
	}
    
}

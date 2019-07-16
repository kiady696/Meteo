/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import model.User;

/**
 *
 * @author KIADY
 */
public class LoginDAO {
    
    public User[] getUsers(DBConnect dbc) throws Exception{
        
        String queryString = "SELECT * FROM US";
        @SuppressWarnings("UseOfObsoleteCollectionType")
        Vector<User> vect = new Vector();
        Statement st = null;
        ResultSet rs = null;       
            
        try{        
            st = dbc.getConnection().createStatement();
            rs = st.executeQuery(queryString);
            while(rs.next()){
            vect.add(new User(rs.getString(1),rs.getString(2)));
            }                       
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(st!=null){
                st.close();   
            }        
        }
        User[]results = new User[vect.size()];
        for(int i=0;i<vect.size();i++){
            
            results[i] = vect.get(i);
        }         
        return results;
    }
    
    public int checkUser(User[] users,String username,String password){
        for(int i=0;i<users.length;i++){
            if(username.equalsIgnoreCase(users[i].getNom()) && password.equalsIgnoreCase(users[i].getPassword())){
                return 0; //means regular user
            }
            else if(username.equals("sudo") && password.equals("root")){
                return 1; //means sudo
            }         
        }
        return -1;
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
                            
                            sql=sql+"'"+(Date)m[i].get(ob)+"'";
                            
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
    
    
}

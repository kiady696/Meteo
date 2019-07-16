/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBConnect;
import DAO.PrevisionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Prevision;

/**
 *
 * @author KIADY
 */
public class InsertPrevServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("text/html");
        
       
        DBConnect dbc = new DBConnect();
        try{
            PrintWriter out = res.getWriter();
            dbc.connect();
                
                PrevisionDAO pdao = new PrevisionDAO();
                //recuperer les parametres du formulaire
                String idPrevision = req.getParameter("idPrevision");
                String annee = req.getParameter("annee"); 
                int an = Integer.parseInt(annee);
                String mois = req.getParameter("mois");
                int month = Integer.parseInt(mois);
                String jour = req.getParameter("jour");
                int day = Integer.parseInt(jour);
                //Construire un Timestamp
                Timestamp tsp = new Timestamp(an-1900,month-1,day,0,0,0,0);
                String desc = req.getParameter("descPrevision");
                
                String tempMax = req.getParameter("tempMax");
                double tempMaxF = Double.parseDouble(tempMax);
                String tempMin = req.getParameter("tempMin");
                double tempMinF = Double.parseDouble(tempMin);
                
                String idRegion = req.getParameter("idRegion");
                
                Prevision pre = new Prevision(idPrevision,tsp,new Date(),desc,tempMaxF,tempMinF,idRegion);
                
                pdao.insertInto(dbc, pre, "previsions");
                out.println("insertion reussie,verifier dans la base");
                

                
                
                
                //construire une prevision
                //controle de donnees
                
                //pdao.insertInto(dbc, , "Previsions");
                
                
                res.sendRedirect("searchPrevDate.jsp");
                
            
            
               
                
           
        }
        catch (Exception ex) {
            req.setAttribute("messageErreur", ex.getMessage());
            RequestDispatcher dispat = req.getRequestDispatcher("/erreur.jsp"); //rehefa misy erreur de any foana
            dispat.forward(req,res);
        
        }        
        finally{
            try {
                dbc.disconnect();
            } catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}

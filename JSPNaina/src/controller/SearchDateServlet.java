/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Prevision;
import service.PrevisionService;

/**
 *
 * @author KIADY
 */
public class SearchDateServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        try {
            res.setStatus(200);
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();           
            
            PrevisionService ps = new PrevisionService();
            
            //convert strings annee,mois,jour en int            
            String annee = req.getParameter("annee"); 
            int an = Integer.parseInt(annee);
            String mois = req.getParameter("mois");
            int month = Integer.parseInt(mois);
            String jour = req.getParameter("jour");
            int day = Integer.parseInt(jour);

            //creates a Timestamp from parameters
            Timestamp date = new Timestamp(an-1900,month-1,day,0,0,0,0);
            
            //mset Prevision eto amzay misy exception catchena foana
            Prevision p = new Prevision("1",date,new Date(),"",66.0,66.0,"");
            
            ps.Meteo(date); //(fonctions DAO n ao anatin'io Meteo io)
            
            //alefa dispat koa le region reetra mifanaraka amn previsions azo
            
            req.setAttribute("regs", ps.getRegions());
            req.setAttribute("prevs",ps.getPrevisions());
            req.setAttribute("date", date);
            RequestDispatcher dispat = req.getRequestDispatcher("/results2.jsp");
            dispat.forward(req,res);
                       
            /*(tonga ao @ le result.jsp , ny fakana anle resultat:
            Ligne 1 :<%page import = "classes.*,DAO.*,Services.*
            
            <% Prevision[] prevs = (Prevision[]) request.getAttribute("prevs");%>*/                       
        } catch (Exception ex) {
            PrintWriter out = res.getWriter();
            req.setAttribute("messageErreur", ex.getMessage());
            RequestDispatcher dispat = req.getRequestDispatcher("/erreur.jsp"); //rehefa misy zavatra set-ena iany vo mandefa erreur (reefa misy any am base)
            dispat.forward(req,res);
            
            
        }
    }
    
}

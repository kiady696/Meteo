/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KIADY
 */
public class SearchEndroitServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        
        out.print("Bienvenue endroitSearch");
        
        //eto ny code mampipotra ny formulaire de menu voloany amle application
    }
    
}

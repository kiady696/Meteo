/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBConnect;
import DAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author KIADY
 */
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
       
        DBConnect dbc = new DBConnect();
        try{
            dbc.connect();
            LoginDAO ldao = new LoginDAO();
            User[] users = ldao.getUsers(dbc);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            //Check login if (user)->consulter Prevision par date/semaine/region  else if(sudo)-> createPrevision
            int check = ldao.checkUser(users,username,password);
            if(check == 1){
                res.sendRedirect("createPrevision.jsp");
            }else if(check == 0){
                //username = req.Session["id"];
                res.sendRedirect("searchPrevDate.jsp");
            }else if(check == -1){
                res.sendRedirect("loginErrorPage.jsp");
            }            
        }
        catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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

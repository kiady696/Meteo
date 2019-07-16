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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author KIADY
 */
public class SignInServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("text/html");
        
       
        DBConnect dbc = new DBConnect();
        try{
            PrintWriter out = res.getWriter();
            dbc.connect();
            LoginDAO ldao = new LoginDAO();
           
            //le avany am form inscription.jsp
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String password2 = req.getParameter("password2");

            //Check signin if password == password2 -> SignInServlet.insertInto(User)
            if(password.compareTo(password2)==0){
                User nouvo = new User(username,password2);
                
                ldao.insertInto(dbc, nouvo, "Us");
                //atao anaty session le nouvel utilisateur
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
                res.sendRedirect("searchPrevDate.jsp");
                
            }
            else{
                throw new Exception("Erreur d'inscription,reessayez");
                
            }
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

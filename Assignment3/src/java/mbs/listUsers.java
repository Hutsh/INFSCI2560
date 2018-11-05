/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hutsh
 */

public class listUsers extends HttpServlet {
    private Connection conn;
    private Statement st;
    private ResultSet rs=null;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
              Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/tianshuohu";
            conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM ASSIGNMENT3");
            rs =  st.executeQuery(q1);
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listUsers.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("allUsers", rs);
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);

       
        /* TODO output your page here */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ADMIN PAGE</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>All Users:</h1>");
        out.println("<ol>");
       try{
           while(rs.next())
           {
//             out.println("<li><a href=\"reviewMessage?file="+
//                 rs.getString("messageid")+
//                 "\">"+rs.getString("author")+"</a></li>");
             out.println("<li>"+rs.getString("name")+"</li>");
           }
       }
       catch(SQLException sqle)
                 {
            sqle.printStackTrace();  
        }

       /*for (int i=0;i<files.length;i++)
        {out.println("<li><a href=\"reviewMessage?file="+
                 files[i].getName().toString()+
                 "\">"+files[i].getName().toString()+"</a></li>");
        }*/
        out.println("</ol>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

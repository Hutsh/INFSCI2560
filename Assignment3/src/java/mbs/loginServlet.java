/*
 * To change this template, choose Tools | Templates
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author spring
 */
public class loginServlet extends HttpServlet {
    private Connection conn;
     private Statement st;
     private ResultSet rs=null;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        myBean ub = new myBean();
        session.setAttribute("ub",ub);
        boolean correctPassword = false;
        

        //depending on which form on index.jsp was used we login or register
        //failure returns to index.jsp, success spawns cw
        //the userbean is used to transfer information

        if(request.getParameter("log")!=null){
            String inputname = request.getParameter("name");
            String inputPass = request.getParameter("password");
            
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String connectionURL = "jdbc:derby://localhost:1527/tianshuohu";
                conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
                st = conn.createStatement();
                String q1 = new String("SELECT * FROM ASSIGNMENT3 WHERE NAME ='" + inputname + "'");
//                String q1 = new String("SELECT * FROM ASSIGNMENT3");
                rs =  st.executeQuery(q1);
            }        
            catch (SQLException se)
            {
                se.printStackTrace();  
            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(listMessages.class.getName()).log(Level.SEVERE, null, ex);
            }
                     

            
            
            
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>BBBBBBBBBBBBB</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<hr>");
//            out.println("<h1>"+inputPass+"</h1>");

            String correctPass = "";
            try{
//              correctPass = rs.getString("password");
                if( rs.next())
                {
                  correctPass = rs.getString("password");
                  ub.setAddress(rs.getString("address"));
                  ub.setAddress(rs.getString("address"));
                  ub.setPhone(rs.getString("phone"));
                  ub.setName(rs.getString("name"));
                  ub.setId(Integer.valueOf(rs.getString("id")));
                }
            }
            catch(SQLException sqle) {
                 sqle.printStackTrace();  
            }

//            out.println("<h2>correct password:" + correctPass + "</h2>");
//            out.println("<h2>input password:" + inputPass + "</h2>");
//            out.println("<h2>Address:" + ub.getAddress() + "</h2>");
//            out.println("<h2>phone:" + ub.getPhone() + "</h2>");
            

            ArrayList<ResultSet> userlist = new ArrayList<ResultSet>();
            ResultSet temp = null;
            
            ArrayList<ArrayList<String>> userListList = new ArrayList<ArrayList<String>>();
            
            
            if(correctPass.equals(inputPass)){ // correct password
//                out.println("<hr>");
//                out.println("<h1>Correst Password!</h1>");
                if (inputname.equals("admin")) { // go admin page

                    try {
                        st = conn.createStatement();
                        String q2 = new String("SELECT * FROM ASSIGNMENT3");
                        rs = st.executeQuery(q2);
                        
                        try {
                            while (rs.next()) {
                                ArrayList<String> userinfolist = new ArrayList<String>();
                                if (rs != null) {
                                    userinfolist.add(rs.getString("id"));
                                    userinfolist.add(rs.getString("name"));
                                    userinfolist.add(rs.getString("address"));
                                    userinfolist.add(rs.getString("phone"));
//                                  userlist.add(rs);
//                                  out.println("<li>" + rs.getString("name") + "</li>");
                                }
                                userListList.add(userinfolist);

                            }
                        } catch (SQLException sqle) {
                            sqle.printStackTrace();
                        }
 
                        
                        
                        
                        
                        
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    
                    
                    request.setAttribute("allUsers", userListList);
                    
                    
                    
                    request.getRequestDispatcher("adminPage.jsp").forward(request, response);

                    
                    
//                    response.sendRedirect("listUsers");
//                    response.sendRedirect("adminPage.jsp");
                }else{ // go userhome
                    ub.setStatus("LOGIN SUCCESS");
                    response.sendRedirect("userhome.jsp");
//                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/userhome.jsp");
//                    rd.forward(request, response);
                }
            }else{ // wrong 
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User name exist</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User name and password does not match</h1>");

                out.println("<hr>");
                out.println("<p><a href = \"\\Assignment3\">Back</a></p>");
                out.println("<p><a href =\"signUp.jsp\">Click to sign up</a></p>");

                out.println("</body>");
                out.println("</html>");
                out.close();
            }
//            out.println("</body>");
//            out.println("</html>");
            out.close();
            
            
//            if(request.getParameter("name").equals("Spring"))
//            {
//
//            ub.setStatus("LOGIN SUCCESS");
//            ub.setName(request.getParameter("name"));
//            ub.setId(1);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/userhome.jsp");
//            rd.forward(request, response);
//            }
//            else{
//            ub.setStatus("LOGIN FAILURE RETRY");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/userhome.jsp");
//            rd.forward(request, response);
//            }
//        }
//            
            
            
        /*
        if(request.getParameter("reg")!=null)
            {
            if (!request.getParameter("password2").equals(request.getParameter("password1")))
                {
                ub.setloginStatus("Registration Failed, passwords didn't match");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                }
            else
                {int status = dbm.registerUser(
                request.getParameter("fname"), request.getParameter("lname"),
                request.getParameter("email"), request.getParameter("uname"),
                request.getParameter("password1"));
                if(status==1)
                    {
                    ub.setloginStatus(dbm.getUserName(request.getParameter("username"))+" is now registered and logged in.");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cw.jsp");
                    rd.forward(request, response);
                    }
                else{
                    ub.setloginStatus("Registration Failed, existing username, please try again");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                    }
                }
            }
        */
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

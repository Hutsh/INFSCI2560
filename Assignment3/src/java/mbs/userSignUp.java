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
import javax.servlet.http.HttpSession;


public class userSignUp extends HttpServlet {

    private Connection conn;
    private Statement st;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bytesread;
        char[] cbuf = new char[128];
        ResultSet rs = null;
        ResultSet allname = null;
        
        HttpSession session=request.getSession(true);
        myBean ub = new myBean();
        session.setAttribute("ub", ub);
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        String newName = request.getParameter("name");
        String newAddress = request.getParameter("address");
        String newPhone = request.getParameter("phone");
        String newPass = request.getParameter("password");
        String newPass2 = request.getParameter("password2");
        
//        try {
//            if (rs.next()) {
//                
//            } else {
//                out.println("</tr><td>No Message Found</td><tr>");
//            }
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }

//        String updateAddress = "UPDATE ASSIGNMENT3 SET ADDRESS='" + newAddress + "' WHERE ID=" + id ;
//        String updatePhone = "UPDATE ASSIGNMENT3 SET PHONE='" + newPhone + "' WHERE ID=" + id ;
//        String updatePassword = "UPDATE ASSIGNMENT3 SET PASSWORD='" + newPass + "' WHERE ID=" + id ;
        
        
        
        try { //insert user
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/tianshuohu";
            conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");

            st = conn.createStatement();
            
            String maxId = "SELECT * FROM ASSIGNMENT3 WHERE id = (SELECT MAX(id) FROM ASSIGNMENT3)";
            String allnamesql = "select NAME from ASSIGNMENT3";
            allname = st.executeQuery(allnamesql);
            Boolean nameExist = false;
            String curname;
            while (allname.next()) {
                curname = allname.getString("name");
                if (curname.equals(newName)) {
                    nameExist = true;
                }
            }

            if (nameExist) { //用户名存在
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User name exist</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User name exist</h1>");

                out.println("<hr>");
                out.println("<h1>ID:" + id + "</h1>");
                out.println("<h1>" + newName + "</h1>");
                out.println("<h1>" + newAddress + "</h1>");
                out.println("<h1>newPhone:" + newPhone + "</h1>");
                out.println("<h1>newPass:" + newPass + "</h1>");
                out.println("<h1>newPass2:" + newPass2 + "</h1>");
                out.println("<hr>");
                out.println("<a href =\"signUp.jsp\">Click to sign up</a>");

                out.println("</body>");
                out.println("</html>");
            } else {
                rs = st.executeQuery(maxId);
                String nextId = "-1";

                if (rs.next()) {
                    nextId = String.valueOf(Integer.parseInt(rs.getString("id")) + 1);
                }

                String insertSql1 = "INSERT INTO IS2560.ASSIGNMENT3 (ID, \"NAME\", PASSWORD, ADDRESS, PHONE) VALUES (";
                String insertSql2 = nextId + ", '" + newName + "', '" + newPass + "', '" + newAddress + "', '" + newPhone + "')";
                String insertSql = insertSql1 + insertSql2;

                st.executeUpdate(insertSql);
                
                
                ub.setId(Integer.parseInt(nextId));
                ub.setAddress(newAddress);
                ub.setPhone(newPhone);
                ub.setName(newName);


                out.println("<html>");
                out.println("<head>");
                out.println("<title>Sign Up Success</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Success!</h1>");
                out.println("<a href =\"userhome.jsp\">Click here to user home</a>");

                out.println("</body>");
                out.println("</html>");

            }


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editMyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }



        

        if (false) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String connectionURL = "jdbc:derby://localhost:1527/tianshuohu";
                conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
                st = conn.createStatement();
                String q1 = new String("SELECT * FROM ASSIGNMENT3 WHERE NAME = "
                        + request.getParameter("id"));
                rs = st.executeQuery(q1);
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(editMyInfo.class.getName()).log(Level.SEVERE, null, ex);
            }

            /* TODO output your page here */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reviewMessage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Review Message Page</h1>");
            out.println("<h3><a href =\"listMessages\">Click here to got back to the message list</a></h3>");
            out.println("<form method =\"post\" action = \"acceptMessage\">");
            out.println("<input type=\"hidden\" name=\"file\" value=\"" + request.getParameter("file") + "\" />");
            out.println("<table border=\"1\"> <tbody>");
            try {
                if (rs.next()) {
                    out.println("<tr><td>Name:</td>");
                    out.println("<td><input type=\"text\" name=\"sender\" value=\"" + rs.getString("author") + "\" size=\"50\" /></td>");
                    out.println("</tr><tr>");
                    out.println("<tr><td>Title:</td>");
                    out.println("<td><input type=\"text\" name=\"title\" value=\"" + rs.getString("title") + "\" size=\"50\" /></td>");
                    out.println("</tr><tr>");
                    out.println("<td> Message:</td>");
                    out.println("<td><textarea name=\"message\" rows=\"4\" cols=\"50\">");
                    out.println(rs.getString("message"));
                } else {
                    out.println("</tr><td>No Message Found</td><tr>");
                }
                /*
    File SD= new File("c:\\spring\\TmpMsgDat\\"+request.getParameter("file"));
    FileReader fr = new FileReader(SD);
    while ((bytesread=fr.read(cbuf, 0, 128))!=-1)
    {String ps = new String(cbuf, 0, bytesread);
        out.println(ps);}
                 */

            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

            out.println("</textarea></td>");
            out.println("</tr> <tr> <td></td>");
            out.println("<td><input type=\"submit\" value=\"Save Edited Message\" name=\"Submit\" /></td>");
            out.println(" </tr> </tbody></table> </form>");
            out.println("</body>");
            out.println("</html>");

            out.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

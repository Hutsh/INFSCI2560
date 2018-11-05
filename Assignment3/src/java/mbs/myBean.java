/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mbs;

import java.io.Serializable;

/**
 * @author spring
 */
public class myBean extends Object implements Serializable {

    public static final String ISTATUS = "Login";

    private String status;
    private int id;
    private String name;
    private String address;
    private String phone;

    public myBean() {
        status = ISTATUS;
        id=0;
        name = new String();
        address = new String();
        phone = new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public int getId() {return id;}
    public void setId(int value) {id = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}
    
    public String getAddress() { return address;}
    public void setAddress(String value) { address = value;}
    
    public String getPhone() {return phone;}
    public String setPhone(String value) {return phone = value;}
}

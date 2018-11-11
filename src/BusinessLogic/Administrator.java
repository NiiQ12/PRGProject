/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;

/**
 *
 * @author Nicky
 */
public class Administrator extends Employee implements Serializable
{
    public static String loggedInAdminID = "";
    
    public Administrator(String id, String name, String surname, String cellNo, String email, Address address, Login login)
    {
        super(id, name, surname, cellNo, email, address, login);
    }    
}

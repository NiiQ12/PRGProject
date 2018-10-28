/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Hendriko
 */
public class Login
{
    private int loginID;
    private String username;
    private String password;

    public Login(int loginID, String username, String password)
    {
        this.loginID = loginID;
        this.username = username;
        this.password = password;
    }

    public int getLoginID()
    {
        return loginID;
    }

    public void setLoginID(int loginID)
    {
        this.loginID = loginID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public static boolean TestLogin(String username, String password) throws SQLException, ClassNotFoundException
    {
        boolean isValidLogin;
               
        List<Object> lst = DataHandler.Login(username, password);
        
        if (lst.isEmpty())
        {
            isValidLogin = false;
        } else
        {
            EmployeeType et = (EmployeeType) lst.get(1);
            
            switch (et)
            {
                case Staff:
                    Staff.loggedInStaffID = lst.get(0).toString();
                    break;
                case Admin:
                    Administrator.loggedInAdminID = lst.get(0).toString();
                    break;
            }
            
            isValidLogin = true;
        }
        
        DataHandler.CloseConnection();
        
        return isValidLogin;
    }

    public static boolean CheckLogin(String username) throws SQLException, ClassNotFoundException
    {
        boolean isAvailable = DataHandler.CheckLogin(username);
        
        DataHandler.CloseConnection();
        
        return isAvailable;
    }
    
    @Override
    public String toString()
    {
        return "Login{" + "loginID=" + loginID + ", username=" + username + ", password=" + password + '}';
    }
}

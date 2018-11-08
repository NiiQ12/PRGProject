/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hendriko
 */
public class Login
{
    private int loginID;
    private String username;
    private String password;
    private boolean registered;

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

    public boolean isRegistered()
    {
        return registered;
    }

    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }

    public static boolean TestLogin(String username, String password) throws SQLException, ClassNotFoundException
    {
        boolean isValidLogin;

        List<Object> lst = DataHandler.GetInstance().Login(username, password);

        if (lst.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Invalid login details!");

            isValidLogin = false;
        } else
        {
            EmployeeType et = (EmployeeType) lst.get(1);

            isValidLogin = true;

            switch (et)
            {
                case Staff:
                    if (lst.get(2).equals(false))
                    {
                        JOptionPane.showMessageDialog(null, "This account has not been registered by an admin!");

                        isValidLogin = false;
                    } else
                    {
                        Staff.loggedInStaffID = lst.get(0).toString();
                    }
                    break;
                case Admin:
                    Administrator.loggedInAdminID = lst.get(0).toString();
                    break;
            }
        }

        DataHandler.GetInstance().CloseConnection();

        return isValidLogin;
    }

    public static boolean CheckLogin(String username) throws SQLException, ClassNotFoundException
    {
        boolean isAvailable = DataHandler.GetInstance().CheckLogin(username);

        DataHandler.GetInstance().CloseConnection();

        return isAvailable;
    }

    public static int GetLoginID(String username, String password) throws ClassNotFoundException, SQLException
    {
        int loginID = DataHandler.GetInstance().GetLoginID(username, password);

        return loginID;
    }

    public Login(int loginID, String username, String password, boolean registered)
    {
        this.loginID = loginID;
        this.username = username;
        this.password = password;
        this.registered = registered;
    }

    @Override
    public String toString()
    {
        return "Login{" + "loginID=" + loginID + ", username=" + username + ", password=" + password + '}';
    }
}

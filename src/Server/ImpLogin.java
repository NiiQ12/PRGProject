/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.Administrator;
import BusinessLogic.EmployeeType;
import BusinessLogic.ILogin;
import BusinessLogic.Staff;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class ImpLogin extends UnicastRemoteObject implements ILogin
{
    public ImpLogin() throws RemoteException
    {

    }

    @Override
    public List<Object> TestLogin(String username, String password) throws SQLException, ClassNotFoundException, RemoteException
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
                        Administrator.loggedInAdminID = "";
                    }
                    break;
                case Admin:
                    Administrator.loggedInAdminID = lst.get(0).toString();
                    Staff.loggedInStaffID = "";
                    break;
            }
        }

        DataHandler.GetInstance().CloseConnection();
        
        return lst;
    }

    @Override
    public boolean CheckLogin(String username) throws SQLException, ClassNotFoundException, RemoteException
    {
        boolean isAvailable = DataHandler.GetInstance().CheckLogin(username);

        DataHandler.GetInstance().CloseConnection();

        return isAvailable;
    }

    @Override
    public int GetLoginID(String username, String password) throws ClassNotFoundException, SQLException, RemoteException
    {
        int loginID = DataHandler.GetInstance().GetLoginID(username, password);

        return loginID;
    }
}

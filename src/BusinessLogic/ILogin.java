/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicky
 */
public interface ILogin extends Remote
{    
    public List<Object> TestLogin(String username, String password) throws SQLException, ClassNotFoundException, RemoteException;
    public boolean CheckLogin(String username) throws SQLException, ClassNotFoundException, RemoteException;
    public int GetLoginID(String username, String password) throws SQLException, ClassNotFoundException, RemoteException;
}

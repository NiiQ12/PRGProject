/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Nicky
 */
public interface IAddress extends Remote
{
    public int GetAddressID(String city, String suburb, String street, String port) throws SQLException, ClassNotFoundException, RemoteException;
}

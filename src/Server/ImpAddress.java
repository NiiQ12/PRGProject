/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 *
 * @author Nicky
 */
public class ImpAddress extends UnicastRemoteObject implements IAddress
{
    public ImpAddress() throws RemoteException
    {

    }   
    
    @Override
    public int GetAddressID(String city, String suburb, String street, String port) throws SQLException, ClassNotFoundException, RemoteException
    {
        int addressID = DataHandler.GetInstance().GetAddressID(city, suburb, street, port);
        
        return addressID;
    }
}

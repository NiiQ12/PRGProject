/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IManufacturer;
import BusinessLogic.Manufacturer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class ImpManufacturer extends UnicastRemoteObject implements IManufacturer
{
    public ImpManufacturer() throws RemoteException
    {

    }   
    
    @Override
    public List<Manufacturer> GetManufacturers() throws SQLException, ClassNotFoundException, RemoteException
    {
        List<Manufacturer> manufacturers = new ArrayList<>();
                
        ResultSet rs = DataHandler.GetInstance().GetManufacturers();
        
        while (rs.next())
        {            
            manufacturers.add(new Manufacturer(rs.getInt(1), rs.getString(2)));
        }
        
        return manufacturers;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IDepartment;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicky
 */
public class ImpDepartment extends UnicastRemoteObject implements IDepartment
{
    public ImpDepartment() throws RemoteException
    {

    }   
    
    @Override
    public ArrayList<String> GetDepartmentsFromDatabase() throws SQLException, ClassNotFoundException, RemoteException
    {
        ArrayList<String> departments = new ArrayList<>();
        
        ResultSet rs = DataHandler.GetInstance().GetDepartment();
        
        while(rs.next())
        {
            departments.add(rs.getString("Description"));
        }
        
        return departments;
    }
}

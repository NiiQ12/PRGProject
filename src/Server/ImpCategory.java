/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.Category;
import BusinessLogic.ICategory;
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
public class ImpCategory extends UnicastRemoteObject implements ICategory
{
    public ImpCategory() throws RemoteException
    {

    }   
    
    @Override
    public List<Category> GetCategories() throws SQLException, ClassNotFoundException, RemoteException
    {
        List<Category> categories = new ArrayList<>();
        ResultSet rs = DataHandler.GetInstance().GetCategories();
        
        while (rs.next())
        {            
            categories.add(new Category(rs.getInt(1), rs.getString(2)));
        }
        
        DataHandler.GetInstance().CloseConnection();
        
        return categories;
    }
}

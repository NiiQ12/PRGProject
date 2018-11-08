/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DataHandler;

/**
 *
 * @author Nicky
 */
public class Category
{
    private int id;
    private String description;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public static List<Category> GetCategories() throws SQLException, ClassNotFoundException
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

    public Category(int id, String description)
    {
        this.id = id;
        this.description = description;
    }   
}

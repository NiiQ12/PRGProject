/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class Manufacturer
{
    private int id;
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public static List<Manufacturer> GetManufacturers() throws SQLException, ClassNotFoundException
    {
        List<Manufacturer> manufacturers = new ArrayList<>();
                
        ResultSet rs = DataHandler.GetInstance().GetManufacturers();
        
        while (rs.next())
        {            
            manufacturers.add(new Manufacturer(rs.getInt(1), rs.getString(2)));
        }
        
        return manufacturers;
    }

    public Manufacturer(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

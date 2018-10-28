/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import com.sun.rowset.internal.Row;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DataAccess.DataHandler;

/**
 *
 * @author Nicky
 */
public class Stationery
{
    private int stationeryCode;
    private String category;
    private String Description;
    private int stock;
    private double price;
    private String manufacturer;
    
    private int quantity;
    
    public int getStationeryCode()
    {
        return stationeryCode;
    }

    public void setStationeryCode(int stationeryCode)
    {
        this.stationeryCode = stationeryCode;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }
    
    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public static void AddStationery(int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException
    {
        DataHandler.AddStationery(categoryID, description, stock, price, manufactureID);
    }
    
    public static void UpdateStationery(int stationeryCode, int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException
    {
        DataHandler.UpdateStationery(stationeryCode, categoryID, description, stock, price, manufactureID);
    }
    
    public void UpdateStationeryStock(int newStock) throws SQLException, ClassNotFoundException
    {
        DataHandler.UpdateStationeryStock(this.stationeryCode, newStock);
    }
    
    public static void DeleteStationery(int stationeryCode) throws SQLException, ClassNotFoundException
    {
        DataHandler.DeleteStationery(stationeryCode);
    }
    
    public static List<Stationery> GetStationery(String description, int categoryID) throws SQLException, ClassNotFoundException
    {
        List<Stationery> stationeries = new ArrayList<>();
        
        ResultSet rs = DataHandler.GetStationery(description, categoryID);
            
        while (rs.next())
        {            
            stationeries.add(new Stationery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6)));
        }
        
        DataHandler.CloseConnection();
        
        return stationeries;
    }
    
    public static int GetLastStationeryCode() throws ClassNotFoundException, SQLException
    {
        int code = 0;
        
        ResultSet rs = DataHandler.GetLastStationeryCode();
                
        while (rs.next())
        {            
            code = rs.getInt(1) + 1;
        }
        
        DataHandler.CloseConnection();
        
        return code;
    }

    public Stationery()
    {
    }

    public Stationery(int stationeryCode, String category, String Description, int stock, double price, String manufacturer)
    {
        this.stationeryCode = stationeryCode;
        this.category = category;
        this.Description = Description;
        this.stock = stock;
        this.price = price;
        this.manufacturer = manufacturer;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s", this.stationeryCode);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessLogic.*;
import DataAccess.DataHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class OrderDetail
{
    private int id;
    private int stationeryCode;
    private String category;
    private String description;
    private double price;
    private int quantity;
    
    public int getStationeryCode()
    {
        return stationeryCode;
    }

    public void setStationeryCode(int stationeryCode)
    {
        this.stationeryCode = stationeryCode;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
        
    
    public OrderDetail()
    {
        
    }

    public OrderDetail(int id, int stationeryCode, int quantity)
    {
        this.id = id;
        this.stationeryCode = stationeryCode;
        this.quantity = quantity;
    }

    public OrderDetail(int id, int stationeryCode, String category, String description, double price, int quantity)
    {
        this.id = id;
        this.stationeryCode = stationeryCode;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return String.format("%-10d%-15s%-20s%s %6.2f   %-10d", this.stationeryCode, this.category, this.description, NumberFormat.getCurrencyInstance().getCurrency().getSymbol(), this.price, this.quantity);
    }
    
    
}

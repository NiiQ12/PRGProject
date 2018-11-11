/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;

/**
 *
 * @author Nicky
 */
public class Stationery implements Serializable
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

    public Stationery(int stationeryCode, String category, String Description, int stock, double price, String manufacturer, int quantity)
    {
        this.stationeryCode = stationeryCode;
        this.category = category;
        this.Description = Description;
        this.stock = stock;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    @Override
    public String toString()
    {
        return String.format("%s", this.stationeryCode);
    }
}

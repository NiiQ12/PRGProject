/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.SQLException;

/**
 *
 * @author Hendriko
 */
public class Address
{
    private int addressID;
    private String city;
    private String suburb;
    private String street;
    private String port;

    public Address(int addressID, String city, String suburb, String street, String port)
    {
        this.addressID = addressID;
        this.city = city;
        this.suburb = suburb;
        this.street = street;
        this.port = port;
    }
    
    public int getAddressID()
    {
        return addressID;
    }

    public void setAddressID(int addressID)
    {
        this.addressID = addressID;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public static int GetAddressID(String city, String suburb, String street, String port) throws SQLException, ClassNotFoundException
    {
        int addressID = DataHandler.GetAddressID(city, suburb, street, port);
        
        return addressID;
    }
    
    @Override
    public String toString()
    {
        return "Address{" + "addressID=" + addressID + ", city=" + city + ", suburb=" + suburb + ", street=" + street + ", port=" + port + '}';
    }      
}

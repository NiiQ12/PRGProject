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
public class RequestDetail implements Serializable
{
    private int id;
    private int stationeryCode;
    private String category;
    private String description;
    private int quantity;

    public int getStationeryCode()
    {
        return stationeryCode;
    }

    public void setStationeryCode(int stationeryCode)
    {
        this.stationeryCode = stationeryCode;
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

    public RequestDetail()
    {

    }

    public RequestDetail(int stationeryCode, int quantity)
    {
        this.stationeryCode = stationeryCode;
        this.quantity = quantity;
    }

    public RequestDetail(int id, int stationeryCode, String category, String description, int quantity)
    {
        this.id = id;
        this.stationeryCode = stationeryCode;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }
}

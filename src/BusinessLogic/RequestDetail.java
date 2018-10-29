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
public class RequestDetail
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
        
    public void AddRequestDetail(int requestID) throws SQLException, ClassNotFoundException
    {
        DataHandler.AddRequestDetail(requestID, this.stationeryCode, this.quantity);
    }
    
    public static List<RequestDetail> GetRequestDetails(RequestType rt) throws SQLException, ClassNotFoundException
    {
        List<RequestDetail> requestDetails = new ArrayList<>();
        
        ResultSet rs = DataHandler.GetRequestDetails(rt);
        
        while (rs.next())
        {            
            requestDetails.add(new RequestDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        
        return requestDetails;
    }
    
    public void UpdateCancelledRequestDetailQuantity(int stationeryCode, int quantity) throws SQLException, ClassNotFoundException // REGISTER
    {
        DataHandler.UpdateCancelledRequestDetailQuantity(this.stationeryCode, this.quantity);
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

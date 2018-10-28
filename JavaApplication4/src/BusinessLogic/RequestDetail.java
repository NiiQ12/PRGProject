/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class RequestDetail
{
    private int stationeryCode;
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
    
    public void AddRequestDetail(int requestID) throws SQLException, ClassNotFoundException
    {
        DataHandler.AddRequestDetail(requestID, this.stationeryCode, this.quantity);
    }
    
    public RequestDetail()
    {
        
    }

    public RequestDetail(int stationeryCode, int quantity)
    {
        this.stationeryCode = stationeryCode;
        this.quantity = quantity;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class Order implements Serializable
{
    private int orderID;
    private Date date;
    private String adminID;
    private List<OrderDetail> orderDetails;

    public int getOrderID()
    {
        return orderID;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getAdminID()
    {
        return adminID;
    }

    public void setAdminID(String adminID)
    {
        this.adminID = adminID;
    }

    public List<OrderDetail> getOrderDetails()
    {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails)
    {
        this.orderDetails = orderDetails;
    }

    public Order()
    {

    }

    public Order(int orderID, Date date, String adminID, List<OrderDetail> orderDetails)
    {
        this.orderID = orderID;
        this.date = date;
        this.adminID = adminID;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString()
    {
        return String.format("ORDER ID : %d\nDATE     : %s\nADMIN ID : %s", this.orderID, this.date, this.adminID);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import BusinessLogic.*;
import DataAccess.DataHandler;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class Order
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

    public void AddOrder() throws ClassNotFoundException, SQLException
    {
        DataHandler.AddOrder(this.date);
        
        int orderID = Order.GetLastOrderID();
        
        for (OrderDetail orderDetail : this.orderDetails)
        {
            orderDetail.setId(orderID);
        }
        
        OrderDetail.AddOrderDetails(this.orderDetails);
    }

    public static int GetLastOrderID() throws ClassNotFoundException, SQLException
    {
        int latestOrderID = DataHandler.GetLastOrderID();

        return latestOrderID;
    }

    public static List<Order> GetOrders(ReportType rt) throws SQLException, ClassNotFoundException
    {
        List<Order> orders = new ArrayList<>();

        ResultSet rs = DataHandler.GetOrders(rt);

        while (rs.next())
        {
            List<OrderDetail> orderDetails = OrderDetail.GetOrderDetails(rs.getInt(1));
            orders.add(new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), orderDetails));
        }

        DataHandler.CloseConnection();

        return orders;
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

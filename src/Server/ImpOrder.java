/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IOrder;
import BusinessLogic.Order;
import BusinessLogic.OrderDetail;
import BusinessLogic.ReportType;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class ImpOrder extends UnicastRemoteObject implements IOrder
{
    public ImpOrder() throws RemoteException
    {

    }   
    
    @Override
    public void AddOrder(Order order) throws ClassNotFoundException, SQLException, RemoteException
    {
        DataHandler.GetInstance().AddOrder(order.getDate());
        
        int orderID = GetLastOrderID();
        
        for (OrderDetail orderDetail : order.getOrderDetails())
        {
            orderDetail.setId(orderID);
        }
        
        ImpOrderDetail.AddOrderDetails(order.getOrderDetails());
    }

    @Override
    public int GetLastOrderID() throws ClassNotFoundException, SQLException, RemoteException
    {
        int latestOrderID = DataHandler.GetInstance().GetLastOrderID();

        return latestOrderID;
    }

    @Override
    public List<Order> GetOrders(ReportType rt) throws SQLException, ClassNotFoundException, RemoteException
    {
        List<Order> orders = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetOrders(rt);

        while (rs.next())
        {
            List<OrderDetail> orderDetails = ImpOrderDetail.GetOrderDetails(rs.getInt(1));
            orders.add(new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), orderDetails));
        }

        DataHandler.GetInstance().CloseConnection();

        return orders;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.OrderDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class ImpOrderDetail
{
    public static List<OrderDetail> GetOrderDetails(int id) throws SQLException, ClassNotFoundException
    {
        List<OrderDetail> orderDetails = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetOrderDetails(id);

        while (rs.next())
        {
            orderDetails.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
        }

        return orderDetails;
    }

    public static void AddOrderDetails(List<OrderDetail> orderDetails) throws ClassNotFoundException, SQLException
    {
        for (int i = 0; i < orderDetails.size(); i++)
        {
            DataHandler.GetInstance().AddOrderDetails(orderDetails.get(i).getId(), orderDetails.get(i).getStationeryCode(), orderDetails.get(i).getQuantity());
        }
    }
}

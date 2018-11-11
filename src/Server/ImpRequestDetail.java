/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.RequestDetail;
import BusinessLogic.RequestType;
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
public class ImpRequestDetail
{
    public static void AddRequestDetail(int requestID, RequestDetail rd) throws SQLException, ClassNotFoundException
    {
        DataHandler.GetInstance().AddRequestDetail(requestID, rd.getStationeryCode(), rd.getQuantity());
    }

    public static List<RequestDetail> GetRequestDetails(RequestType rt) throws SQLException, ClassNotFoundException
    {
        List<RequestDetail> requestDetails = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetRequestDetails(rt);

        while (rs.next())
        {
            requestDetails.add(new RequestDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }

        return requestDetails;
    }

    public static void UpdateCancelledRequestDetailQuantity(int stationeryCode, int quantity) throws SQLException, ClassNotFoundException
    {
        DataHandler.GetInstance().UpdateCancelledRequestDetailQuantity(stationeryCode, quantity);
    }
}

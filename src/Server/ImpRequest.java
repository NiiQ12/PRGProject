/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IRequest;
import BusinessLogic.Request;
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
public class ImpRequest extends UnicastRemoteObject implements IRequest
{    
    public ImpRequest() throws RemoteException
    {

    }   
    
    @Override
    public void AddRequest(Request request) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().AddRequest(request.getStaffID(), request.getRequestDate());

        ResultSet rs = DataHandler.GetInstance().GetLastRequestID();

        int requestID = 0;
        
        while (rs.next())
        {
            requestID = rs.getInt(1);
        }

        for (RequestDetail requestDetail : request.getRequestDetails())
        {
            ImpRequestDetail.AddRequestDetail(requestID, requestDetail);
        }

        DataHandler.GetInstance().CloseConnection();
    }

    @Override
    public List<Request> GetRequests(RequestType rt) throws SQLException, ClassNotFoundException, RemoteException
    {
        List<Request> requests = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetRequests(rt);

        List<RequestDetail> requestDetails = ImpRequestDetail.GetRequestDetails(rt);

        while (rs.next())
        {
            requests.add(new Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6), requestDetails));
        }

        DataHandler.GetInstance().CloseConnection();

        return requests;
    }

    @Override
    public void CancelRequest(Request request) throws SQLException, ClassNotFoundException, RemoteException
    {
        for (RequestDetail requestDetail : request.getRequestDetails())
        {
            System.out.println(requestDetail.getStationeryCode());
            ImpRequestDetail.UpdateCancelledRequestDetailQuantity(requestDetail.getId(), requestDetail.getQuantity());
        }

        DataHandler.GetInstance().DeleteRequest(request.getRequestID());
    }

    @Override
    public void AcceptRequest(int requestID, String message, int days) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().AcceptRequest(requestID, message, days);
    }

    @Override
    public void RejectRequest(int requestID, String message) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().RejectRequest(requestID, message);
    }

    @Override
    public void RefillCancelledRequestQuantities(Request request) throws ClassNotFoundException, SQLException, RemoteException
    {
        for (int i = 0; i < request.getRequestDetails().size(); i++)
        {
            DataHandler.GetInstance().RefillCancelledRequestQuantities(request.getRequestDetails().get(i).getStationeryCode(), request.getRequestDetails().get(i).getQuantity());
        }
    }
}

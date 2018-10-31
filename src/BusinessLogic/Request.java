/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class Request
{

    private int requestID;
    private String staffID;
    private String adminID;
    private Date requestDate;
    private Date receiveDate;
    private boolean requestAccepted;
    private List<RequestDetail> requestDetails;

    public int getRequestID()
    {
        return requestID;
    }

    public void setRequestID(int requestID)
    {
        this.requestID = requestID;
    }

    public String getStaffID()
    {
        return staffID;
    }

    public void setStaffID(String staffID)
    {
        this.staffID = staffID;
    }

    public String getAdminID()
    {
        return adminID;
    }

    public void setAdminID(String adminID)
    {
        this.adminID = adminID;
    }

    public Date getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(Date requestDate)
    {
        this.requestDate = requestDate;
    }

    public Date getReceiveDate()
    {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate)
    {
        this.receiveDate = receiveDate;
    }

    public boolean isRequestAccepted()
    {
        return requestAccepted;
    }

    public void setRequestAccepted(boolean requestAccepted)
    {
        this.requestAccepted = requestAccepted;
    }

    public List<RequestDetail> getRequestDetails()
    {
        return requestDetails;
    }

    public void setRequestDetails(List<RequestDetail> requestDetails)
    {
        this.requestDetails = requestDetails;
    }

    public void AddRequest() throws SQLException, ClassNotFoundException
    {
        DataHandler.AddRequest(this.staffID, this.requestDate);

        ResultSet rs = DataHandler.GetLastRequestID();

        while (rs.next())
        {
            this.requestID = rs.getInt(1);
        }

        for (RequestDetail requestDetail : requestDetails)
        {
            requestDetail.AddRequestDetail(requestID);
        }

        DataHandler.CloseConnection();
    }

    public static List<Request> GetRequests(RequestType rt) throws SQLException, ClassNotFoundException
    {
        List<Request> requests = new ArrayList<>();

        ResultSet rs = DataHandler.GetRequests(rt);

        List<RequestDetail> requestDetails = RequestDetail.GetRequestDetails(rt);

        while (rs.next())
        {
            requests.add(new Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6), requestDetails));
        }

        DataHandler.CloseConnection();

        return requests;
    }

    public void CancelRequest() throws SQLException, ClassNotFoundException
    {
        for (RequestDetail requestDetail : this.requestDetails)
        {
            System.out.println(requestDetail.getStationeryCode());
            requestDetail.UpdateCancelledRequestDetailQuantity(requestDetail.getId(), requestDetail.getQuantity());
        }

        DataHandler.DeleteRequest(this.requestID);
    }

    public static void AcceptRequest(int requestID) throws SQLException, ClassNotFoundException
    {
        DataHandler.AcceptRequest(requestID);
    }

    public static void RejectRequest(int requestID) throws SQLException, ClassNotFoundException
    {
        DataHandler.RejectRequest(requestID);
    }

    public void RefillCancelledRequestQuantities() throws ClassNotFoundException, SQLException
    {
        for (int i = 0; i < this.requestDetails.size(); i++)
        {
            DataHandler.RefillCancelledRequestQuantities(requestDetails.get(i).getStationeryCode(), requestDetails.get(i).getQuantity());
        }
    }

    public Request()
    {

    }

    public Request(String staffID, List<RequestDetail> requestDetails)
    {
        this.staffID = staffID;

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        this.requestDate = date;
        this.requestDetails = requestDetails;
    }

    public Request(int requestID, String staffID, String adminID, Date requestDate, Date receiveDate, boolean requestAccepted, List<RequestDetail> requestDetails)
    {
        this.requestID = requestID;
        this.staffID = staffID;
        this.adminID = adminID;
        this.requestDate = requestDate;
        this.receiveDate = receiveDate;
        this.requestAccepted = requestAccepted;
        this.requestDetails = requestDetails;
    }
}

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
    
    public static List<Request> GetRequests() throws SQLException, ClassNotFoundException
    {
        List<Request> requests = new ArrayList<>();
        
        ResultSet rs = DataHandler.GetRequests();
        
        List<RequestDetail> requestDetails = RequestDetail.GetRequestDetails();
        
        while (rs.next())
        {            
            requests.add(new Request(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getBoolean(6), requestDetails));
        }
        
        return requests;
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

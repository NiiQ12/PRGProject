/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicky
 */
public interface IRequest extends Remote
{
    public void AddRequest(Request request) throws SQLException, ClassNotFoundException, RemoteException;
    public List<Request> GetRequests(RequestType rt) throws SQLException, ClassNotFoundException, RemoteException;
    public void CancelRequest(Request request) throws SQLException, ClassNotFoundException, RemoteException;
    public void AcceptRequest(int requestID, String message, int days) throws SQLException, ClassNotFoundException, RemoteException;
    public void RejectRequest(int requestID, String message) throws SQLException, ClassNotFoundException, RemoteException;
    public void RefillCancelledRequestQuantities(Request request) throws SQLException, ClassNotFoundException, RemoteException;
}

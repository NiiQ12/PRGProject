/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicky
 */
public interface IStaff extends Remote
{
    public ArrayList<Staff> GetStaffFromDatabase(CampusType ct) throws SQLException, ClassNotFoundException, RemoteException;
    public Staff GetStaffFromDatabase(String id) throws SQLException, ClassNotFoundException, RemoteException;
    public void AddNewStaffMember(Staff staff) throws SQLException, ClassNotFoundException, RemoteException;
    public void UpdateStaffMember(Staff staff) throws SQLException, ClassNotFoundException, RemoteException;
    public void RegisterStaff(String staffID) throws SQLException, ClassNotFoundException, RemoteException;
    public void UnregisterStaff(String staffID) throws SQLException, ClassNotFoundException, RemoteException;
    public void CheckAdminResponses(String staffID) throws SQLException, ClassNotFoundException, RemoteException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.Address;
import BusinessLogic.CampusType;
import BusinessLogic.Department;
import BusinessLogic.IStaff;
import BusinessLogic.Login;
import BusinessLogic.Staff;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class ImpStaff extends UnicastRemoteObject implements IStaff
{
    public ImpStaff() throws RemoteException
    {

    }   
    
    @Override
    public ArrayList<Staff> GetStaffFromDatabase(CampusType ct) throws SQLException, ClassNotFoundException, RemoteException
    {
        ArrayList<Staff> staffMembers = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetStaff(ct);

        while (rs.next())
        {
            staffMembers.add(new Staff(rs.getString("StaffID"), new Department(rs.getInt("DepartmentID"), rs.getString("Description")), rs.getString("Name"), rs.getString("Surname"), rs.getString("CellNo"), rs.getString("Email"), new Address(rs.getInt("AddressID"), rs.getString("City"), rs.getString("Suburb"), rs.getString("Street"), rs.getString("Port")), new Login(rs.getInt("LoginID"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Registered"))));
        }

        DataHandler.GetInstance().CloseConnection();

        return staffMembers;
    }

    @Override
    public Staff GetStaffFromDatabase(String id) throws SQLException, ClassNotFoundException, RemoteException
    {
        Staff staff;

        ResultSet rs = DataHandler.GetInstance().GetStaff(id);

        rs.first();

        staff = new Staff(rs.getString("StaffID"), new Department(rs.getInt("DepartmentID"), rs.getString("Description")), rs.getString("Name"), rs.getString("Surname"), rs.getString("CellNo"), rs.getString("Email"), new Address(rs.getInt("AddressID"), rs.getString("City"), rs.getString("Suburb"), rs.getString("Street"), rs.getString("Port")), new Login(rs.getInt("LoginID"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Registered")));

        DataHandler.GetInstance().CloseConnection();

        return staff;
    }

    @Override
    public void AddNewStaffMember(Staff staff) throws ClassNotFoundException, SQLException, RemoteException
    {
        DataHandler.GetInstance().AddStaff(staff.getId(), staff.getDepartment().getDepartmentID(), staff.getName(), staff.getSurname(), staff.getCellNo(), staff.getEmail(), staff.getAddress().getCity(), staff.getAddress().getSuburb(), staff.getAddress().getStreet(), staff.getAddress().getPort(), staff.getLogin().getUsername(), staff.getLogin().getPassword());
    }

    @Override
    public void UpdateStaffMember(Staff staff) throws ClassNotFoundException, SQLException, RemoteException
    {
        DataHandler.GetInstance().UpdateStaff(Staff.loggedInStaffID, staff.getDepartment().getDepartmentID(), staff.getName(), staff.getSurname(), staff.getCellNo(), staff.getEmail(), staff.getAddress().getAddressID(), staff.getAddress().getCity(), staff.getAddress().getSuburb(), staff.getAddress().getStreet(), staff.getAddress().getPort(), staff.getLogin().getLoginID(), staff.getLogin().getUsername(), staff.getLogin().getPassword());
    }

    @Override
    public void RegisterStaff(String staffID) throws ClassNotFoundException, SQLException, RemoteException
    {
        DataHandler.GetInstance().RegisterStaff(staffID);
    }

    @Override
    public void UnregisterStaff(String staffID) throws ClassNotFoundException, SQLException, RemoteException
    {
        DataHandler.GetInstance().UnregisterStaff(staffID);
    }

    @Override
    public void CheckAdminResponses(String staffID) throws ClassNotFoundException, SQLException, RemoteException
    {
        ResultSet rs = DataHandler.GetInstance().CheckAdminResponses(staffID);

        JOptionPane.showMessageDialog(null, "Hello");
        rs.first();
        while (rs.next())
        {
            if (!rs.getBoolean("accepted"))
            {
                JOptionPane.showMessageDialog(null, "Request Number: " + rs.getInt("RequestID") + " Has Been Cancelled: " + rs.getString("AdminResponse"));
            } else
            {
                JOptionPane.showMessageDialog(null, "Request Number: " + rs.getInt("RequestID") + " Has Been Accepted!: " + rs.getString("AdminResponse"));
            }
        }

        DataHandler.GetInstance().CloseConnection();
    }
}

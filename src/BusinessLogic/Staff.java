/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DataHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hendriko
 */
public class Staff extends Employee
{

    public static String loggedInStaffID = "";

    private Department department;

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public static ArrayList<Staff> GetStaffFromDatabase(CampusType ct) throws SQLException, ClassNotFoundException
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

    public static Staff GetStaffFromDatabase(String id) throws SQLException, ClassNotFoundException
    {
        Staff staff;

        ResultSet rs = DataHandler.GetInstance().GetStaff(id);

        rs.first();

        staff = new Staff(rs.getString("StaffID"), new Department(rs.getInt("DepartmentID"), rs.getString("Description")), rs.getString("Name"), rs.getString("Surname"), rs.getString("CellNo"), rs.getString("Email"), new Address(rs.getInt("AddressID"), rs.getString("City"), rs.getString("Suburb"), rs.getString("Street"), rs.getString("Port")), new Login(rs.getInt("LoginID"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Registered")));

        DataHandler.GetInstance().CloseConnection();

        return staff;
    }

    public void AddNewStaffMember() throws ClassNotFoundException, SQLException
    {
        DataHandler.GetInstance().AddStaff(this.getId(), this.department.getDepartmentID(), this.getName(), this.getSurname(), this.getCellNo(), this.getEmail(), this.getAddress().getCity(), this.getAddress().getSuburb(), this.getAddress().getStreet(), this.getAddress().getPort(), this.getLogin().getUsername(), this.getLogin().getPassword());
    }

    public void UpdateStaffMember() throws ClassNotFoundException, SQLException
    {
        DataHandler.GetInstance().UpdateStaff(loggedInStaffID, this.department.getDepartmentID(), this.getName(), this.getSurname(), this.getCellNo(), this.getEmail(), this.getAddress().getAddressID(), this.getAddress().getCity(), this.getAddress().getSuburb(), this.getAddress().getStreet(), this.getAddress().getPort(), this.getLogin().getLoginID(), this.getLogin().getUsername(), this.getLogin().getPassword());
    }

    public static void RegisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        DataHandler.GetInstance().RegisterStaff(staffID);
    }

    public static void UnregisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        DataHandler.GetInstance().UnregisterStaff(staffID);
    }

    public static void CheckAdminResponses(String staffID) throws ClassNotFoundException, SQLException
    {
        ResultSet rs = DataHandler.GetInstance().CheckAdminResponses(staffID);

        rs.first();
        while (rs.next())
        {
            if (!rs.getBoolean("AdminResponseReceived"))
            {
                JOptionPane.showMessageDialog(null, "Request Number: " + rs.getInt("RequestID") + " Has Been Cancelled: " + rs.getString("AdminResponse"));
            } else
            {
                JOptionPane.showMessageDialog(null, "Request Number: " + rs.getInt("RequestID") + " Has Been Accepted!: " + rs.getString("AdminResponse"));
            }
        }

        DataHandler.GetInstance().CloseConnection();
    }

    public Staff()
    {
        super();
    }

    public Staff(String staffID, Department department, String name, String surname, String cellNo, String email, Address address, Login login)
    {
        super(staffID, name, surname, cellNo, email, address, login);
        this.department = department;
    }
}

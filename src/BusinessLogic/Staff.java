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
    
    public static ArrayList<Staff> GetStaffFromDatabase() throws SQLException, ClassNotFoundException
    {
        ArrayList<Staff> staffMembers = new ArrayList<>();

        ResultSet rs = DataHandler.GetStaff();

        while (rs.next())
        {
            staffMembers.add(new Staff(rs.getString("StaffID"), new Department(rs.getInt("DepartmentID"), rs.getString("Description")), rs.getString("Name"), rs.getString("Surname"), rs.getString("CellNo"), rs.getString("Email"), new Address(rs.getInt("AddressID"), rs.getString("City"), rs.getString("Suburb"), rs.getString("Street"), rs.getString("Port")), new Login(rs.getInt("LoginID"), rs.getString("Username"), rs.getString("Password"))));
        }

        DataHandler.CloseConnection();

        return staffMembers;
    }

    public static Staff GetStaffFromDatabase(String id) throws SQLException, ClassNotFoundException
    {
        Staff staff;

        ResultSet rs = DataHandler.GetStaff(id);

        rs.first();

        staff = new Staff(rs.getString("StaffID"), new Department(rs.getInt("DepartmentID"), rs.getString("Description")), rs.getString("Name"), rs.getString("Surname"), rs.getString("CellNo"), rs.getString("Email"), new Address(rs.getInt("AddressID"), rs.getString("City"), rs.getString("Suburb"), rs.getString("Street"), rs.getString("Port")), new Login(rs.getInt("LoginID"), rs.getString("Username"), rs.getString("Password")));

        DataHandler.CloseConnection();

        return staff;
    }

    public void AddNewStaffMember() throws ClassNotFoundException, SQLException
    {
        DataHandler.AddStaff(this.getId(), this.department.getDepartmentID(), this.getName(), this.getSurname(), this.getCellNo(), this.getEmail(), this.getAddress().getCity(), this.getAddress().getSuburb(), this.getAddress().getStreet(), this.getAddress().getPort(), this.getLogin().getUsername(), this.getLogin().getPassword());
    }

    public void UpdateStaffMember() throws ClassNotFoundException, SQLException
    {
        DataHandler.UpdateStaff(loggedInStaffID, this.department.getDepartmentID(), this.getName(), this.getSurname(), this.getCellNo(), this.getEmail(), this.getAddress().getAddressID(), this.getAddress().getCity(), this.getAddress().getSuburb(), this.getAddress().getStreet(), this.getAddress().getPort(), this.getLogin().getLoginID(), this.getLogin().getUsername(), this.getLogin().getPassword());
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

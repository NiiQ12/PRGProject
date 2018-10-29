/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLogic.EmployeeType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class DataHandler
{
    // Testing testing
    static Connection con;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;

    public static void ConnectToDatabase() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull", "root", "");
    }

    public static void CloseConnection() throws SQLException
    {
        con.close();
    }

    // <editor-fold desc="Login">
    public static List<Object> Login(String username, String password) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        List<Object> lst = new ArrayList<>();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StaffID FROM staff INNER JOIN login ON staff.LoginID = login.LoginID WHERE Username = '" + username + "' AND Password = '" + password + "'");

        if (rs.next())
        {
            lst.add(rs.getString(1));
            lst.add(EmployeeType.Staff);
        } else
        {
            st = con.createStatement();
            rs = st.executeQuery("SELECT AdministratorID FROM administrator INNER JOIN login ON administrator.LoginID = login.LoginID WHERE Username = '" + username + "' AND Password = '" + password + "'");

            if (rs.next())
            {
                lst.add(rs.getString(1));
                lst.add(EmployeeType.Admin);
            } 
        }

        return lst;
    }

    public static boolean CheckLogin(String username) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT LoginID FROM login WHERE Username = '" + username + "'");

        if (rs.next())
        {
            return true;
        } else
        {
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold desc="Stationery">
    public static void AddStationery(int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("INSERT INTO stationery(CategoryID, Description, Stock, Price, ManufacturerID) VALUES(?,?,?,?,?)");
        pst.setInt(1, categoryID);
        pst.setString(2, description);
        pst.setInt(3, stock);
        pst.setDouble(4, price);
        pst.setInt(5, manufactureID);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void UpdateStationery(int stationeryCode, int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET CategoryID = ?, Description = ?, Stock = ?, Price = ?, ManufacturerID = ? WHERE StationeryCode = ?");
        pst.setInt(1, categoryID);
        pst.setString(2, description);
        pst.setInt(3, stock);
        pst.setDouble(4, price);
        pst.setInt(5, manufactureID);
        pst.setInt(6, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void UpdateStationeryStock(int stationeryCode, int stock) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET Stock = ? WHERE StationeryCode = ?");
        pst.setInt(1, stock);
        pst.setInt(2, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void DeleteStationery(int stationeryCode) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("DELETE FROM stationery WHERE StationeryCode = ?");
        pst.setInt(1, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public static ResultSet GetStationery(String description, int categoryID) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();

        if (description.equals("") && categoryID == 0)
        {
            rs = st.executeQuery("SELECT stationery.StationeryCode, category.Description, stationery.Description, stationery.Stock, stationery.Price, manufacturer.Name FROM stationery INNER JOIN manufacturer ON stationery.ManufacturerID = manufacturer.ManufacturerID INNER JOIN category ON stationery.CategoryID = category.CategoryID");
        } else if (description.equals(""))
        {
            rs = st.executeQuery("SELECT stationery.StationeryCode, category.Description, stationery.Description, stationery.Stock, stationery.Price, manufacturer.Name FROM stationery INNER JOIN manufacturer ON stationery.ManufacturerID = manufacturer.ManufacturerID INNER JOIN category ON stationery.CategoryID = category.CategoryID WHERE stationery.CategoryID = '" + categoryID + "'");
        } else if (categoryID == 0)
        {
            rs = st.executeQuery("SELECT stationery.StationeryCode, category.Description, stationery.Description, stationery.Stock, stationery.Price, manufacturer.Name FROM stationery INNER JOIN manufacturer ON stationery.ManufacturerID = manufacturer.ManufacturerID INNER JOIN category ON stationery.CategoryID = category.CategoryID WHERE stationery.Description LIKE '%" + description + "%'");
        } else
        {
            rs = st.executeQuery("SELECT stationery.StationeryCode, category.Description, stationery.Description, stationery.Stock, stationery.Price, manufacturer.Name FROM stationery INNER JOIN manufacturer ON stationery.ManufacturerID = manufacturer.ManufacturerID INNER JOIN category ON stationery.CategoryID = category.CategoryID WHERE stationery.Description LIKE '%" + description + "%' AND stationery.CategoryID = '" + categoryID + "'");
        }

        return rs;

        // Close connection in class method
    }

    public static ResultSet GetLastStationeryCode() throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StationeryCode FROM stationery ORDER BY stationeryCode DESC LIMIT 1");

        return rs;
    }

    public static ResultSet GetCategories() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM category");

        return rs;

        // Close connection in class method
    }
    // </editor-fold>

    // <editor-fold desc="Manufacturer">
    public static ResultSet GetManufacturers() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT manufacturerID, name FROM manufacturer");

        return rs;

        // Close connection in class method
    }
    // </editor-fold>

    // <editor-fold desc="Staff">
    public static void AddStaff(String staffID, int departmentID, String name, String surname, String cellNo, String email, String city, String suburb, String street, String port, String username, String password) throws ClassNotFoundException, SQLException // REGISTER
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StaffID FROM staff WHERE StaffID = '" + staffID + "'");

        if (!(rs.next()))
        {
            pst = con.prepareStatement("INSERT INTO login(Username, Password) VALUES(?,?)");
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();

            st = con.createStatement();
            rs = st.executeQuery("SELECT LoginID FROM login WHERE Username = '" + username + "'");

            int loginID = 0;

            while (rs.next())
            {
                loginID = rs.getInt("LoginID");
            }

            st = con.createStatement();
            rs = st.executeQuery("SELECT AddressID FROM Address WHERE City = '" + city + "' AND Suburb = '" + suburb + "' AND Street = '" + street + "' AND Port = '" + port + "'");

            int addressID = 0;

            if (rs.next())
            {
                addressID = rs.getInt("AddressID");
            } else
            {
                pst = con.prepareStatement("INSERT INTO address(City, Suburb, Street, Port) VALUES(?,?,?,?)");
                pst.setString(1, city);
                pst.setString(2, suburb);
                pst.setString(3, street);
                pst.setString(4, port);
                pst.executeUpdate();

                st = con.createStatement();
                rs = st.executeQuery("SELECT AddressID FROM address");

                while (rs.next())
                {
                    addressID = rs.getInt("AddressID");
                }
            }

            pst = con.prepareStatement("INSERT INTO staff VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, staffID);
            pst.setInt(2, departmentID);
            pst.setString(3, name);
            pst.setString(4, surname);
            pst.setString(5, cellNo);
            pst.setString(6, email);
            pst.setInt(7, addressID);
            pst.setInt(8, loginID);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Staff member successfully added!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "Staff Member With The Same ID Already Exists", "Warning!", JOptionPane.WARNING_MESSAGE);
        }

        CloseConnection();
    }

    public static ResultSet GetStaff() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID");

        return rs;
        // Close connection in class method
    }
    // </editor-fold>

    // <editor-fold desc="Department">
    public static ResultSet GetDepartment() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT Description FROM department");

        return rs;
    }

    // </editor-fold>
    // <editor-fold desc="Requests">   
    public static void AddRequest(String staffID, Date requestDate) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("INSERT INTO request(StaffID, RequestDate) VALUES(?,?)");
        pst.setString(1, staffID);
        pst.setDate(2, requestDate);
        pst.executeUpdate();
    }

    public static ResultSet GetLastRequestID() throws SQLException, ClassNotFoundException // REGISTER
    {
        st = con.createStatement();
        rs = st.executeQuery("SELECT RequestID FROM request ORDER BY RequestID DESC LIMIT 1");

        return rs;
    }

    public static void AddRequestDetail(int requestID, int stationeryCode, int quantity) throws SQLException, ClassNotFoundException // REGISTER
    {
        pst = con.prepareStatement("INSERT INTO requestdetails(RequestID, StationeryCode, Quantity) VALUES(?,?,?)");
        pst.setInt(1, requestID);
        pst.setInt(2, stationeryCode);
        pst.setInt(3, quantity);
        pst.executeUpdate();
    }
    // </editor-fold>
}

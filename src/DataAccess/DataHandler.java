/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLogic.Administrator;
import BusinessLogic.EmployeeType;
import BusinessLogic.RequestType;
import BusinessLogic.Staff;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
        rs = st.executeQuery("SELECT StaffID, Registered FROM staff INNER JOIN login ON staff.LoginID = login.LoginID WHERE Username = '" + username + "' AND Password = '" + password + "'");

        if (rs.next())
        {
            lst.add(rs.getString(1));
            lst.add(EmployeeType.Staff);
            lst.add(rs.getBoolean(2));
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

    public static int GetLoginID(String username, String password) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT LoginID FROM login WHERE Username = '" + username + "' AND Password = '" + password + "'");

        int loginID = 0;

        if (rs.next())
        {
            loginID = rs.getInt("LoginID");
        }

        return loginID;
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
    }

    public static ResultSet GetStationeryDescriptions() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        
        rs = st.executeQuery("SELECT Description FROM stationery");

        return rs;
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
        rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID");

        return rs;
    }

    public static ResultSet GetStaff(String id) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID WHERE staff.StaffID = '" + id + "'");

        return rs;
    }

    public static void UpdateStaff(String staffID, int departmentID, String name, String surname, String cellNo, String email, int addressID, String city, String suburb, String street, String port, int loginID, String username, String password) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE staff SET DepartmentID = ?, Name = ?, Surname = ?, CellNo = ?, Email = ? WHERE StaffID = ?");
        pst.setInt(1, departmentID);
        pst.setString(2, name);
        pst.setString(3, surname);
        pst.setString(4, cellNo);
        pst.setString(5, email);
        pst.setString(6, staffID);
        pst.executeUpdate();

        pst = con.prepareStatement("UPDATE address SET City = ?, Suburb = ?, Street = ?, Port = ? WHERE AddressID = ?");
        pst.setString(1, city);
        pst.setString(2, suburb);
        pst.setString(3, street);
        pst.setString(4, port);
        pst.setInt(5, addressID);
        pst.executeUpdate();

        pst = con.prepareStatement("UPDATE login SET Username = ?, Password = ? WHERE LoginID = ?");
        pst.setString(1, username);
        pst.setString(2, password);
        pst.setInt(3, loginID);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Profile successfully updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);

        CloseConnection();
    }
    
    public static void RegisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();
        
        pst = con.prepareStatement("UPDATE staff SET registered = 1 WHERE StaffID = ?");
        pst.setString(1, staffID);
        pst.executeUpdate();
        
        CloseConnection();
    }
    
    public static void UnregisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();
        
        pst = con.prepareStatement("UPDATE staff SET registered = 0 WHERE StaffID = ?");
        pst.setString(1, staffID);
        pst.executeUpdate();
        
        CloseConnection();
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

    public static ResultSet GetRequestDetails(RequestType rt) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        st = con.createStatement();

        switch (rt)
        {
            case All:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID");
                } else
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID WHERE StaffID = " + Staff.loggedInStaffID);
                }
                break;
            case Completed:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID WHERE request.accepted IS NOT NULL");
                } else
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID WHERE StaffID = '" + Staff.loggedInStaffID + "' AND request.accepted IS NOT NULL");
                }
                break;
            case Uncompleted:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID WHERE AdministratorID IS NULL AND request.accepted IS NULL");
                } else
                {
                    rs = st.executeQuery("SELECT requestdetails.RequestID, requestdetails.StationeryCode, category.Description, stationery.Description, Quantity FROM requestdetails INNER JOIN stationery ON requestdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN request ON request.RequestID = requestdetails.RequestID WHERE StaffID = '" + Staff.loggedInStaffID + "' AND request.accepted IS NULL");
                }
                break;
        }

        return rs;
    }

    public static ResultSet GetRequests(RequestType rt) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();

        switch (rt)
        {
            case All:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT * FROM request");
                } else
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE StaffID = " + Staff.loggedInStaffID);
                }
                break;
            case Completed:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE accepted IS NOT NULL");
                } else
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE StaffID = '" + Staff.loggedInStaffID + "' AND accepted IS NOT NULL");
                }
                break;
            case Uncompleted:
                if (Staff.loggedInStaffID.equals(""))
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE AdministratorID IS NULL AND accepted IS NULL AND ReceiveDate IS NULL");
                } else
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE StaffID = '" + Staff.loggedInStaffID + "' AND accepted IS NULL");
                }
                break;
        }

        return rs;
    }

    public static void UpdateCancelledRequestDetailQuantity(int stationeryCode, int quantity) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET Stock = Stock + ? WHERE StationeryCode = ?");
        pst.setInt(1, quantity);
        pst.setInt(2, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void DeleteRequest(int requestID) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("DELETE FROM requestDetails WHERE RequestID = ?");
        pst.setInt(1, requestID);
        pst.executeUpdate();

        pst = con.prepareStatement("DELETE FROM request WHERE RequestID = ?");
        pst.setInt(1, requestID);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void AcceptRequest(int id) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT DATE_ADD(request.RequestDate, INTERVAL 10 DAY) FROM request WHERE RequestID = '" + id + "'");

        Date date = null;

        if (rs.next())
        {
            date = rs.getDate(1);
        }

        pst = con.prepareStatement("UPDATE request SET AdministratorID =?, ReceiveDate = ?, Accepted = ? WHERE RequestID = ?");
        pst.setString(1, Administrator.loggedInAdminID);
        pst.setDate(2, date);
        pst.setBoolean(3, true);
        pst.setInt(4, id);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void RejectRequest(int id) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE request SET AdministratorID = ?, ReceiveDate =  NULL, Accepted = ? WHERE RequestID = ?");
        pst.setString(1, Administrator.loggedInAdminID);
        pst.setBoolean(2, false);
        pst.setInt(3, id);
        pst.executeUpdate();

        CloseConnection();
    }

    public static void RefillCancelledRequestQuantities(int stationeryCode, int amount) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET Stock = Stock + ? WHERE StationeryCode = ?");
        pst.setInt(1, amount);
        pst.setInt(2, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }
    // </editor-fold>

    // <editor-fold desc="Address"> 
    public static int GetAddressID(String city, String suburb, String street, String port) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT AddressID FROM address WHERE City = '" + city + "' AND Suburb = '" + suburb + "' AND Street = '" + street + "' AND Port = '" + port + "'");

        int addressID = 0;

        if (rs.next())
        {
            addressID = rs.getInt("AddressID");
        }

        return addressID;
    }

    // </editor-fold> 
    
    // <editor-fold desc="Order"> 
    
    public static int GetLastOrderID() throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();
        
        st = con.createStatement();
        rs = st.executeQuery("SELECT OrderID FROM tblOrder ORDER BY OrderID DESC LIMIT 1");
        
        int latestOrderID = 0;
        
        if (rs.next())
        {
            latestOrderID = rs.getInt(1);
        }
        
        return latestOrderID;
    }
    
    // </editor-fold>
}

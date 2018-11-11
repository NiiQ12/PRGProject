/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.Administrator;
import BusinessLogic.CampusType;
import BusinessLogic.EmployeeType;
import BusinessLogic.ReportType;
import BusinessLogic.RequestType;
import BusinessLogic.Staff;
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

    private DataHandler()
    {

    }

    private static DataHandler dh = new DataHandler();

    public static DataHandler GetInstance()
    {
        return dh;
    }

    static Connection con;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;

    public void ConnectToDatabase() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull", "root", "");
    }

    public void CloseConnection() throws SQLException
    {
        con.close();
    }

    // <editor-fold desc="Login">
    public List<Object> Login(String username, String password) throws SQLException, ClassNotFoundException
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

    public boolean CheckLogin(String username) throws SQLException, ClassNotFoundException
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

    public int GetLoginID(String username, String password) throws ClassNotFoundException, SQLException
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
    public void AddStationery(int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException // REGISTER
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

    public void UpdateStationery(int stationeryCode, int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException // REGISTER
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

    public void UpdateStationeryStock(int stationeryCode, int stock) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET Stock = ? WHERE StationeryCode = ?");
        pst.setInt(1, stock);
        pst.setInt(2, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public void DeleteStationery(int stationeryCode) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("DELETE FROM stationery WHERE StationeryCode = ?");
        pst.setInt(1, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public ResultSet GetStationery(String description, int categoryID) throws SQLException, ClassNotFoundException
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

    public ResultSet GetStationeryDescriptions() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();

        rs = st.executeQuery("SELECT Description FROM stationery");

        return rs;
    }

    public ResultSet GetLastStationeryCode() throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StationeryCode FROM stationery ORDER BY stationeryCode DESC LIMIT 1");

        return rs;
    }

    public ResultSet GetStockOfStationery(int stationeryCode) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT Stock FROM stationery WHERE StationeryCode = " + stationeryCode);

        return rs;
    }

    public ResultSet GetCategories() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM category");

        return rs;

        // Close connection in class method
    }
    // </editor-fold>

    // <editor-fold desc="Manufacturer">
    public ResultSet GetManufacturers() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT manufacturerID, name FROM manufacturer");

        return rs;

        // Close connection in class method
    }
    // </editor-fold>

    // <editor-fold desc="Staff">
    public void AddStaff(String staffID, int departmentID, String name, String surname, String cellNo, String email, String city, String suburb, String street, String port, String username, String password, String campus) throws ClassNotFoundException, SQLException // REGISTER
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

            pst = con.prepareStatement("INSERT INTO staff (StaffID, DepartmentID, Name, Surname, CellNo, Email, AddressID, LoginID, CampusID, Registered) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, staffID);
            pst.setInt(2, departmentID);
            pst.setString(3, name);
            pst.setString(4, surname);
            pst.setString(5, cellNo);
            pst.setString(6, email);
            pst.setInt(7, addressID);
            pst.setInt(8, loginID);

            if (campus.equals("Pretoria"))
            {
                pst.setInt(9, 1);
            } else
            {
                pst.setInt(9, 2);
            }

            pst.setInt(10, 0);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Staff member successfully added!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "Staff Member With The Same ID Already Exists", "Warning!", JOptionPane.WARNING_MESSAGE);
        }

        CloseConnection();
    }

    public ResultSet GetStaff(CampusType ct) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();

        switch (ct)
        {
            case All:
                rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID");
                break;
            case Pretoria:
                rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID WHERE staff.CampusID = 1");
                break;
            case Kempton:
                rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID WHERE staff.CampusID = 2");
                break;
        }

        return rs;
    }

    public ResultSet GetStaff(String id) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT StaffID, department.DepartmentID, department.Description, Name, Surname, CellNo, Email, address.AddressID, City, Suburb, Street, Port, login.LoginID, Username, Password, Registered FROM staff INNER JOIN department ON staff.DepartmentID = department.DepartmentID INNER JOIN address ON staff.AddressID = address.AddressID INNER JOIN login ON staff.LoginID = login.LoginID WHERE staff.StaffID = '" + id + "'");

        return rs;
    }

    public void UpdateStaff(String staffID, int departmentID, String name, String surname, String cellNo, String email, int addressID, String city, String suburb, String street, String port, int loginID, String username, String password) throws SQLException, ClassNotFoundException
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

    public void RegisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE staff SET registered = 1 WHERE StaffID = ?");
        pst.setString(1, staffID);
        pst.executeUpdate();

        CloseConnection();
    }

    public void UnregisterStaff(String staffID) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE staff SET registered = 0 WHERE StaffID = ?");
        pst.setString(1, staffID);
        pst.executeUpdate();

        CloseConnection();
    }

    public ResultSet CheckAdminResponses(String staffID) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT RequestID, accepted, AdminResponse, AdminResponseReceived FROM request WHERE StaffID = '" + staffID + "' AND AdminResponseReceived = 0");

        return rs;
    }

    public void UpdateAdminResponse(int requestID) throws ClassNotFoundException, SQLException
    {
        pst = con.prepareStatement("UPDATE request SET AdminResponseReceived = 1 WHERE RequestID = '" + requestID + "'");
        pst.executeUpdate();
    }

    public ResultSet GetCampuses() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT Location FROM campus INNER JOIN staff ON campus.ID = staff.CampusID");

        return rs;
    }
    // </editor-fold>

    // <editor-fold desc="Department">
    public ResultSet GetDepartment() throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT Description FROM department");

        return rs;
    }

    // </editor-fold>
    // <editor-fold desc="Requests">   
    public void AddRequest(String staffID, Date requestDate) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("INSERT INTO request(StaffID, RequestDate, AdminResponse) VALUES(?,?,?)");
        pst.setString(1, staffID);
        pst.setDate(2, requestDate);
        pst.setString(3, "");
        pst.executeUpdate();
    }

    public ResultSet GetLastRequestID() throws SQLException, ClassNotFoundException // REGISTER
    {
        st = con.createStatement();
        rs = st.executeQuery("SELECT RequestID FROM request ORDER BY RequestID DESC LIMIT 1");

        return rs;
    }

    public void AddRequestDetail(int requestID, int stationeryCode, int quantity) throws SQLException, ClassNotFoundException // REGISTER
    {
        pst = con.prepareStatement("INSERT INTO requestdetails(RequestID, StationeryCode, Quantity) VALUES(?,?,?)");
        pst.setInt(1, requestID);
        pst.setInt(2, stationeryCode);
        pst.setInt(3, quantity);
        pst.executeUpdate();
    }

    public ResultSet GetRequestDetails(RequestType rt) throws SQLException, ClassNotFoundException // REGISTER
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

    public ResultSet GetRequests(RequestType rt) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();

        switch (rt)
        {
            case All:
                if (!Administrator.loggedInAdminID.equals(""))
                {
                    rs = st.executeQuery("SELECT * FROM request");
                } else
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE StaffID = " + Staff.loggedInStaffID);
                }
                break;
            case Completed:
                if (!Administrator.loggedInAdminID.equals(""))
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE accepted IS NOT NULL");
                } else
                {
                    rs = st.executeQuery("SELECT * FROM request WHERE StaffID = '" + Staff.loggedInStaffID + "' AND accepted IS NOT NULL");
                }
                break;
            case Uncompleted:
                if (!Administrator.loggedInAdminID.equals(""))
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

    public void UpdateCancelledRequestDetailQuantity(int stationeryCode, int quantity) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE stationery SET Stock = Stock + ? WHERE StationeryCode = ?");
        pst.setInt(1, quantity);
        pst.setInt(2, stationeryCode);
        pst.executeUpdate();

        CloseConnection();
    }

    public void DeleteRequest(int requestID) throws SQLException, ClassNotFoundException // REGISTER
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

    public void AcceptRequest(int id, String message, int days) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        st = con.createStatement();
        rs = st.executeQuery("SELECT DATE_ADD(request.RequestDate, INTERVAL '" + days + "' DAY) FROM request WHERE RequestID = '" + id + "'");

        Date date = null;

        if (rs.next())
        {
            date = rs.getDate(1);
        }

        pst = con.prepareStatement("UPDATE request SET AdministratorID =?, ReceiveDate = ?, Accepted = ?, AdminResponse = ?, AdminResponseReceived = ? WHERE RequestID = ?");
        pst.setString(1, Administrator.loggedInAdminID);
        pst.setDate(2, date);
        pst.setBoolean(3, true);
        pst.setString(4, message);
        pst.setBoolean(5, false);
        pst.setInt(6, id);
        pst.executeUpdate();

        CloseConnection();
    }

    public void RejectRequest(int id, String message) throws SQLException, ClassNotFoundException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("UPDATE request SET AdministratorID = ?, ReceiveDate =  NULL, Accepted = ?, AdminResponse = ?, AdminResponseReceived = ? WHERE RequestID = ?");
        pst.setString(1, Administrator.loggedInAdminID);
        pst.setBoolean(2, false);
        pst.setString(3, message);
        pst.setBoolean(4, false);
        pst.setInt(5, id);
        pst.executeUpdate();

        CloseConnection();
    }

    public void RefillCancelledRequestQuantities(int stationeryCode, int amount) throws ClassNotFoundException, SQLException
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
    public int GetAddressID(String city, String suburb, String street, String port) throws SQLException, ClassNotFoundException
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
    public int GetLastOrderID() throws ClassNotFoundException, SQLException
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

    public void AddOrder(Date date) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("INSERT INTO tblOrder(Date, AdministratorID) VALUES(?,?)");
        pst.setDate(1, date);
        pst.setString(2, Administrator.loggedInAdminID);
        pst.executeUpdate();

        CloseConnection();
    }

    public void AddOrderDetails(int orderID, int stationeryCode, int quantity) throws ClassNotFoundException, SQLException
    {
        ConnectToDatabase();

        pst = con.prepareStatement("INSERT INTO orderdetails VALUES(?,?,?)");
        pst.setInt(1, orderID);
        pst.setInt(2, stationeryCode);
        pst.setInt(3, quantity);
        pst.executeUpdate();

        CloseConnection();
    }

    public ResultSet GetOrders(ReportType rt) throws SQLException, ClassNotFoundException // REGISTER
    {
        ConnectToDatabase();

        st = con.createStatement();

        switch (rt)
        {
            case Daily:
                rs = st.executeQuery("SELECT * FROM tblOrder WHERE Date = CURDATE()");
                break;
            case Weekly:
                rs = st.executeQuery("SELECT * FROM tblOrder WHERE WEEK(Date) = WEEK(NOW())");
                break;
            case Monthly:
                rs = st.executeQuery("SELECT * FROM tblOrder WHERE MONTH(Date) = MONTH(NOW())");
                break;
        }

        return rs;
    }

    public ResultSet GetOrderDetails(int id) throws SQLException, ClassNotFoundException // REGISTER
    {
        st = con.createStatement();
        rs = st.executeQuery("SELECT orderdetails.OrderID, orderdetails.StationeryCode, category.Description, stationery.Description, Price, Quantity FROM orderdetails INNER JOIN stationery ON orderdetails.StationeryCode = stationery.StationeryCode INNER JOIN category ON category.CategoryID = stationery.CategoryID INNER JOIN tblorder ON tblOrder.OrderID = orderdetails.OrderID WHERE tblOrder.OrderID = " + id);

        return rs;
    }

    // </editor-fold>
}

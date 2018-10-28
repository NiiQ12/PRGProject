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
public class Department
{
    private int departmentID;
    private String description;

    public Department(int departmentID, String description)
    {
        this.departmentID = departmentID;
        this.description = description;
    }

    public int getDepartmentID()
    {
        return departmentID;
    }

    public void setDepartmentID(int departmentID)
    {
        this.departmentID = departmentID;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public static ArrayList<String> GetDepartmentsFromDatabase() throws SQLException, ClassNotFoundException
    {
        ArrayList<String> departments = new ArrayList<>();
        
        ResultSet rs = DataHandler.GetDepartment();
        
        while(rs.next())
        {
            departments.add(rs.getString("Description"));
        }
        
        return departments;
    }
    
    @Override
    public String toString()
    {
        return "Department{" + "departmentID=" + departmentID + ", description=" + description + '}';
    }
}

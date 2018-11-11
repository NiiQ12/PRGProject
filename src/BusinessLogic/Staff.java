/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;

/**
 *
 * @author Hendriko
 */
public class Staff extends Employee implements Serializable
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

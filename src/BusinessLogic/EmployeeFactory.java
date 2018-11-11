/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author Nicky
 */
public class EmployeeFactory
{
    public static Employee MakeEmployee(String empType, String id, Department department, String name, String surname, String cellNo, String email, Address address, Login login)
    {
        switch (empType)
        {
            case "Staff":
                return new Staff(id, department, name, surname, cellNo, email, address, login);
            case "Admin":
                return new Administrator(id, name, surname, cellNo, email, address, login);
            default:
                return null;
        }
    }
}

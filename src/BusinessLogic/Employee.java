/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;

/**
 *
 * @author Nicky
 */
public abstract class Employee implements Serializable
{    
    private String id;
    private String name;
    private String surname;
    private String cellNo;
    private String email;
    private Address address;
    private Login login;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getCellNo()
    {
        return cellNo;
    }

    public void setCellNo(String cellNo)
    {
        this.cellNo = cellNo;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Login getLogin()
    {
        return login;
    }

    public void setLogin(Login login)
    {
        this.login = login;
    }
    
    public Employee()
    {
        
    }

    public Employee(String id, String name, String surname, String cellNo, String email, Address address, Login login)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cellNo = cellNo;
        this.email = email;
        this.address = address;
        this.login = login;
    }
}

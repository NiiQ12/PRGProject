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
public class Login implements Serializable
{
    private int loginID;
    private String username;
    private String password;
    private boolean registered;

    public int getLoginID()
    {
        return loginID;
    }

    public void setLoginID(int loginID)
    {
        this.loginID = loginID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isRegistered()
    {
        return registered;
    }

    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }

    public Login(int loginID, String username, String password, boolean registered)
    {
        this.loginID = loginID;
        this.username = username;
        this.password = password;
        this.registered = registered;
    }

    @Override
    public String toString()
    {
        return "Login{" + "loginID=" + loginID + ", username=" + username + ", password=" + password + '}';
    }
}

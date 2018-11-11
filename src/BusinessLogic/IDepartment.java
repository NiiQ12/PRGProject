/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicky
 */
public interface IDepartment extends Remote
{
    public ArrayList<String> GetDepartmentsFromDatabase() throws SQLException, ClassNotFoundException, RemoteException;
}

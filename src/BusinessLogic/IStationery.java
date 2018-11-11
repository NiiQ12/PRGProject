/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nicky
 */
public interface IStationery extends Remote
{
    public void AddStationery(int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException, RemoteException;
    public void UpdateStationery(int stationeryCode, int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException, RemoteException;
    public void UpdateStationeryStock(int newStock, Stationery stationery) throws ClassNotFoundException, SQLException, RemoteException;
    public void DeleteStationery(int stationeryCode) throws ClassNotFoundException, SQLException, RemoteException;
    public List<Stationery> GetStationery(String description, int categoryID) throws ClassNotFoundException, SQLException, RemoteException;
    public List<String> GetStationeryDescriptions() throws ClassNotFoundException, SQLException, RemoteException;
    public int GetLastStationeryCode() throws ClassNotFoundException, SQLException, RemoteException;
}

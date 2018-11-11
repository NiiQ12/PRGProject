/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLogic.IStationery;
import BusinessLogic.Stationery;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicky
 */
public class ImpStationery extends UnicastRemoteObject implements IStationery
{
    public ImpStationery() throws RemoteException
    {
        
    }   
    
    @Override
    public void AddStationery(int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().AddStationery(categoryID, description, stock, price, manufactureID);
    }

    @Override
    public void UpdateStationery(int stationeryCode, int categoryID, String description, int stock, double price, int manufactureID) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().UpdateStationery(stationeryCode, categoryID, description, stock, price, manufactureID);
    }

    @Override
    public void UpdateStationeryStock(int newStock, Stationery stationery) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().UpdateStationeryStock(stationery.getStationeryCode(), newStock);
    }

    @Override
    public void DeleteStationery(int stationeryCode) throws SQLException, ClassNotFoundException, RemoteException
    {
        DataHandler.GetInstance().DeleteStationery(stationeryCode);
    }

    @Override
    public List<Stationery> GetStationery(String description, int categoryID) throws SQLException, ClassNotFoundException, RemoteException
    {
        List<Stationery> stationeries = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetStationery(description, categoryID);

        while (rs.next())
        {
            stationeries.add(new Stationery(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6)));
        }

        DataHandler.GetInstance().CloseConnection();

        return stationeries;
    }

    @Override
    public List<String> GetStationeryDescriptions() throws SQLException, ClassNotFoundException, RemoteException
    {
        List<String> descriptions = new ArrayList<>();

        ResultSet rs = DataHandler.GetInstance().GetStationeryDescriptions();

        while (rs.next())
        {
            descriptions.add(rs.getString(1));
        }

        DataHandler.GetInstance().CloseConnection();

        return descriptions;
    }

    @Override
    public int GetLastStationeryCode() throws ClassNotFoundException, SQLException, RemoteException
    {
        int code = 0;

        ResultSet rs = DataHandler.GetInstance().GetLastStationeryCode();

        while (rs.next())
        {
            code = rs.getInt(1) + 1;
        }

        DataHandler.GetInstance().CloseConnection();

        return code;
    }
}
